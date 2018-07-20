package com.cardlinesrl.scheduler;

import com.cardlinesrl.clerp.model.VirtualBalance;
import com.cardlinesrl.clerp.model.VirtualParticipant;
import com.cardlinesrl.clerp.service.VirtualParticipantService;
import com.cardlinesrl.virtualline.service.ParticipantBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Task {

    @Autowired
    private ParticipantBalanceService participantBalanceService;

    @Autowired
    private VirtualParticipantService virtualParticipantService;

    @Scheduled(cron = "0 0 18 * * *")
    public void scheduleBalanceControl() {

        participantBalanceService.findParticipantsNegativeBalance()
                .forEach(participant -> {
                    VirtualParticipant vParticipant = new VirtualParticipant(participant.getParticipantId(), participant.getParticipantName());
                    vParticipant.addBalance(new VirtualBalance(new Date(), participant.getParticipantBalance()));
                    virtualParticipantService.save(vParticipant);
                });
    }

}

