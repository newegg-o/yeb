package com.xxxx.server.config.security.component;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 判断用户角色
 * @author 呵呵厉害了
 * @date 2021/03/20 19:21
 **/
@Component
public class CustomUrlDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        for(ConfigAttribute configAttribute:configAttributes){
            //当前url所需角色
            String needRole = configAttribute.getAttribute();
            //判断是否登陆即可访问，此角色在customFilter中设置
            if("ROLE_LOGIN".equals(needRole)){
                //是否登陆
                if(authentication instanceof AnonymousAuthenticationToken){
                    throw new AccessDeniedException("尚未登陆");
                }else {
                    return;
                }
            }
            //判断用户角色是否未url所需角色
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(needRole)){
                    return;
                }
            }

        }
        throw new AccessDeniedException("权限不足");

    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
