package com.ashokit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emp_tbl")
public class Employee {


//    @GeneratedValue(strategy = GenerationType.IDENTITY) -> When use mysql database
//    @GeneratedValue(strategy = GenerationType.SEQUENCE) -> When use oracle database
//    @GeneratedValue(strategy = GenerationType.TABLE) -> When use mysql database and hibernate maintain a table
//    so that approch cannot recommended
//    @GeneratedValue(strategy = GenerationType.AUTO) -> Automatic detect database

    //And below code for custom empId generator
    @Id
    @GeneratedValue(generator = "custom_order_id_generator")
    @GenericGenerator(name = "custom_order_id_generator", strategy = "com.ashokit.generators.OrderIdGenerator")
    private String empId; // Ensure this is a String

    @Column(name = "emp_name", nullable = false, length = 100)
    private String empName;

    @Column(name = "emp_salary", nullable = false)
    private Double empSalary;

    @Column(name = "emp_gender", nullable = false, length = 10)
    private String empGender;

    @Column(name = "department", nullable = false, length = 50)
    private String dept;

    @CreationTimestamp
    @Column(name = "date_created", updatable = false)
    private LocalDate dateCreated;

    @UpdateTimestamp
    @Column(name = "last_updated", insertable = false)
    private LocalDate lastUpdated;
}