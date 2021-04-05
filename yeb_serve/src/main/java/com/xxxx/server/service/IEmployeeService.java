package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.Employee;
import com.xxxx.server.pojo.ResBean;
import com.xxxx.server.pojo.ResPageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xzf
 * @since 2021-03-16
 */
public interface IEmployeeService extends IService<Employee> {
    /**
     * 获取所有员工
     * @param currentPage
     * @param size
     * @param employee
     * @param beginDateScope
     * @return
     */
    ResPageBean getEmployeeByPage(Integer currentPage, Integer size, Employee employee, LocalDate[] beginDateScope);

    /**
     * 获取工号
     * @return
     */
    ResBean maxWorkID();

    /**
     * 添加员工
     * @param employee
     * @return
     */
    ResBean addEmp(Employee employee);

    /**
     * 查询员工
     * @param id
     * @return
     */
    List<Employee> getEmployee(Integer id);

    /**
     * 获取所有员工账套
     * @param currentPage
     * @param size
     * @return
     */
    ResPageBean getEmployeeWithSalary(Integer currentPage, Integer size);
}
