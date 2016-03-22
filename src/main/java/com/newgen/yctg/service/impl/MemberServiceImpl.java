package com.newgen.yctg.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newgen.core.service.base.BaseServiceImpl;
import com.newgen.yctg.bean.UserInfo;
import com.newgen.yctg.mapper.MemberMapper;
import com.newgen.yctg.service.MemberService;


@Transactional
@Service
public class MemberServiceImpl extends BaseServiceImpl<UserInfo>  implements MemberService{

	
	
	@Inject
	private MemberMapper usermapper;
	@Override
	public UserInfo getUserByNameAndPassword(String name_Login, String password) {
		

		
		return usermapper.getUserByNameAndPassword(name_Login,password);
	}

}
