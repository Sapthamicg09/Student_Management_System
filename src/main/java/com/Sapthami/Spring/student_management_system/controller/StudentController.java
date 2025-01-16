package com.Sapthami.Spring.student_management_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Sapthami.Spring.student_management_system.entity.Student;
import com.Sapthami.Spring.student_management_system.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students"; // View name (students.html)
    }

    @GetMapping("/new")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "create_student"; // View name for creating student (create_student.html)
    }

    @PostMapping
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student"; // Thymeleaf template name
    }

    @PostMapping("/{id}")
    public String updateStudent(@PathVariable Long id, 
                                @ModelAttribute("student") Student student) {
        // Fetch the existing student by ID
        Student existingStudent = studentService.getStudentById(id);
        if (existingStudent != null) {
            // Update the fields
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setEmail(student.getEmail());
            // Save the updated student object
            studentService.updateStudent(existingStudent);
        }
        return "redirect:/students";
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) 
    {
        studentService.deleteStudentById(id);
        return "redirect:/students"; // Redirecting to the list of students
    }
}
