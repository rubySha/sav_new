package com.sav.background.rest;

import com.sav.background.biz.SysUserBiz;
import com.sav.background.entity.SysUser;
import com.sav.background.mapper.SysUserMapper;
import com.sav.common.rest.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kaikai on 2018/1/22.
 * 登录中心
 */
@RestController
@RequestMapping("/center")
public class LoginRest extends BaseController<SysUserBiz,SysUser>{


    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public SysUser selectByName(){
        return baseBiz.selectByName();
    }

}
