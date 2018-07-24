package com.cardlinesrl.clerp.repository;

import com.cardlinesrl.clerp.model.VirtualBalance;
import com.cardlinesrl.clerp.model.VirtualParticipant;
import com.cardlinesrl.util.HibernateUtilClerp;
import com.cardlinesrl.virtualline.model.ParticipantBalance;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class VirtualParticipantRepository {

    public static void proccessParticipantsNegativeBalance(List<ParticipantBalance> participants) {

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

}
