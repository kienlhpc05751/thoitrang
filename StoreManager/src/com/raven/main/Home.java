/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.raven.main;
//         import com.raven.form.Form_2;

//import model.CarStoreManagerA;

//import dao.CarDAO;
//import dao.*;
import java.sql.Connection;
import java.util.List;
//import domeform.util.DatabaseHelper_1;
import com.raven.form.Form_2;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import model.CarStoreManagerA;
import java.awt.Color;
import java.awt.Component;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
//import model.*;

/**
 *
 * @author Asus
 */
public class Home extends javax.swing.JFrame {
        Form_2  form_2 = new Form_2();

//    ArrayList<CarStoreManagerA> listcarsA = new ArrayList<>();
//    List<CarStoreManagerA> list = new ArrayList<>();
    int current = 0; //chỉ số truy cập
    int current1 = 0; //chỉ số truy cập
    int current2 = 0;

    NumberFormat nf = NumberFormat.getCurrencyInstance();
    DecimalFormat df = new DecimalFormat("#.######");
    int index;

    String id; // biến lưu mã để check trùng mã dùng lại
    String id1; // biến lưu mã để check trùng mã dùng lại

    // Định dạng phần ngàn
//        String formattedNumber = nf.format(number);
    // In kết quả
//        System.out.println(formattedNumber);
    
    
    
//    List<CarStoreManagerA> cars = new ArrayList<>();
//    List<NhanVien> listNVS = new ArrayList<>();
//    List<khachHang> listKHS = new ArrayList<>();

