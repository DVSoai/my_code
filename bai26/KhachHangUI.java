/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai26;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author DELL
 */
public class KhachHangUI extends JFrame {

    DefaultMutableTreeNode root = null;
    JTree treeNhom;

    DefaultTableModel dtm;
    JTable tblKhach;

    JTextField txtTen, txtMa, txtPhone, txtEmail;
    JButton btnLuu, btnXoa;

    ArrayList<NhomKhachHang> dsNhom;
    ArrayList<KhachHang> dsKhach;
    NhomKhachHang nhomSelected;

    public KhachHangUI(String title) {
        super(title);
        addControls();
        addEvents();
        fakeData();
    }

    public void addEvents() {
        treeNhom.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
                DefaultMutableTreeNode nodeSelected = (DefaultMutableTreeNode) treeNhom.getLastSelectedPathComponent();
                if (nodeSelected != null && nodeSelected.getLevel() == 1) {
                    nhomSelected = (NhomKhachHang) nodeSelected.getUserObject();
                    hienThiDanhSachTheoNhom();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            private void hienThiDanhSachTheoNhom() {
                //To change body of generated methods, choose Tools | Templates.
                dtm.setRowCount(0);//Xoa du lieu cu
                for (KhachHang kh : nhomSelected.getKhachHangs()) {
                    Vector<String> vec = new Vector<String>();
                    vec.add(kh.getMa());
                    vec.add(kh.getTen());
                    vec.add(kh.getPhone());
                    vec.add(kh.getEmail());
                    dtm.addRow(vec);
                }
            }
        });
        tblKhach.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
                int rowSelected = tblKhach.getSelectedRow();
                if (rowSelected == -1) {
                    return;
                }
                String ma = tblKhach.getValueAt(rowSelected, 0) + "";
                String Ten = tblKhach.getValueAt(rowSelected, 1) + "";
                String Phone = tblKhach.getValueAt(rowSelected, 2) + "";
                String Email = tblKhach.getValueAt(rowSelected, 3) + "";
                txtMa.setText(ma);
                txtTen.setText(Ten);
                txtPhone.setText(Phone);
                txtEmail.setText(Email);

            }

            @Override
            public void mousePressed(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }
        });
        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of generated methods, choose Tools | Templates.
                KhachHang kh = new KhachHang(txtMa.getText(), txtTen.getText(), txtPhone.getText(), txtEmail.getText());
                nhomSelected.themKhachHang(kh);
            }
        });
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of generated methods, choose Tools | Templates.

                KhachHang kh = new KhachHang(txtMa.getText(), txtTen.getText(), txtPhone.getText(), txtEmail.getText());
                nhomSelected.xoaKhachHangTheoMa(kh.getMa());

            }
        });
    }

    public void addControls() {
        Container con = getContentPane();
        JPanel pnLeft = new JPanel();
        pnLeft.setPreferredSize(new Dimension(300, 0));
        JPanel pnRight = new JPanel();
        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnLeft, pnRight);
        con.setLayout(new BorderLayout());
        con.add(sp, BorderLayout.CENTER);

        pnRight.setLayout(new BorderLayout());
        JPanel pnTopOfRight = new JPanel();
        pnTopOfRight.setPreferredSize(new Dimension(0, 350));
        JPanel pnBottomRight = new JPanel();
        JSplitPane spRight = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                pnTopOfRight, pnBottomRight);
        pnRight.add(spRight, BorderLayout.CENTER);

        //Ph???n b??n tr??i c???a qu???n L?? Kh??ch H??ng
        pnLeft.setLayout(new BorderLayout());
        root = new DefaultMutableTreeNode("C??ng Ty T??i Ph??t");
        treeNhom = new JTree(root);
        JScrollPane sctree = new JScrollPane(treeNhom, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pnLeft.add(sctree, BorderLayout.CENTER);

        // Ph???n b??n ph???i c???a qu???n l?? kh??ch h??ng
        pnTopOfRight.setLayout(new BorderLayout());
        dtm = new DefaultTableModel();
        dtm.addColumn("M?? Kh??ch H??ng");
        dtm.addColumn("T??n Kh??ch H??ng");
        dtm.addColumn("S??? ??i???n Tho???i");
        dtm.addColumn("Th?? ??i???n T???");
        tblKhach = new JTable(dtm);
        JScrollPane scTable = new JScrollPane(tblKhach, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                 JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pnTopOfRight.add(scTable, BorderLayout.CENTER);

        pnBottomRight.setLayout(new BoxLayout(pnBottomRight, BoxLayout.Y_AXIS));
        JPanel pnMa = new JPanel();
        JLabel lblMa = new JLabel("M?? Kh??ch H??ng");
        pnMa.setLayout(new FlowLayout(FlowLayout.LEFT));
        txtMa = new JTextField(15);
        pnMa.add(lblMa);
        pnMa.add(txtMa);
        pnBottomRight.add(pnMa);

        JPanel pnTen = new JPanel();
        JLabel lblTen = new JLabel("T??n Kh??ch H??ng");
        pnTen.setLayout(new FlowLayout(FlowLayout.LEFT));
        txtTen = new JTextField(15);
        pnTen.add(lblTen);
        pnTen.add(txtTen);
        pnBottomRight.add(pnTen);

        JPanel pnPhone = new JPanel();
        JLabel lblPhone = new JLabel("S??? ??i???n Tho???i");
        pnPhone.setLayout(new FlowLayout(FlowLayout.LEFT));
        txtPhone = new JTextField(15);
        pnPhone.add(lblPhone);
        pnPhone.add(txtPhone);
        pnBottomRight.add(pnPhone);

        JPanel pnEmail = new JPanel();
        JLabel lblEmail = new JLabel("Th?? ??i???n T???");
        pnEmail.setLayout(new FlowLayout(FlowLayout.LEFT));
        txtEmail = new JTextField(15);
        pnEmail.add(lblEmail);
        pnEmail.add(txtEmail);
        pnBottomRight.add(pnEmail);

        JPanel pnButton = new JPanel();
        pnButton.setLayout(new FlowLayout(FlowLayout.LEFT));
        btnLuu = new JButton("L??u Kh??ch H??ng");
        btnXoa = new JButton("Xo?? Kh??ch H??ng");
        pnButton.add(btnLuu);
        pnButton.add(btnXoa);
        pnBottomRight.add(pnButton);

        lblMa.setPreferredSize(lblTen.getPreferredSize());
        lblPhone.setPreferredSize(lblTen.getPreferredSize());
        lblEmail.setPreferredSize(lblTen.getPreferredSize());
    }

    public void fakeData() {
        dsNhom = new ArrayList<NhomKhachHang>();
        NhomKhachHang vip = new NhomKhachHang("Nh??m1", "Kh??ch H??ng VIP");
        NhomKhachHang tiemnang = new NhomKhachHang("Nh??m2", "Kh??ch H??ng Ti???m N??ng");
        NhomKhachHang khotinh = new NhomKhachHang("Nh??m3", "Kh??ch H??ng Kh?? T??nh");
        dsNhom.add(vip);
        dsNhom.add(tiemnang);
        dsNhom.add(khotinh);

        vip.getKhachHangs().add(new KhachHang("1", "So??i", "8888", "s@gmail.com"));
        vip.getKhachHangs().add(new KhachHang("2", "T??i", "6666", "t@gmail.com"));
        tiemnang.getKhachHangs().add(new KhachHang("1", "S??n", "3333", "so@gmail.com"));
        tiemnang.getKhachHangs().add(new KhachHang("2", "Kh??nh", "2222", "k@gmail.com"));
        tiemnang.getKhachHangs().add(new KhachHang("3", "Hi???p", "5555", "h@gmail.com"));
        khotinh.getKhachHangs().add(new KhachHang("1", "Vi???t", "9999", "v@gmail.com"));
        khotinh.getKhachHangs().add(new KhachHang("2", "Qu??n", "0000", "q@gmail.com"));

        for (NhomKhachHang nhom : dsNhom) {
            DefaultMutableTreeNode nodeNhom = new DefaultMutableTreeNode(nhom);
            root.add(nodeNhom);
            for (KhachHang khach : nhom.getKhachHangs()) {
                DefaultMutableTreeNode nodeKhach = new DefaultMutableTreeNode(khach);
                nodeNhom.add(nodeKhach);
            }
        }
        treeNhom.expandRow(0);
    }

    public void showWindows() {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
