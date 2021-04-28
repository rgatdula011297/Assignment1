package com.example.demo.controller.model;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.stream.Stream;

/**
 * This class shows the error messages
 * 
 *
 */
public enum MessageType {

	RECORD_NOT_FOUND("No record."),
	RECORD_DELETED("Record has been deleted."),
	INSERT_SUCCESS("Record has been inserted."),
	UPDATE_DATA("Record has been updated"),
	RECORD_EXIST("Record already existing");
	private String code;
	
	private MessageType(String code) {
		this.code = code;
	}
	
	public static MessageType decode(final String error) {		
		return Stream.of(MessageType.values())
				.filter(e -> e.code.equals(error))
				.findFirst().orElse(null);
	}
	
	@JsonValue
	public String getCode() {
		return code;
	}
}