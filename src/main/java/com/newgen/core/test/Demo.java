package com.newgen.core.test;

import net.sf.ehcache.CacheManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.newgen.core.utils.SpringUtils;


public class Demo {

	@Test
	public  void testst()
	{
		
		
		ApplicationContext sc = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		System.out.println();
		
	}

}
