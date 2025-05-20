package com.kidaro.kael.model;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Jadwal {

    private String idJadwal;
    private Film film;
    private LocalDate tanggal;
    private LocalTime waktu;

    // Constructor
    public Jadwal(String idJadwal, Film film, LocalDate tanggal, LocalTime waktu) {
        this.idJadwal = idJadwal;
        this.film = film;
        this.tanggal = tanggal;
        this.waktu = waktu;
    }

    // Getter dan Setter
    public String getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(String idJadwal) {
        this.idJadwal = idJadwal;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public LocalTime getWaktu() {
        return waktu;
    }

    public void setWaktu(LocalTime waktu) {
        this.waktu = waktu;
    }

    // Method tampilkan jadwal
    public void tampilkanJadwal() {
        System.out.println("ID Jadwal      : " + this.idJadwal);
        System.out.println("Judul Film     : " + this.film.getJudul());
        System.out.println("Ruangan        : " + this.film.getRuangan());
        System.out.println("Tanggal Tayang : " + this.tanggal);
        System.out.println("Waktu Tayang   : " + this.waktu);
        System.out.println("---------------------------------");
    }

    // Method untuk cek apakah jadwal bentrok
    public static boolean cekJadwalBentrok(List<Jadwal> daftarJadwal, Jadwal jadwalBaru) {
        for (Jadwal j : daftarJadwal) {
            if (j.getTanggal().equals(jadwalBaru.getTanggal())
                && j.getWaktu().equals(jadwalBaru.getWaktu())
                && j.getFilm().getRuangan().equalsIgnoreCase(jadwalBaru.getFilm().getRuangan())) {
                return true; // bentrok
            }
        }
        return false; // tidak bentrok
    }
}
 {
    
}
