package com.newgen.core.bean;



public class Category implements java.io.Serializable{
	

	private String id;

	private String name;
	
	private String parentid;
	
	private String parentids;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getParentids() {
		return parentids;
	}

	public void setParentids(String parentids) {
		this.parentids = parentids;
	}
	
	
	

	
	
	
	
	
	

}
