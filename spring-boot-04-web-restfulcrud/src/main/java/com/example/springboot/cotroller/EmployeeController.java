package com.example.springboot.cotroller;

import com.example.springboot.dao.DepartmentDao;
import com.example.springboot.dao.EmployeeDao;
import com.example.springboot.entities.Department;
import com.example.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);
        //thymeleaf默认拼串
        //classpath:/templates/xxxx.html
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toaddpage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    //添加员工
    //springMVC会自动将请求的请求参数与入参对象进行一一绑定，要求请求参数的名字和Javabean入参的对象里面的属性名是一样的
    public String addemp(Employee employee){
        System.out.println("保存的员工信息："+employee);
        //保存员工
        employeeDao.save(employee);
        //来到员工页面
        //redirect:表示重定向到某一地址    /代表当前路径
        //forward：表示转发到某一地址
        return "redirect:/emps";
    }

    //来到修改页面，查出当前员工并进行回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id")Integer id,
                             Model model){
        //需要显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        //回到修改页面（add是一个二合一的页面）
        return "emp/add";
    }

    //修改员工
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("保存的员工信息："+employee);
        //保存员工
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }



    ///////
}
