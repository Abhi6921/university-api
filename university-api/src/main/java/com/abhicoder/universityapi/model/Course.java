package com.abhicoder.universityapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long courseId;
    private String courseName;
    private String lecturerName;
    private Integer courseDuration;

    public Course(String courseName, String lecturerName, Integer courseDuration) {
        this.courseName = courseName;
        this.lecturerName = lecturerName;
        this.courseDuration = courseDuration;
    }
}
