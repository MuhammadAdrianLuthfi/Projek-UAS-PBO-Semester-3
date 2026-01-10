/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemparkir.model;

/**
 *
 * @author 62878
 */
public class Truck extends Kendaraan {
    public Truck(int idKendaraan, String platNomor) {
        super(idKendaraan,platNomor, Jeniskendaraan.TRUCK, 4);
    }

    @Override
    public double hitungTarif(int lamaParkir) {
        return lamaParkir * 7000; 
    }
}