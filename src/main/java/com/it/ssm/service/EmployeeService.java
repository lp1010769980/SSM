package com.it.ssm.service;

import com.github.pagehelper.PageInfo;
import com.it.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeService {


    /**
     * 查询所有员工信息
     * @return
     */
    List<Employee> getAllEmployee();



    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    Employee getEmployeeById(Integer id);

    /**
     * 添加员工信息
     * @param employee
     * @return
     */
    void addEmployee(Employee employee);


    /**
     * 修改用户信息
     * @param employee
     */
    void updateEmployee(Employee employee);

    /**
     * 删除员工信息
     * @param id
     */
    void deleteEmployeeById(Integer id);

    /**
     * 获取员工的分页信息
     * @param pageNum
     * @return
     */
    PageInfo<Employee> getEmployeePage(Integer pageNum);
}
