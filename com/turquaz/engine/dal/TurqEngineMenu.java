package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqEngineMenu implements Serializable {

    /** identifier field */
    private java.lang.Integer id;

    /** persistent field */
    private java.lang.String menuName;

    /** persistent field */
    private java.lang.String menuImage;

    /** persistent field */
    private int menuType;

    /** persistent field */
    private int parentId;

    /** persistent field */
    private com.turquaz.engine.dal.TurqModuleComponent turqModuleComponent;

    /** full constructor */
    public TurqEngineMenu(java.lang.Integer id, java.lang.String menuName, java.lang.String menuImage, int menuType, int parentId, com.turquaz.engine.dal.TurqModuleComponent turqModuleComponent) {
        this.id = id;
        this.menuName = menuName;
        this.menuImage = menuImage;
        this.menuType = menuType;
        this.parentId = parentId;
        this.turqModuleComponent = turqModuleComponent;
    }

    /** default constructor */
    public TurqEngineMenu() {
    }

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public java.lang.String getMenuName() {
        return this.menuName;
    }

    public void setMenuName(java.lang.String menuName) {
        this.menuName = menuName;
    }

    public java.lang.String getMenuImage() {
        return this.menuImage;
    }

    public void setMenuImage(java.lang.String menuImage) {
        this.menuImage = menuImage;
    }

    public int getMenuType() {
        return this.menuType;
    }

    public void setMenuType(int menuType) {
        this.menuType = menuType;
    }

    public int getParentId() {
        return this.parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public com.turquaz.engine.dal.TurqModuleComponent getTurqModuleComponent() {
        return this.turqModuleComponent;
    }

    public void setTurqModuleComponent(com.turquaz.engine.dal.TurqModuleComponent turqModuleComponent) {
        this.turqModuleComponent = turqModuleComponent;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqEngineMenu) ) return false;
        TurqEngineMenu castOther = (TurqEngineMenu) other;
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
