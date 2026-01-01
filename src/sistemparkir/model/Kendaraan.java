/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemparkir.model;

/**
 *
 * @author 62878
 */
public abstract class Kendaraan {
    private String platNomor;
    private Jeniskendaraan jenis;
    private int golongan;

    public Kendaraan(String platNomor, Jeniskendaraan jenis, int golongan) {
        this.platNomor = platNomor;
        this.jenis = jenis;
        this.golongan = golongan;
    }

    public abstract double hitungTarif(int lamaParkir);

    public String getPlatNomor() { 
        return platNomor; 
    }
    public void setPlatNomor(String platNomor) { 
        this.platNomor = platNomor; 
    }
    public Jeniskendaraan getJenis() {
        return jenis; 
    }
    public int getGolongan() { 
        return golongan; 
    }
}
