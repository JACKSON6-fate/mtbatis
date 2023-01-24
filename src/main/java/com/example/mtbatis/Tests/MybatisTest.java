package com.example.mtbatis.Tests;

import com.example.mtbatis.dao.EmployeeMapper;
import com.example.mtbatis.entity.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class MybatisTest {
    public SqlSessionFactory sqlSessionFactory;

    @Test
    public void test() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatisconfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> emps = mapper.getEmpById(null, null, "i");
        for (Employee emp : emps) {
            System.out.println(emp);
        }


    }

    @Test
    public void test2() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatisconfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee mengjia = new Employee("mengjia", 0, "wangmengjia@qq.com",1);
        System.out.println(mengjia);
        int res = mapper.insertEmployee(mengjia);
        System.out.println(mengjia);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatisconfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        int res = mapper.updateEmployee(new Employee(3,"wang",0,"popo@com",1,null));

        sqlSession.commit();
        sqlSession.close();
        System.out.println(res);
    }

    @Test
    public void test4() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatisconfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        boolean res = mapper.deleteEmployeeById(5);

        sqlSession.commit();
        sqlSession.close();
        System.out.println(res);
    }

    @Test
    public void test5() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatisconfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee emp = mapper.getEmp(1);
        System.out.println(emp);
        sqlSession.close();
    }


    @Test
    public void test6() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatisconfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(3);
        List<Employee> emps = mapper.getEmps(ids);

        for (Employee emp : emps) {
            System.out.println(emp);
        }

    }

}
