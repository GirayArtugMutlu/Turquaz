package com.turquaz.engine.dal;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TurqAccountingTransactionColumn implements Serializable {

    /** identifier field */
    private java.lang.Integer accountingTransactionColumnsId;

    /** persistent field */
    private java.math.BigDecimal deptAmount;

    /** persistent field */
    private java.math.BigDecimal creditAmount;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByAccountIdDeptor;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByAccountIdCreditor;

    /** persistent field */
    private com.turquaz.engine.dal.TurqAccountingTransaction turqAccountingTransaction;

    /** full constructor */
    public TurqAccountingTransactionColumn(java.math.BigDecimal deptAmount, java.math.BigDecimal creditAmount, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByAccountIdDeptor, com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByAccountIdCreditor, com.turquaz.engine.dal.TurqAccountingTransaction turqAccountingTransaction) {
        this.deptAmount = deptAmount;
        this.creditAmount = creditAmount;
        this.turqAccountingAccountByAccountIdDeptor = turqAccountingAccountByAccountIdDeptor;
        this.turqAccountingAccountByAccountIdCreditor = turqAccountingAccountByAccountIdCreditor;
        this.turqAccountingTransaction = turqAccountingTransaction;
    }

    /** default constructor */
    public TurqAccountingTransactionColumn() {
    }

    public java.lang.Integer getAccountingTransactionColumnsId() {
        return this.accountingTransactionColumnsId;
    }

    public void setAccountingTransactionColumnsId(java.lang.Integer accountingTransactionColumnsId) {
        this.accountingTransactionColumnsId = accountingTransactionColumnsId;
    }

    public java.math.BigDecimal getDeptAmount() {
        return this.deptAmount;
    }

    public void setDeptAmount(java.math.BigDecimal deptAmount) {
        this.deptAmount = deptAmount;
    }

    public java.math.BigDecimal getCreditAmount() {
        return this.creditAmount;
    }

    public void setCreditAmount(java.math.BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public com.turquaz.engine.dal.TurqAccountingAccount getTurqAccountingAccountByAccountIdDeptor() {
        return this.turqAccountingAccountByAccountIdDeptor;
    }

    public void setTurqAccountingAccountByAccountIdDeptor(com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByAccountIdDeptor) {
        this.turqAccountingAccountByAccountIdDeptor = turqAccountingAccountByAccountIdDeptor;
    }

    public com.turquaz.engine.dal.TurqAccountingAccount getTurqAccountingAccountByAccountIdCreditor() {
        return this.turqAccountingAccountByAccountIdCreditor;
    }

    public void setTurqAccountingAccountByAccountIdCreditor(com.turquaz.engine.dal.TurqAccountingAccount turqAccountingAccountByAccountIdCreditor) {
        this.turqAccountingAccountByAccountIdCreditor = turqAccountingAccountByAccountIdCreditor;
    }

    public com.turquaz.engine.dal.TurqAccountingTransaction getTurqAccountingTransaction() {
        return this.turqAccountingTransaction;
    }

    public void setTurqAccountingTransaction(com.turquaz.engine.dal.TurqAccountingTransaction turqAccountingTransaction) {
        this.turqAccountingTransaction = turqAccountingTransaction;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("accountingTransactionColumnsId", getAccountingTransactionColumnsId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TurqAccountingTransactionColumn) ) return false;
        TurqAccountingTransactionColumn castOther = (TurqAccountingTransactionColumn) other;
        return new EqualsBuilder()
            .append(this.getAccountingTransactionColumnsId(), castOther.getAccountingTransactionColumnsId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAccountingTransactionColumnsId())
            .toHashCode();
    }

}