    public Home() {
        initComponents();
        setTitle("QUẢN LÝ XE MÁY");
        setLocationRelativeTo(null);
//        loaddate();
//        loaddateNV();
//        loaddateKH();
//
//        DisplayKH(current2);
//        DisplayNV(current1);
//        Display(current);
//        RuingChu();
    }
//
//    public void SapXepTheogia() {
//        Collections.sort(cars, new Comparator<CarStoreManagerA>() {// dài đó là model1 .xe á
//            @Override
//            public int compare(CarStoreManagerA s1, CarStoreManagerA s2) {
//                Double a = Double.valueOf(s1.getGia());
//                Double b = Double.valueOf(s2.getGia());
//                
//
//                return Double.compare(a, b);
//            }
//          
//        });
//         System.out.println("thành công 22");
//        loaddate();
//
//    }
    
//    
//    public void RuingChu() {
//        new Thread() {
//            public void run() {
//                String text = jblTenSR.getText() + (" ");
//                while (true) {
//                    text = text.substring(1, text.length()) + text.charAt(0);
//                    try {
//                        sleep(500);
//                        jblTenSR.setText(text);
//                    } catch (InterruptedException ex) {
//                    }
//                }
//            }
//        }.start();
//    }
//
//    boolean checkMaXe() {
//        try {
//            Connection con = DatabaseHelper_1.connectDb();
//            Statement statement = con.createStatement();
//            String sql = " select * from XE ";
//            ResultSet resultSet = statement.executeQuery(sql);
//
//            while (resultSet.next()) {
//                String r = resultSet.getString("MAXE");
//                if (r.equals(txtMaXe.getText())) {
//                    System.out.println(" Trung mã MAXE rồi!");
//                    return false;
//                }
//            }
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return true;
//    }
//
//    boolean checkMaKH() {
//        try {
//            Connection con = DatabaseHelper_1.connectDb();
//            Statement statement = con.createStatement();
//            String sql = " select * from KHACHHANG ";
//            ResultSet resultSet = statement.executeQuery(sql);
//
//            while (resultSet.next()) {
//                String r = resultSet.getString("MAKH");
//                if (r.equals(txtMaKH.getText())) {
//                    System.out.println(" Trung mã MAKH rồi!");
//                    return false;
//                }
//            }
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return true;
//    }
//
//    boolean checkMaNV() {
//        try {
//            Connection con = DatabaseHelper_1.connectDb();
//            Statement statement = con.createStatement();
//            String sql = " select * from NHANVIEN ";
//            ResultSet resultSet = statement.executeQuery(sql);
//
//            while (resultSet.next()) {
//                String r = resultSet.getString("MANV");
//                if (r.equals(txtMaXe.getText())) {
//                    System.out.println(" Trung mã MANV rồi!");
//                    return false;
//                }
//            }
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return true;
//    }
//
//    // lấy dữ liệu từ đa ta
//    public void loaddate() {
//        Connection con = DatabaseHelper_1.connectDb();
//        if (con != null) {
//            cars = CarDAO.getAll(con);
//            hienThi();
//            if (!cars.isEmpty()) {
//            } else {
//                System.out.println("Danh sách đang trống");
//            }
//        } else {
//            System.out.println("Kết nối thất bại");
//        }
//    }
//
//    public void loaddateNV() {
//        Connection con = DatabaseHelper_1.connectDb();
//        if (con != null) {
//            listNVS = NhanVienDao.getAllNV(con);
//            hienThiNV();
//            if (!listNVS.isEmpty()) {
//
//            } else {
//                System.out.println("danh sách rỗng 0");
//            }
//
//        } else {
//            System.out.println("kết nối thất bại 0:");
//        }
//
//    }
//
//    public void loaddateKH() {
//        Connection con = DatabaseHelper_1.connectDb();
//        if (con != null) {
//            listKHS = KhachHangDao.getAllKH(con);
//            hienThiKH();
//            if (!listNVS.isEmpty()) {
//
//            } else {
//                System.out.println("danh sách rỗng 0");
//            }
//
//        } else {
//            System.out.println("kết nối thất bại 0:");
//        }
//
//    }
//
//    public void hienThiNV() {
//        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
//        model.setRowCount(0);
//        for (NhanVien nv : listNVS) {
//            Object[] row = {
//                nv.getMaNV(), nv.getTenNV(), nv.getSdtNV(),
//                nv.getDiachiNV(), nv.getPhai(), nv.getLuong(), nv.getDate()
//            };
//            model.addRow(row);
//        }
//    }
//
//    public void hienThi() {
//        DefaultTableModel model = (DefaultTableModel) tblBan.getModel();
//        model.setRowCount(0);
//        for (CarStoreManagerA car : cars) {
//            Object[] row = {car.getMaXe(), car.getTenXe(),
//                car.getLoaiXe(), car.getNgayNhapXe(), car.getGia()};
//            model.addRow(row);
//        }
//
//    }
//
//    public void hienThiKH() {
//        DefaultTableModel model = (DefaultTableModel) tblKH.getModel();
//        model.setRowCount(0);
//        for (khachHang kh : listKHS) {
//            Object[] row = {
//                kh.getMaKH(), kh.getTenKH(), kh.getPhaiKH(),
//                kh.getSdtKH(), kh.getDiachiKH()
//            };
//            model.addRow(row);
//        }
//    }
//
//    public void DisplayNV(int i) {
//        if (listNVS != null && i >= 0 && i < listNVS.size()) {
//            NhanVien nv = listNVS.get(i);
//            txtMaNV.setText(nv.getMaNV());
//            txtHoTen.setText(nv.getTenNV());
//            txtSDT.setText(String.valueOf(nv.getSdtNV()));
//            txtdiachi.setText(nv.getDiachiNV());
//            txtGia.setText(nv.getLuong());
//            if (nv.getPhai().equals("Nam")) {
//                jRadioButton1.setSelected(true);
//            } else {
//                jRadioButton2.setSelected(true);
//            }
//            txtLuong.setText(nv.getLuong());
//            tblNhanVien.setRowSelectionInterval(i, i);
//        } else {
//            System.out.println("Không có đối tượng NhanVien tại vị trí " + i);
//        }
//    }
//
//    // lấy cái int i = row
//    public void Display(int i) {
//        if (cars != null && i >= 0 && i < cars.size()) {
//            CarStoreManagerA car = cars.get(i);
//            txtMaXe.setText(car.getMaXe());
//            txtTenXe.setText(car.getTenXe());
//            txtLoaiXe.setText(car.getLoaiXe());
//            txtNgayNhap.setText(car.getNgayNhapXe());
//            txtGia.setText(car.getGia());
//            tblBan.setRowSelectionInterval(i, i);
//        } else {
//            System.out.println("Không có đối tượng CarStoreManagerA tại vị trí " + i);
//        }
//    }
//
//    public void DisplayKH(int i) {
//        if (listKHS != null && i >= 0 && i < listKHS.size()) {
//            khachHang car = listKHS.get(i);
//            txtMaKH.setText(car.getMaKH());
//            txtTenHK.setText(car.getTenKH());
//            txtSĐTHK.setText(car.getSdtKH());
//            if (car.getPhaiKH().equals("Nam")) {
//                jRadioButton1.setSelected(true);
//            } else {
//                jRadioButton2.setSelected(true);
//            }
//            txtĐiaChiHK.setText(car.getDiachiKH());
//            tblKH.setRowSelectionInterval(i, i);
//        } else {
//            System.out.println("Không có đối tượng khách hàng  tại vị trí " + i);
//        }
//    }
//
//    public void deleteNV() {
//        Connection con = DatabaseHelper_1.connectDb();
//        NhanVien nv = new NhanVien();
//        nv.setMaNV(txtMaNV.getText());
//        int ketqua = NhanVienDao.delet(con, nv);
//        if (ketqua == 0) {
//            System.out.println(" Xóa không thành công");
//        } else {
//            loaddateNV();
//            DisplayNV(current1);
//            JOptionPane.showMessageDialog(this, " Xóa thành công");
//        }
//    }
//
//    public void delete() {
//        Connection con = DatabaseHelper_1.connectDb();
//        CarStoreManagerA car = new CarStoreManagerA();
//        car.setMaXe(txtMaXe.getText());
//        int ketqua = CarDAO.delet(con, car);
//        if (ketqua == 0) {
//            System.out.println(" Xóa không thành công");
//        } else {
//            loaddate();
//            Display(current);
//            JOptionPane.showMessageDialog(this, "Xóa thành công");
//        }
//    }
//
//    public void deleteHK() {
//        Connection con = DatabaseHelper_1.connectDb();
//        khachHang kh = new khachHang();
//        kh.setMaKH(txtMaKH.getText());
//        int ketqua = KhachHangDao.delet(con, kh);
//        if (ketqua == 0) {
//            System.out.println(" Xóa không thành công");
//        } else {
//            loaddateKH();
//            DisplayKH(current2);
//            JOptionPane.showMessageDialog(this, "Xóa thành công");
//        }
//    }
//
//    public void top3() {
//        try {
//            Connection con = DatabaseHelper_1.connectDb();
//            String sql = "SELECT TOP 3 * FROM XE ORDER BY GIA DESC;";
//            Statement statement = con.createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//            String message = "Top 3 xe có giá cao nhất:\n\n";
//            while (rs.next()) {
//                String maXe = rs.getString("MAXE");
//                String tenXe = rs.getString("TENXE");
//                DecimalFormat df = new DecimalFormat("#.######");
//                String giaXe = String.valueOf(df.format(rs.getDouble("GIA")));
////                double giaXe = df.format(rs.getDouble("GIA"));
//                message += "Mã xe: " + maXe + "\n";
//                message += "Tên xe: " + tenXe + "\n";
//                message += "Giá xe: " + giaXe + " đ" + "\n\n";
//            }
//            JOptionPane.showMessageDialog(null, message);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public void timKiemNV() {
//        if (txtMaNV.getText().equals(" ")) {
//            JOptionPane.showMessageDialog(this, "trống mã!");
//            return;
//        } else {
//            String ma = txtMaNV.getText();
//            System.out.println("mã:" + ma);
//            int size = listNVS.size();
//            System.out.println(size);
//            for (int i = 0; i < size; i++) {
//                if (listNVS.get(i).getMaNV().equalsIgnoreCase(ma)) {
//                    JOptionPane.showMessageDialog(null, "Đã tìm thấy!!!");
//                    DisplayNV(i);
//                    return;
//                }
//            }
//            JOptionPane.showMessageDialog(null, "Không tìm thấy!!!");
//        }
//    }
//
//    public void timKiem() {
//        if (jTextField1.getText().equals(" ")) {
//            JOptionPane.showMessageDialog(this, "trống mã!");
//            return;
//        } else {
//            String ma = jTextField1.getText();
//            System.out.println("mã:" + ma);
//            int size = cars.size();
//            System.out.println(size);
//            for (int i = 0; i < size; i++) {
//                if (cars.get(i).getMaXe().equalsIgnoreCase(ma)) {
//                    JOptionPane.showMessageDialog(null, "Đã tìm thấy!!!");
//                    Display(i);
//                    return;
//                }
//            }
//            JOptionPane.showMessageDialog(null, "Không tìm thấy!!!");
//        }
//    }
//
//    public void insertNV() {
//
//        if (checkMaNV()) {
//
//            System.out.println("Mã không trùng!");
//            Connection con = DatabaseHelper_1.connectDb();
//            NhanVien car = new NhanVien();
//            car.setMaNV(txtMaNV.getText());
//            car.setTenNV(txtHoTen.getText());
//            car.setSdtNV(Integer.parseInt(txtSDT.getText()));
//            car.setDiachiNV(txtdiachi.getText());
//            car.setPhai(jRadioButton1.isSelected() ? "Nam" : "Nữ");
//            car.setLuong(txtLuong.getText());
//            car.setDate(txtNgayS.getText());
//            String id1 = txtMaXe.getText(); // Đảm bảo rằng bạn đã khai báo id1
//            int ketqua = NhanVienDao.insert(con, car);
//            if (ketqua == 0) {
//                System.out.println(" Thêm không thành công !");
//            } else {
//                loaddateNV();
//                DisplayNV(current);
//                JOptionPane.showMessageDialog(this, "Thêm thành công!");
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "trùng mã: " + id);
//        }
//
//    }
//
//    public void insertKH() {
//
//        if (checkMaKH()) {
//            System.out.println("mã không trùng!");
//            Connection con = DatabaseHelper_1.connectDb();
//            khachHang kh = new khachHang();
//            kh.setMaKH(txtMaKH.getText());
//            kh.setTenKH(txtTenHK.getText());
////            kh.setPhaiKH(rdoNam.isSelected() ? "Nam" : "Nữ");
//            if (rdoNam.isSelected()) {
//                kh.setPhaiKH("Nam");
//            } else {
//                kh.setPhaiKH("Nữ");
//            }
//            kh.setSdtKH(txtSĐTHK.getText());
//            kh.setDiachiKH(txtĐiaChiHK.getText());
////            id = txtMaKH.getText();
//            int ketqua = KhachHangDao.insert(con, kh);
//            if (ketqua == 0) {
//                System.out.println(" Thêm không thành công !");
//            } else {
//                loaddateKH();
//                DisplayKH(current2);
//                JOptionPane.showMessageDialog(this, "Thêm thành công!");
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "trùng mã: ");
////            JOptionPane.showMessageDialog(this, "trùng mã: " + id);
//            // phương án hai dialog yes no hỏi có muốn updata luôn không
//        }
//    }
//
//    public void insert() {
//
//        if (checkMaXe()) {
//            System.out.println("mã không trùng!");
//            Connection con = DatabaseHelper_1.connectDb();
//            CarStoreManagerA car = new CarStoreManagerA();
//            car.setMaXe(txtMaXe.getText());
//            car.setTenXe(txtTenXe.getText());
//            car.setLoaiXe(txtLoaiXe.getText());
//            car.setNgayNhapXe(txtNgayNhap.getText());
//            car.setGia(txtGia.getText());
//            id = txtMaXe.getText();
//            int ketqua = CarDAO.insert(con, car);
//            if (ketqua == 0) {
//                System.out.println(" insert không thành công !");
//            } else {
//                loaddate();
//                Display(current);
//                JOptionPane.showMessageDialog(this, "insert thành công!");
//
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "trùng mã: " + id);
//            // phương án hai dialog yes no hỏi có muốn updata luôn không
//        }
//
//    }
//
//    public void updateNV() {
//        Connection con = DatabaseHelper_1.connectDb();
//        NhanVien car = new NhanVien();
//        car.setTenNV(txtHoTen.getText());
//        car.setSdtNV(Integer.parseInt(txtSDT.getText()));
//        car.setDiachiNV(txtNgayNhap.getText());
//        car.setPhai(txtGia.getText());
//        car.setLuong(txtLuong.getText());
//        car.setLuong(txtMaNV.getText());
//        int rs = NhanVienDao.update(con, car);
//        if (rs > 0) {
//            JOptionPane.showMessageDialog(this, " Update thành công !");
//            loaddateNV();
//            DisplayNV(current);
//        } else {
//            JOptionPane.showMessageDialog(this, "insert thất bại");
//
//        }
//    }
//
//    public void update() {
//        Connection con = DatabaseHelper_1.connectDb();
//        CarStoreManagerA car = new CarStoreManagerA();
//        car.setTenXe(txtTenXe.getText());
//        car.setLoaiXe(txtLoaiXe.getText());
//        car.setNgayNhapXe(txtNgayNhap.getText());
//        car.setGia(txtGia.getText());
//        car.setMaXe(txtMaXe.getText());
//        int rs = CarDAO.update(con, car);
//        if (rs > 0) {
//            JOptionPane.showMessageDialog(this, " Update thành công !");
//            loaddate();
//            Display(current);
//        } else {
//            JOptionPane.showMessageDialog(this, "insert thất bại");
//
//        }
//    }
//
//    public void updateKH() {
//        Connection con = DatabaseHelper_1.connectDb();
//        khachHang kh = new khachHang();
//        kh.setMaKH(txtMaKH.getText());
//        kh.setTenKH(txtTenHK.getText());
//        if (rdoNam.isSelected()) {
//            kh.setPhaiKH("Nam");
//        } else {
//            kh.setPhaiKH("Nữ");
//        }
//        kh.setSdtKH(txtSDT.getText());
//        kh.setDiachiKH(txtdiachi.getText());
//        int rs = KhachHangDao.update(con, kh);
//        if (rs > 0) {
//            JOptionPane.showMessageDialog(this, " Update thành công !");
//            loaddateKH();
//            DisplayKH(current2);
//        } else {
//            JOptionPane.showMessageDialog(this, "insert thất bại");
//
//        }
//    }
//
    int width = 190, height = 590;

    public void openMenuBar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < width; i++) {
                    pnMenu.setSize(width, height);
                }
            }
        }).start();
    }
