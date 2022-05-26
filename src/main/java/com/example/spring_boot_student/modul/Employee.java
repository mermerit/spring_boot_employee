package com.example.spring_boot_student.modul;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@ToString

public class Employee {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name = "name")
    private String name;

    @Column(unique = true)
    private String email;

    @OneToOne( cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private JobEntity jobEntity;



}

