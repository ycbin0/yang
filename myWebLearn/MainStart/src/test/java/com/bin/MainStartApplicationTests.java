package com.bin;

import com.bin.common.datasource.DbSource;
import com.bin.common.util.ConvertObjectUtil;
import com.bin.common.util.JwtUtil;
import com.bin.common.util.UuidUtil;
import com.bin.login.domain.Authority;
import com.bin.login.domain.LoginUser;
import com.bin.login.domain.Role;
import com.bin.login.domain.UserTotal;
import com.bin.login.mapper.LoginUserMapper;
import com.bin.login.service.AuthorityService;
import com.bin.login.service.LoginUserService;
import com.bin.login.service.RoleService;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class MainStartApplicationTests {

    @Autowired
    private LoginUserMapper loginUserMapper;

    @Autowired
    private LoginUserService loginUserService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthorityService authorityService;
    @Resource
    @Qualifier(value = "passwordEncoder")
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        LoginUser login = new LoginUser();
        login.setUserId(0);
        LoginUser loginUser = loginUserMapper.selectOneLoginUser(login);
        System.out.println(loginUser);
    }


    @Test
    public void ObjToArrays(){
        String s = "snainsi\n dbauybvu ";
        System.out.println(s);
        String s1 = "snainsi\\n dbauybvu ";
        System.out.println(s1);
    }



}
