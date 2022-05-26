package com.example.spring_boot_student.modul;

import liquibase.pro.packaged.E;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class JobEntity {
    @Id
    @SequenceGenerator(name = "job_sequence",
            sequenceName = "job_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "job_sequence")
    @Column(name = "job_id")
    private int id;
    private String name;



}
