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

import com.spring.college.entity.Marksheet;
import com.spring.college.service.MarksheetService;

@Controller
public class MarksheetController {

	@Autowired
	MarksheetService marksheetService;

	private Logger logger = Logger.getLogger(this.getClass().getName());

	@InitBinder
	public void initBider(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"),false));
	}

	@RequestMapping(value = "/marksheet/marksheet-form")
	public String contactForm(Model model) {
		Marksheet marksheet = new Marksheet();
		model.addAttribute("marksheet", marksheet);
		return "marksheet-form";
	}

	@RequestMapping("/marksheet/marksheetRegistration")
	public String marksheetConfirmation(@Valid @ModelAttribute("marksheet") Marksheet marksheet, BindingResult result) {
		if (result.hasErrors()) {
			return "marksheet-form";
		} else {
			logger.info("Saving the student marksheet:"+marksheet);
			marksheetService.saveMarksheet(marksheet);
			return "redirect:marksheet-list";
		}
	}

	@RequestMapping(value = "/marksheet/marksheet-list")
	public String listMarksheet(Model model) {
		model.addAttribute("marksheet", marksheetService.getMarksheets());
		return "marksheet-list";
	}

	@GetMapping(value = "/marksheet/marksheetFormForUpdate")
	public String marksheetFormForUpdate(@RequestParam("marksheet") int theId, Model model) {
		Marksheet theMarksheet = marksheetService.getMarksheet(theId);
		logger.info("Updating the student marksheet:"+theMarksheet);
		model.addAttribute("marksheet", theMarksheet);
		return "marksheet-form";
	}

	@GetMapping(value = "/marksheet/marksheet-delete")
	public String marksheetDelete(@RequestParam("marksheet") int theId, Model model) {
		logger.info("Deleting the student marksheet:"+theId);
		marksheetService.deleteMarksheet(theId);
		return "redirect:marksheet-list";
	}
}
