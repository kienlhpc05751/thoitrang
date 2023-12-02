/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

//import com.raven.dao.NhanVienDao;
import com.raven.dao.KhachHangDao;
import com.raven.dao.LoaiSpDAO;
import com.raven.dao.SanPhamDao;
import com.raven.utils.XDialogHelper;
import com.raven.utils.XShareHelper;
import com.raven.utils.Validator;
import com.raven.main.Main;
import com.raven.model.KhachHang;
import com.raven.model.LoaiSanPham;
import com.raven.model.Sanpham;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import com.raven.utils.MsgBox;
import com.raven.utils.XDate;
import com.raven.utils.XImage;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
//import com.raven.dao.
//import com.raven.dao.

/**
 *
 * @author RAVEN
 */
public class SanPhamView1 extends javax.swing.JPanel {

    String masp = null;
    int row = 01;
    SanPhamDao dao = new SanPhamDao() {
    };
    List<Sanpham> listSP = new ArrayList<>();
    LoaiSpDAO daosp = new LoaiSpDAO() {
    };
    List<LoaiSanPham> listLSP = new ArrayList<>();

    public SanPhamView1() {
        initComponents();
        Int();
        fillTable(listSP);
    }

    public void Int() {
        fillCombobox();
    }

    void chonComboBox(int index) {
        if (index >= 0) {
            LoaiSanPham cd = listLSP.get(index);

//              listLSP = (List<LoaiSanPham>) daosp.selectById(cd.getMaloaiSP());
//            listLSP = daosp.selectById(cd.getMaLoai());
//            System.out.println(listSP);
//            txtMaSP.setText(cd.getBienTheSP());
//            txtTenSP.setText(cd.getTenSP());
//            txtChuyenDe.setText(cd.getTenCD());
//            txtHocPhi.setText(String.valueOf(cd.getHocPhi()));
//            txtSoLuongH.setText(String.valueOf(cd.getThoiLuong()));
//            maCD = cd.getMaCD();
//            fillTable(listKH);
        }
    }

    //fill dữ liệu lên cobombox cboMaloai
    void fillCombobox() {

        listLSP = daosp.selectAll();
        DefaultComboBoxModel cboModel = (DefaultComboBoxModel) CboMaloai.getModel();
        cboModel.removeAllElements();
        cboModel.addElement("vui lòng chọn !");
        for (LoaiSanPham itempCD : listLSP) {

            cboModel.addElement(itempCD.getMaloaiSP());
        }

//             listSP = dao.selectAll();
//        DefaultComboBoxModel cboModel = (DefaultComboBoxModel) CboMaloai.getModel();
//        cboModel.removeAllElements();
//        for (Sanpham itempCD : listSP) {
//            cboModel.addElement(itempCD.getMaLoai());
//        }
//        System.out.println("Size of listSP: " + listSP.size());
//        List<Object[]> list = new ArrayList<>();
//        list = dao.getco();
//        
//        System.out.println("Size of listSP: " + listSP.size());
//
//        DefaultComboBoxModel cboModel = (DefaultComboBoxModel) CboMaloai.getModel();
//        cboModel.removeAllElements();
//        for (Object[] objects : list) {
//                        cboModel.addElement(objects.row);
//
//        }
    }
    // fill dữ liệu lên bảng

    void fillTable(List<Sanpham> list) {
        String row[] = {"MaSP", "LoaiSP", "TenSP", "Kichco", "Mausac", "gia ban", "soLuong"};
        DefaultTableModel model = new DefaultTableModel(row, 0);
        model.setRowCount(0);
        listSP = dao.selectAll();
        for (Sanpham itempKH : listSP) {
            model.addRow(new Object[]{itempKH.getBienTheSP(), itempKH.getMaLoai(), itempKH.getTenSP(), itempKH.getKichCo(), itempKH.getMauSac(), itempKH.getGia(), itempKH.getSoLuong()});
        }
        tblSanPham.setModel(model);
    }
// fill lên from dữ liệu trong l

    void setForm(Sanpham kh) {

        txtMaSP.setText(kh.getBienTheSP());
        // Giả sử ComboBox có kiểu dữ liệu là String
        String selectedLoai = kh.getMaLoai();
        CboMaloai.setSelectedItem(selectedLoai);
        txtTenSP.setText(kh.getTenSP());
        txtKichCo.setText(kh.getKichCo());
        txtMauSac.setText(kh.getMauSac());
        txtGiaBan.setText(String.valueOf(kh.getGia()));
        txtSoLuong.setText(String.valueOf(kh.getSoLuong()));
    }

