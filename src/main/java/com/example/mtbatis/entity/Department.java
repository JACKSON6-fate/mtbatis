package com.example.mtbatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.testng.annotations.Test;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Department {
    private Integer id;
    private String deptName;
}
