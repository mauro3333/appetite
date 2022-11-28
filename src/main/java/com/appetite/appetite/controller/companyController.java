package com.appetite.appetite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appetite.appetite.dao.iEmployeeRepository;
import com.appetite.appetite.dao.iOrderRepository;
import com.appetite.appetite.entity.Employee;
import com.appetite.appetite.entity.Orderx;

@Controller
@RequestMapping("/company")
public class companyController {

    @Autowired
    iEmployeeRepository employeeRepository;

    @Autowired
	iOrderRepository orderRepository;

    @GetMapping("")
    public String displayFoodForm(Model model) {
        return "company-home/index-home";
    }
// -------------------------------------------------------------------------
    @GetMapping("/employee/new")
    public String displayEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/new-employee";
    }
// -------------------------------------------------------------------------
    @PostMapping("/employee/save")
    public String createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/company/employee/new";
    }
// -------------------------------------------------------------------------
    @GetMapping("/assign/new")
    public String assignDeliverEmployeeForm(Model model) {

        model.addAttribute("orderX", new Orderx());

        List<Employee> employee = employeeRepository.findAll();
        List<Orderx> orders = orderRepository.findByStatus("New");
		model.addAttribute("employees", employee);
		model.addAttribute("orders", orders);

        return "order/order-assign";
    }


// -------------------------------------------------------------------------
@PostMapping("/assign/save")
public String assignEmployeeOrder(Orderx order) {
    System.out.println("==============ASSIGN EMPLOYEE================" + order.getEmployeeId() + "==============================" );
    System.out.println("==============ASSIGN ORDER================" + order.getOrderxId() + "==============================" );
    // orderRepository.updateEmployeeOrderx(order.getEmployeeId(), order.getOrderxId());
    Orderx assignOrder = orderRepository.findByorderxId(order.getOrderxId());
    assignOrder.setEmployeeId(order.getEmployeeId());
    assignOrder.setStatus("Assigned");
    orderRepository.save(assignOrder);
    // orderRepository.updateEmployeeOrderx(231L, 241L);

    return "redirect:/company";
}


}
