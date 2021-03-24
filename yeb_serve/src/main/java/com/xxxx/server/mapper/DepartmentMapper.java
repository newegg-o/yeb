package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.Department;
import com.xxxx.server.pojo.ResBean;

import java.util.List;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xzf
 * @since 2021-03-16
 */
public interface DepartmentMapper extends BaseMapper<Department> {
    /**
     * 获取所有部门
     * @return
     */
    List<Department> getAllDepartments(Integer parentId);

    /**
     * 删除所有部门
     * @param department
     * @return
     */
    void deleteDep(Department department);

    /**
     * 添加部门
     * @param dep
     */
    void addDep(Department dep);
}
