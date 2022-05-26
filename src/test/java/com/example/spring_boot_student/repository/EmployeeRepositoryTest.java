package com.example.spring_boot_student.repository;

import com.example.spring_boot_student.modul.Employee;
import com.example.spring_boot_student.modul.JobEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository repository;

    @Test
    public void saveStudent(){
        JobEntity jobEntity = JobEntity.builder()
                .name("accountant")
                .build();

        Employee employee= Employee.builder()
                .email("mohamadcommm")
                .name("meranl")
                .jobEntity(jobEntity)
                .build();
    repository.save(employee);
    }
    @Test
   public void getStudent()
   {
    List <Employee>employees=
    repository.findAll();
       System.out.println(employees);
   }
    @Test
    public void printStudentByEmailAddressNativeNamedId(){
        Employee employee=repository.getEmployeeByEmailAddress("mohamad.gmail");
        System.out.println("student "+employee);
    }



}