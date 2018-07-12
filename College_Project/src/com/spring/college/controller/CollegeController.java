package com.spring.college.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.college.entity.College;
import com.spring.college.service.CollegeService;

@Controller
public class CollegeController {

	@Autowired
	CollegeService collegeService;

	private Logger logger = Logger.getLogger(this.getClass().getName());

	@InitBinder
	public void initBider(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"),false));
	}

	@RequestMapping(value = "/college/college-form")
	public String contactForm(Model model) {
		College college = new College();
		model.addAttribute("college", college);
		return "college-form";
	}

	@RequestMapping("/college/collegeRegistration")
	public String collegeConfirmation(@Valid @ModelAttribute("college") College college, BindingResult result) {
		if (result.hasErrors()) {
			return "college-form";
		} else {
			collegeService.saveCollege(college);
			return "redirect:college-list";
		}
	}

	@RequestMapping(value = "/college/college-list")
	public String listCollege(Model model) {
		model.addAttribute("college", collegeService.getColleges());
		return "college-list";
	}

	@GetMapping(value = "/college/collegeFormForUpdate")
	public String collegeFormForUpdate(@RequestParam("college") int theId, Model model) {
		College theCollege = collegeService.getCollege(theId);
		model.addAttribute("college", theCollege);
		return "college-form";
	}

	@GetMapping(value = "/college/college-delete")
	public String collegeDelete(@RequestParam("college") int theId, Model model) {
		collegeService.deleteCollege(theId);
		return "redirect:college-list";
	}
}
