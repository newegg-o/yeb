package com.xxxx.server.controller;


import com.xxxx.server.pojo.Joblevel;
import com.xxxx.server.pojo.Position;
import com.xxxx.server.pojo.ResBean;
import com.xxxx.server.service.IJoblevelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xzf
 * @since 2021-03-16
 */
@RestController
@RequestMapping("/system/basic/joblevel")
public class JoblevelController {
    @Autowired
    private IJoblevelService joblevelService;


    @ApiOperation(value = "获取项目职称")
    @GetMapping("/")
    public List<Joblevel> getAllJobLevels(){
        return joblevelService.list();
    }

    @ApiOperation(value = "添加职称信息")
    @PostMapping("/")
    public ResBean addPosition(@RequestBody Joblevel joblevel){
        joblevel.setCreateDate(LocalDateTime.now());
        if(joblevelService.save(joblevel)){
            return ResBean.success("添加成功");
        }
        return ResBean.error("添加失败");

    }

    @ApiOperation(value = "更新职称信息")
    @PutMapping("/")
    public ResBean updatePosition(@RequestBody Joblevel joblevel){
        if(joblevelService.updateById(joblevel)){
            return ResBean.success("更新成功");

        }
        return ResBean.error("更新失败");

    }

    @ApiOperation(value = "删除职称信息")
    @DeleteMapping("/{id}")
    public ResBean deletePosition(@PathVariable Integer id){
        if(joblevelService.removeById(id)){
            return ResBean.success("删除成功");

        }
        return ResBean.error("删除失败");
    }
    @ApiOperation(value = "批量删除职称信息")
    @DeleteMapping("/")
    public ResBean deletePositionsByIds(Integer[] ids){
        if(joblevelService.removeByIds(Arrays.asList(ids))){
            return ResBean.success("删除成功");

        }
        return ResBean.error("删除失败");
    }



}
