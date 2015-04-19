package org.aaron.product.browser.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;

/**
 * ProductDetails represents detailed data about a product.
 */
public class ProductDetails {

	@Id
	private String id;

	private String sku;

	private String name;

	private String category;

	private Date lastUpdated;

	private double price;

	/**
	 * Constructor
	 */
	public ProductDetails() {

	}

	/**
	 * @return product details unique identifier
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            product details unique identifier
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * @param sku
	 *            sku
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	/**
	 * @return product name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            product name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return product category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            product category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return product last updated time
	 */
	public Date getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * @param lastUpdated
	 *            product last updated time
	 */
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	/**
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProductDetails [id=" + id + ", sku=" + sku + ", name=" + name
				+ ", category=" + category + ", lastUpdated=" + lastUpdated
				+ ", price=" + price + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastUpdated == null) ? 0 : lastUpdated.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDetails other = (ProductDetails) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastUpdated == null) {
			if (other.lastUpdated != null)
				return false;
		} else if (!lastUpdated.equals(other.lastUpdated))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		return true;
	}

}
