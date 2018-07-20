package com.cardlinesrl.virtualline.model;

import java.math.BigDecimal;

public class ParticipantBalance {

    private Integer participantId;
    private String participantName;
    private BigDecimal participantBalance;

    public ParticipantBalance(Integer participantId, String participantName, BigDecimal participantBalance) {
        this.participantId = participantId;
        this.participantName = participantName;
        this.participantBalance = participantBalance;
    }

    public Integer getParticipantId() {
        return participantId;
    }

    public String getParticipantName() {
        return participantName;
    }

    public BigDecimal getParticipantBalance() {
        return participantBalance;
    }

    @Override
    public String toString() {
        return "ParticipantBalanceRepository{" +
                "participantId=" + participantId +
                ", participantName='" + participantName + '\'' +
                ", participantBalance=" + participantBalance +
                '}';
    }
}
