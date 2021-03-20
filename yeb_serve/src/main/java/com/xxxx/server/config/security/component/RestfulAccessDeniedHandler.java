package com.xxxx.server.config.security.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xxxx.server.pojo.ResBean;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 访问接口没有权限时。自定义返回结果
 *
 * @author 呵呵厉害了
 * @date 2021/03/18 22:55
 **/
@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {


    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json");
        PrintWriter out = httpServletResponse.getWriter();
        ResBean bean = ResBean.error("权限不足，联系管理员");
        bean.setCode(403);
        out.write(new ObjectMapper().writeValueAsString(bean));
        out.flush();
        out.close();
    }
}
