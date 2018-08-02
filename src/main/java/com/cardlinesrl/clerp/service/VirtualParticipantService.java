package com.cardlinesrl.clerp.service;

import com.cardlinesrl.util.ClerpConnection;
import com.cardlinesrl.virtualline.model.ParticipantBalance;

import java.util.List;

public class VirtualParticipantService {

    public void processParticipantsNegativeBalance(List<ParticipantBalance> participants) {

        ClerpConnection cl = new ClerpConnection();

        cl.openConnection();

        cl.getParticipantsNegativeBalance(participants);

        cl.closeConnection();
    }

}
