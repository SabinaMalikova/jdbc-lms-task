package peaksoft;

import peaksoft.model.Employee;
import peaksoft.model.Job;
import peaksoft.service.EmployeeService;
import peaksoft.service.JobService;
import peaksoft.service.serviceImpl.EmployeeServiceImpl;
import peaksoft.service.serviceImpl.JobServiceImpl;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        JobService jobService = new JobServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();

//        System.out.println("Create table jobs: ");
//        jobService.createJobTable();
//
//        System.out.println("Create table employees: ");
//        employeeService.createEmployee();
//
//        System.out.println("Add job to table: ");
//        jobService.addJob(new Job("instructor","developer","middle",3));
//        jobService.addJob(new Job("mentor","developer","junior",1));
//        jobService.addJob(new Job("javist","developer","senior",8));
//
//        System.out.println("Add Employee to table: ");
//        employeeService.addEmployee(new Employee("Sasha","Alexsandrovba",18,"sasha@gmail.com",2L));
//        employeeService.addEmployee(new Employee("Masha","Mihailova",28,"masha@gmail.com",1L));
//        employeeService.addEmployee(new Employee("Dasha","Smirnova",25,"dasha@gmail.com",3L));
//        employeeService.addEmployee(new Employee("Artem","Karaev",24,"artem@gmail.com",3L));
//
//        System.out.println("get job by id:");
//        System.out.println(jobService.getJobById(1L));
//
//        System.out.println("Выберите asc или desc:");
//        System.out.println(jobService.sortByExperience(new Scanner(System.in).nextLine()));
//
//        System.out.println("get job by Employee Id");
//        System.out.println(jobService.getJobByEmployeeId(1L));
//
//        System.out.println("delete Description Column");
//        jobService.deleteDescriptionColumn();
//
//        System.out.println("drop Table employee: ");
//        employeeService.dropTable();
//
//        System.out.println("clean Table");
//        employeeService.cleanTable();
//
//        System.out.println("update Employee: ");
//        Employee employee = new Employee("Grisha","Grushevich",45,"grisha@gmail.com",2L);
//        employeeService.updateEmployee(5L,employee);
//
//        System.out.println("get All Employees: ");
//        System.out.println(employeeService.getAllEmployees());
//
//        System.out.println("find By Email: ");
//        System.out.println(employeeService.findByEmail("dasha@gmail.com"));

//        System.out.println("get Employee By Position: ");
//        System.out.println(employeeService.getEmployeeByPosition("mentor"));

//        System.out.println("get Employee By Id:");
//        System.out.println(employeeService.getEmployeeById(5L));


    }
}
