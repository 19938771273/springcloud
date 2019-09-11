package com.boottext.impl;

import com.boottext.entity.Student;
import com.boottext.mapper.StudentDao;
import com.boottext.service.StudentDaoService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentDaoService {
    @Autowired
    private StudentDao dao;
    @Override
    public List<Student> findall() {

        return dao.findall();
    }

    @Override
    public boolean addUser(Student user) {
          return dao.addUser(user);
    }

    @Override
    public Integer updateUser(Student user) {
         return   dao.updateUser(user);
    }

    @Override
    public int deleteUser(Integer id) {
        dao.deleteUser(id);
        return 0;
    }

    @Override
    public Student findByid(int id) {
        return dao.findByid(id);
    }

    @Override
    public Student findByUsername(String username) {
        return dao.findByUsername(username);
    }

    @Override
    public Student findById(int id) {
        return this.dao.findById(id);
    }


}
