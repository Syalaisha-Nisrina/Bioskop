package com.kidaro.kael.controller;

import com.kidaro.kael.model.Film;
import com.kidaro.kael.model.Jadwal;
import com.kidaro.kael.service.JadwalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/jadwal")
public class JadwalController {

    @Autowired
    private JadwalService jadwalService;

    @GetMapping
    public List<Jadwal> tampilkanSemuaJadwal() {
        return jadwalService.getAllJadwal();
    }

    @PostMapping
    public String tambahJadwal(
        @RequestParam String id,
        @RequestParam String judulFilm,
        @RequestParam String ruangan,
        @RequestParam String tanggal,
        @RequestParam String waktu
    ) {
        Film film = new Film(judulFilm, ruangan);
        Jadwal jadwalBaru = new Jadwal(id, film, LocalDate.parse(tanggal), LocalTime.parse(waktu));

        boolean sukses = jadwalService.tambahJadwal(jadwalBaru);
        return sukses ? "Jadwal berhasil ditambahkan" : "Jadwal bentrok, gagal ditambahkan";
    }

    @DeleteMapping("/{id}")
    public String hapusJadwal(@PathVariable String id) {
        boolean sukses = jadwalService.hapusJadwal(id);
        return sukses ? "Jadwal dihapus" : "Jadwal tidak ditemukan";
    }
}
