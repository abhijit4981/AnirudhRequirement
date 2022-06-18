package uniper.poc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uniper.poc.model.Login;
import uniper.poc.model.ModelPojo;

@Controller
public class MainController {

	@GetMapping(value = "/")
	public ModelAndView index() {
		System.out.println("Show Home");
		return new ModelAndView("index");
	}

	@GetMapping(value = "/showLogin")
	public ModelAndView showLogin() {
		System.out.println("Show Login");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		modelAndView.addObject("login", new Login());
		return modelAndView;
	}

	@GetMapping(value = "/showRegister")
	public ModelAndView showRegister() {
		System.out.println("Show Register");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("register");
		modelAndView.addObject("user", new ModelPojo());
		return modelAndView;
	}

}
