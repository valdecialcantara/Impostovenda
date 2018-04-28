package br.com.model;

import java.io.Serializable;

/**
 * @author VBA
 *
 */
public class Material implements Serializable, Comparable<Material> {

	private static final long serialVersionUID = -1873145584044221079L;
	private int id;
	private Integer input;
	private String name;
	private Float price;
	private Integer stockQuantity;
	private int idGroup;
	private Boolean imported;
	
    public int compareTo(Material material) {
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

	public Integer getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public int getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

	public Boolean getImported() {
		return imported;
	}

	public void setImported(Boolean imported) {
		this.imported = imported;
	}

    
}
