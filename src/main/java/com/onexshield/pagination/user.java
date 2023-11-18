package com.onexshield.pagination;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;

@Component
@AllArgsConstructor
@Data
@Builder
@Entity
public class user {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    public user() {
        this.name = generateRandomName();
    }
    private String generateRandomName() {
        String allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int nameLength = new Random().nextInt(10) + 1; // Generate a random length between 1 and 10
        StringBuilder randomName = new StringBuilder();

        for (int i = 0; i < nameLength; i++) {
            int randomIndex = new Random().nextInt(allowedCharacters.length());
            randomName.append(allowedCharacters.charAt(randomIndex));
        }

        return randomName.toString();
    }
}

