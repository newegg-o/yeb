package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.Department;
import com.xxxx.server.pojo.ResBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xzf
 * @since 2021-03-16
 */
public interface IDepartmentService extends IService<Department> {
    /**
     * 获取所有部门
     * @return
     */
    List<Department> getAllDepartments();

    /**
     * 删除所有部门
     * @param id
     * @return
     */
 ResBean deleteDep(Integer id);

    /**
     * 添加部门
     * @param dep
     * @return
     */
    ResBean addDep(Department dep);
}
