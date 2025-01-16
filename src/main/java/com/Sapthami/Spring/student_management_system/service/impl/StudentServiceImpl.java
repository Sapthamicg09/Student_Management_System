package com.Sapthami.Spring.student_management_system.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
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
        return studentRepository.save(student);  // Saves student to the database
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElse(null);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);  // Updates student in the database
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);  // Deletes student from the database
    }
}
