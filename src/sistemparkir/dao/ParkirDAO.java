/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemparkir.dao;

import java.util.List;

/**
 *
 * @author 62878
 */
public abstract class ParkirDAO {
    // Metode utama yang akan di-override
    public abstract int hitungBiaya(KendaraanDAO knd, int lamaJam);
    
    public void cetakStruk(KendaraanDAO knd, int lamaJam) {
        int total = hitungBiaya(knd, lamaJam);
        System.out.println("--- STRUK PARKIR ---");
        System.out.println("Plat Nomor  : " + knd.getplatNomor());
        System.out.println("Jenis       : " + knd.getjenis());
        System.out.println("Lama Parkir : " + lamaJam + " Jam");
        System.out.println("Total Bayar : Rp " + total);
        System.out.println("--------------------");
    }
    KendaraanDAO kd;

    public sistemparkir.model.Kendaraan createKendaraanByGolongan(int i, String b, int golongan) {
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
           // ps.setString(1, kendaraan.getPlatNomor());
           //ps.setInt(i, kd.getGolongan());
            ps.setString(b, kd.getJenis().toString());
            ps.setInt(golongan, kd.getGolongan());
            ps.executeUpdate();
            return true;
        }
    }//pdao.createKendaraanByGolongan(0, rs.getString("plat_nomor"), golongan);

    public boolean deleteParkir(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }//delete data berdasar id

    public Object[] getParkirById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }//select data parkir berdasarkan id

    public List<Object[]> getAllParkirAktif() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }//refresh data yg ter input???

    public boolean insert(sistemparkir.model.Kendaraan kendaraan) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }//input data berdasar id

    public boolean insertParkir(sistemparkir.model.Kendaraan kendaraan) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }//

    public boolean updateKendaraan(sistemparkir.model.Kendaraan kendaraan) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }//

    public double prosesKeluarParkir(Integer idParkir) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }//
    
    public class Kendaraan {
    private String jenis;
    private String platNomor;
    private boolean idMahasiswa;

    public Kendaraan(String jenis, String platNomor, boolean isMahasiswa) {
        this.jenis = jenis;
        this.platNomor = platNomor;
        this.idMahasiswa = isMahasiswa;
    }

    // Pastikan nama method sama persis dengan yang dipanggil
    public String getplatNomor() { return platNomor; }
    public String getjenis() { return jenis; }
    public boolean idMahasiswa() { return idMahasiswa; }
}
    public class ParkirDAOImpl extends ParkirDAO {

    @Override
    public int hitungBiaya(KendaraanDAO knd, int lamaJam) {
        // Jika mahasiswa, biaya otomatis 0 (Gratis)
        if (knd.idMahasiswa()) {
            return 0;
        }

        int tarifPerJam;
        switch (knd.getjenis()) {
            case "motor":
                tarifPerJam = 2000;
                break;
            case "mobil":
                tarifPerJam = 5000;
                break;
            case "truck":
                tarifPerJam = 7000;
                break;
            default:
                tarifPerJam = 0;
                System.out.println("Jenis kendaraan tidak dikenal.");
                break;
        }

        return tarifPerJam * lamaJam;
        }
    
    //public void getAllParkirAktif(){}
    //public void createKendaraanByGolongan(){}
    //public void getParkirById(id){}
    }
}