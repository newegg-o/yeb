package com.xxxx.server.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.Role;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xzf
 * @since 2021-03-16
 */
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 根据id查询角色列表
     *
     * @param adminId
     * @return
     */
    List<Role> getRoles(Integer adminId);
}
