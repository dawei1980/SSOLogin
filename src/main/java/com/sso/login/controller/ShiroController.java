package com.sso.login.controller;

import com.sso.login.dto.LoginDTO;
import com.sso.login.entity.SysUser;
import com.sso.login.service.ShiroService;
import com.sso.login.utils.TokenUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author 大誌
 * @Date 2019/3/30 22:04
 * @Version 1.0
 */
@RestController
public class ShiroController {

    private final ShiroService shiroService;

    public ShiroController(ShiroService shiroService) {
        this.shiroService = shiroService;
    }


    /**
     * 登录
     */
    @PostMapping("/sys/login")
    public Map<String, Object> login(@RequestBody LoginDTO loginDTO) {

        Map<String, Object> result = new HashMap<>();
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();

        //用户信息
        SysUser sysUser = shiroService.findByUsername(username);
        //账号不存在、密码错误
        if (sysUser == null || !sysUser.getPassword().equals(password)) {
            result.put("status", 400);
            result.put("msg", "账号或密码有误");
        } else {
            //生成token，并保存到数据库
            result = shiroService.createToken(sysUser.getUserId());
            result.put("status", 200);
            result.put("msg", "登陆成功");
        }
        return result;
    }

    /**
     * 退出
     */
    @PostMapping("/sys/logout")
    public Map<String, Object> logout(String token , HttpServletRequest httpServletRequest) {
        Map<String, Object> result = new HashMap<>();
        //参数里的token是swagger测试用，开发中用下面方法
        token = TokenUtil.getRequestToken(httpServletRequest);
        shiroService.logout(token);
        result.put("status", "200");
        result.put("msg", "您已安全退出系统");
        return result;
    }
}


