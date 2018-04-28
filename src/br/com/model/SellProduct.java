package br.com.model;

import java.io.Serializable;

/**
 * @author VBA
 *
 */
public class SellProduct implements Serializable, Comparable<SellProduct> {

	private static final long serialVersionUID = -7241581381968939505L;
	private int id;
	private Integer input;
	private String name;
	private Float price;
	private Float duty;
	private Integer quantity;
	private int idMaterial;
	
    public int compareTo(SellProduct material) {
        if (this.input > material.input) {
            return 1;
        }
        if (this.input < material.input) {
            return -1;
        }
        return 0;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getInput() {
		return input;
	}

	public void setInput(Integer input) {
		this.input = input;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getDuty() {
		return duty;
	}

	public void setDuty(Float duty) {
		this.duty = duty;
	}

	public int getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(int idMaterial) {
		this.idMaterial = idMaterial;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
