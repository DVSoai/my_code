/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai20;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class NhanVien implements Serializable{
    private String maNV;
    private String tenNV;
    private Date ngayVaoLamViec;
    private Date namsinh;
    private PhongBan phong;

    public NhanVien(String maNV, String tenNV, Date ngayVaoLamViec, Date namsinh) {
        super();
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngayVaoLamViec = ngayVaoLamViec;
        this.namsinh = namsinh;
    }
  
    
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Date getNgayVaoLamViec() {
        return ngayVaoLamViec;
    }

    public void setNgayVaoLamViec(Date ngayVaoLamViec) {
        this.ngayVaoLamViec = ngayVaoLamViec;
    }

    public Date getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(Date namsinh) {
        this.namsinh = namsinh;
    }

    public PhongBan getPhong() {
        return phong;
    }

    public void setPhong(PhongBan phong) {
        this.phong = phong;
    }

    @Override
    public String toString() {
        return this.tenNV;
    }

    
    
}
