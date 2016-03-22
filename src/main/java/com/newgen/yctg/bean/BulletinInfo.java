package com.newgen.yctg.bean;

public class BulletinInfo {
	
	public Integer bulletinID;
	public String bulletinTitel;
	public String bulletinContent;	 
	public Integer ifPut;
	public String CreatTime;
	
	
	
	
	public Integer getBulletinID() {
		return bulletinID;
	}
	public void setBulletinID(Integer bulletinID) {
		this.bulletinID = bulletinID;
	}
	public String getBulletinTitel() {
		return bulletinTitel;
	}
	public void setBulletinTitel(String bulletinTitel) {
		this.bulletinTitel = bulletinTitel;
	}
	public String getBulletinContent() {
		return bulletinContent;
	}
	public void setBulletinContent(String bulletinContent) {
		this.bulletinContent = bulletinContent;
	}

	public Integer getIfPut() {
		return ifPut;
	}
	public void setIfPut(Integer ifPut) {
		this.ifPut = ifPut;
	}
	public String getCreatTime() {
		return CreatTime;
	}
	public void setCreatTime(String creatTime) {
		CreatTime = creatTime;
	} 
	

}
