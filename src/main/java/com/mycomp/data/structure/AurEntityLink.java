package com.mycomp.data.structure;

public class AurEntityLink implements AurDto {
	private String name;
	private String url;
	private String description;
	private String protocol;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	
	@Override
	public String toString() {
		return "name = " + name + ", url = " + url + ", description = " + description + ", protocol = " + protocol;  
	}
}
