package com.newgen.yctg.service;

import com.newgen.core.service.base.BaseService;
import com.newgen.yctg.bean.UserInfo;

public interface MemberService extends BaseService<UserInfo>{

	UserInfo getUserByNameAndPassword(String name_Login, String password);

}
