package com.zjweu.entity;

public class Comment {
	private Integer cid;

	private Integer titleId;

	private String titleType;

	private String content;

	private Integer formId;

	private Integer id;

	private String username;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getTitleId() {
		return titleId;
	}

	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}

	public String getTitleType() {
		return titleType;
	}

	public void setTitleType(String titleType) {
		this.titleType = titleType == null ? null : titleType.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public Integer getFormId() {
		return formId;
	}

	public void setFormId(Integer formId) {
		this.formId = formId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	@Override
	public String toString() {
		return "Comment [cid=" + cid + ", titleId=" + titleId + ", titleType=" + titleType + ", content=" + content
				+ ", formId=" + formId + ", id=" + id + ", username=" + username + "]";
	}

}