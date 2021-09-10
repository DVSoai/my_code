/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai20;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author DELL
 */
public class PhongBan implements Serializable{
    private String maPhong;
    private String tenPhong;
    Vector<NhanVien>NhanViens;

    public void themNhanVien(NhanVien nv)
    {
        this.NhanViens.add(nv);
        nv.setPhong(this);
    }
    
    public void suaNhanVien(NhanVien nv)
    {
        this.NhanViens.add(nv);
        nv.setPhong(this);
    }
    
    public PhongBan() {
        super();
        this.NhanViens = new Vector<NhanVien>();
    }
     
    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public Vector<NhanVien> getNhanViens() {
        return NhanViens;
    }

    public void setNhanViens(Vector<NhanVien> NhanViens) {
        this.NhanViens = NhanViens;
    }

    @Override
    public String toString() {
        return this.tenPhong;
    }
    
}
