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

//@RestController
//@RequestMapping("/students")

@Controller
public class StudentController {


    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "studentList"; // Thymeleaf view name
    }

    @PostMapping("/students")
    public String createStudent(@RequestBody Student student) {
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

//    @Autowired
//    private StudentRepository studentRepository;
//
//    @GetMapping
//    public List<Student> getAllStudents() {
//        return studentRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long studentId) {
//        return studentRepository.findById(studentId)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public Student createStudent(@RequestBody Student student) {
//        return studentRepository.save(student);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Student> updateStudent(
//            @PathVariable(value = "id") Long studentId,
//            @RequestBody Student studentDetails
//    ) {
//        return studentRepository.findById(studentId)
//                .map(existingStudent -> {
//                    existingStudent.setName(studentDetails.getName());
//                    existingStudent.setEmail(studentDetails.getEmail());
//                    return ResponseEntity.ok(studentRepository.save(existingStudent));
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteStudent(@PathVariable(value = "id") Long studentId) {
//        return studentRepository.findById(studentId)
//                .map(existingStudent -> {
//                    studentRepository.delete(existingStudent);
//                    return ResponseEntity.ok().<Void>build();
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
}
