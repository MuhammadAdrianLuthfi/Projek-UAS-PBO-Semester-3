/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemparkir.dao;

/**
 *
 * @author 62878
 */
import sistemparkir.config.Database;
import sistemparkir.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParkirDAO {
    public boolean insert(Kendaraan kendaraan) {
        String sql = "INSERT INTO kendaraan (plat_nomor, golongan, jenis, tarif_per_jam) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, kendaraan.getPlatNomor());
            ps.setInt(2, kendaraan.getGolongan());
            ps.setString(3, kendaraan.getJenis().toString());
            ps.setDouble(4, kendaraan.hitungTarif(1));
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Kendaraan> getAll() {
        List<Kendaraan> list = new ArrayList<>();
        String sql = "SELECT * FROM kendaraan";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Kendaraan k = null;
                String plat = rs.getString("plat_nomor");
                int gol = rs.getInt("golongan");
                
                switch (gol) {
                    case 1 -> k = new Mahasiswa(plat);
                    case 2 -> k = new Motor(plat);
                    case 3 -> k = new Mobil(plat);
                    case 4 -> k = new Truck(plat);
                }
                
                if (k != null) {
                    list.add(k);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean update(Kendaraan kendaraan, String platLama) {
        String sql = "UPDATE kendaraan SET plat_nomor = ?, golongan = ?, jenis = ?, tarif_per_jam = ? WHERE plat_nomor = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, kendaraan.getPlatNomor());
            ps.setInt(2, kendaraan.getGolongan());
            ps.setString(3, kendaraan.getJenis().toString());
            ps.setDouble(4, kendaraan.hitungTarif(1));
            ps.setString(5, platLama);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String platNomor) {
        String sql = "DELETE FROM kendaraan WHERE plat_nomor = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, platNomor);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public double getTarifKeluar(String platNomor) {
        String sql = "SELECT waktu_masuk, tarif_per_jam FROM kendaraan WHERE plat_nomor = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, platNomor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Timestamp masuk = rs.getTimestamp("waktu_masuk");
                double tarif = rs.getDouble("tarif_per_jam");
                long selisih = System.currentTimeMillis() - masuk.getTime();
                int jam = (int) Math.ceil((double) selisih / (1000 * 60 * 60));
                if (jam <= 0) jam = 1;
                return jam * tarif;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
