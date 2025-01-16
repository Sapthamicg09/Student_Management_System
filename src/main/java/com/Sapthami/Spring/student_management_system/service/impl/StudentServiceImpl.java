package com.Sapthami.Spring.student_management_system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Sapthami.Spring.student_management_system.entity.Student;
import com.Sapthami.Spring.student_management_system.repository.StudentRepository;
import com.Sapthami.Spring.student_management_system.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        // Use Optional to handle the case where a student with the given ID does not exist
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElse(null);
    }

    @Override
    public Student updateStudent(Student student) {
        // Save method in JPA repository will update the entity if it already exists
        return studentRepository.save(student);
    }
    
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
