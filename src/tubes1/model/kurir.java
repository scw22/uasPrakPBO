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
    int id_kurir;

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

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getNama_lengkap() {
        return nama_lengkap;
    }

    public void setNama_lengkap(String nama_lengkap) {
        this.nama_lengkap = nama_lengkap;
    }

    public String getAlamat_lengkap() {
        return alamat_lengkap;
    }

    public void setAlamat_lengkap(String alamat_lengkap) {
        this.alamat_lengkap = alamat_lengkap;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKode_post() {
        return kode_post;
    }

    public void setKode_post(String kode_post) {
        this.kode_post = kode_post;
    }

    public kurir(int id_kurir, int kapasitars_berat, int total_berat_bawaan) {
        this.id_kurir = id_kurir;
        this.kapasitars_berat = kapasitars_berat;
        this.total_berat_bawaan = total_berat_bawaan;
    }
    int kapasitars_berat;
    int total_berat_bawaan;
}
