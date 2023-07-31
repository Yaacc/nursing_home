package cn.ndky.controller;


import cn.ndky.entity.Employee;
import cn.ndky.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yaacc
 * @since 2023-07-31
 */
@RestController
@RequestMapping("//employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping
    public List<Employee> findAll(){
        return employeeService.list();
    }
    @PostMapping
    public boolean newEmployee(@RequestBody Employee employee){
        return employeeService.saveOrUpdate(employee);
    }
    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Integer id){
        return employeeService.removeById(id);
    }
}

