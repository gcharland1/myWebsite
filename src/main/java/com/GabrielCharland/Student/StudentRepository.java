package com.GabrielCharland.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository // Dit à Spring que c'est un Repo
public interface StudentRepository extends JpaRepository<Student, Long> {
    /*
     * Le repositoty est l'interface qui va jouer directement dans la DB.
     * Un interface est une classe abstracte (Qui n'a pas de méthode pré-
     * définies). Les méthodes sont définies dans des classes qui
     * implémentent l'interface.
     *
     * Ici, StudentRepository reprend la classe JpaRepository, mais avec
     * des Student comme donnée et des Long comme type de Id.
     */

    // Renvoie la commande SQL a partir de l'Entity Student (notre classe)
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
