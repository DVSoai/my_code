/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai26;

import java.util.Vector;

/**
 *
 * @author DELL
 */
public class NhomKhachHang {
    private String ma;
    private String ten;
    private Vector<KhachHang>khachHangs;

    public void themKhachHang(KhachHang kh)
    {
        this.khachHangs.add(kh);
        kh.setNhom(this);
    }
    public void xoaKhachHangTheoMa(String maKH)
    {
        for (KhachHang khachHang : khachHangs) {
            if(khachHang.getMa().equals(maKH))
                this.khachHangs.remove(khachHang);
        }
    }
    
    public NhomKhachHang() {
        this.khachHangs = new Vector<KhachHang>();
    }

    
    
    public NhomKhachHang(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
        this.khachHangs = new Vector<KhachHang>();
    }

    
    
    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Vector<KhachHang> getKhachHangs() {
        return khachHangs;
    }

    public void setKhachHangs(Vector<KhachHang> khachHangs) {
        this.khachHangs = khachHangs;
    }

    @Override
    public String toString() {
        return this.ten; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
