package com.rtersou.j2eproject.models.party;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, Long> {

    //Party findByName(String name);



}
