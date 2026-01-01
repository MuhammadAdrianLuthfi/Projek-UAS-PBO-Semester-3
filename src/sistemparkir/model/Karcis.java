/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemparkir.model;

import java.time.LocalDateTime;
/**
 *
 * @author 62878
 */
public class Karcis {
    private Kendaraan kendaraan;
    private LocalDateTime waktuMasuk;
    private int idTiket;

    public Karcis(int idTiket, Kendaraan kendaraan) {
        this.idTiket = idTiket;
        this.kendaraan = kendaraan;
        this.waktuMasuk = LocalDateTime.now();
    }
}
