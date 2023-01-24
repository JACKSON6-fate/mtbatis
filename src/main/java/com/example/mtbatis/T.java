package com.example.mtbatis;

import com.example.mtbatis.dao.EmployeeMapper;
import com.example.mtbatis.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class T {
    public static void main(String[] args) throws IOException {
        /**
         * 根据全局配置文件创建出一个sqlSessionFactory
         * SqlSessionFactory: 是SqlSession工厂 负责创建SqlSession对象
         * SqlSession: sql会话 代表和数据库的一次会话
         * */
        String resource = "mybatisconfig.xml";
        InputStream asStream = Resources.getResourceAsStream(resource);
        System.out.println("hello push");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(asStream);
        //获取和数据库的一次会话  相当于 getConnection()
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            //使用sqlSession操作数据库 获取到dao接口的实现
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            //Employee empById = mapper.getEmpById(1);
            //System.out.println(empById);
        }finally {
            sqlSession.close();
        }
    }
}
