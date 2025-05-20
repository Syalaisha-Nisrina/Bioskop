package com.kidaro.kael.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Film {
    @Id @GeneratedValue
    private Long id;

    private String title;
    private boolean showing;
    private LocalDate releaseDate;

    @JsonBackReference
    @ManyToOne
    private User uploader;
}
