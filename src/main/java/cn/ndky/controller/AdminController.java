package cn.ndky.controller;


import cn.ndky.common.Constants;
import cn.ndky.config.Result;
import cn.ndky.entity.Admin;
import cn.ndky.service.AdminService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yaacc
 * @since 2023-07-31
 */
@RestController

@Slf4j
@RequestMapping("/admin")
public class AdminController{
    @Autowired
    private AdminService adminService;

    //登入功能
    @PostMapping("/login")
    public Result<?> login(HttpServletRequest request, @RequestBody Admin adminParam) {
        String password=adminParam.getPassword();
        LambdaQueryWrapper<Admin> lqw=new LambdaQueryWrapper<>();
        lqw.eq(Admin::getAdminNumber, adminParam.getAdminNumber());
        Admin admin=adminService.getOne(lqw);
        if(admin==null){
            return Result.error(Constants.CODE_400,"用户不存在");
        }
        if(!admin.getPassword().equals(password)){
            return Result.error(Constants.CODE_400,"用户名或密码错误");
        }
        request.getSession().setAttribute("adminParam",admin.getId());
        return Result.success(admin);
    }
    //登出功能
    @PostMapping("/logout")
    public Result<?> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("adminParam");
        return Result.success("退出成功");
    }

    //查找所有
    @GetMapping("/all")
    public Result<?> findAll() {
        return Result.success(adminService.list());
    }
    //按id查询
    @GetMapping("/{id}")

    public Result<?> getById(@PathVariable Integer id) {
        log.info("查询的id：{}", id);
        return Result.success(adminService.getById(id));
    }
    @DeleteMapping("/{id}")
    public Result<?> update(@PathVariable Integer id) {
        log.info("将被删除的id：{}", id);
        adminService.removeById(id);
        return Result.success();
    }
}

