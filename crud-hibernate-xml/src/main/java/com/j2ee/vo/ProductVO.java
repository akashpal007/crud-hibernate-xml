package com.j2ee.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Akash
 *
 */
@Entity
@Table(name = "products")
public class ProductVO {
	@Id
	@Column(name = "productCode", columnDefinition = "varchar(15) NOT NULL")
	private String productCode;

	@Column(name = "productName", columnDefinition = "varchar(70) NOT NULL")
	private String productName;

	@ManyToOne
	@JoinColumn(name = "productLine")
	private ProductLineVO productLineVO;

	@Column(name = "productScale", columnDefinition = "varchar(10) NOT NULL")
	private String productScale;

	@Column(name = "productVendor", columnDefinition = "varchar(50) NOT NULL")
	private String productVendor;

	@Column(name = "productDescription", columnDefinition = "text NOT NULL")
	private String productDescription;

	@Column(name = "quantityInStock", columnDefinition = "smallint(6) NOT NULL")
	private int quantityInStock;

	@Column(name = "buyPrice", columnDefinition = "varchar(15) NOT NULL")
	private double buyPrice;

	@Column(name = "MSRP", columnDefinition = "decimal(10,2) NOT NULL")
	private double MSRP;

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productLineVO
	 */
	public ProductLineVO getProductLineVO() {
		return productLineVO;
	}
	
	/**
	 * @return ProductLine(String)
	 */
	public String getProductLine() {
		return productLineVO.getProductLine();
	}

	/**
	 * @param productLineVO the productLineVO to set
	 */
	public void setProductLineVO(ProductLineVO productLineVO) {
		this.productLineVO = productLineVO;
	}
	
	/**
	 * @param productLine(String)
	 */
	public void setProductLine(String productLine) {
		ProductLineVO productLineVO = new ProductLineVO();
		productLineVO.setProductLine(productLine);
		this.productLineVO = productLineVO;
	}

	/**
	 * @return the productScale
	 */
	public String getProductScale() {
		return productScale;
	}

	/**
	 * @param productScale the productScale to set
	 */
	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}

	/**
	 * @return the productVendor
	 */
	public String getProductVendor() {
		return productVendor;
	}

	/**
	 * @param productVendor the productVendor to set
	 */
	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	/**
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * @param productDescription the productDescription to set
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	/**
	 * @return the quantityInStock
	 */
	public int getQuantityInStock() {
		return quantityInStock;
	}

	/**
	 * @param quantityInStock the quantityInStock to set
	 */
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	/**
	 * @return the buyPrice
	 */
	public double getBuyPrice() {
		return buyPrice;
	}

	/**
	 * @param buyPrice the buyPrice to set
	 */
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	/**
	 * @return the mSRP
	 */
	public double getMSRP() {
		return MSRP;
	}

	/**
	 * @param mSRP the mSRP to set
	 */
	public void setMSRP(double mSRP) {
		MSRP = mSRP;
	}

}
