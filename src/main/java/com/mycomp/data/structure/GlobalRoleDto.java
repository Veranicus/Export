package com.mycomp.data.structure;

public class GlobalRoleDto {

	private long id;
	private String title;
	private String alternatekey;
	private boolean defaultRole;
	private boolean editable;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isDefaultRole() {
		return defaultRole;
	}

	public void setDefaultRole(boolean defaultRole) {
		this.defaultRole = defaultRole;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public String getAlternatekey() {
		return alternatekey;
	}

	public void setAlternatekey(String alternatekey) {
		this.alternatekey = alternatekey;
	}
}
