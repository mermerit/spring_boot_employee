package com.example.spring_boot_student.Controller;

import com.example.spring_boot_student.modul.Employee;
import com.example.spring_boot_student.repository.EmployeeRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.verify;


class EmployeeControllerTest {
    @Mock
    private EmployeeRepository repository;
    private AutoCloseable autoCloseable;
    private EmployeeController udertest;



@BeforeEach
void setUp()
{    autoCloseable =MockitoAnnotations.openMocks(this);
    udertest=new EmployeeController(repository);
}

    @AfterEach
    void tearDown() throws Exception {
    autoCloseable.close();

    }

    @Test
    void index() {
    }

    @Test
    void findAll() {

    udertest.findAll();
    verify(repository).findAll();

}

    @Test
    void findById() {
    }

    @Test
    void add() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }
}