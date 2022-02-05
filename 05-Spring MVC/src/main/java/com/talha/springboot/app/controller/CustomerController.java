package com.talha.springboot.app.controller;

import com.talha.springboot.app.entity.Customer;
import com.talha.springboot.app.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final ICustomerService m_service;

    public CustomerController(ICustomerService service) {
        m_service = service;
    }

    @GetMapping(value = "/list")
    public String listCustomers(Model model) {

        List<Customer> customers = m_service.findAllByOrderByIdAsc();

        System.out.println(customers);

        model.addAttribute("customers", customers);

        return "list-customers";
    }

    @GetMapping(value = "/showFormForAdd")
    public String showFormForAdd(Model model) {

        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping(value = "/saveCustomer")
    public String saveCustomer(@ModelAttribute(name = "customer") Customer customer) {

        m_service.save(customer);

        return "redirect:/customer/list";
    }

    @GetMapping(value = "/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id,Model model) {

        Customer customer = m_service.findById(id);
        model.addAttribute("customer",customer);

        return "customer-form";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam("customerId") int id,Model model) {

        m_service.deleteById(id);

        return "redirect:/customer/list";
    }

    @GetMapping(value = "/search")
    public String search(@RequestParam("theSearchName") String name,Model model) {

        List<Customer> customers = m_service.findAllByFirstNameOrLastName(name);

        model.addAttribute("customers", customers);

        return "list-customers";
    }



}
