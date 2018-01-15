package com.mycomp.data.structure;

public class UserPersonalDataServerDto {

	private String serverId;
	private String fqdn;
	private String name;
	private AurUserPersonalDataDto aurUserPersonalData;

	public String getServerId() {
		return serverId;
	}
	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
	public String getFqdn() {
		return fqdn;
	}
	public void setFqdn(String fqdn) {
		this.fqdn = fqdn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public AurUserPersonalDataDto getAurUserPersonalData() {
		return aurUserPersonalData;
	}
	public void setAurUserPersonalData(AurUserPersonalDataDto aurUserPersonalData) {
		this.aurUserPersonalData = aurUserPersonalData;
	}
}
