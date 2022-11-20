package com.it.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.it.ssm.pojo.Employee;
import com.it.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 *查询所有的员工信息-->/employee-->get
 * 查询员工的分页信息-->/employee/page/1-->get
 *根据id查询员工信息-->/employee/1-->get
 *跳转到添加页面-->/to/add-->get
 *添加员工信息-->/employee-->post
 *修改员工信息-->/employee-->put
 *删除员工信息-->/employee/1-->delete
 * @author 卢鹏
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee/page/{pageNum}",method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("pageNum") Integer pageNum,Model model){
        //获取员工信息的分页信息
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNum);
        //将分页数据共享到请求域中
        model.addAttribute("page",page);
        //跳转到employee_list.html
        return "employee_list";
    }
    
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        //查询所有的员工信息
        List<Employee> list = employeeService.getAllEmployee();
        // 将员工信息在请求域中共享
        model.addAttribute("list",list);
        //跳转到employee_list.html
        return "employee_list";
    }

    //根据id查询员工信息并跳转到修改页面
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id ,Model model){
        // 查询员工信息
        Employee employee = employeeService.getEmployeeById(id);
        // 将员工信息在请求域中共享
        model.addAttribute("employee", employee);
        // 跳转到employee_update.html
        return "employee_update";
    }

    //跳转到添加员工页面并返回列表页面
    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        // 添加员工信息
        employeeService.addEmployee(employee);
        // 跳转到employee_list.html
        return "redirect:/employee/page/1";
    }

    //修改页面修改员工信息并返回列表页面
    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String updateEmployee(Employee employee) {
        // 修改员工信息
        employeeService.updateEmployee(employee);
        // 跳转到employee_list.html
        return "redirect:/employee/page/1";

    }
    //删除员工信息
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        // 删除员工信息
        employeeService.deleteEmployeeById(id);
        // 跳转到employee_list.html
        return "redirect:/employee/page/1";

    }

}
