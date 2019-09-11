package com.boottext.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.boottext.entity.User;
import com.boottext.service.UserDaoService;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserDao extends BaseMapper<User> {

}