    Sanpham getForm() {
        Sanpham kh = new Sanpham();

        kh.setBienTheSP(txtMaSP.getText());
        // Lấy giá trị từ ComboBox
        Object selectedLoai = CboMaloai.getSelectedItem();
        if (selectedLoai != null) {
            // Chuyển đổi và đặt giá trị cho thuộc tính maLoai
            kh.setMaLoai(selectedLoai.toString());
        } else {
            // Xử lý khi không có mục nào được chọn trong ComboBox
            kh.setMaLoai(null); // hoặc giá trị mặc định khác tùy vào logic của bạn
        }
        kh.setTenSP(txtTenSP.getText());
        kh.setKichCo(txtKichCo.getText());
        kh.setMauSac(txtMauSac.getText());
        kh.setGia(Double.parseDouble(txtGiaBan.getText()));
        kh.setSoLuong(Integer.parseInt(txtSoLuong.getText()));

//        kh.setMaCD(maCD);
////        kh.setMaKH(maKH);
//        kh.setThoiLuong(Integer.parseInt(txtSoLuongH.getText()));
//        kh.setHocPhi(Double.valueOf(txtHocPhi.getText()));
//        kh.setNgayKG(txtKhaiGiang.getText());
//        kh.setMaNV(Auth.user.getMaNV());
//        kh.setNgayTao(txtNgayTao.getText());
//        kh.setGhiChu(txtGhiChu.getText());
        return kh;
    }

    void edit(int index) {
        Sanpham kh = listSP.get(index);
        setForm(kh);
    }

    void first() {
        this.row = 0;
        this.edit(row);
    }

    void prev() {
        if (this.row < 1) {
            return;
        } else {
            this.row--;
            this.edit(row);
        }
    }

    void next() {
        if (this.row > tblSanPham.getRowCount() - 2) {
            return;
        } else {
            this.row++;
            this.edit(row);
//            System.out.println(row);
        }
    }

    void last() {
        this.row = tblSanPham.getRowCount() - 1;
        this.edit(row);
    }

    void insert() {
        try {
            dao.insert(getForm());
            MsgBox.alert(null, "Thêm sản phẩm  Thành Công");
            fillTable(listSP);
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(null, "Thêm sản phẩm Thất Bại");
        }
//        if (checkFrom()) {
//            try {
////                MsgBox.alert(null, "Thêm Khóa Học Thành Công");
//                daokh.insert(getForm());
////                fillTable(listKH);
////                  listCD = daoCD.selectAll();
//                   fillTable(listKH);
//            } catch (Exception e) {
//                e.printStackTrace();
//                MsgBox.alert(null, "Thêm Khóa Học Thất Bại");
//            }
//        }
    }

    void update() {
        try {
            dao.update(getForm());
            MsgBox.alert(null, "Cập nhật sản phẩm Thành Công");
            fillTable(listSP);
        } catch (Exception e) {
            MsgBox.alert(null, "Cập nhật sản phẩm Thất Bại");
        }
    }

    void delete() {
        try {
            dao.delete(String.valueOf(masp));
            MsgBox.alert(null, "Delete sản phẩm Thành Công");
            fillTable(listSP);
        } catch (Exception e) {
            MsgBox.alert(null, "Delete sản phẩm Thất Bại");
        }
//        try {
//            if (!Auth.isManager()) {
//                MsgBox.alert(null, "Bạn Không Có Quyền Xóa Khóa Học");
//                return;
//            } else {
//                MsgBox.alert(null, "Delete Khóa Học Thành Công");
//                daokh.delete(String.valueOf(maKH));
//            }
//        } catch (Exception e) {
//            MsgBox.alert(null, "Delete Khóa Học Thất Bại");
//        }
    }

    void clearForm() {
        Sanpham kh = new Sanpham();
        this.setForm(kh);
        fillCombobox();
        this.row = -1;
        this.updateStatus();
    }

    void updateStatus() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblSanPham.getRowCount() - 1);
//        txtMaNV.setEditable(!edit);
//        btnThem.setEnabled(!edit);
//        btnSua.setEnabled(edit);
//        btnXoa.setEnabled(edit);
//        btnFrist.setEnabled(edit && !first);
//        btnPrev.setEnabled(edit && !first);
//        btnNext.setEnabled(edit && !last);
//        btnLast.setEnabled(edit && !last);
    }

