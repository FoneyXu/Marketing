package org.marketing.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * OrdersBelow entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orders_below", catalog = "marketing")
public class OrdersBelow implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer ordersId;
	private Integer commodityId;
	private Integer shopNum;
	private Double shopPrice;
	private Double shopTotalPrice;
	private Integer customerId;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public OrdersBelow() {
	}

	/** full constructor */
	public OrdersBelow(Integer ordersId, Integer commodityId, Integer shopNum,
			Double shopPrice, Double shopTotalPrice, Integer customerId,
			Timestamp createTime) {
		this.ordersId = ordersId;
		this.commodityId = commodityId;
		this.shopNum = shopNum;
		this.shopPrice = shopPrice;
		this.shopTotalPrice = shopTotalPrice;
		this.customerId = customerId;
		this.createTime = createTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "orders_id")
	public Integer getOrdersId() {
		return this.ordersId;
	}

	public void setOrdersId(Integer ordersId) {
		this.ordersId = ordersId;
	}

	@Column(name = "commodity_id")
	public Integer getCommodityId() {
		return this.commodityId;
	}

	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}

	@Column(name = "shop_num")
	public Integer getShopNum() {
		return this.shopNum;
	}

	public void setShopNum(Integer shopNum) {
		this.shopNum = shopNum;
	}

	@Column(name = "shop_price", precision = 11)
	public Double getShopPrice() {
		return this.shopPrice;
	}

	public void setShopPrice(Double shopPrice) {
		this.shopPrice = shopPrice;
	}

	@Column(name = "shop_total_price", precision = 11)
	public Double getShopTotalPrice() {
		return this.shopTotalPrice;
	}

	public void setShopTotalPrice(Double shopTotalPrice) {
		this.shopTotalPrice = shopTotalPrice;
	}

	@Column(name = "customer_id")
	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}