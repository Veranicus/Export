/*******************************************************************************
 * Copyright © Tieto Sweden AB 2015. All rights reserved
 *******************************************************************************/
package com.mycomp.data.structure;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class UserPersonalDataDto {

	private String userToken;
	private String firstname;
	private String lastname;
	private String fullname;
	private String email;
	private String departmentNumber;
	private Date lastLogin;
	private Date lastLoginLdap;
	private Date registrationDate;
	private String sshKey;
	private Set<GlobalRoleDto> globalRoles;
	private List<UserPersonalDataCompanyDto> companies;

	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartmentNumber() {
		return departmentNumber;
	}
	public void setDepartmentNumber(String departmentNumber) {
		this.departmentNumber = departmentNumber;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Date getLastLoginLdap() {
		return lastLoginLdap;
	}
	public void setLastLoginLdap(Date lastLoginLdap) {
		this.lastLoginLdap = lastLoginLdap;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public Set<GlobalRoleDto> getGlobalRoles() {
		return globalRoles;
	}
	public void setGlobalRoles(Set<GlobalRoleDto> globalRoles) {
		this.globalRoles = globalRoles;
	}
	public List<UserPersonalDataCompanyDto> getCompanies() {
		return companies;
	}
	public void setCompanies(List<UserPersonalDataCompanyDto> companies) {
		this.companies = companies;
	}
	public String getSshKey() {
		return sshKey;
	}
	public void setSshKey(String sshKey) {
		this.sshKey = sshKey;
	}
}
