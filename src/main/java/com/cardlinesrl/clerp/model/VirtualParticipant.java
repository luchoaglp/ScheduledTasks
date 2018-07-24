package com.cardlinesrl.clerp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "virtual_participants")
public class VirtualParticipant {

    @Id
    @Column(name = "virtual_id", nullable = false)
    private Integer virtualId;

    @Column(name = "participant_name", nullable = false, length = 50)
    private String participantName;

    @OneToMany(mappedBy = "virtualParticipant", cascade = CascadeType.ALL)
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

