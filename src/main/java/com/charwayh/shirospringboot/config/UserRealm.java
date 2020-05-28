package com.charwayh.shirospringboot.config;


import com.charwayh.shirospringboot.pojo.User;
import com.charwayh.shirospringboot.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService userService = null;


    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=》授权doGetAuthorizationInfo");
        return null;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了=》认证doGetAuthorizationInfo");


        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;

        User user = userService.queryUserByName(usernamePasswordToken.getUsername());

        if(user == null){
            // 抛出异常
            return null;
        }
        return new SimpleAuthenticationInfo("",user.getPassword(),"");
    }
}
