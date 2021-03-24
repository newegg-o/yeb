package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.MenuRole;
import com.xxxx.server.pojo.ResBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xzf
 * @since 2021-03-16
 */
public interface IMenuRoleService extends IService<MenuRole> {
    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    ResBean updateMenuRole(Integer rid, Integer[] mids);
}
