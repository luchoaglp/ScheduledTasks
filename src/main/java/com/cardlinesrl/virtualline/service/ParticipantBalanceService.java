package com.cardlinesrl.virtualline.service;

import com.cardlinesrl.virtualline.model.ParticipantBalance;
import com.cardlinesrl.virtualline.repository.ParticipantBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantBalanceService {

    @Autowired
    private ParticipantBalanceRepository participantBalanceRepository;

    public List<ParticipantBalance> findParticipantsNegativeBalance() {
        return participantBalanceRepository.findParticipantsNegativeBalance();
    }

}
