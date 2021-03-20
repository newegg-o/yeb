package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.server.mapper.MenuMapper;
import com.xxxx.server.pojo.Admin;
import com.xxxx.server.pojo.Menu;
import com.xxxx.server.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xzf
 * @since 2021-03-16
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 根据用户id查询菜单
     *
     * @return
     */
    @Override
    public List<Menu> getMenusByAdminId() {
        Integer adminId = ((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        //从redis获取菜单数据

        List<Menu> menus = (List<Menu>) valueOperations.get("menu_" + adminId);
        //如果为空，去数据库
        if(CollectionUtils.isEmpty(menus)){
            menus = menuMapper.getMenusByAdminId(adminId);
            //将数据存入Redis
            valueOperations.set("menu_"+adminId,menus);
        }
        return menus;
    }
}
