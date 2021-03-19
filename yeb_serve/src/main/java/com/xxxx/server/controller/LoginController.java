package com.xxxx.server.controller;

import com.xxxx.server.pojo.Admin;
import com.xxxx.server.pojo.AdminLoginParam;
import com.xxxx.server.pojo.ResBean;
import com.xxxx.server.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * 登陆
 *
 * @author xuzefei
 * @create 2021-03-18-16:38
 */
@Api(tags = "LoginController")
@RestController
public class LoginController {
    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "登入之后返回token")
    @PostMapping("/login")
    public ResBean login(@RequestBody AdminLoginParam adminLoginParam, HttpServletRequest request) {
        return adminService.login(adminLoginParam.getUsername(),
                adminLoginParam.getPassword(),adminLoginParam.getCode(),request);

    }

    @ApiOperation(value = "获取当前用户登陆信息")
    @GetMapping("/admin/info")
    public Admin getAdminInfo(Principal principal) {
        if (principal == null) {
            return null;
        }
        String username = principal.getName();
        Admin admin = adminService.getAdminByUserName(username);
        admin.setPassword(null);
        return admin;
    }

    @ApiOperation(value = "退出登陆")
    @PostMapping("/logout")
    public ResBean logout() {
        return ResBean.success("注销成功");
    }


}
