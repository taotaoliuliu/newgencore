package com.newgen.core.test;

import net.sf.ehcache.CacheManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.newgen.core.utils.SpringUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:springmvc-application.xml"})
public class Demo2 {

	@Test
	public  void testst()
	{
		 CacheManager cacheManager = ((CacheManager)SpringUtils.getBean("cacheManager"));

		System.out.println(cacheManager);
	}

}
