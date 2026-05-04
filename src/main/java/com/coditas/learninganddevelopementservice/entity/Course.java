package com.coditas.learninganddevelopementservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name ="duration")
    private Integer duration;

    @Column(name = "yt_link")
    private String ytLink;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;

    @OneToOne(mappedBy = "course")
    private Assignment assignment;


}
