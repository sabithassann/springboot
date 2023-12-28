/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stdcrud.controller;

import com.mycompany.stdcrud.dao.StudentDao;
import com.mycompany.stdcrud.model.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
public class StudentController {
    @Autowired
     private StudentDao sd;
    
    @GetMapping("/viewallstd")
    public  String viewAllEmp(Model m){
        List<Student> empList=sd.getAllEmp();        
        m.addAttribute("stdList", empList);
        return "viewAllStd";
    
    }
    
    @GetMapping("/stdsaveform")
    public  String saveForm(Model m){
        
        m.addAttribute("student", new Student());        
        return "stdsaveform";    
    }
    
    @PostMapping("/stdsave")
    public  String saveEmp(@ModelAttribute Student s){        
        sd.saveEmp(s);            
        return "redirect:/viewallstd";   
    }
    
    @RequestMapping("/deletestd/{roll}")
    public  String deleteEmp(@PathVariable("roll") int roll){
        
        sd.deleteEmp(roll);
        return "redirect:/viewallstd";         
    }
    
    @RequestMapping("/stdeditform/{roll}")
    public String empEditForm(@PathVariable("roll") int roll,Model m){
        Student student=sd.getEmpById(roll);
        m.addAttribute("student", student);
        return  "stdEdit";
    }
    
    @RequestMapping("/editstdsave")
    public String editEmpSave(@ModelAttribute("student") Student student){
        sd.updateEmp(student);
        return "redirect:/viewallstd";
    }
}
