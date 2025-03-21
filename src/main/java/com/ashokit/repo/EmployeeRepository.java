package com.ashokit.repo;

import com.ashokit.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findByEmpSalaryGreaterThan(Double empSalary);

    @Query(value = "from Employee")
    public List<Employee> getAll();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO emp_tbl (emp_id, emp_name, emp_salary, emp_gender, dept) VALUES (:#{#employee.empId}, :#{#employee.empName}, :#{#employee.empSalary}, :#{#employee.empGender}, :#{#employee.dept})", nativeQuery = true)
    void saveEmployee(@Param("employee") Employee employee);

    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.empGender = :empGender WHERE e.empId = :empId")
    void updateEmployee(
            @Param("empId") Integer empId,
            @Param("empGender") String empGender
    );

    @Modifying
    @Transactional
    @Query(value="delete from Employee e where e.empId= :empId")
    void deleteEmployee(@Param("empId") Integer empId);

}