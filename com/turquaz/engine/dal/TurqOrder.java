package com.turquaz.engine.dal;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqOrder implements Serializable
{
	/** identifier field */
	private java.lang.Integer id;
	/** persistent field */
	private int ordersDocumentNo;
	/** persistent field */
	private java.util.Date ordersDate;
	/** persistent field */
	private java.lang.String ordersDefinition;
	/** persistent field */
	private int ordersDiscountRate;
	/** persistent field */
	private int ordersVat;
	/** persistent field */
	private java.math.BigDecimal ordersDiscountAmount;
	/** persistent field */
	private java.math.BigDecimal ordersCharges;
	/** persistent field */
	private java.math.BigDecimal ordersVatAmount;
	/** persistent field */
	private java.math.BigDecimal ordersTotalAmount;
	/** persistent field */
	private java.util.Date ordersDueDate;
	/** persistent field */
	private java.util.Date ordersDeliverDate;
	/** persistent field */
	private int ordersDelivered;
	/** persistent field */
	private int ordersType;
	/** persistent field */
	private java.lang.String createdBy;
	/** persistent field */
	private java.util.Date creationDate;
	/** persistent field */
	private java.lang.String updatedBy;
	/** persistent field */
	private java.util.Date lastModified;
	/** persistent field */
	private com.turquaz.engine.dal.TurqBill turqBill;
	/** persistent field */
	private com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard;
	/** persistent field */
	private Set turqOrderInGroups;

	/** full constructor */
	public TurqOrder(int ordersDocumentNo, java.util.Date ordersDate, java.lang.String ordersDefinition, int ordersDiscountRate,
			int ordersVat, java.math.BigDecimal ordersDiscountAmount, java.math.BigDecimal ordersCharges,
			java.math.BigDecimal ordersVatAmount, java.math.BigDecimal ordersTotalAmount, java.util.Date ordersDueDate,
			java.util.Date ordersDeliverDate, int ordersDelivered, int ordersType, java.lang.String createdBy,
			java.util.Date creationDate, java.lang.String updatedBy, java.util.Date lastModified,
			com.turquaz.engine.dal.TurqBill turqBill, com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard, Set turqOrderInGroups)
	{
		this.ordersDocumentNo = ordersDocumentNo;
		this.ordersDate = ordersDate;
		this.ordersDefinition = ordersDefinition;
		this.ordersDiscountRate = ordersDiscountRate;
		this.ordersVat = ordersVat;
		this.ordersDiscountAmount = ordersDiscountAmount;
		this.ordersCharges = ordersCharges;
		this.ordersVatAmount = ordersVatAmount;
		this.ordersTotalAmount = ordersTotalAmount;
		this.ordersDueDate = ordersDueDate;
		this.ordersDeliverDate = ordersDeliverDate;
		this.ordersDelivered = ordersDelivered;
		this.ordersType = ordersType;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.updatedBy = updatedBy;
		this.lastModified = lastModified;
		this.turqBill = turqBill;
		this.turqCurrentCard = turqCurrentCard;
		this.turqOrderInGroups = turqOrderInGroups;
	}

	/** default constructor */
	public TurqOrder()
	{
	}

	public java.lang.Integer getId()
	{
		return this.id;
	}

	public void setId(java.lang.Integer id)
	{
		this.id = id;
	}

	public int getOrdersDocumentNo()
	{
		return this.ordersDocumentNo;
	}

	public void setOrdersDocumentNo(int ordersDocumentNo)
	{
		this.ordersDocumentNo = ordersDocumentNo;
	}

	public java.util.Date getOrdersDate()
	{
		return this.ordersDate;
	}

	public void setOrdersDate(java.util.Date ordersDate)
	{
		this.ordersDate = ordersDate;
	}

	public java.lang.String getOrdersDefinition()
	{
		return this.ordersDefinition;
	}

	public void setOrdersDefinition(java.lang.String ordersDefinition)
	{
		this.ordersDefinition = ordersDefinition;
	}

	public int getOrdersDiscountRate()
	{
		return this.ordersDiscountRate;
	}

	public void setOrdersDiscountRate(int ordersDiscountRate)
	{
		this.ordersDiscountRate = ordersDiscountRate;
	}

	public int getOrdersVat()
	{
		return this.ordersVat;
	}

	public void setOrdersVat(int ordersVat)
	{
		this.ordersVat = ordersVat;
	}

	public java.math.BigDecimal getOrdersDiscountAmount()
	{
		return this.ordersDiscountAmount;
	}

	public void setOrdersDiscountAmount(java.math.BigDecimal ordersDiscountAmount)
	{
		this.ordersDiscountAmount = ordersDiscountAmount;
	}

	public java.math.BigDecimal getOrdersCharges()
	{
		return this.ordersCharges;
	}

	public void setOrdersCharges(java.math.BigDecimal ordersCharges)
	{
		this.ordersCharges = ordersCharges;
	}

	public java.math.BigDecimal getOrdersVatAmount()
	{
		return this.ordersVatAmount;
	}

	public void setOrdersVatAmount(java.math.BigDecimal ordersVatAmount)
	{
		this.ordersVatAmount = ordersVatAmount;
	}

	public java.math.BigDecimal getOrdersTotalAmount()
	{
		return this.ordersTotalAmount;
	}

	public void setOrdersTotalAmount(java.math.BigDecimal ordersTotalAmount)
	{
		this.ordersTotalAmount = ordersTotalAmount;
	}

	public java.util.Date getOrdersDueDate()
	{
		return this.ordersDueDate;
	}

	public void setOrdersDueDate(java.util.Date ordersDueDate)
	{
		this.ordersDueDate = ordersDueDate;
	}

	public java.util.Date getOrdersDeliverDate()
	{
		return this.ordersDeliverDate;
	}

	public void setOrdersDeliverDate(java.util.Date ordersDeliverDate)
	{
		this.ordersDeliverDate = ordersDeliverDate;
	}

	public int getOrdersDelivered()
	{
		return this.ordersDelivered;
	}

	public void setOrdersDelivered(int ordersDelivered)
	{
		this.ordersDelivered = ordersDelivered;
	}

	public int getOrdersType()
	{
		return this.ordersType;
	}

	public void setOrdersType(int ordersType)
	{
		this.ordersType = ordersType;
	}

	public java.lang.String getCreatedBy()
	{
		return this.createdBy;
	}

	public void setCreatedBy(java.lang.String createdBy)
	{
		this.createdBy = createdBy;
	}

	public java.util.Date getCreationDate()
	{
		return this.creationDate;
	}

	public void setCreationDate(java.util.Date creationDate)
	{
		this.creationDate = creationDate;
	}

	public java.lang.String getUpdatedBy()
	{
		return this.updatedBy;
	}

	public void setUpdatedBy(java.lang.String updatedBy)
	{
		this.updatedBy = updatedBy;
	}

	public java.util.Date getLastModified()
	{
		return this.lastModified;
	}

	public void setLastModified(java.util.Date lastModified)
	{
		this.lastModified = lastModified;
	}

	public com.turquaz.engine.dal.TurqBill getTurqBill()
	{
		return this.turqBill;
	}

	public void setTurqBill(com.turquaz.engine.dal.TurqBill turqBill)
	{
		this.turqBill = turqBill;
	}

	public com.turquaz.engine.dal.TurqCurrentCard getTurqCurrentCard()
	{
		return this.turqCurrentCard;
	}

	public void setTurqCurrentCard(com.turquaz.engine.dal.TurqCurrentCard turqCurrentCard)
	{
		this.turqCurrentCard = turqCurrentCard;
	}

	public java.util.Set getTurqOrderInGroups()
	{
		return this.turqOrderInGroups;
	}

	public void setTurqOrderInGroups(java.util.Set turqOrderInGroups)
	{
		this.turqOrderInGroups = turqOrderInGroups;
	}

	public String toString()
	{
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public boolean equals(Object other)
	{
		if (!(other instanceof TurqOrder))
			return false;
		TurqOrder castOther = (TurqOrder) other;
		return new EqualsBuilder().append(this.getId(), castOther.getId()).isEquals();
	}

	public int hashCode()
	{
		return new HashCodeBuilder().append(getId()).toHashCode();
	}
}