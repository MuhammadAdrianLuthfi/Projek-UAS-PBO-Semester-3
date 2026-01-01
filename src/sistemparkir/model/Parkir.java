/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemparkir.model;

/**
 *
 * @author 62878
 */
import java.time.LocalDateTime;

public class Parkir {
    private String id;
    private Kendaraan kendaraan;
    private LocalDateTime waktuMasuk;
    private LocalDateTime waktuKeluar;
    private double totalBayar;

    public static final String STATUS_AKTIF = "PARKIR";
    public static final String STATUS_SELESAI = "KELUAR";

    public Parkir(String id, Kendaraan kendaraan) {
        this.id = id;
        this.kendaraan = kendaraan;
        this.waktuMasuk = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public LocalDateTime getWaktuMasuk() {
        return waktuMasuk;
    }

    public LocalDateTime getWaktuKeluar() {
        return waktuKeluar;
    }

    public void setWaktuKeluar(LocalDateTime waktuKeluar) {
        this.waktuKeluar = waktuKeluar;
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(double totalBayar) {
        this.totalBayar = totalBayar;
    }
}
