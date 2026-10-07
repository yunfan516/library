package com.atguigu.liteims.controller;

import com.atguigu.liteims.common.Result;
import com.atguigu.liteims.dto.SysUserDTO;
import com.atguigu.liteims.entity.SysUser;
import com.atguigu.liteims.service.SysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "登录注销")
public class LoginController {

    @Autowired
    SysUserService sysUserService;

    @Operation(summary = "通过用户名和密码登录")
    @PostMapping("/login")
    public Result login(@RequestBody SysUserDTO sysUserDTO, HttpSession session) {
        SysUser sysUser = sysUserService.login(sysUserDTO);
        if(sysUser != null){
            session.setAttribute("user", sysUser);
            return Result.success(sysUser);
        }
        return Result.fail("账号或密码错误");
    }

    @Operation(summary = "注销")
    @GetMapping("/logout")
    public Result logout(HttpSession session) {
        if(session!=null){ //session失效时间，默认30分钟。  吃饭回来session已经失效了，直接注销就会报空指针。所以增加这个判断
            session.removeAttribute("user");
            session.invalidate();
        }
        return Result.success(null);
    }

}
