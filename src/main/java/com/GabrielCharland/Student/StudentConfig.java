package com.GabrielCharland.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// Dit à Spring qu'il s'agit d'un script de confit à rouler au début
@Configuration
public class StudentConfig {
    /*
     * Classe qui injecte 2 étudiants dans notre DB (Pour le testing)
     */

    @Bean // Dit à Java qu'il faut exécuter cette portion de code
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student john = new Student(
                    "John",
                    "John.Doe@gmail.com",
                    LocalDate.of(1991, Month.JANUARY, 1)
            );

            Student raquel = new Student(
                    "Raquel",
                    "lisbone@lacasa.eu",
                    LocalDate.of(1970, Month.APRIL, 12)
            );

            Student carey = new Student(
                    "Carey",
                    "goalie_31@yahoo.com",
                    LocalDate.of(2086, Month.JUNE, 28)
            );

            repository.saveAll(List.of(john, raquel, carey));
        };
    }
}
