package com.mycomp.data.structure;

import java.util.List;

public class UserPersonalDataCompanyDto {

	private String title;
	private String areaid;
	private List<String> userCompanyRoles; 
	private List<UserPersonalDataProductSpaceDto> userProductSpaces;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	public List<String> getUserCompanyRoles() {
		return userCompanyRoles;
	}
	public void setUserCompanyRoles(List<String> userCompanyRoles) {
		this.userCompanyRoles = userCompanyRoles;
	}
	public List<UserPersonalDataProductSpaceDto> getUserProductSpaces() {
		return userProductSpaces;
	}
	public void setUserProductSpaces(List<UserPersonalDataProductSpaceDto> userProductSpaces) {
		this.userProductSpaces = userProductSpaces;
	}
}
