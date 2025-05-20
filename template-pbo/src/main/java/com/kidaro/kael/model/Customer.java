
package com.kidaro.kael.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer extends Person {

    private String email; // opsional

    // Relasi satu pelanggan bisa punya banyak tiket
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets;

    // Tidak ada logika bisnis di sini. Semua logika dipindah ke Service Layer.
}



