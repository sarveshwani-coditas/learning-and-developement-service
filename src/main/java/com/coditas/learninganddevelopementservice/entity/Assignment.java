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
@Table(name = "assignment")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "name")
    private String AssignmentName;

    @Column(name ="total_marks")
    private Integer totalMarks;

    @OneToMany(mappedBy = "assignment")
    private List<AssignmentAttempt> assignmentAttempts;


}
