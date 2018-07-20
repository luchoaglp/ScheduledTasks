package com.cardlinesrl.clerp.repository;

import com.cardlinesrl.clerp.model.VirtualParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VirtualParticipantRepository extends JpaRepository<VirtualParticipant, Integer> {



}
