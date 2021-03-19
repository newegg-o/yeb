package com.xxxx.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

/**
 * 用户登陆实体类
 * @author xuzefei
 * @create 2021-03-18-16:11
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "AdminLogin对象",description = "")
public class AdminLoginParam {
    @ApiModelProperty(value = "用户名",required=true)
    private String username;
    @ApiModelProperty(value = "密码",required=true)
    private String password;
    @ApiModelProperty(value = "验证码",required = true)
    private String code;


}
