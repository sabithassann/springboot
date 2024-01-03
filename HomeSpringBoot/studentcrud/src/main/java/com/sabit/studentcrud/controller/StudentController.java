package com.sabit.studentcrud.controller;

import com.sabit.studentcrud.model.Student;
import com.sabit.studentcrud.repository.StudentRepository;
import com.sabit.studentcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
public class StudentController {


    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

   @GetMapping("/")
   public String index(){
        return "studentList";
   }

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "studentList"; // Thymeleaf view name
    }

    @PostMapping("/students")
    public String createStudent(@RequestParam String name, @RequestParam String email) {
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        studentService.createStudent(student);
        return "redirect:/students";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, Student student) {
        studentService.updateStudent(id, student);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }


   @DeleteMapping("/students/{id}")
   public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
       studentService.deleteStudent(id);
       return ResponseEntity.ok("Student with ID " + id + " deleted successfully");
   }

}
