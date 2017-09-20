package org.marketing.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orders", catalog = "marketing")
public class Orders implements java.io.Serializable {

	// Fields

	private Integer id;
	private Double totalPrice;
	private Integer harvestAddressId;
	private Timestamp createTime;
	private Integer customerId;
	private Integer state;
	private Timestamp payTime;

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** full constructor */
	public Orders(Double totalPrice, Integer harvestAddressId,
			Timestamp createTime, Integer customerId, Integer state,
			Timestamp payTime) {
		this.totalPrice = totalPrice;
		this.harvestAddressId = harvestAddressId;
		this.createTime = createTime;
		this.customerId = customerId;
		this.state = state;
		this.payTime = payTime;
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

	@Column(name = "total_price", precision = 11)
	public Double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Column(name = "harvest_address_id")
	public Integer getHarvestAddressId() {
		return this.harvestAddressId;
	}

	public void setHarvestAddressId(Integer harvestAddressId) {
		this.harvestAddressId = harvestAddressId;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "customer_id")
	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "pay_time", length = 19)
	public Timestamp getPayTime() {
		return this.payTime;
	}

	public void setPayTime(Timestamp payTime) {
		this.payTime = payTime;
	}

}