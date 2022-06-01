package com.abhicoder.universityapi.repository;

import com.abhicoder.universityapi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
