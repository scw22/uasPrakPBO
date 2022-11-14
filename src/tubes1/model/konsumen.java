/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tubes1.model;

/**
 *
 * @author user
 */
public class konsumen extends user {
    int id_user;

    public konsumen(int id_user, int user, String username, String password, String no_telp, String nama_lengkap, String alamat_lengkap, String kota, String provinsi, String kode_post) {
        super(user, username, password, no_telp, nama_lengkap, alamat_lengkap, kota, provinsi, kode_post);
        this.id_user = id_user;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    
}
