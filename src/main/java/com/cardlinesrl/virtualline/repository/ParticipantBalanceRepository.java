package com.cardlinesrl.virtualline.repository;

import java.math.BigDecimal;

import com.cardlinesrl.virtualline.model.ParticipantBalance;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ParticipantBalanceRepository {

    @PersistenceContext(unitName = "virtualline")
    private EntityManager manager;

    public List<ParticipantBalance> findParticipantsNegativeBalance() {

        List <Object[]> results = manager.createNativeQuery("SELECT PARTICIPANT_ID participant_id, P.name participant_name, B.balance participant_balance " +
                "FROM balance_cache B " +
                "INNER JOIN participant P on (P.account = B.account) " +
                "HAVING participant_balance < 0").getResultList();

        return results.stream()
            .map(obj -> new ParticipantBalance((Integer) obj[0], ((String) obj[1]).trim(), (BigDecimal) obj[2]))
            .collect(Collectors.toList());
    }

}
