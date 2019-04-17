package com.rtersou.j2eproject;

import com.rtersou.j2eproject.models.Party.Party;
import com.rtersou.j2eproject.models.Party.PartyRepository;
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
            System.out.println("Preloading " + repository.save(new Party("Possession", new Date(), new Date(), "23h00", "12h00")));
            System.out.println("Preloading " + repository.save(new Party("Razance", new Date(), new Date(), "23h00", "10h00")));

        };
    }
}
