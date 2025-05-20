package com.kidaro.kael.service;

import com.kidaro.kael.model.Jadwal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class JadwalService {

    private List<Jadwal> daftarJadwal = new ArrayList<>();

    public List<Jadwal> getAllJadwal() {
        return daftarJadwal;
    }

    public boolean tambahJadwal(Jadwal jadwalBaru) {
        if (Jadwal.cekJadwalBentrok(daftarJadwal, jadwalBaru)) {
            return false;
        } else {
            daftarJadwal.add(jadwalBaru);
            return true;
        }
    }

    public Jadwal getById(String id) {
        for (Jadwal j : daftarJadwal) {
            if (j.getIdJadwal().equalsIgnoreCase(id)) {
                return j;
            }
        }
        return null;
    }

    public boolean hapusJadwal(String id) {
        return daftarJadwal.removeIf(j -> j.getIdJadwal().equalsIgnoreCase(id));
    }
}

