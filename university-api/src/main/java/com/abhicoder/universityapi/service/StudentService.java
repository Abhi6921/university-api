package com.abhicoder.universityapi.service;

import com.abhicoder.universityapi.model.Student;
import com.abhicoder.universityapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student newStudent) {
        try {
            Student storeStudent = studentRepository.save(newStudent);
            return storeStudent;
        }
        catch (Exception ex) {
            throw new IllegalArgumentException("something went wrong in adding student");
        }

    }
}
