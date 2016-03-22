package com.newgen.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.newgen.core.base.BaseMapper;
import com.newgen.core.bean.Menu;
import com.newgen.core.bean.User;
import com.newgen.yctg.bean.TextInfo;
import com.newgen.yctg.bean.UserInfo;

public interface MenuMapper extends BaseMapper<Menu> {

	List<Menu> getListByUser(User user);

	List<Menu> getUrlWithNoButton(Object object);

	List<Menu> getListByUserWithNoButton(User user);


}
