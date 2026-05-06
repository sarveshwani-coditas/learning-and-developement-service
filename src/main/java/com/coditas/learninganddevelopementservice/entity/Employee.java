package com.coditas.learninganddevelopementservice.entity;

import com.coditas.learninganddevelopementservice.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name ="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name ="status")
    private Status status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Enrollment> enrollment;

    @OneToMany(mappedBy = "employee")
    private List<AssignmentAttempt> assignmentAttempts;

    @OneToMany(mappedBy = "employee")
    private List<Certificate> certificates;

}
