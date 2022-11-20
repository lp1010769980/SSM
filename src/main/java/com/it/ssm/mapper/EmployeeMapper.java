package com.it.ssm.mapper;

import com.it.ssm.pojo.Employee;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface EmployeeMapper {
    /**
     * 查询所有的员工信息
     * @return
     */
    List<Employee> getAllEmployee();

    /**
     * 根据id查询员工信息
     *
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
     * 修改员工信息
     * @param employee
     */
    void updateEmployee(Employee employee);

    /**
     * 删除员工信息
     * @param id
     */
    void deleteEmployeeById(Integer id);


}
