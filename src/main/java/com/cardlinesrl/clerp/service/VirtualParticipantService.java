package com.cardlinesrl.clerp.service;

import com.cardlinesrl.clerp.model.VirtualParticipant;
import com.cardlinesrl.clerp.repository.VirtualParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VirtualParticipantService {

    @Autowired
    private VirtualParticipantRepository virtualParticipantRepository;

    public void save(VirtualParticipant participant) {
        virtualParticipantRepository.save(participant);
    }

}
