package com.javaweb.customer;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// handler methods will go here...
	@RequestMapping("/")
	public ModelAndView home() {
		List<Customer> listCustomer = customerService.listAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listCustomer", listCustomer);
		return mav;
	}
	// To implement the create new customer feature, we need to write two handler methods. 
	// The first one is to display the new customer form:
	@RequestMapping("/new")
	public String newCustomerForm(Map<String, Object> model) {
		Customer customer = new Customer();
		model.put("customer", customer);
		return "new_customer"; // new_customer.jsp
	}
	// And the second handler method is to handle the Save button on this form:
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
	    customerService.save(customer);
	    return "redirect:/";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editCustomerForm(@RequestParam long id) {
	    ModelAndView mav = new ModelAndView("edit_customer");
	    Customer customer = customerService.get(id);
	    mav.addObject("customer", customer);
	 
	    return mav;
	}
	@RequestMapping("/delete")
	public String deleteCustomerForm(@RequestParam long id) {
	    customerService.delete(id);
	    return "redirect:/";       
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
	    List<Customer> result = customerService.search(keyword);
	    ModelAndView mav = new ModelAndView("search");
	    mav.addObject("result", result); 
	    return mav;    
	}
}