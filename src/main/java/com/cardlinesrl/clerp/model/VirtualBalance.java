package com.cardlinesrl.clerp.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "virtual_balances")
public class VirtualBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "balance_id", nullable = false)
    private Integer balanceId;

    @Column(name = "balance_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date balanceDate;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "virtual_id", nullable = false)
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
