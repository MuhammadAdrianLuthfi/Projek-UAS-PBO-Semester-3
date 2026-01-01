/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemparkir.model;

/**
 *
 * @author 62878
 */
public class Mahasiswa extends Kendaraan {
    public Mahasiswa(String platNomor) {
        super(platNomor, Jeniskendaraan.MAHASISWA, 1);
    }

    @Override
    public double hitungTarif(int lamaParkir) {
        return 0;
    }
}
