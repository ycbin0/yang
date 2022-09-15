package com.bin.login.util;

import com.bin.common.exception.PasswordErrorException;
import com.bin.common.exception.UserNameNotFoundException;
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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class SecurityUtil {

    private final LoginUserService loginUserService;

    private final AuthenticationManager authenticationManager;

    private final RoleService roleService;

    private final AuthorityService authorityService;

    public SecurityUtil(LoginUserService loginUserService, AuthenticationManager authenticationManager, RoleService roleService, AuthorityService authorityService) {
        this.loginUserService = loginUserService;
        this.authenticationManager = authenticationManager;
        this.roleService = roleService;
        this.authorityService = authorityService;
    }

    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     * @throws UserNameNotFoundException
     * @throws PasswordErrorException
     */
    public String login(String username, String password) throws UserNameNotFoundException, PasswordErrorException, JsonProcessingException {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        setAuthencationMessage(usernamePasswordAuthenticationToken);
        try{
            authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        }catch (UsernameNotFoundException e){
            throw new UserNameNotFoundException("用户名不存在");
        }catch (BadCredentialsException e){
            throw new PasswordErrorException("密码错误");
        }

        LoginUser loginUser = loginUserService.selectLoginUser(username);

        Set<String> authoritySet = new HashSet<>();
        List<Role> roles = roleService.selectByUserId(loginUser.getUserId());
        roles.stream().forEach(item -> {
            List<Authority> authorities = authorityService.selectByRoleId(item.getRoleId());
            authorities.forEach(authority -> authoritySet.add(authority.getAuthCode()));
        });
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authoritySet.stream().forEach(item -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(item);
            authorityList.add(grantedAuthority);
        });

        // 创建当前用户主体信息
        UserTotal userTotal = new UserTotal(username, null, authorityList);
        userTotal.setRoleList(roles);
        List<String> authList = ConvertObjectUtil.setToList(authoritySet);
        String[] auths = ConvertObjectUtil.listToArray(authList, String.class);
        userTotal.setAuths(auths);
        userTotal.setUuid(UuidUtil.getSimpleUUid());
        userTotal.setRoles(ConvertObjectUtil.listToArray(roles.stream().map(i -> i.getRoleName()).collect(Collectors.toList()), String.class));
        return JwtUtil.createToken(userTotal);
    }

    /**
     * 获取当前上下文的authentication对象
     * @return
     */
    private static Authentication getCurrentAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取用户信息
     * @return
     */
    public static Object getUser(){
        return getCurrentAuthentication().getPrincipal();
    }

    /**
     * 获取用户权限信息
     * @return
     */
    public static Collection<? extends GrantedAuthority> getAuthorityList(){
        return getCurrentAuthentication().getAuthorities();
    }

    /**
     * 存储上下文认证信息
     * @param authencationMessage
     */
    public static void setAuthencationMessage(UsernamePasswordAuthenticationToken authencationMessage){
        SecurityContextHolder.getContext().setAuthentication(authencationMessage);
    }


    public static UserTotal getUserTotal(String token) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(JwtUtil.getData("user", token).asString(), UserTotal.class);
    }

}
