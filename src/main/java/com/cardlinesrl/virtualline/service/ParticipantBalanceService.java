package com.cardlinesrl.virtualline.service;

import com.cardlinesrl.util.VirtuallineConnection;
import com.cardlinesrl.virtualline.model.ParticipantBalance;

import java.util.List;

public class ParticipantBalanceService {

    public List<ParticipantBalance> getParticipantsNegativeBalance() {

        VirtuallineConnection vl = new VirtuallineConnection();

        vl.openConnection();

        List<ParticipantBalance> participants = vl.getParticipantsNegativeBalance();

        vl.closeConnection();

        return participants;
    }

}
