package com.rtersou.j2eproject;

import com.rtersou.j2eproject.models.party.Party;
import com.rtersou.j2eproject.models.party.PartyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(PartyRepository repository) {
        return args -> {
            System.out.println("Preloading " + repository.save(new Party("Possession", new Date(), new Date(), "145 rue de chevilly, Villejuif 94800", "test", "test", "test")));
            System.out.println("Preloading " + repository.save(new Party("Razance", new Date(), new Date(), "145 rue de chevilly, Villejuif 94800", "test", "test", "test")));

        };
    }


}
