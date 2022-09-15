package com.bin.config.security.authority;

import com.bin.login.domain.LoginUser;
import com.bin.login.domain.UserTotal;
import com.bin.login.util.SecurityUtil;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MyCustomizeAuthority
 * @Description: 自定义权限认证类
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
@Component("auth")
public class MyCustomizeAuthority {

    /**
     * 判断是否有该角色
     * @param roleName
     * @return
     */
    public boolean hasRole(String roleName){
        if(roleName == null || "".equals(roleName)){
            return false;
        }
        UserTotal user = (UserTotal) SecurityUtil.getUser();
        String[] roles = user.getRoles();
        for (String i: roles) {
            if(roleName.equals(i)){
                return true;
            }
        }
        return false;
    }
}
