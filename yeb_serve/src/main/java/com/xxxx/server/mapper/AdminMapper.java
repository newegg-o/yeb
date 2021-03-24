package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.Admin;
import com.xxxx.server.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xzf
 * @since 2021-03-16
 */
public interface AdminMapper extends BaseMapper<Admin> {
    List<Admin> getAllAdmins(@Param("id") Integer id, @Param("keywords") String keywords);
    /**
     * 通过用户id查询列表
     * @param id
     * @return
     */

}
