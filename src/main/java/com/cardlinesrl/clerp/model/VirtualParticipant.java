package com.cardlinesrl.clerp.model;

import java.util.ArrayList;
import java.util.List;

public class VirtualParticipant {

    private Integer virtualId;
    private String participantName;
    private List<VirtualBalance> balances = new ArrayList<>();

    public VirtualParticipant() { }

    public VirtualParticipant(Integer virtualId, String participantName) {
        this.virtualId = virtualId;
        this.participantName = participantName;
    }

    public void addBalance(VirtualBalance balance) {
        if(balance.getVirtualParticipant() == null)
            balance.setVirtualParticipant(this);
        balances.add(balance);
    }

    public Integer getVirtualId() {
        return virtualId;
    }

    public void setVirtualId(Integer virtualId) {
        this.virtualId = virtualId;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public List<VirtualBalance> getBalances() {
        return balances;
    }

    public void setBalances(List<VirtualBalance> balances) {
        this.balances = balances;
    }

    @Override
    public String toString() {
        return "VirtualParticipant{" +
                "virtualId=" + virtualId +
                ", participantName='" + participantName + '\'' +
                '}';
    }
}

