package com.gamingroom;

import java.util.ArrayList;

public class Entity {

	private long id;
	
	private String name;
	
	//default constructor kept private to prevent creation of empty instance
	private Entity() {
		
	}
	
	public Entity(long id, String name) {
		this();
		this.id = id;
		this.name = name;
	}
	
	// simple getter functions to return id and name values
	// for use in child classes
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	//overridden method to return entity id and name
	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + "]";
		
	}
}
