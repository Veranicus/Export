/*******************************************************************************
 * Copyright © Tieto Sweden AB 2015. All rights reserved
 *******************************************************************************/
package com.mycomp.data.structure;

import java.util.List;
import java.util.Map;

public class AurEntityDto implements AurDto {

	private String entid;
	private String psuid;
	private String type;
	private AurEntityState state;
	private Map<String, String> fields;
	private List<AurEntityLink> links;

	public String getEntid() {
		return entid;
	}
	public void setEntid(String entid) {
		this.entid = entid;
	}
	public String getPsuid() {
		return psuid;
	}
	public void setPsuid(String psuid) {
		this.psuid = psuid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public AurEntityState getState() {
		return state;
	}
	public void setState(AurEntityState state) {
		this.state = state;
	}
	public Map<String, String> getFields() {
		return fields;
	}
	public void setFields(Map<String, String> fields) {
		this.fields = fields;
	}
	public List<AurEntityLink> getLinks() {
		return links;
	}
	public void setLinks(List<AurEntityLink> links) {
		this.links = links;
	}

	@Override
	public String toString() {
		return "entid = " + entid + ", type = " + type;
	}
}
