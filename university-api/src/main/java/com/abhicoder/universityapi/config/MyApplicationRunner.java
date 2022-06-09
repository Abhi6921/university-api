package com.abhicoder.universityapi.config;

import com.abhicoder.universityapi.model.Course;
import com.abhicoder.universityapi.model.Parent;
import com.abhicoder.universityapi.model.User;
import com.abhicoder.universityapi.repository.CourseRepository;
import com.abhicoder.universityapi.repository.UserRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Log
@Transactional
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    public MyApplicationRunner(UserRepository userRepository, CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //oneToManyMapping();
        oneToOneMapping();

    }
    private void oneToManyMapping() {
        // String firstName, String lastName, String email, String phoneNumber
        User user1 = new User("Abhishek", "Narvekar", "abhishek@gmail.com", "987643121");
        User user2 = new User("Amrish", "Schaap", "amrish@gmail.com", "43278956");
        User user3 = new User("Tommy", "King", "tomy@gmail.com", "3846538945");

        List<User> users = new ArrayList<>(Arrays.asList(
                user1, user2, user3
        ));

        userRepository.saveAll(users);

        List<Course> courses = List.of(
                // String courseName, String lecturerName, Integer courseDuration, User user
                new Course("Java Advanced", "Wim Wiltenburg", 45, user1),
                new Course("Web Dev 2", "Mark de Haan", 56, user2),
                new Course("Functional Modelling", "Marya Brutt", 34, user3),
                new Course("Haarlem Festival", "Thijs Otter", 67, user3)
        );

        courseRepository.saveAll(courses);
    }

    private void oneToOneMapping() {
        User user = new User("biniam", "king", "biniam@gmail.com", "3409284329");

        Parent parent = new Parent("Janet", "Lisbon", "janet@gmail.com", "938467938476");

        parent.setUser(user);
        user.setParent(parent);

        userRepository.save(user);


    }
}
