package com.cardlinesrl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ScheduledTaksApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduledTaksApplication.class, args);
	}

	/*
	@Bean
	CommandLineRunner init() {

        return args -> {

            VirtuallineConnection vl = new VirtuallineConnection();

            vl.openConnection();

            List<ParticipantBalance> participants = vl.getParticipantsNegativeBalance();

            vl.closeConnection();

            insertData(participants);

            HibernateUtilClerp.shutdown();
        };
	}

    private static void insertData(List<ParticipantBalance> participants) {

        Session session = null;
        Transaction transaction = null;

        try {

            session = HibernateUtilClerp.getSessionFactory().openSession();
            transaction = session.getTransaction();
            transaction.begin();

            for(ParticipantBalance participant : participants) {

                VirtualParticipant p = session.get(VirtualParticipant.class, participant.getParticipantId());

                if (p == null) {

                    p = new VirtualParticipant(participant.getParticipantId(), participant.getParticipantName());

                    p.addBalance(new VirtualBalance(new Date(), participant.getParticipantBalance()));

                    session.persist(p);

                } else {

                    p.addBalance(new VirtualBalance(new Date(), participant.getParticipantBalance()));

                    session.merge(p);
                }
            }

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    */
}
