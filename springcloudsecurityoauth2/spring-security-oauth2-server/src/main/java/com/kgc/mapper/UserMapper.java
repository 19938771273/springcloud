package com.kgc.mapper;

import com.kgc.entity.TbPermission;
import com.kgc.entity.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    public TbUser getUserByUserName(@Param("username") String username);

    /**
     * 更具用户id查询权限
     * @param id
     * @return
     */
    public List<TbPermission> getPermissionByUserId(@Param("userId") int iuseId);
}
