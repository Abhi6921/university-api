package com.abhicoder.universityapi.config;

import com.abhicoder.universityapi.model.Course;
import com.abhicoder.universityapi.model.Student;
import com.abhicoder.universityapi.repository.CourseRepository;
import com.abhicoder.universityapi.repository.StudentRepository;
import lombok.extern.java.Log;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Log
@Transactional
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    // TODO: Add Login Authentication
    public MyApplicationRunner(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Student> students = List.of(
                new Student("Abhishek", "Narvekar", "email", "0612458974"),
                new Student("Felicity", "Smoak", "felicity@gmail.com", "0613272371263"),
                new Student("Oliver", "Queen", "oliver@gmail.com", "06438748373")
        );

        List<Course> courses = List.of(
                new Course("Java Fundamentals", "Wim Wiltenburg", 23),
                new Course("IT Service Management", "Usman Ali", 45),
                new Course("No Sql", "Thijs Otter", 23),
                new Course("C#", "Gerwin van Dijken", 56),
                new Course("Web Developement 2", "Mark de Haan", 78)
        );

        studentRepository.saveAll(students);
        courseRepository.saveAll(courses);
    }
}
