package com.j2ee.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author Akash
 *
 */
@Entity
@Table(name = "productlines")
public class ProductLineVO {
	@Id
	@Column(name = "productLine", columnDefinition = "varchar(50) NOT NULL")
	private String productLine;
	@Column(name = "textDescription", columnDefinition = "varchar(4000) DEFAULT NULL")
	private String textDescription;
	/**
	 * @return the productLine
	 */
	public String getProductLine() {
		return productLine;
	}
	/**
	 * @param productLine the productLine to set
	 */
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}
	/**
	 * @return the textDescription
	 */
	public String getTextDescription() {
		return textDescription;
	}
	/**
	 * @param textDescription the textDescription to set
	 */
	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}
	
	

}
