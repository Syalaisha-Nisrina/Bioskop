package com.kidaro.kael.repository;

import com.kidaro.kael.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public class FilmRepository {
        List<Film> findAllByShowingTrue();
        List<Film> findAllByUploaderId(Long uploaderId);
    }
