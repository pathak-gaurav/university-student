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
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.college.entity.College;
import com.spring.college.entity.Student;
import com.spring.college.service.CollegeService;
import com.spring.college.service.StudentService;

@Controller
public class CollegeController {

	@Autowired
	CollegeService collegeService;

	@Autowired
	StudentService studentService;

	private Logger logger = Logger.getLogger(this.getClass().getName());

	@InitBinder
	public void initBider(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), false));
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
			logger.info("Saving the college:"+college);
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
		logger.info("Deleting the college:"+theId);
		collegeService.deleteCollege(theId);
		return "redirect:college-list";
	}

	@RequestMapping(value = "/college/student-form")
	public String collegeStuedntForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "college-student-form";
	}

	@RequestMapping("/college/studentRegistration")
	public String studentConfirmationForCollege(@Valid @ModelAttribute("student") Student student, BindingResult result,
			HttpSession session, Model model) {
		if (result.hasErrors()) {
			return "college-student-form";
		} else {
			Integer userId = (Integer) session.getAttribute("userId");
			College collegeIdBasedOnUserId = collegeService.getCollegeIdBasedOnUserId(userId);
			student.setCollegeId(collegeIdBasedOnUserId.getId());
			logger.info("Saving the student: "+student+". For the college:"+ collegeIdBasedOnUserId);
			studentService.saveStudent(student); 
			return "redirect:college-student-list";
		}
	}

	@RequestMapping(value = "/college/college-student-list")
	public String getCollegeStudents(Model model, HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		College collegeIdBasedOnUserId = collegeService.getCollegeIdBasedOnUserId(userId);
		logger.info("Listing students of college :"+collegeIdBasedOnUserId);
		model.addAttribute("studentList", studentService.findByCollegeId(userId));
		return "college-student-list";
	}
}
