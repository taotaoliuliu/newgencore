package com.newgen.yctg.mapper;

import org.apache.ibatis.annotations.Param;

import com.newgen.core.base.BaseMapper;
import com.newgen.yctg.bean.TextInfo;
import com.newgen.yctg.bean.UserInfo;

public interface MemberMapper extends BaseMapper<UserInfo> {

	UserInfo getUserByNameAndPassword(@Param("name_Login") String name_Login, @Param("password") String password);

}
