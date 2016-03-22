package com.newgen.core.base;

import java.util.List;

/**
 * 公共接口
 * @author lanyuan
 * @date 2015-02-01
 * @Email: mmm333zzz520@163.com
 * @version 3.0v
 * @param <T>
 */
public interface Base<T> {
	/**
	 * 返回所有数据
	 * @param t
	 * @return List<T>
	 */
	public List<T> queryAll(T t);

	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;

	/**
	 * 更新数据
	 * @param t
	 * @throws Exception
	 */
	public void update(T t) throws Exception;

	/**
	 * 返回某一条数据
	 * @param id
	 * @return T
	 */
	public T getById(String id);

	/**
	 * 保存数据
	 * @param t
	 * @throws Exception
	 */
	public void add(T t) throws Exception;
	
	/**
	 * 批量删除
	 * @param ids
	 * @throws Exception
	 */
	public void delete(String[] ids)throws Exception;
}
