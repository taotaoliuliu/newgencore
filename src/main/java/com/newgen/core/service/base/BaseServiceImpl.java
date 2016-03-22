package com.newgen.core.service.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import com.newgen.core.base.BaseMapper;
import com.newgen.core.plugin.PageView;



/**
 * 服务实现的基类,封装基本的增，删，改。查的方法 所有服务实现类都要继承这个,然后写自己的具体实现方法,
 * 如果只有简单的增，删，改。查业务，继承这个实现类基类时,子类什么都不写，在控制直接调用父类方法即可，
 * 写法：具体可以参照LogServiceImpl
 * 
 * @author lanyuan
 * @date 2015-02-01
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 * @param <T>
 */
public class BaseServiceImpl<T> {

	@Autowired
	private BaseMapper<T> mapper;

	public List<T> queryAll(T t) {
		return mapper.queryAll(t);
	}

	public void delete(String id) throws Exception {
		mapper.delete(id);
	}

	public void update(T t) throws Exception {
		mapper.update(t);
	}

	public T getById(String id) {
		return mapper.getById(id);
	}

	public void add(T t) throws Exception {
		mapper.add(t);
	}

	public PageView getPageList(PageView pageView, T t) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("t", t);
		List<T> list = mapper.query(map);
		pageView.setRecords(list);
		
		PageView p =new PageView(pageView.getPageNow(),pageView.getPageSize(),pageView.getRowCount(),pageView.getRecords());
		
		return p;
	}

	public void delete(String[] ids) throws Exception {
		for (String id : ids) {
			mapper.delete(id);
		}
	}

}