//    
//  00002202708
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        tabs = new javax.swing.JTabbedPane();
        pnUpdate = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblMaSP = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblMaNV1 = new javax.swing.JLabel();
        lblMaNV6 = new javax.swing.JLabel();
        lblMaNV7 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        txtKichCo = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtMauSac = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        lblGiaBan = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        lblMaLoai = new javax.swing.JLabel();
        CboMaloai = new javax.swing.JComboBox<>();
        lblSoLuong = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        pnButton = new javax.swing.JPanel();
        btnfirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();

        jPanel1.setLayout(new java.awt.BorderLayout());

        pnUpdate.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblMaSP.setBackground(new java.awt.Color(102, 0, 204));
        lblMaSP.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaSP.setForeground(new java.awt.Color(27, 51, 61));
        lblMaSP.setText("Mã SP");

        txtMaSP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaSP.setBorder(null);

        lblMaNV1.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaNV1.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV1.setText("Tên KH");

        lblMaNV6.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaNV6.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV6.setText("Kích Cở");

        lblMaNV7.setBackground(new java.awt.Color(102, 0, 204));
        lblMaNV7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaNV7.setForeground(new java.awt.Color(27, 51, 61));
        lblMaNV7.setText("Màu Sắc");

        txtTenSP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenSP.setBorder(null);
        txtTenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSPActionPerformed(evt);
            }
        });

        txtKichCo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtKichCo.setBorder(null);

        txtMauSac.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMauSac.setBorder(null);
        txtMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMauSacActionPerformed(evt);
            }
        });

        lblGiaBan.setBackground(new java.awt.Color(102, 0, 204));
        lblGiaBan.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblGiaBan.setForeground(new java.awt.Color(27, 51, 61));
        lblGiaBan.setText("Giá bán");

        txtGiaBan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGiaBan.setBorder(null);

        lblMaLoai.setBackground(new java.awt.Color(102, 0, 204));
        lblMaLoai.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaLoai.setForeground(new java.awt.Color(27, 51, 61));
        lblMaLoai.setText("MaLoai");

        CboMaloai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CboMaloaiActionPerformed(evt);
            }
        });

        lblSoLuong.setBackground(new java.awt.Color(102, 0, 204));
        lblSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblSoLuong.setForeground(new java.awt.Color(27, 51, 61));
        lblSoLuong.setText("Số Lượng");

        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSoLuong.setBorder(null);

        pnButton.setBackground(new java.awt.Color(255, 255, 255));
        pnButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnfirst.setBackground(new java.awt.Color(204, 204, 204));
        btnfirst.setText("|<");
        btnfirst.setBorderPainted(false);
        btnfirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfirstActionPerformed(evt);
            }
        });

        btnPrev.setBackground(new java.awt.Color(204, 204, 204));
        btnPrev.setText("<<");
        btnPrev.setBorderPainted(false);
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(204, 204, 204));
        btnNext.setText(">>");
        btnNext.setBorderPainted(false);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setBackground(new java.awt.Color(204, 204, 204));
        btnLast.setText(">|");
        btnLast.setBorderPainted(false);
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(204, 204, 204));
        btnThem.setText("Thêm");
        btnThem.setBorderPainted(false);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(204, 204, 204));
        btnSua.setText("Sửa");
        btnSua.setBorderPainted(false);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(204, 204, 204));
        btnXoa.setText("Xóa");
        btnXoa.setBorderPainted(false);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(204, 204, 204));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setBorderPainted(false);
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnButtonLayout = new javax.swing.GroupLayout(pnButton);
        pnButton.setLayout(pnButtonLayout);
        pnButtonLayout.setHorizontalGroup(
            pnButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnButtonLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnfirst)
                .addGap(18, 18, 18)
                .addComponent(btnPrev)
                .addGap(18, 18, 18)
                .addComponent(btnNext)
                .addGap(18, 18, 18)
                .addComponent(btnLast)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnSua)
                .addGap(18, 18, 18)
                .addComponent(btnXoa)
                .addGap(18, 18, 18)
                .addComponent(btnLamMoi)
                .addGap(14, 14, 14))
        );
        pnButtonLayout.setVerticalGroup(
            pnButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnButtonLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem)
                        .addComponent(btnSua)
                        .addComponent(btnXoa)
                        .addComponent(btnLamMoi))
                    .addGroup(pnButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnfirst)
                        .addComponent(btnPrev)
                        .addComponent(btnNext)
                        .addComponent(btnLast)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoLuong)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CboMaloai, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))
                    .addComponent(txtMauSac)
                    .addComponent(jSeparator5)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSP)
                            .addComponent(txtKichCo)
                            .addComponent(jSeparator3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMaNV6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addComponent(jSeparator4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtGiaBan)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblMaNV1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(355, 355, 355))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaNV7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator7)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblMaSP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaLoai)
                    .addComponent(lblMaNV1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CboMaloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMaNV6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMaNV7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblGiaBan)
                .addGap(1, 1, 1)
                .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSoLuong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnUpdateLayout = new javax.swing.GroupLayout(pnUpdate);
        pnUpdate.setLayout(pnUpdateLayout);
        pnUpdateLayout.setHorizontalGroup(
            pnUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        pnUpdateLayout.setVerticalGroup(
            pnUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        tabs.addTab("CẬP NHẬT", pnUpdate);

        tblSanPham.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblSanPham.setFont(new java.awt.Font("UTM BryantLG", 1, 14)); // NOI18N
        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã KH", "Tên KH", "Email", "SDT", "Địa chỉ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblSanPham.setGridColor(new java.awt.Color(204, 204, 204));
        tblSanPham.setRowHeight(30);
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        javax.swing.GroupLayout btnListLayout = new javax.swing.GroupLayout(btnList);
        btnList.setLayout(btnListLayout);
        btnListLayout.setHorizontalGroup(
            btnListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 928, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnListLayout.setVerticalGroup(
            btnListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnListLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
        );

        tabs.addTab("DANH SÁCH", btnList);

        jPanel1.add(tabs, java.awt.BorderLayout.CENTER);

        lblTitle.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(102, 102, 102));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("QUẢN LÝ SẢN PHẨM");
        lblTitle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(lblTitle, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblSanPhamMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseReleased

    }//GEN-LAST:event_tblSanPhamMouseReleased

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
//        this.index = tblSanPham.getRowCount() - 1;
//        this.edit();
        last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
//        this.index++;
//        this.edit();
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
//        this.index--;
//        this.edit();
        prev();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnfirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfirstActionPerformed
//        this.index = 0;
//        this.edit();
        first();
    }//GEN-LAST:event_btnfirstActionPerformed

    private void txtMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMauSacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMauSacActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        clearForm();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
//        if (evt.getClickCount() == 2) {
//            this.index = tblSanPham.rowAtPoint(evt.getPoint());
//            if (this.index >= 0) {
//                this.edit();
//                tabs.setSelectedIndex(0);
//                
//            }
//        }
        this.row = tblSanPham.getSelectedRow();
        this.edit(row);
        tabs.setSelectedIndex(0);
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void txtTenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSPActionPerformed

    private void CboMaloaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CboMaloaiActionPerformed
        // TODO add your handling code here:
        row = CboMaloai.getSelectedIndex()-1;
        System.out.println("roo");

        System.out.println(row);
        chonComboBox(row);
    }//GEN-LAST:event_CboMaloaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CboMaloai;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLast;
    private javax.swing.JPanel btnList;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnfirst;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel lblGiaBan;
    private javax.swing.JLabel lblMaLoai;
    private javax.swing.JLabel lblMaNV1;
    private javax.swing.JLabel lblMaNV6;
    private javax.swing.JLabel lblMaNV7;
    private javax.swing.JLabel lblMaSP;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnButton;
    private javax.swing.JPanel pnUpdate;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtKichCo;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMauSac;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
