package com.appetite.appetite.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appetite.appetite.dao.iFoodRepository;
import com.appetite.appetite.dao.iOrderRepository;
import com.appetite.appetite.entity.Food;
import com.appetite.appetite.entity.Order;

@Controller
@RequestMapping("/order")
public class OrderController {


    @Autowired
    iOrderRepository orderRepository;

    @Autowired
    iFoodRepository foodRepository;

    @GetMapping("/new")
    public String displayNewOrderForm(Model model) {
        model.addAttribute("order", new Order());

        List<Food> foods = foodRepository.findAll();
        model.addAttribute("foods", foods);
        return "order/new-order";
    }

    @PostMapping("/save")
    public String createOrder(Order order) { //,  Model model
        System.out.println("Food ID: "  + " --- client Id: " +   order.getClientId());
        orderRepository.save(order);
        return "redirect:/";
    }



}
