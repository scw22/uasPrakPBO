/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tubes1.model;

/**
 *
 * @author user
 */
public class kurir extends user{
    private int id_kurir;
    private int kapasitars_berat;
    private int total_berat_bawaan;

    public kurir(int id_kurir, int kapasitars_berat, int total_berat_bawaan, int user, String username, String password, String no_telp, String nama_lengkap, String alamat_lengkap, String kota, String provinsi, String kode_post) {
        super(user, username, password, no_telp, nama_lengkap, alamat_lengkap, kota, provinsi, kode_post);
        this.id_kurir = id_kurir;
        this.kapasitars_berat = kapasitars_berat;
        this.total_berat_bawaan = total_berat_bawaan;
    }

    public int getId_kurir() {
        return id_kurir;
    }

    public void setId_kurir(int id_kurir) {
        this.id_kurir = id_kurir;
    }

    public int getKapasitars_berat() {
        return kapasitars_berat;
    }

    public void setKapasitars_berat(int kapasitars_berat) {
        this.kapasitars_berat = kapasitars_berat;
    }

    public int getTotal_berat_bawaan() {
        return total_berat_bawaan;
    }

    public void setTotal_berat_bawaan(int total_berat_bawaan) {
        this.total_berat_bawaan = total_berat_bawaan;
    }   
}
