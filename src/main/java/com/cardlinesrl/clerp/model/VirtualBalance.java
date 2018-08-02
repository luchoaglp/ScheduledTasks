package com.cardlinesrl.clerp.model;

import java.math.BigDecimal;
import java.util.Date;

public class VirtualBalance {

    private Integer balanceId;
    private Date balanceDate;
    private BigDecimal balance;
    private VirtualParticipant virtualParticipant;

    public VirtualBalance() { }

    public VirtualBalance(Date balanceDate, BigDecimal balance) {
        this.balanceDate = balanceDate;
        this.balance = balance;
    }

    public Integer getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(Integer balanceId) {
        this.balanceId = balanceId;
    }

    public Date getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(Date balanceDate) {
        this.balanceDate = balanceDate;
    }

    public VirtualParticipant getVirtualParticipant() {
        return virtualParticipant;
    }

    public void setVirtualParticipant(VirtualParticipant virtualParticipant) {
        this.virtualParticipant = virtualParticipant;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "VirtualBalance{" +
                "balanceId=" + balanceId +
                ", balanceDate=" + balanceDate +
                ", balance=" + balance +
                '}';
    }
}
