package com.newgen.yctg.utils;

import com.newgen.core.plugin.PageView;



public class PageUtil {

	
	
	public static PageView getPageView(String pageNow,String pageSize) {
		
		PageView pageView = null;

		if (StringTools.isNullOrEmpty(pageNow)) {
			pageView = new PageView(1);
		} else {
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		if (StringTools.isNullOrEmpty(pageSize)) {
			pageSize = "10";
		} 
		pageView.setPageSize(Integer.parseInt(pageSize));
		return pageView;
	}
}
