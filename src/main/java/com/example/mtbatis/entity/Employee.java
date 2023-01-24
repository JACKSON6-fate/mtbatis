package com.example.mtbatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("emps")
@ToString
public class Employee {
    private Integer id;
    private String empName;
    private Integer gender;
    private String email;
    private Integer did;
    private Department department;

    public Employee(String empName, Integer gender, String email,Integer did) {
        this.empName = empName;
        this.gender = gender;
        this.email = email;
        this.did = did;
    }

}
