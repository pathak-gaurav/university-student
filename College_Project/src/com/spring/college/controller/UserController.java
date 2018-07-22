package com.spring.college.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.college.command.LoginCommand;
import com.spring.college.entity.User;
import com.spring.college.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	private Logger logger = Logger.getLogger(this.getClass().getName());

	@InitBinder
	public void initBider(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"),false));
	}


	@RequestMapping(value = { "/", "/index" })
	public String index(Model m) {
		m.addAttribute("command", new LoginCommand());
		return "index";
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginHandle(@ModelAttribute("command") LoginCommand cmd, Model model, HttpSession session) {
		try {
			User login = userService.login(cmd.getLogin(), cmd.getPassword());
			if (login == null) {
				model.addAttribute("err", "Login Failed! Enter valid credentials");
				return "index";
			} else {
				if (login.getRoleId().equals(userService.ROLE_ADMIN)) {
					addUserInSession(login, session);
					return "redirect:admin/dashboard";
				} else if (login.getRoleId().equals(userService.ROLE_USER)) {
					addUserInSession(login, session);
					return "redirect:user/dashboard";
				} else if (login.getRoleId().equals(userService.ROLE_STUDENT)) {
					addUserInSession(login, session);
					return "redirect:student/dashboard";
				} else if (login.getRoleId().equals(userService.ROLE_KIOSK)) {
					addUserInSession(login, session);
					return "redirect:kiosk/dashboard";
				} else if (login.getRoleId().equals(userService.ROLE_COLLEGE)) {
					addUserInSession(login, session);
					return "redirect:college/dashboard";
				} else {
					model.addAttribute("err", "Invalid User Role!");
					return "index";
				}
			}
		} catch (Exception e) {
			model.addAttribute("err", e.getMessage());
			return "index";
		}
	}

	private void addUserInSession(User u, HttpSession session) {
		session.setAttribute("user", u);
		session.setAttribute("userId", u.getUserId());
		session.setAttribute("role", u.getRoleId());
	}
	
	@RequestMapping("/logout")
	private String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index?act=lo";
	}

	@RequestMapping("/user/dashboard")
	public String userDashboard() {
		return "dashboard_user";
	}

	@RequestMapping("/admin/dashboard")
	public String adminDashboard() {
		return "dashboard_admin";
	}

	@RequestMapping("/student/dashboard")
	public String studentDashboard() {
		return "dashboard_student";
	}

	@RequestMapping("/college/dashboard")
	public String collegeDashboard() {
		return "dashboard_college";
	}

	@RequestMapping("/kiosk/dashboard")
	public String kioskDashboard() {
		return "dashboard_kiosk";
	}
	
	
	@RequestMapping(value = "/user/user-form")
	public String contactForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "user-form";
	}
	
	@RequestMapping("/user/userRegistration")
	public String userConfirmation(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if (result.hasErrors()) {
			return "user-form";
		} else {
			logger.info("Adding the user:"+user);
			userService.addUser(user);
			return "redirect:user-list";
		}
	}

	@RequestMapping(value = "/user/user-list")
	public String listUsers(Model model) {
		logger.info("Listing all the usersr:"+userService.getUsers());
		model.addAttribute("user", userService.getUsers());
		return "user-list";
	}

	@GetMapping(value = "/user/userFormForUpdate")
	public String userFormForUpdate(@RequestParam("user") int theId, Model model) {
		User theUser = userService.getUser(theId);
		logger.info("Updating the user with Id:"+theId);
		model.addAttribute("user", theUser);
		return "user-form";
	}

	@GetMapping(value = "/user/user-delete")
	public String UserDelete(@RequestParam("user") int theId, Model model) {
		logger.info("Deleting the user with Id:"+theId);
		userService.deleteUser(theId);
		return "redirect:user-list";
	}

}
