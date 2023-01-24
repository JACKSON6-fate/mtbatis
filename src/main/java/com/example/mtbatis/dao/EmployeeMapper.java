package com.example.mtbatis.dao;

import com.example.mtbatis.entity.Department;
import com.example.mtbatis.entity.Employee;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

public interface EmployeeMapper{
    public List<Employee> getEmpById(@Param("id") Integer id, @Param("did") Integer did,@Param("email") String email);
    public int updateEmployee(Employee emp);
    public boolean deleteEmployeeById(Integer id);
    public int insertEmployee(Employee employee);
    public List<Employee> getEmps(List ids);

    public Department getDeptById(Integer id);

    //基于注解的配置
    @Select("select * from t_employee where id = #{id}")
    public Employee getEmp(Integer id);
}
