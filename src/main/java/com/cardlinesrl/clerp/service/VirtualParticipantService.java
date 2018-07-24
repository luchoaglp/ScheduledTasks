package com.cardlinesrl.clerp.service;

import com.cardlinesrl.clerp.repository.VirtualParticipantRepository;
import com.cardlinesrl.util.HibernateUtilClerp;
import com.cardlinesrl.virtualline.model.ParticipantBalance;

import java.util.List;

public class VirtualParticipantService {

    public static void proccessParticipantsNegativeBalance(List<ParticipantBalance> participants) {
        VirtualParticipantRepository.proccessParticipantsNegativeBalance(participants);
        HibernateUtilClerp.shutdown();
    }

}
