package com.xxxx.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 公共分页返回对象
 *
 * @author 呵呵厉害了
 * @date 2021/03/24 22:39
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResPageBean {
    /**
     * 总条数
     */
    private Long total;
    /**
     * 数据list
     */
    private List<?> data;
}
