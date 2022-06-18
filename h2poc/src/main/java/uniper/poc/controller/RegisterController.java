package uniper.poc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import uniper.poc.model.ModelPojo;
import uniper.poc.service.ModelServiceImpl;


@Controller
@Slf4j
public class RegisterController {

	@Autowired
	ModelServiceImpl userService;

	@PostMapping(value = "/register")
	public ModelAndView login(@ModelAttribute(value = "user") ModelPojo user) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (user == null) {
				errorPage(modelAndView);
			} else {
				log.info("***************************** Going to save user");
				if (userService.isRegistered(user)) {
					modelAndView.addObject("message", "Registeration Successful!!");
					modelAndView.setViewName("success");
				} else {
					System.out.println("User :: NOT Registered");
					errorPage(modelAndView);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorPage(modelAndView);
		}
		return modelAndView;
	}

	public void errorPage(ModelAndView modelAndView) {
		modelAndView.addObject("message", "Invalid Input");
		modelAndView.addObject("link", "register.jsp");
		modelAndView.setViewName("errorPage");
	}
}
