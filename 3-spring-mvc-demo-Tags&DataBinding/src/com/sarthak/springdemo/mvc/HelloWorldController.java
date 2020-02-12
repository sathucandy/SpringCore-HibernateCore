package com.sarthak.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// need a controller method to show initial form

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	// need a controller to process the form

	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	// new controller to read form data and
	// add data to model

	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {

		// read request parameter from html form
		String theName = request.getParameter("studentName");

		// convert data in all upper case
		theName = theName.toUpperCase();

		// create message
		String result = "Yo " + theName;

		// add message to model
		model.addAttribute("message", result);

		return "helloworld";
	}

	@RequestMapping("/processFormVersionThree")
	public String letsShoutDude(@RequestParam("studentName") String theName, Model model) {

		// read request parameter from html form
//		String theName = request.getParameter("studentName");

		// convert data in all upper case
		theName = theName.toUpperCase();

		// create message
		String result = "Hey my friend from v3 " + theName;

		// add message to model
		model.addAttribute("message", result);

		return "helloworld";
	}

}