//
    public void closeMenuBar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = width; i > 0; i--) {
                    pnMenu.setSize(i, height);
                }
            }
        }).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
     private void showForm(Component com) {
        pnParen.removeAll();
        pnParen.add(com);
        pnParen.revalidate();
        pnParen.repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel22 = new javax.swing.JLabel();
        pnMain = new javax.swing.JPanel();
        pnMenu = new javax.swing.JPanel();
        txtFormQLxe = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFormQLxe1 = new javax.swing.JLabel();
        txtFormQLxe2 = new javax.swing.JLabel();
        txtFormQLxe3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnParen = new javax.swing.JPanel();
        pnHome = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jblTenSR = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 381, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnMain.setPreferredSize(new java.awt.Dimension(110, 400));

        pnMenu.setBackground(new java.awt.Color(204, 204, 204));
        pnMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnMenu.setPreferredSize(new java.awt.Dimension(110, 395));

        txtFormQLxe.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        txtFormQLxe.setText("Quản lý xe");
        txtFormQLxe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFormQLxeMouseClicked(evt);
            }
        });

        jLabel3.setText("kk");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        txtFormQLxe1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        txtFormQLxe1.setText("Quản lý khách hàng");
        txtFormQLxe1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFormQLxe1MouseClicked(evt);
            }
        });

        txtFormQLxe2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        txtFormQLxe2.setText("Quản lý nhân viên");
        txtFormQLxe2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFormQLxe2MouseClicked(evt);
            }
        });

        txtFormQLxe3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        txtFormQLxe3.setText("Quản lý hoa đơn");
        txtFormQLxe3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFormQLxe3MouseClicked(evt);
            }
        });

        jLabel20.setBackground(new java.awt.Color(153, 153, 153));
        jLabel20.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel20.setText(" EXIT");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFormQLxe, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFormQLxe2)
                    .addComponent(txtFormQLxe1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFormQLxe3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(59, 59, 59)
                .addComponent(txtFormQLxe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFormQLxe2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFormQLxe1)
                .addGap(18, 18, 18)
                .addComponent(txtFormQLxe3)
                .addGap(61, 61, 61)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(31, 31, 31))
        );

        jLabel4.setText("menu");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        pnParen.setLayout(new java.awt.CardLayout());

        pnHome.setBackground(new java.awt.Color(51, 51, 51));
        pnHome.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout pnHomeLayout = new javax.swing.GroupLayout(pnHome);
        pnHome.setLayout(pnHomeLayout);
        pnHomeLayout.setHorizontalGroup(
            pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHomeLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 1047, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnHomeLayout.setVerticalGroup(
            pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHomeLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel21)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pnParen.add(pnHome, "card3");

        jblTenSR.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jblTenSR.setForeground(new java.awt.Color(0, 0, 255));
        jblTenSR.setText("Showroom Cars ");

        javax.swing.GroupLayout pnMainLayout = new javax.swing.GroupLayout(pnMain);
        pnMain.setLayout(pnMainLayout);
        pnMainLayout.setHorizontalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMainLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 845, Short.MAX_VALUE)
                .addComponent(jblTenSR)
                .addContainerGap())
            .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnMainLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnParen, javax.swing.GroupLayout.DEFAULT_SIZE, 1079, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnMainLayout.setVerticalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
            .addGroup(pnMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jblTenSR)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnParen, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, 1091, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        openMenuBar();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        closeMenuBar();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void txtFormQLxeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFormQLxeMouseClicked
        // TODO add your handling code here:
