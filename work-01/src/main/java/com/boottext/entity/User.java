package com.boottext.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.sun.xml.internal.bind.v2.model.core.ID;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Table;

@Slf4j
@Data
@Table(name="user")
public class User {
    @TableId(value = "ID",type = IdType.AUTO)
    private int id;
    private String name;
    private int age;
    private String email;

    public User(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
