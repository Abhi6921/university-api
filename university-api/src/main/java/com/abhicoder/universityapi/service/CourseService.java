package com.abhicoder.universityapi.service;

import com.abhicoder.universityapi.model.Course;
import com.abhicoder.universityapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    public Course addCourse(Course newCourse) {
        try {
            Course storeCourse = courseRepository.save(newCourse);
            return storeCourse;
        }
        catch (Exception ex) {
            throw new IllegalArgumentException("Something went wrong in saving the course");
        }
    }

}
