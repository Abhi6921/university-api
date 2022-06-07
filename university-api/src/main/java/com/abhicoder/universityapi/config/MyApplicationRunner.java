package com.abhicoder.universityapi.config;

import com.abhicoder.universityapi.model.Course;
import com.abhicoder.universityapi.model.User;
import com.abhicoder.universityapi.repository.CourseRepository;
import com.abhicoder.universityapi.repository.UserRepository;
import lombok.extern.java.Log;
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
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    // TODO: Add Login Authentication
    public MyApplicationRunner(UserRepository userRepository, CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<User> students = List.of(
                new User("Abhishek", "Narvekar", "email", "0612458974"),
                new User("Felicity", "Smoak", "felicity@gmail.com", "0613272371263"),
                new User("Oliver", "Queen", "oliver@gmail.com", "06438748373")
        );

        List<Course> courses = List.of(
                new Course("Java Fundamentals", "Wim Wiltenburg", 23),
                new Course("IT Service Management", "Usman Ali", 45),
                new Course("No Sql", "Thijs Otter", 23),
                new Course("C#", "Gerwin van Dijken", 56),
                new Course("Web Developement 2", "Mark de Haan", 78)
        );

        userRepository.saveAll(students);
        courseRepository.saveAll(courses);
    }
}
