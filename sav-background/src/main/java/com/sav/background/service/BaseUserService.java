package com.sav.background.service;

import com.sav.background.entity.SysUser;
import com.sav.background.mapper.SysUserMapper;
import com.sav.common.biz.BaseBiz;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by kaikai on 2018/1/22.
 */
@Service
public class BaseUserService extends BaseBiz<SysUserMapper,SysUser> implements UserDetailsService  {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = mapper.selectByName(username);
        if(sysUser == null) throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        return new User(sysUser.getUsername(),sysUser.getPassword(),null);
    }
}
