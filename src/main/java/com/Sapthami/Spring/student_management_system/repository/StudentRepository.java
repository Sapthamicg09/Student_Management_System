package com.Sapthami.Spring.student_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sapthami.Spring.student_management_system.entity.Student;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Find student by first name
    List<Student> findByFirstName(String firstName);

    // Find student by last name
    List<Student> findByLastName(String lastName);

    // Find student by email
    Optional<Student> findByEmail(String email);

    // Find student by first name and last name
    List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    // Find students by email containing a specific string (like a domain or part of an email)
    List<Student> findByEmailContaining(String emailPart);

    // Custom query to find students whose names start with a specific letter
    List<Student> findByFirstNameStartingWith(String letter);

    // Find students by a part of the last name
    List<Student> findByLastNameContaining(String lastNamePart);

    // Delete a student by email (this will generate a DELETE query)
    void deleteByEmail(String email);

    // Delete students by first name
    void deleteByFirstName(String firstName);

    // Delete students by first name and last name
    void deleteByFirstNameAndLastName(String firstName, String lastName);

    // Custom query to find students by first name or last name
    List<Student> findByFirstNameOrLastName(String firstName, String lastName);

    // Custom query to get students with first name containing specific characters
    List<Student> findByFirstNameContainingIgnoreCase(String firstNamePart);
}
