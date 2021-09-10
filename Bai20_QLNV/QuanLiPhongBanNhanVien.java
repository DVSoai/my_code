/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai20;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author DELL
 */
public class QuanLiPhongBanNhanVien extends JFrame{
    JComboBox<PhongBan>cboPhongban;
    JList<NhanVien>listNhanVien;
    JTextField txtMa ,txtTen ,txtNgayVaoLam ,txtNamSinh;
    JButton btnLuu ,btnXoa ,btnThoat ,btnSua;
    ArrayList<PhongBan>dsPhongBan;
    ArrayList<NhanVien>dsNhanVienPhongBan;
    
    SimpleDateFormat sdf= new SimpleDateFormat("yyyy");
    PhongBan  pbSelected=null;
    NhanVien  nvSelected=null;
    
   public QuanLiPhongBanNhanVien(String tieude)
   {
       super(tieude);
       addControls();
       addEvent();
       fakeData();
   }
   
   public void addControls()
   {
       Container con = getContentPane();
       JPanel pnMain = new JPanel();
       pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
       con.add(pnMain);
       JPanel pnPhongBan = new JPanel();
       pnPhongBan.setLayout(new FlowLayout());
       pnMain.add(pnPhongBan);
       JLabel lblPhongBan = new JLabel("Chọn phòng ban");
       cboPhongban = new JComboBox<PhongBan>();
       cboPhongban.setPreferredSize(new Dimension(200, 20));
       pnPhongBan.add(lblPhongBan);
       pnPhongBan.add(cboPhongban);
       
       JPanel pnDanhSachVaChiTiet = new JPanel();
       pnDanhSachVaChiTiet.setLayout(new GridLayout(1 ,2));
       pnMain.add(pnDanhSachVaChiTiet);
       
       JPanel pnDanhSach = new JPanel();
       pnDanhSach.setLayout(new BorderLayout());
       listNhanVien = new JList<NhanVien>();
       JScrollPane sc = new JScrollPane(listNhanVien ,
       JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
       ,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       pnDanhSach.add(sc,BorderLayout.CENTER);
       pnDanhSachVaChiTiet.add(pnDanhSach);
       
       Border borderDanhSach = BorderFactory.createLineBorder(Color.BLUE);
       TitledBorder titleborderDanhSach = new TitledBorder(borderDanhSach ,"Danh Sách");
       titleborderDanhSach.setTitleJustification(TitledBorder.CENTER);
       titleborderDanhSach.setTitleColor(Color.RED);
       pnDanhSach.setBorder(titleborderDanhSach);
       
       JPanel pnChiTiet = new JPanel();
       pnChiTiet.setLayout(new BoxLayout(pnChiTiet, BoxLayout.Y_AXIS));
       pnDanhSachVaChiTiet.add(pnChiTiet);
       
       Border borderChiTiet = BorderFactory.createLineBorder(Color.BLUE);
       TitledBorder titleborderChiTiet = new TitledBorder(borderChiTiet ,"Thông tin chi tiết");
       titleborderChiTiet.setTitleJustification(TitledBorder.CENTER);
       titleborderChiTiet.setTitleColor(Color.RED);
       pnChiTiet.setBorder(titleborderChiTiet);
       
       JPanel pnMa = new JPanel();
       pnMa.setLayout(new FlowLayout());
       JLabel lblMa = new JLabel("Mã:");
       txtMa = new JTextField(15);
       pnMa.add(lblMa);
       pnMa.add(txtMa);
        pnChiTiet.add(pnMa);
               
       JPanel pnTen = new JPanel();
       pnTen.setLayout(new FlowLayout());
       JLabel lblTen = new JLabel("Tên:");
       txtTen = new JTextField(15);
       pnTen.add(lblTen);
       pnTen.add(txtTen);
       pnChiTiet.add(pnTen);
       
       JPanel pnNgayVao = new JPanel();
       pnNgayVao.setLayout(new FlowLayout());
       JLabel lblNgayVao = new JLabel("Ngày vào :");
       txtNgayVaoLam = new JTextField(15);
       pnNgayVao.add(lblNgayVao);
       pnNgayVao.add(txtNgayVaoLam);
       pnChiTiet.add(pnNgayVao);
       
       JPanel pnNamSinh = new JPanel();
       pnNamSinh.setLayout(new FlowLayout());
       JLabel lblNamSinh = new JLabel("Năm sinh :");
       txtNamSinh = new JTextField(15);
       pnNamSinh.add(lblNamSinh);
       pnNamSinh.add(txtNamSinh);
       pnChiTiet.add(pnNamSinh);
       
       JPanel pnButton = new JPanel();
       
       Border borderButton = BorderFactory.createLineBorder(Color.BLUE);
       TitledBorder titleborderButton = new TitledBorder(borderButton ,"Chọn chức năng");
       titleborderButton.setTitleJustification(TitledBorder.CENTER);
       titleborderButton.setTitleColor(Color.RED);
       pnButton.setBorder(titleborderButton);
       
       pnButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
       btnLuu = new JButton("Lưu");
       btnXoa = new JButton("Xoá");
       btnThoat = new JButton("Thoát");
       btnSua = new JButton("Sửa");
       pnButton.add(btnLuu);
       pnButton.add(btnXoa);
       pnButton.add(btnSua);
       pnButton.add(btnThoat);
       pnMain.add(pnButton);
       lblMa.setPreferredSize(lblNamSinh.getPreferredSize());
       lblTen.setPreferredSize(lblNamSinh.getPreferredSize());
       lblNgayVao.setPreferredSize(lblNamSinh.getPreferredSize());
       
   }
   public void fakeData()
   {
       dsPhongBan = new ArrayList<PhongBan>();
       PhongBan phtgv = new PhongBan();
       phtgv.setMaPhong("Phòng 1");
       phtgv.setTenPhong("Phòng hợp tác giảng viên");
       
       PhongBan pkd = new PhongBan();
       pkd.setMaPhong("Phòng 2");
       pkd.setTenPhong("Phòng Kinh Doanh");
       
       PhongBan pgt = new PhongBan();
       pgt.setMaPhong("Phòng 3");
       pgt.setTenPhong("Phòng giao tiếp");
       
       dsPhongBan.add(pgt);
       dsPhongBan.add(pkd);
       dsPhongBan.add(phtgv);
       
       pgt.themNhanVien(new NhanVien("NV1", "Đỗ Viết SOái", new Date(2021), new Date(2001)));
       pgt.themNhanVien(new NhanVien("NV1", "Đỗ Viết SOái", new Date(2021), new Date(2001)));        
       pgt.themNhanVien(new NhanVien("NV1", "Đỗ Viết SOái", new Date(2021), new Date(2001)));        
       
       for(PhongBan pb : dsPhongBan)
       {
           cboPhongban.addItem(pb);
       }
   }
   
   public void addEvent()
   {
       cboPhongban.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               if(cboPhongban.getSelectedIndex()==-1) return;
                 pbSelected =(PhongBan) cboPhongban.getSelectedItem();
               listNhanVien.setListData(pbSelected.getNhanViens());
           }
       });
       listNhanVien.addMouseListener(new MouseListener() {
           @Override
           public void mouseClicked(MouseEvent e) {
                if(listNhanVien.getSelectedIndex()==-1) return;
                nvSelected=listNhanVien.getSelectedValue();
                txtMa.setText(nvSelected.getMaNV());
                txtTen.setText(nvSelected.getTenNV());
                txtNamSinh.setText(sdf.format(nvSelected.getNamsinh()));
                txtNgayVaoLam.setText(sdf.format(nvSelected.getNgayVaoLamViec()));
           }

          
           public void mousePressed(MouseEvent e) {

           }

           
           public void mouseReleased(MouseEvent e) {
                
           }

        
           public void mouseEntered(MouseEvent e) {
              
           }

           
           public void mouseExited(MouseEvent e) {
             
           }
       });
       btnLuu.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                xuLyLuu();
           }
       });
       btnXoa.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                xuLyXoa();
           }
       });
       btnSua.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                xuLySua();
           }

       });
       btnThoat.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                System.exit(0);
           }
       });
   }
   
   protected void xuLyLuu() {
               try
               {
                   NhanVien nv = new NhanVien(txtMa.getText(), txtTen.getText()
                           , sdf.parse(txtNgayVaoLam.getText()),sdf.parse(txtNamSinh.getText()));
                   if(pbSelected!=null)
               {
                   pbSelected.themNhanVien(nv);
                   listNhanVien.setListData(pbSelected.getNhanViens());
               }
               }
               
               catch(Exception ex)
               {
                   JOptionPane.showMessageDialog(null, ex.toString());
               }
           }
   
   protected void xuLyXoa() {
               if(nvSelected!=null)
               {
                   pbSelected.getNhanViens().remove(nvSelected);
                   nvSelected = null;
                   listNhanVien.setListData(pbSelected.getNhanViens());
               }
           }
    protected void xuLySua() {
                try
               {
                   NhanVien nv = new NhanVien(txtMa.getText(), txtTen.getText()
                           , sdf.parse(txtNgayVaoLam.getText()),sdf.parse(txtNamSinh.getText()));
                   if(nvSelected!=null&&pbSelected!=null)
               {
                  pbSelected.getNhanViens().remove(nvSelected);
                  pbSelected.suaNhanVien(nv);
                   nvSelected = null;
                   listNhanVien.setListData(pbSelected.getNhanViens());
               }
               }
               
               catch(Exception ex)
               {
                   JOptionPane.showMessageDialog(null, ex.toString());
               }
           }
   
   
   public void showWindows()
   {
        this.setSize(500 ,350);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
   }
}
