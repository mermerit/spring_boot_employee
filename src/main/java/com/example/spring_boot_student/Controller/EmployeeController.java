package com.example.spring_boot_student.Controller;

import com.example.spring_boot_student.welcom.Message;
import com.example.spring_boot_student.exception.ResourseNotFoundException;
import com.example.spring_boot_student.modul.Employee;
import com.example.spring_boot_student.modul.JobEntity;
import com.example.spring_boot_student.repository.EmployeeRepository;
import com.example.spring_boot_student.repository.JobentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private JobentityRepository jobentityRepository;
    @Autowired
    @Qualifier("Upusercase")
    private Message upsercase;
    @Autowired
    @Qualifier("MessageWelcom")
    private Message message1;

    public EmployeeController(EmployeeRepository repository) {

    }


    @GetMapping("/")
    public String index()
    {
        return upsercase.text("meran ") +message1.text();
    }

    @GetMapping("employees")
    public List <Employee> findAll()
    {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findById(@PathVariable (value = "id")Long employeeId)
            throws ResourseNotFoundException {
        Employee employee =employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourseNotFoundException("Employee not found for this id" +employeeId));
        return ok().body(employee);

    }
    @PostMapping("employees")
    public Employee add(@RequestBody Employee employee)
    {
        return this.employeeRepository.save(employee);
    }

    @PutMapping("employees/{id}")
    public ResponseEntity <Employee>update(@PathVariable(value = "id")Long employeeId
    , @Validated @RequestBody Employee employeeDetails  ) throws ResourseNotFoundException
    { Employee employee =employeeRepository.findById(employeeId)
            .orElseThrow(()-> new ResourseNotFoundException("Employee not found for this id" +employeeId));

        employee.setEmail(employeeDetails.getEmail());
        employee.setName(employeeDetails.getName());

    return ok(this.employeeRepository.save(employee));
    }

    @DeleteMapping("employees/{id}")
    public Map<String,Boolean> deleteById(@PathVariable (value = "id")Long employeeId) throws ResourseNotFoundException{

        Employee employee =employeeRepository.findById(employeeId)
        .orElseThrow(()-> new ResourseNotFoundException("employee not found "+employeeId) );
    this.employeeRepository.delete(employee);
    Map<String ,Boolean> responce = new HashMap<>();
    responce.put("deleted " +employeeId +" id",Boolean.TRUE);
    return responce;
    }

    @PutMapping("employees/job/{id}")
    public ResponseEntity<JobEntity> update_job(@PathVariable(value = "id")int id
            , @Validated @RequestBody JobEntity jobDetails  ) throws ResourseNotFoundException
    { JobEntity jobEntity =jobentityRepository.findById(id)
            .orElseThrow(()-> new ResourseNotFoundException("Employee not found for this id" +id));

        jobEntity.setName(jobDetails.getName());
        return ok(this.jobentityRepository.save(jobEntity));

    }

    @GetMapping("employees/job")
    public List <JobEntity> getAllJob()
    {
        return jobentityRepository.findAll();
    }





}
