/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemparkir.model;

/**
 *
 * @author 62878
 */
public class Mobil extends Kendaraan {
    public Mobil(String platNomor) {
        super(platNomor, Jeniskendaraan.MOBIL, 3);
    }

    @Override
    public double hitungTarif(int lamaParkir) {
        return lamaParkir * 5000;
    }
}