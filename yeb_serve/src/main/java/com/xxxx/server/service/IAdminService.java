package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.Admin;
import com.xxxx.server.pojo.Menu;
import com.xxxx.server.pojo.ResBean;
import com.xxxx.server.pojo.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xzf
 * @since 2021-03-16
 */
public interface IAdminService extends IService<Admin> {
    /**
     * 登陆后放回token
     *
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */

    ResBean login(String username, String password, String code, HttpServletRequest request);

    /**
     * 根据用户名获取用户
     *
     * @param username
     * @return
     */
    Admin getAdminByUserName(String username);

    /**
     * 根据id查询角色列表
     * @param adminId
     * @return
     */
    List<Role> getRoles(Integer adminId) ;
}
