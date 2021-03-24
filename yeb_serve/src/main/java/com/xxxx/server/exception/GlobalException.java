package com.xxxx.server.exception;

import com.xxxx.server.pojo.ResBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理
 *
 * @author 呵呵厉害了
 * @date 2021/03/20 23:25
 **/
@RestControllerAdvice
public class GlobalException {

//    @ExceptionHandler(SQLException.class)
//    public ResBean mysqlException(SQLException e){
//        if(e instanceof SQLIntegrityConstraintViolationException) {
//            return ResBean.error("该数据有关联数据，操作失败");
//        }
//        return ResBean.error("数据库异常，操作失败");
//    }
}
