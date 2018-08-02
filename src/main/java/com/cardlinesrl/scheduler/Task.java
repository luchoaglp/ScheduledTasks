package com.cardlinesrl.scheduler;

import com.cardlinesrl.clerp.service.VirtualParticipantService;
import com.cardlinesrl.virtualline.service.ParticipantBalanceService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Task {

    @Scheduled(cron = "0 0 18 * * ?")
    public void scheduleBalanceControl() {

        new VirtualParticipantService().processParticipantsNegativeBalance(new ParticipantBalanceService().getParticipantsNegativeBalance());
    }

}

