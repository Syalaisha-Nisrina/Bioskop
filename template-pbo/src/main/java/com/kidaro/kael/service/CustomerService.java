// File: src/main/java/com/kidaro/kael/service/CustomerService.java

package com.kidaro.kael.service;

import com.kidaro.kael.model.Customer;
import com.kidaro.kael.model.Film;
import com.kidaro.kael.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    public void lihatFilm(List<FilmRepository> daftarFilm) {
        System.out.println("Daftar film yang sedang tayang:");
        for (FilmRepository film : daftarFilm) {
            System.out.println("- " + film.getJudul());
        }
    }

    public void lihatRiwayatTransaksi(Customer customer) {
        System.out.println("Riwayat transaksi untuk user: " + customer.getUsername());
        for (Ticket tiket : customer.getTickets()) {
            System.out.println("- Tiket: " + tiket.getJadwal().getFilm().getJudul()
                    + " | Waktu: " + tiket.getJadwal().getWaktu());
        }
    }

    public void lakukanPembayaran(Customer customer, Ticket tiket) {
        System.out.println("Pembayaran untuk tiket film " + tiket.getJadwal().getFilm().getJudul()
                + " sebesar Rp " + tiket.getHargaTotal() + " telah berhasil oleh " + customer.getUsername());
    }
}