//    int index = -1; // vị trí của khách hàng đang hiển thị trên form
//    KhachHangDao khDao = new KhachHangDao();
//
//    void load() {
//        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
//        model.setRowCount(0);
//        try {
//            List<KhachHang> list = khDao.selectAll();
//            for (KhachHang kh : list) {
//                Object[] row = {
//                    kh.getMaKH(),
//                    kh.getTenKH(),
//                    kh.getEmail(),
//                    kh.getSDT(),
//                    kh.getDiaChi()
//                };
//                model.addRow(row);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Lỗi truy vấn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
//            System.err.println("Lỗi truy vấn: " + e.getMessage());
//        }
//    }
//
//    void edit() {
//        try {
//            Integer makh = (Integer) tblSanPham.getValueAt(this.index, 0);
//            KhachHang model = khDao.findByID(makh);
//            if (model != null) {
//                this.setModel(model);
////                tabs.setSelectedIndex(0);
//                this.setStatus(false);
//            }
//        } catch (Exception e) {
//            MsgBox.alert(this, "Lỗi truy vấn!");
//            System.err.println("Lỗi truy vấn: " + e.getMessage());
//        }
//    }
//
//    void setModel(KhachHang model) {
//        txtMaSP.setText(String.valueOf(model.getMaKH()));
//        txtTenSP.setText(model.getTenKH());
//        txtKichCo.setText(model.getEmail());
//        txtMauSac.setText(model.getSDT());
//        txtGiaBan.setText(model.getDiaChi());
//    }
//    
//    KhachHang getModel() {
//        KhachHang model = new KhachHang();
//        model.setMaKH(Integer.valueOf(txtMaSP.getText()));
//        model.setTenKH(txtTenSP.getText());
//        model.setEmail(txtKichCo.getText());
//        model.setSDT(txtMauSac.getText());
//        model.setDiaChi(txtGiaBan.getText());
//        return model;
//    }
//
//    void setStatus(boolean insertable) {
//        txtMaSP.setEditable(insertable);
//        btnThem.setEnabled(insertable);
//        btnSua.setEnabled(!insertable);
//        btnXoa.setEnabled(!insertable);
//
//        boolean first = this.index > 0;
//        boolean last = this.index < tblSanPham.getRowCount() - 1;
//        btnfirst.setEnabled(!insertable && first);
//        btnPrev.setEnabled(!insertable && first);
//        btnNext.setEnabled(!insertable && last);
//        btnLast.setEnabled(!insertable && last);
//    }
//
//    void insert() {
//       if (!validator()) {
//            return;
//        }
//
//        KhachHang nv = getModel();
//
//        if (nv == null) {
//            return;
//        }
//
//        KhachHangDao.getInstant().insert(nv);
//        MsgBox.alert(this, "Thêm thành công " + " " + nv.getTenKH());
//        clear();
//        load();
//
//    }
//
//    void update() {
//        if (!validator()) {
//            return;
//        }
//
//        KhachHang kh = getModel();
//
//        if (kh == null) {
//            return;
//        }
//
//        KhachHangDao.getInstant().update(kh);
//        MsgBox.alert(this, "Sửa thành công " + " " + kh.getTenKH());
//        clear();
//
////        this.dispose();
//        load();
//
//    }
//
//    void delete() {
//        if (MsgBox.confirm(this, "Ban that su muon xoa nhan vien nay khong?")) {
//           Integer maKh = Integer.valueOf(txtMaSP.getText());
//            try {
//                khDao.delete(maKh);
//                this.load();
//                this.clear();
//                MsgBox.alert(this, "Xoa thanh cong!");
//            } catch (Exception e) {
//                MsgBox.alert(this, "Xoa that bai!");
//            }
//        }
////
////int[] list = tblNhanVien.getSelectedRows();
////
////        if (list.length <= 0) {
////            return;
////        }
////
////        boolean check = MsgBox.confirm(this, "Điều này sẽ làm mất đi " + list.length + " nhân viên của cửa hàng đó >.<");
////
////        if (!check) {
////            tblNhanVien.clearSelection();
////            return;
////        }
////
////        for (int selectedRow : list) {
////            String id = (String) tblNhanVien.getValueAt(selectedRow, 1);
////            if (id.endsWith(Auth.user.getMaNV())) {
////                MsgBox.alert(this, "Không thể xóa tài khoản đang đăng nhập !");
////                return;
////            }
////            NhanVienDao.getInstant().delete(id);
////
////        }
////        load();
////        tblNhanVien.clearSelection();
//    }
//
//    void clear() {
//        this.setModel(new KhachHang());
//        this.setStatus(true);
//        this.index = -1;
//    }
//
//    private boolean validator() {
//        boolean flag = true;
//        String mess = "";
//
//        if (Validator.isEmpty(txtTenSP)) {
//            mess += "Bạn chưa nhập tên cho khách hàng \n";
//            flag = false;
//        } else {
//            if (!Validator.isValidName(txtTenSP.getText())) {
//                mess += "Tên không hợp lệ \n";
//                flag = false;
//            }
//        }
//
//        if (Validator.isEmpty(txtMauSac)) {
//            mess += "Bạn chưa nhập số điện thoại cho khách hàng \n";
//            flag = false;
//        } else {
//            if (!Validator.isTel(txtMauSac.getText())) {
//                mess += "Số điện thoại không hợp lệ \n";
//                flag = false;
//            }
//        }
//        if (Validator.isEmpty(txtKichCo)) {
//            mess += "Bạn chưa nhập email cho khách hàng \n";
//            flag = false;
//        } else {
//            if (!Validator.isEmail(txtKichCo.getText())) {
//                mess += "Email không hợp lệ \n";
//                flag = false;
//            }
//        }
//
//        return flag;
//    }
}
