package com.xxxx.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxxx.server.pojo.*;
import com.xxxx.server.service.IMenuRoleService;
import com.xxxx.server.service.IMenuService;
import com.xxxx.server.service.IRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 权限组
 *
 * @author 呵呵厉害了
 * @date 2021/03/21 10:41
 **/
@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IMenuService menuService;

    @Autowired
    private IMenuRoleService menuRoleService;

    @ApiOperation(value = "获取所有角色")
    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleService.list();
    }

    @ApiOperation(value = "添加角色信息")
    @PostMapping("/role")
    public ResBean addPosition(@RequestBody Role role) {
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());

        }
        if (roleService.save(role)) {
            return ResBean.success(("添加成功"));
        }
        return ResBean.error("添加失败");

    }

//    @ApiOperation(value = "更新职称信息")
//    @PutMapping("/")
//    public ResBean updatePosition(@RequestBody Joblevel joblevel){
//        if(joblevelService.updateById(joblevel)){
//            return ResBean.success("更新成功");
//
//        }
//        return ResBean.error("更新失败");
//
//    }

    @ApiOperation(value = "删除角色信息")
    @DeleteMapping("/role/{rid}")
    public ResBean deleteRole(@PathVariable Integer rid) {
        if (roleService.removeById(rid)) {
            return ResBean.success("删除成功");

        }
        return ResBean.error("删除失败");
    }

    @ApiOperation(value = "查询所有菜单")
    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @ApiOperation(value = "根据角色id查询菜单id")
    @GetMapping("/mid/{rid}")
    public List<Integer> getMidByRid(@PathVariable Integer rid) {

        return menuRoleService.list(new QueryWrapper<MenuRole>().eq("rid",rid))
                .stream().map(MenuRole::getMid).collect(Collectors.toList());
    }

    @ApiOperation(value = "更新角色菜单")
    @PutMapping("/")
    public ResBean updateMenuRole(Integer rid,Integer[] mids){
        return menuRoleService.updateMenuRole(rid,mids);
    }
}