// chuyển from đó á hiểu không 
//        Form
        pnParen.removeAll();
          showForm(form_2);

//        pnParen.add(pn);
        pnParen.repaint();
        pnParen.revalidate();
    }//GEN-LAST:event_txtFormQLxeMouseClicked

    private void txtFormQLxe1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFormQLxe1MouseClicked
        // TODO add your handling code here:
//        pnKhachhang.removeAll();
//        pnParen.removeAll();
//        pnParen.add(pnKhachhang);
//        pnParen.repaint();
//        pnParen.revalidate();

    }//GEN-LAST:event_txtFormQLxe1MouseClicked

    private void txtFormQLxe2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFormQLxe2MouseClicked
        // TODO add your handling code here:
        // chuyển trang
//        pnParen.removeAll();
//        pnParen.add(pnEmployee);
//        pnParen.repaint();
//        pnParen.revalidate();

    }//GEN-LAST:event_txtFormQLxe2MouseClicked

    private void txtFormQLxe3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFormQLxe3MouseClicked
        // TODO add your handling code here:
//           pnParen.removeAll();
//        pnParen.add(pnDonHang);
//        pnParen.repaint();
//        pnParen.revalidate();

    }//GEN-LAST:event_txtFormQLxe3MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel20MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jblTenSR;
    private javax.swing.JPanel pnHome;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnParen;
    private javax.swing.JLabel txtFormQLxe;
    private javax.swing.JLabel txtFormQLxe1;
    private javax.swing.JLabel txtFormQLxe2;
    private javax.swing.JLabel txtFormQLxe3;
    // End of variables declaration//GEN-END:variables
}
