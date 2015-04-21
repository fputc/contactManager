package com.alen.contactmanager.model.entity;

public enum NumberType {
    PRIVATE("Private"),
    WORK("Work"),
    OTHER("Other");
    
    private String label;
    
    private NumberType(String label) {
    	this.label = label;
    }
    
    public String getLabel() {
    	return label;
    }
}