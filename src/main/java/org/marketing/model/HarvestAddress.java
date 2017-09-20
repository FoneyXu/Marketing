package org.marketing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * HarvestAddress entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "harvest_address", catalog = "marketing")
public class HarvestAddress implements java.io.Serializable {

	// Fields

	private Integer id;
	private String address;
	private Integer customerId;
	private String contacter;
	private String contactPhone;
	private Integer state;

	// Constructors

	/** default constructor */
	public HarvestAddress() {
	}

	/** full constructor */
	public HarvestAddress(String address, Integer customerId, String contacter,
			String contactPhone, Integer state) {
		this.address = address;
		this.customerId = customerId;
		this.contacter = contacter;
		this.contactPhone = contactPhone;
		this.state = state;
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

	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "customer_id")
	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Column(name = "contacter", length = 20)
	public String getContacter() {
		return this.contacter;
	}

	public void setContacter(String contacter) {
		this.contacter = contacter;
	}

	@Column(name = "contact_phone", length = 11)
	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}