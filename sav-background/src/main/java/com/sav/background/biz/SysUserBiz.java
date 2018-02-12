package com.sav.background.biz;

import com.sav.background.entity.SysUser;
import com.sav.background.mapper.SysUserMapper;
import com.sav.common.biz.BaseBiz;
import org.springframework.stereotype.Service;

/**
 * Created by kaikai on 2018/1/22.
 */
@Service
public class SysUserBiz extends BaseBiz<SysUserMapper,SysUser>{

    public SysUser selectByName(){
        return mapper.selectByName("admin");
    }

}
