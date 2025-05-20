package com.kidaro.kael.service;

import com.kidaro.kael.model.Film;
import com.kidaro.kael.model.WatchFeeTransaction;
import com.kidaro.kael.repository.FilmRepository;
import com.kidaro.kael.repository.WatchFeeTransactionRepository;
import com.kidaro.kael.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmService {
    private final FilmRepository filmRepo;
    private final WatchFeeTransactionRepository watchFeeTransactionRepo;
    private final UserRepository userRepo;

    public WatchFeeTransaction watchFilm(Long filmId, int ticketCount) {
        Film film = filmRepo.findById(filmId).orElseThrow();
        film.setShowing(true); // Menandai film sedang ditonton / aktif
        filmRepo.save(film);

        WatchFeeTransaction transaction = new WatchFeeTransaction();
        transaction.setFilm(film);
        transaction.setTicketCount(ticketCount);
        transaction.setDate(LocalDate.now());
        transaction.setTotalPrice(ticketCount * 50.0); // Contoh harga tiket per film
        return watchFeeTransactionRepo.save(transaction);
    }

    public List<Film> getNowShowingFilms() {
        return filmRepo.findAllByShowingTrue();
    }

    public List<Film> findUserFilms(String username) {
        return userRepo.findByUsername(username)
                .map(user -> filmRepo.findAllByUploaderId(user.getId()))
                .orElse(List.of());
    }
}
    
}
