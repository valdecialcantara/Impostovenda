package br.com.model;

import java.io.Serializable;

/**
 * @author VBA
 *
 */
public class GroupMaterial implements Serializable{

	private static final long serialVersionUID = 2096130554518888119L;
	private int id;
	private String name;
	private Boolean dutyFree;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getDutyFree() {
		return dutyFree;
	}
	public void setDutyFree(Boolean dutyFree) {
		this.dutyFree = dutyFree;
	}
	
}
