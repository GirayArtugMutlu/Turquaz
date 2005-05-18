package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqService implements Serializable {

    /** identifier field */
    private java.lang.Integer id;

    /** persistent field */
    private java.lang.String serviceName;

    /** persistent field */
    private java.lang.String className;

    /** persistent field */
    private java.lang.String methodName;

    /** full constructor */
    public TurqService(java.lang.Integer id, java.lang.String serviceName, java.lang.String className, java.lang.String methodName) {
        this.id = id;
        this.serviceName = serviceName;
        this.className = className;
        this.methodName = methodName;
    }

    /** default constructor */
    public TurqService() {
    }

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public java.lang.String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(java.lang.String serviceName) {
        this.serviceName = serviceName;
    }

    public java.lang.String getClassName() {
        return this.className;
    }

    public void setClassName(java.lang.String className) {
        this.className = className;
    }

    public java.lang.String getMethodName() {
        return this.methodName;
    }

    public void setMethodName(java.lang.String methodName) {
        this.methodName = methodName;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqService) ) return false;
        TurqService castOther = (TurqService) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .toHashCode();
    }

}
