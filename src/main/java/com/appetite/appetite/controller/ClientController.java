
package com.appetite.appetite.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.appetite.appetite.dao.iCheckRepository;
import com.appetite.appetite.dao.iClientRepository;
import com.appetite.appetite.dao.iFoodRepository;
import com.appetite.appetite.dao.iOrderDetailRepository;
import com.appetite.appetite.dao.iOrderRepository;
import com.appetite.appetite.entity.Client;
import com.appetite.appetite.entity.Food;
import com.appetite.appetite.entity.OrderDetail;
import com.appetite.appetite.entity.Orderx;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class ClientController {

	List<OrderDetail> orderDetailX = new ArrayList<OrderDetail>();
	List<OrderDetail> orderDetDisplay = new ArrayList<OrderDetail>();

	Double totalPrice = 0.0;

	Client checkCliend = new Client();
	Client clientAddress = new Client();

	@Autowired
	iOrderRepository orderRepository;

	@Autowired
	iOrderDetailRepository orderDetailRepository;

	@Autowired
	iFoodRepository foodRepository;

	@Autowired
	iClientRepository clientRepository;

	@Autowired
	iCheckRepository clientCheckRepository;

	// -------------------------------------------------------------------------
	@GetMapping("/")
	public String displayCheckClientForm(Model model) {
		model.addAttribute("client", new Client());
		return "login/login";
	}

	@RequestMapping("/home")
	public String loadIndexClient(Model model) {
		model.addAttribute("client", checkCliend);
		return "/home/index";
	}

	// -------------------------------------------------------------------------
	@GetMapping("/register/new")
	public String displayClientForm(Model model) {
		model.addAttribute("client", new Client());
		return "register/register";
	}

	@PostMapping("/register/save")
	public String createClient(Client client) {
		clientRepository.save(client);
		return "redirect:/";
	}

	// -------------------------------------------------------------------------

	@PostMapping("/check")
	public String checkClient(Client client) {
		checkCliend = clientCheckRepository.findByEmailAndPassword(client.getEmail(), client.getPassword());

		if (checkCliend != null) {
			return "redirect:/home";
		}
		return "redirect:/";
	}

	public Client getcheckCliend() {
		return checkCliend;
	}

	// -------------------------------------------------------------------------
	@GetMapping("/order/new")
	public String displayNewOrderForm(Model model) {
		model.addAttribute("orderDetail", new OrderDetail());

		List<Food> foods = foodRepository.findAll();
		model.addAttribute("foods", foods);
		model.addAttribute("ordersD", orderDetailX);
		model.addAttribute("totalprice", totalPrice);

		return "order/new-order";
	}

	// -------------------------------------------------------------------------
	@PostMapping("/order/add")
	public String addOrder(OrderDetail orderDetails) {

		Food food = foodRepository.findByFoodId(orderDetails.getFoodId());
		System.out.println("que es food" + food);
		orderDetails.setPrice(food.getPrice());
		orderDetails.setFoodName(food.getName());
		orderDetails.setSubTotal(food.getPrice() * orderDetails.getQuantity());
		orderDetailX.add(orderDetails);
		totalPrice = totalPrice + orderDetails.getSubTotal();
		return "redirect:/order/new";
	}

	// -------------------------------------------------------------------------
	@PostMapping("/order/save")
	public String createOrder() {
		Orderx order = new Orderx(checkCliend.getClientId(), "New");
		orderRepository.save(order);
		Orderx orderLast = orderRepository.findFirstByOrderByOrderxIdDesc();

		for (OrderDetail x : orderDetailX) {
			x.setOrderId(orderLast.getOrderxId());
			orderDetailRepository.save(x);
		}

		return "redirect:/order/summary";
	}

	// -------------------------------------------------------------------------
	@PostMapping("/order/reset")
	public String resetOrder() {
		orderDetailX.clear();
		totalPrice = 0.0;
		return "redirect:/order/new";
	}

	// -------------------------------------------------------------------------
	@GetMapping("/order/summary")
	public String summaryOrder(Model model) {

		clientAddress = clientRepository.findByclientId(checkCliend.getClientId());
		model.addAttribute("address", clientAddress);

		orderDetailX.clear();
		totalPrice = 0.0;
		return "order/summary-order";
	}

	// -------------------------------------------------------------------------

}
