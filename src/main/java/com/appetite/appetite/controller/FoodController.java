package com.appetite.appetite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appetite.appetite.dao.iFoodRepository;
import com.appetite.appetite.entity.Food;

@Controller
@RequestMapping("/food")
public class FoodController {

    @Autowired
    iFoodRepository foodRepository;

    @GetMapping("/new")
    public String displayFoodForm(Model model) {
        model.addAttribute("food", new Food());
        return "food/new-food";
    }

    @PostMapping("/save")
    public String createFood(Food food) {
        foodRepository.save(food);
        return "redirect:/food/new";
    }

}
