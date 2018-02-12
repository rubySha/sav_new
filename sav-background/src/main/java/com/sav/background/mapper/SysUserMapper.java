package com.sav.background.mapper;

import com.sav.background.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface SysUserMapper extends Mapper<SysUser> {

     @Select("SELECT * FROM sys_user WHERE username = #{username}")
     SysUser selectByName(@Param("username") String username);

}