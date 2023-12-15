package com.raven.form;

import com.raven.dao.ThongKeDao;
import com.raven.model.Model_Card;
import com.raven.model.StatusType;
import com.raven.swing.ScrollBar;
import com.raven.utils.XDate;
import java.awt.Color;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Form_Home extends javax.swing.JPanel {

    public Form_Home() {
        initComponents();
        ThongKeDao dao = new ThongKeDao();
        // đã bán
        Date ngay;
        String soLuong = "";
        String tongtienString = "";
//        List<Object[]> list = dao.daban();
//        for (Object[] db : list) {
//            // Giả sử vị trí 0 là soLuong và vị trí 1 là tongtienString
//            soLuong = String.valueOf(db[0]);
//            tongtienString = String.valueOf(db[1]);
//        }
        Date n = XDate.now();
        String nn = XDate.toString(n, "dd-MM-yyyy");
        List<Object[]> list1 = dao.theoNgay();
        for (Object[] db : list1) {

            soLuong = String.valueOf(db[1]);
            tongtienString = String.valueOf(db[2]);
            card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "ngày " + nn, tongtienString + " VN", "Số lượng SP " + soLuong + " d/c"));
        }

        List<Object[]> list2 = dao.theoThang();
        for (Object[] db : list2) {
            soLuong = String.valueOf(db[1]);
            tongtienString = String.valueOf(db[2]);
            card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "ngày " + nn, tongtienString + " VN", "Số lượng SP " + soLuong + " d/c"));

        }

        List<Object[]> list3 = dao.theoNam();
        for (Object[] db : list3) {
            soLuong = String.valueOf(db[1]);
            tongtienString = String.valueOf(db[2]);
            card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "ngày " + nn, tongtienString + " VN", "Số lượng SP " + soLuong + " d/c"));

        }

        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
//            bản lịch sử        
        String row[] = {"Mã HD", " Ngay Mua", "Tên KH", "Ten SP", "Số lượng", " Thành tiền"};
        DefaultTableModel model1 = new DefaultTableModel(row, 0);
        model1.setRowCount(0);
        List<Object[]> listLichsu = dao.lichsu();
        for (Object[] objects : listLichsu) {
            model1.addRow(objects);
        }
        tblLichSu.setModel(model1);
        //
            String row1[] = {"Tên loại", " số lượng "};
        DefaultTableModel model2 = new DefaultTableModel(row1, 0);
        model1.setRowCount(0);
        List<Object[]> listkho = dao.Tonkho();
        for (Object[] objects : listkho) {
            model1.addRow(objects);
        }
        tblKho.setModel(model1);

//        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/profit.png")), "Total Profit", "$15000", "Increased by 25%"));
//        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/flag.png")), "Unique Visitors", "$300000", "Increased by 70%"));
        // table
//        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
//        table.addRow(new Object[]{"kkkkkkk", "mikebhand@gmail.com", "Admin", "25 Apr,2018", StatusType.PENDING});
//        table.addRow(new Object[]{"Andrew Strauss", "andrewstrauss@gmail.com", "Editor", "25 Apr,2018", StatusType.APPROVED});
//        table.addRow(new Object[]{"Ross Kopelman", "rosskopelman@gmail.com", "Subscriber", "25 Apr,2018", StatusType.APPROVED});
//        table.addRow(new Object[]{"Mike Hussy", "mikehussy@gmail.com", "Admin", "25 Apr,2018", StatusType.REJECT});
//        table.addRow(new Object[]{"Kevin Pietersen", "kevinpietersen@gmail.com", "Admin", "25 Apr,2018", StatusType.PENDING});
//        table.addRow(new Object[]{"Andrew Strauss", "andrewstrauss@gmail.com", "Editor", "25 Apr,2018", StatusType.APPROVED});
//        table.addRow(new Object[]{"Ross Kopelman", "rosskopelman@gmail.com", "Subscriber", "25 Apr,2018", StatusType.APPROVED});
//        table.addRow(new Object[]{"Mike Hussy", "mikehussy@gmail.com", "Admin", "25 Apr,2018", StatusType.REJECT});
//        table.addRow(new Object[]{"Kevin Pietersen", "kevinpietersen@gmail.com", "Admin", "25 Apr,2018", StatusType.PENDING});
//        table.addRow(new Object[]{"Kevin Pietersen", "kevinpietersen@gmail.com", "Admin", "25 Apr,2018", StatusType.PENDING});
//        table.addRow(new Object[]{"Andrew Strauss", "andrewstrauss@gmail.com", "Editor", "25 Apr,2018", StatusType.APPROVED});
//        table.addRow(new Object[]{"Ross Kopelman", "rosskopelman@gmail.com", "Subscriber", "25 Apr,2018", StatusType.APPROVED});
//        table.addRow(new Object[]{"Mike Hussy", "mikehussy@gmail.com", "Admin", "25 Apr,2018", StatusType.REJECT});
//        table.addRow(new Object[]{"Kevin Pietersen", "kevinpietersen@gmail.com", "Admin", "25 Apr,2018", StatusType.PENDING});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card1 = new com.raven.component.Card();
        card2 = new com.raven.component.Card();
        card3 = new com.raven.component.Card();
        panelBorder1 = new com.raven.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLichSu = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKho = new javax.swing.JTable();

        setBackground(new java.awt.Color(250, 234, 221));

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(142, 142, 250));
        card1.setColor2(new java.awt.Color(123, 123, 245));
        panel.add(card1);

        card2.setColor1(new java.awt.Color(186, 123, 247));
        card2.setColor2(new java.awt.Color(167, 94, 236));
        panel.add(card2);

        card3.setColor1(new java.awt.Color(241, 208, 62));
        card3.setColor2(new java.awt.Color(211, 184, 61));
        panel.add(card3);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Lịch Sử mua hàng");

        tblLichSu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblLichSu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblLichSu);

        tblKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblKho);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)))
                .addGap(36, 36, 36))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("Lịch sử mau hàng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Card card1;
    private com.raven.component.Card card2;
    private com.raven.component.Card card3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLayeredPane panel;
    private com.raven.swing.PanelBorder panelBorder1;
    private javax.swing.JTable tblKho;
    private javax.swing.JTable tblLichSu;
    // End of variables declaration//GEN-END:variables
}
