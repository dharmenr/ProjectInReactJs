package com.example.ProjectReactJs.exception;

import java.io.ObjectInputStream.GetField;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNoteFoundException extends RuntimeException{

	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	public ResourceNoteFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("its %s not found %s with : %s"+resourceName +""+fieldName+""+fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		
		
	}
	public String getResourceName() {
		return resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}
	public Object getFieldValue() {
		return fieldValue;
	}
	
	
	
}
