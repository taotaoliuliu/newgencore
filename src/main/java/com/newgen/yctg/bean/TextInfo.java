package com.newgen.yctg.bean;

public class TextInfo {

	
	public Integer textID;
	public String textTitle;
	
	public String textContent;
	
	public String author;
	public String sender;
	
	public Integer anonyFlag;//区别是否拆分的带图片稿件
	public String ContributeDate;
	
	public String rest1;//题材
	public String rest2;//是否图片稿件
	
	public String rest3;//是否提交

	public String AuthorIP;
	
	public String IsUsed;//是否录用	
	public String Cat;//投稿版块
	
	public String status;//稿件录用情况
	public String AttachInfo;//是否图片稿件
	
	public String PicInfo;

	public String filepath;
	
	public String globalNewsId;
	
	
	    
	
	
	
	public String getGlobalNewsId() {
		return globalNewsId;
	}

	public void setGlobalNewsId(String globalNewsId) {
		this.globalNewsId = globalNewsId;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public Integer getTextID() {
		return textID;
	}

	public void setTextID(Integer textID) {
		this.textID = textID;
	}

	public String getTextTitle() {
		return textTitle;
	}

	public void setTextTitle(String textTitle) {
		this.textTitle = textTitle;
	}

	

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Integer getAnonyFlag() {
		return anonyFlag;
	}

	public void setAnonyFlag(Integer anonyFlag) {
		this.anonyFlag = anonyFlag;
	}

	public String getContributeDate() {
		return ContributeDate;
	}

	public void setContributeDate(String contributeDate) {
		ContributeDate = contributeDate;
	}

	public String getRest1() {
		return rest1;
	}

	public void setRest1(String rest1) {
		this.rest1 = rest1;
	}

	public String getRest2() {
		return rest2;
	}

	public void setRest2(String rest2) {
		this.rest2 = rest2;
	}

	public String getRest3() {
		return rest3;
	}

	public void setRest3(String rest3) {
		this.rest3 = rest3;
	}

	public String getAuthorIP() {
		return AuthorIP;
	}

	public void setAuthorIP(String authorIP) {
		AuthorIP = authorIP;
	}

	public String getIsUsed() {
		return IsUsed;
	}

	public void setIsUsed(String isUsed) {
		IsUsed = isUsed;
	}

	public String getCat() {
		return Cat;
	}

	public void setCat(String cat) {
		Cat = cat;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAttachInfo() {
		return AttachInfo;
	}

	public void setAttachInfo(String attachInfo) {
		AttachInfo = attachInfo;
	}

	public String getPicInfo() {
		return PicInfo;
	}

	public void setPicInfo(String picInfo) {
		PicInfo = picInfo;
	}
	
	
	
	
}


