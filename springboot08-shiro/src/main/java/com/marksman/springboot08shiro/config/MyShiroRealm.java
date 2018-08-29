package com.marksman.springboot08shiro.config;

import com.marksman.springboot08shiro.entity.SysPermission;
import com.marksman.springboot08shiro.entity.SysRole;
import com.marksman.springboot08shiro.entity.UserInfo;
import com.marksman.springboot08shiro.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author weilb
 * @date 2018/8/29
 * @description
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoService userInfoService;

    /**
      * @description  权限配置
      * @params [principalCollection]
      * @return org.apache.shiro.authz.AuthorizationInfo
      * @author weilb
      * @date 2018/8/29
      */

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principalCollection.getPrimaryPrincipal();
        for (SysRole role : userInfo.getRoleList()) {
            authorizationInfo.addRole(role.getRole());
            for (SysPermission permission : role.getPermissions()) {
                authorizationInfo.addStringPermission(permission.getPermission());
            }
        }
        return authorizationInfo;
    }

    /**
      * @description  主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确
      * @params [authenticationToken]
      * @return org.apache.shiro.authc.AuthenticationInfo
      * @author weilb
      * @date 2018/8/29
      */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        String username = (String)authenticationToken.getPrincipal();
        System.out.println(authenticationToken.getCredentials());
        UserInfo userInfo = userInfoService.findByUsername(username);
        System.out.println("------>userInfo="+userInfo);
        if (userInfo == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo,userInfo.getPassword(),ByteSource.Util.bytes(userInfo.getCredentialsSalt()),getName());
        return authenticationInfo;
    }
}
