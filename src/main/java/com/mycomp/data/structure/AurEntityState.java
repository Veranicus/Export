package com.mycomp.data.structure;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AurEntityState {

	ACTIVE,ARCHIVED,DELETED,ABSENT;

	@JsonValue
	public String getJsonName() {
		return name().toLowerCase();
	}
}
