package com.abhicoder.universityapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    @ManyToOne
    @JsonIgnoreProperties({"courses"})
    private User user;

    public Course(String courseName, String lecturerName, Integer courseDuration, User user) {
        this.courseName = courseName;
        this.lecturerName = lecturerName;
        this.courseDuration = courseDuration;
        this.user = user;
    }
}
