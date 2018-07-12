package com.spring.college.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

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

import com.spring.college.entity.Student;
import com.spring.college.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@InitBinder
	public void initBider(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"),false));
	}

	@RequestMapping(value = "/student/student-form")
	public String contactForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "student-form";
	}
	
	@RequestMapping("/student/studentRegistration")
	public String studentConfirmation(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "student-form";
		} else {
			studentService.saveStudent(student);
			return "redirect:student-list";
		}
	}

	@RequestMapping(value = "/student/student-list")
	public String liststudents(Model model) {
		model.addAttribute("student", studentService.getStudents());
		return "student-list";
	}

	@GetMapping(value = "/student/studentFormForUpdate")
	public String studentFormForUpdate(@RequestParam("student") int theId, Model model) {
		Student theStudent = studentService.getStudent(theId);
		model.addAttribute("student", theStudent);
		return "student-form";
	}

	@GetMapping(value = "/student/student-delete")
	public String StudentDelete(@RequestParam("student") int theId, Model model) {
		studentService.deleteStudent(theId);
		return "redirect:student-list";
	}

}
