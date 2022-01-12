package com.GabrielCharland.Student;

import javax.persistence.*;
import javax.persistence.GenerationType;

import java.time.LocalDate;
import java.time.Period;

@Entity // Pour Hibernate
@Table
public class Student {
    /*
     * La classe "Étudiant" est au coeur du DB. Le code plus bas est une classe de
     * base en Java pour définir les attributs et les "getter/setter".
     *
     * On a 3 constructors (__init__ en python) parce certaines méthodes ont besoin
     * de générer les attributes avec le constructor et d'autres avec les getters /
     * setters
     */

    /*
     * Générateur de séquence qui fait en sorte que la DB itère
     * le ID de 1 à chaque nouvelle entrée
     */
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long id;
    private String name;
    private String email;
    private LocalDate dob;
    // age est calculée par Spring avec getAge(); plutôt qu'enregistré dans la DB
    @Transient
    private int age;

    // Constructors
    public Student() {

    }

    public Student(long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // To String permet de renvoyer un String sous format de JSON
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
