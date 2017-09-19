package com.condigence.payment.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.condigence.payment.dto.PaymentOrder;

@Controller
public class HomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		PaymentOrder paymentOrder = new PaymentOrder();
		modelAndView.addObject("paymentOrder", paymentOrder);
		modelAndView.setViewName("index");	
		
		
		return modelAndView;
	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public ModelAndView createNewPaymentRequest(@Valid PaymentOrder paymentOrder, BindingResult bindingResult) {
		
		System.out.println(" hello calling ......  ");
		
		System.out.println(" Payment controller called ......  ");
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("index");
		modelAndView.addObject("paymentOrder", new PaymentOrder());
		return modelAndView;
	}
	

}
