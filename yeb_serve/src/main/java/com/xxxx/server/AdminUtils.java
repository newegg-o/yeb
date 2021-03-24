package com.xxxx.server;

import com.xxxx.server.pojo.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 操作员工具类
 *
 * @author 呵呵厉害了
 * @date 2021/03/23 12:34
 **/

/**
 * 获取当前登陆操作员
 */
public class AdminUtils {
    public  static Admin getCurrentAdmin(){
        return  (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    }
}
