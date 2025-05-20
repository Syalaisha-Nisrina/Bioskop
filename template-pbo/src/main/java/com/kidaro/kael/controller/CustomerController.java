package com.kidaro.kael.controller;

import com.kidaro.kael.model.Customer;
import com.kidaro.kael.model.Film;
import com.kidaro.kael.model.Ticket;
import com.kidaro.kael.service.CustomerService;
import com.kidaro.kael.repository.CustomerRepository;
import com.kidaro.kael.repository.FilmRepository;
import com.kidaro.kael.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private TicketRepository ticketRepository;

    // Endpoint untuk lihat semua film
    @GetMapping("/{id}/films")
    public void lihatFilm(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        List<FilmRepository> daftarFilm = filmRepository.findAll();
        customerService.lihatFilm(daftarFilm);
    }

    // Endpoint untuk lihat histori transaksi
    @GetMapping("/{id}/history")
    public void lihatRiwayat(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        customerService.lihatRiwayatTransaksi(customer);
    }

    // Endpoint untuk simulasi pembayaran (dummy)
    @PostMapping("/{id}/pay/{ticketId}")
    public void bayarTiket(@PathVariable Long id, @PathVariable Long ticketId) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow();
        customerService.lakukanPembayaran(customer, ticket);
    }
}
