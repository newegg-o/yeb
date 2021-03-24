package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xxxx.server.mapper.DepartmentMapper;
import com.xxxx.server.pojo.Department;
import com.xxxx.server.pojo.ResBean;
import com.xxxx.server.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {
    @Autowired(required = false)
    private DepartmentMapper departmentMapper;
    /**
     * 获取所有部门
     * @return
     */
    @Override
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartments(-1);
    }

    /**
     * 删除所有部门
     * @param id
     * @return
     */
    @Override
    public ResBean deleteDep(Integer id) {
        Department department= new Department();
        department.setId(id);
        departmentMapper.deleteDep(department);
        if(department.getResult()==-2){
            return ResBean.error("该部门下有子部门，删除失败");
        }
        if(department.getResult()==-1){
            return ResBean.error("该部门下有员工，删除失败");
        }
        if(department.getResult()==1){
            return ResBean.success("删除成功");
        }
        return ResBean.error("删除失败");
    }

    /**
     * 删除所有部门
     * @param dep
     * @return
     */
    @Override
    public ResBean addDep(Department dep) {

        dep.setEnabled(true);
        departmentMapper.addDep(dep);
        if(dep.getResult()==1){
            return ResBean.success("添加成功",dep);
        }
        return ResBean.error("添加失败");
    }
}
