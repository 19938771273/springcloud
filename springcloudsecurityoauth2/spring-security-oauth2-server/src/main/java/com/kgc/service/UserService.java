package com.kgc.service;

import com.kgc.entity.TbPermission;
import com.kgc.entity.TbUser;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    /**
     *
     * @param userName
     * @return TbUser
     * 更具用户名查询用户
     */
    public TbUser getUserByuserName(String userName);

    /**
     *
     * @param userId
     * @return TbPermission
     * 更具用户id查询权限
     */
    public List<TbPermission> getTbpermissionByuserName(int userId);
}
