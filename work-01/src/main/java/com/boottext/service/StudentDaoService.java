package com.boottext.service;

import com.boottext.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentDaoService {

    /**
     * 显示所有学生
     *
     * @return
     */

    List<Student> findall();

    /**
     * 添加学生
     *
     * @param user
     */
    boolean addUser(Student user);

    /**
     * 更新学生信息
     *
     * @param user
     */
    Integer updateUser(Student user);

    /**
     * 删除学生
     * @param id
     * @return
     */
    int deleteUser(Integer id);

    /**
     * 查找一个id
     */
    Student findByid(int id);
    /**
     * 按照用户名查询密码
     */
    Student findByUsername(String username);
    /**
     * id找到user
     */
    Student findById(int id);

}
