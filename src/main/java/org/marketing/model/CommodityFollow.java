package org.marketing.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CommodityFollow entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "commodity_follow", catalog = "marketing")
public class CommodityFollow implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer commodityId;
	private Integer customerId;
	private Timestamp createTimer;

	// Constructors

	/** default constructor */
	public CommodityFollow() {
	}

	/** full constructor */
	public CommodityFollow(Integer commodityId, Integer customerId,
			Timestamp createTimer) {
		this.commodityId = commodityId;
		this.customerId = customerId;
		this.createTimer = createTimer;
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

	@Column(name = "commodity_id")
	public Integer getCommodityId() {
		return this.commodityId;
	}

	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}

	@Column(name = "customer_id")
	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Column(name = "create_timer", length = 19)
	public Timestamp getCreateTimer() {
		return this.createTimer;
	}

	public void setCreateTimer(Timestamp createTimer) {
		this.createTimer = createTimer;
	}

}