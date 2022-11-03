package com.talha.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

//    @GetMapping("/showform")
//    public String showForm(Model model) {
//        Student student = new Student();
//        model.addAttribute("formStudent", student);
//        return "student-form";
//    }
//
//    @PostMapping("/processform")
//    public String processForm(@ModelAttribute("formStudent") Student curStudent, Model model) {
//        System.out.println(curStudent);
//        System.out.println("myModel1" + model);
//        model.addAttribute("curStudent", curStudent);
//        System.out.println("myModel2" + model);
//        Student snew =(Student) model.getAttribute("formStudent");
//        System.out.println("snwq" + snew);
//        return "processform";
//    }

}
