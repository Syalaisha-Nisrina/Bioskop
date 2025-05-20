// File: src/main/java/com/kidaro/kael/model/Person.java

package com.kidaro.kael.model;

import jakarta.persistence.*;
import lombok.*;

@MappedSuperclass // Ini karena Person tidak akan dibuat tabel sendiri, tapi diturunkan oleh Admin dan Customer
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    // Method login & logout sebagai placeholder (bisa dikembangkan di service nantinya)
    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    public void logout() {
        System.out.println("User " + username + " has logged out.");
    }
}

