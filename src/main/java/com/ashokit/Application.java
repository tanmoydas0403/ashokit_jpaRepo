package com.ashokit;

import com.ashokit.entity.Employee;
//import com.ashokit.generators.OrderIdGenerator;
import com.ashokit.repo.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ashokit.repo")
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctxt = SpringApplication.run(Application.class, args);
		EmployeeRepository repo = ctxt.getBean(EmployeeRepository.class);
		System.out.println(repo.getClass().getName());
//		Employee emp1=new Employee();
//		emp1.setEmpId(1);
//		emp1.setEmpName("Tanmoy Das");
//		emp1.setEmpGender("Male");
//		emp1.setEmpSalary(5000.00);
//		emp1.setDept("Account");
//
//		Employee emp2=new Employee();
//		emp2.setEmpId(2);
//		emp2.setEmpName("Tarun Das");
//		emp2.setEmpSalary(15000.00);
//		emp2.setDept("Admin");
//		emp1.setEmpGender("Male");
//
//		Employee emp3=new Employee();
//		emp3.setEmpId(3);
//		emp3.setEmpName("Mrinmoy Das");
//		emp3.setEmpSalary(5500.00);
//		emp3.setDept("Admin");
//		emp1.setEmpGender("Male");
//
//		Employee emp4=new Employee(4,"Kajal Das", 2500.00,"Fe-Male","Manager");
//		Employee emp5=new Employee(5,"Gita Das", 6500.00,"Fe-Male","Manager");
//		Employee emp8=new Employee(6,"Ranjith Das", 4500.00,"Male","Admin");
//		Employee emp6=new Employee(7,"Suresh Das", 3500.00,"Male","Account");
//		Employee emp7=new Employee(8,"Priya Das", 7500.00,"Fe-Male","Account");
//
//		repo.saveAll(Arrays.asList(emp1,emp2,emp3,emp4,emp5,emp6,emp7,emp8));

//		Sort empNameAsc = Sort.by("empName").ascending();
//		List<Employee> asc = repo.findAll(empNameAsc);
//		asc.forEach(System.out::println);
//		System.out.println("----------------------------------------------------------------");
//
//		Sort empSalaryDsc = Sort.by("empSalary").descending();
//		List<Employee> dsc = repo.findAll(empSalaryDsc);
//		dsc.forEach(System.out::println);
//
 //		System.out.println("-----------------------------Pagination-----------------------------------");
//		int pageNo=2;
//		PageRequest page = PageRequest.of(pageNo - 1, 3);
//		Page<Employee> allByPage = repo.findAll(page);
//		List<Employee> content = allByPage.getContent();
//		content.forEach(System.out::println);

//		System.out.println("-----------------------------Search by Gender-----------------------------------");
//		Employee emp=new Employee();
//		emp.setEmpGender("Fe-Male");
//		Example<Employee> of = Example.of(emp);
//		List<Employee> emps = repo.findAll(of);
//		emps.forEach(System.out::println);
//
//		System.out.println("-----------------------------Search by Department-----------------------------------");
//
//		Employee emp1=new Employee();
//		emp1.setDept("Admin");
//		Example<Employee> filterByAdmin = Example.of(emp1);
//		List<Employee> emps1 = repo.findAll(filterByAdmin);
//		emps1.forEach(System.out::println);


//		List<Employee> byEmpSalaryGreaterThan = repo.findByEmpSalaryGreaterThan(5000.00);
//		byEmpSalaryGreaterThan.forEach(System.out::println);

		System.out.println("------------Custom Query-----------------");
//		System.out.println("--------------get all------------------");
//		List<Employee> all = repo.getAll();
//		all.forEach(System.out::println);

//		System.out.println("------------Custom Query for save----------------");
//		Employee e1=new Employee(9,"Tarak Das",9000.00,"Male","HR");
//		Employee e2=new Employee(10,"Piu Das",7000.00,"Fe-Male","Marketing");
//		repo.saveEmployee(e1);
//		repo.saveEmployee(e2);

//		repo.saveEmployee(new Employee(11,"Tanu Biswas",9000.00,"Male","Marketing"));
//		System.out.println("-----Update Query-------")
//		repo.updateEmployee(2,"Male");
//		repo.updateEmployee(3,"Male");

//		System.out.println("--------------Delete Query----------------------");
//		repo.deleteEmployee(11);

//		OrderIdGenerator.setPrefix("EMP_");
		Employee emp=new Employee();
		emp.setEmpName("RajaRani");
		emp.setDept("Admin");
		emp.setEmpSalary(50000.00);
		emp.setEmpGender("Fe-Male");
		repo.save(emp);
	}

}
