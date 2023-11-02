package com.example.demo.controller;


import com.example.demo.model.Student;
import com.example.demo.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String createPage(Model model, Student student){
        model.addAttribute("studentSubmit",student);
        return "createStudent";
    }

    @GetMapping("/listStudent")
    public String listPage(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return"listStudent";
    }


    @GetMapping("/detailStudent/{id}")
    public String detailPage(@PathVariable Long id, Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "detailStudent";
    }


    @PostMapping("/submitForm")
    public String submitFormulaire(@ModelAttribute("studentSubmit") Student student) {
        studentService.createStudent(student);
        System.out.println(student);
        return "redirect:/";
    }

    @PostMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        System.out.println("Etudiants avec l'id : " +id+  "enlever");
        return "redirect:/listStudent";
    }

}