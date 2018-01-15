/*******************************************************************************
 * Copyright © Tieto Sweden AB 2015. All rights reserved
 *******************************************************************************/
package com.mycomp.data.structure;

import java.util.List;

public class UserPersonalDataProductSpaceDto {

	private String productId;
	private String name;
	private String description;
	private String richDescription;
	private boolean active;
	private List<String> userProductSpaceRoles;
	private List<UserPersonalDataServerDto> servers;

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRichDescription() {
		return richDescription;
	}
	public void setRichDescription(String richDescription) {
		this.richDescription = richDescription;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public List<UserPersonalDataServerDto> getServers() {
		return servers;
	}
	public void setServers(List<UserPersonalDataServerDto> servers) {
		this.servers = servers;
	}
	public List<String> getUserProductSpaceRoles() {
		return userProductSpaceRoles;
	}
	public void setUserProductSpaceRoles(List<String> userProductSpaceRoles) {
		this.userProductSpaceRoles = userProductSpaceRoles;
	}
}
