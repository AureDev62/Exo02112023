package com.example.demo.controller;


import com.example.demo.model.Student;
import com.example.demo.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ControllerVue {

    private final IStudentService studentService;

    //public ControllerVue(IStudentService studentService) {
       // this.studentService = studentService;
   // }


    @GetMapping
    public String homePage(){
        return"home";
    }

    @GetMapping("/createStudent")
    public String createPage(Model model){
        model.addAttribute("studentSubmit", new Student());
        return "createStudent";
    }

    @GetMapping("/listStudent")
    public String listPage(Model model){
        List<Student> students = studentService.getAllStudents();
        System.out.println(students);
        model.addAttribute("students", students);
        return"listStudent";
    }


    @GetMapping("/detailStudent")
    public String detailPage(){
        return "detailStudent";
    }

    @PostMapping("/submitForm")
    public String submitFormulaire(@ModelAttribute("studentSubmit") Student student) {
        System.out.println(student);
        return "redirect:/";
    }
}