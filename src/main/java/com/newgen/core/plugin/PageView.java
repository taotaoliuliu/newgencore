package com.newgen.core.plugin;

import java.util.List;

/**
 * //分页封装函数
 * 
 * @param <T>
 */
public class PageView<T> {
	/**
	 * 分页数据
	 */
	private List<T> records;

	/**
	 * 总页�?这个数是计算出来�?
	 * 
	 */
	private long pageCount;

	/**
	 * 每页显示几条记录
	 */
	private int pageSize = 10;

	/**
	 * 默认 当前�?为第�?�� 这个数是计算出来�?
	 */
	private int pageNow = 1;

	/**
	 * 总记录数
	 */
	private long rowCount;

	/**
	 * 从第几条记录�?��
	 */
	private int startPage;

	/**
	 * 规定显示5个页�?
	 */
	private int pagecode = 10;
	
	
	
	private int beginPageIndex; // 页码列表的开始索引
	private int endPageIndex; // 页码列表的结束索引

	public PageView() {
	}
	
	
	
	
	
	public PageView(int pageNow, int pageSize, Long rowCount, List<T> records) {
		this.pageNow = pageNow;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.records = records;

		// 计算pageCount
		pageCount = (rowCount + pageSize - 1) / pageSize;

		// 计算beginPageIndex, endPageIndex
		// 总页码<=10
		if (pageCount <= 10) {
			beginPageIndex = 1;
			endPageIndex = (int)pageCount;
		}
		// 总页码>10
		else {
			// 默认显示当前页附近的共10个页面（前4个+当前页+后5个）
			beginPageIndex = pageNow - 4;
			endPageIndex = pageNow + 5;

			// 如果前面不足4个页码，就显示前10页
			if (beginPageIndex < 1) {
				beginPageIndex = 1;
				endPageIndex = 10;
			}
			// 如果后面不足5个页码，就显示后10页
			else if (endPageIndex > pageCount) {
				endPageIndex = (int)pageCount;
				beginPageIndex = (int)pageCount - 9; // 13 - 10 = 3, 3~13
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * 要获得记录的�?��索引�?���?��始页�?
	 * 
	 * @return
	 */
	public int getFirstResult() {
		return (this.pageNow - 1) * this.pageSize;
	}

	public int getPagecode() {
		return pagecode;
	}

	public void setPagecode(int pagecode) {
		this.pagecode = pagecode;
	}

	/**
	 * 使用构�?函数，，强制必需输入 每页显示数量�?���?��前页
	 * 
	 * @param pageSize
	 *            �??每页显示数量
	 * @param pageNow
	 *            �?��前页
	 */
	public PageView(int pageSize, int pageNow) {
		this.pageSize = pageSize;
		this.pageNow = pageNow;
	}

	/**
	 * 使用构�?函数，，强制必需输入 当前�?
	 * 
	 * @param pageNow
	 *            �?��前页
	 */
	public PageView(int pageNow) {
		this.pageNow = pageNow;
		startPage = (this.pageNow - 1) * this.pageSize;
	}

	/**
	 * 查询结果方法 把�?记录数�?结果集合�?��入到�?ageView对象
	 * 
	 * @param rowCount
	 *            总记录数
	 * @param records
	 *            结果集合
	 */

	public void setQueryResult(long rowCount, List<T> records) {
		setRowCount(rowCount);
		setRecords(records);
	}

	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
		setPageCount(this.rowCount % this.pageSize == 0 ? this.rowCount / this.pageSize : this.rowCount / this.pageSize + 1);
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public long getPageCount() {
		return pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getRowCount() {
		return rowCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}

	public int getBeginPageIndex() {
		return beginPageIndex;
	}

	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}

	public int getEndPageIndex() {
		return endPageIndex;
	}

	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}

	
	
	
}
