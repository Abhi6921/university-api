package com.abhicoder.universityapi.controller;

import com.abhicoder.universityapi.model.Course;
import com.abhicoder.universityapi.model.Student;
import com.abhicoder.universityapi.repository.CourseRepository;
import com.abhicoder.universityapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@RequestMapping(value = "courses", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> storeCourses = courseService.getAllCourses();
        return new ResponseEntity<>(storeCourses, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Course> addCourse(@RequestBody Course newcourse) {
        Course storeCourse = courseService.addCourse(newcourse);
        return new ResponseEntity<>(storeCourse, HttpStatus.CREATED);
    }
}
