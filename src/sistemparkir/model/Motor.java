/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemparkir.model;

/**
 *
 * @author 62878
 */
public class Motor extends Kendaraan {
    public Motor(int idKendaraan, String platNomor) {
        super(idKendaraan, platNomor, Jeniskendaraan.MOTOR, 2);
    }

    @Override
    public double hitungTarif(int lamaParkir) {
        return lamaParkir * 2000;
    }
}