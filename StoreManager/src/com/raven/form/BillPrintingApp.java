/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.raven.form;

import com.raven.dao.HoaDonChiTietDao;
import com.raven.dao.HoaDonDao;
import com.raven.model.HoaDonChiTiet;
import com.raven.model.HoaDon;

import com.raven.utils.XDate;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class BillPrintingApp extends javax.swing.JFrame implements Printable {

    private JTextArea billTextArea;
    private JTable billTable;
    private JTable billTable1;
        private JTable billTable2;

    HoaDonChiTietDao daoHDCT = new HoaDonChiTietDao() {
    };
    List<HoaDonChiTiet> listhdct = new ArrayList<>();
    String madh = "HD9";

    public BillPrintingApp() {
        initComponents();
        setTitle("Bill Printing App");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        billTextArea = new JTextArea();
//        billTextArea.setEditable();
        JScrollPane scrollPane = new JScrollPane(billTextArea);
        Object[][] data = {
            {"    ", "SHOP THỜI TRANG LIGHTING STRIKE", "   \n"},
            {"     ", "_____________________________", "    \n"},
            {"     ", "ngày :" + XDate.now(), "    \n"},
            {"     ", "mã đơn hàng: ", madh + " \n"},};
        String[] columnNames = {"Item", "Quantity", "Price"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        billTable = new JTable(model);

        String row[] = {"Mã HDCT", "MaHD", "MaSP", "soluong", "ghi chu", "ma gg", "Thành tiền"};
        DefaultTableModel model1 = new DefaultTableModel(row, 0);
        listhdct = daoHDCT.getAllByID(madh);
        for (HoaDonChiTiet hd : listhdct) {
            model1.addRow(new Object[]{
                hd.getMaHDn(),
                hd.getMaHDCT(),
                hd.getMaBienTheSP(),
                hd.getSoLuong(),
                hd.getGhiChu(),
                hd.getMaGG(),
                hd.getThanhTien()
            });
        }
        
        HoaDonDao daoHD = new HoaDonDao() {
        };
        List<HoaDon> list = new ArrayList<>();
        String row1[] = {"",""};
        DefaultTableModel model2 = new DefaultTableModel(row1,0);
        list =  daoHD.getAllByID(madh);
        for (HoaDon string : list) {
            model2.addRow(new Object[]{
                string.getMaKH(),
//                string.getMaNV(),
                string.getTongTien()
            });
        }
        
        
        
        

        billTable1 = new JTable(model1);
        
        billTable2 = new JTable(model2);
        // Vẽ nội dung bảng billTable1
        int tableHeight = billTable1.getRowHeight() * (billTable1.getRowCount() + 1); // +1 để tạo dòng chia cách
        int tableWidth = billTable1.getColumnModel().getTotalColumnWidth();
        billTable1.setSize(tableWidth, tableHeight);
//        billTable1.print(g2d);

        // nút in
        JButton printButton = new JButton("Print Bill");
        printButton.addActionListener(e -> printBill());

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(printButton, BorderLayout.SOUTH);

    }

    private void printBill() {

        // Lấy dữ liệu từ bảng và định dạng thành chuỗi
        StringBuilder billContent = new StringBuilder();
        for (int row = 0; row < billTable.getRowCount(); row++) {
            for (int col = 0; col < billTable.getColumnCount(); col++) {
                billContent.append(billTable.getValueAt(row, col)).append("\t");
            }
            billContent.append("\n");
        }
        // dct
        StringBuilder billContent1 = new StringBuilder();
        for (int row = 0; row < billTable1.getRowCount(); row++) {
            for (int col = 0; col < billTable1.getColumnCount(); col++) {
                billContent1.append(billTable1.getValueAt(row, col)).append("\t");
            }
            billContent1.append("\n");
        }
        
             StringBuilder billContent2 = new StringBuilder();
        for (int row = 0; row < billTable2.getRowCount(); row++) {
            for (int col = 0; col < billTable2.getColumnCount(); col++) {
                billContent2.append(billTable2.getValueAt(row, col)).append("\t");
            }
            billContent2.append("\n");
        }

        billTextArea.append(billContent.toString());
        billTextArea.append(billContent1.toString());
                billTextArea.append(billContent2.toString());


        // Gán nội dung hóa đơn vào JTextArea
//        billTextArea.setText(billContent.toString() + "\n" + billContent1.toString() + "\n");
//          billTextArea.append(billContent.toString());
//        billTextArea.append(billContent1.toString());
        // In hóa đơn
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(this);

        if (printerJob.printDialog()) {
            try {
                printerJob.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

//                  graphics.drawString(billTextArea.getText(), 70, 70);
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        // Vẽ nội dung hóa đơn từ JTextArea
        g2d.drawString(billTextArea.getText(), 50, 50);

        return PAGE_EXISTS;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(BillPrintingApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillPrintingApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillPrintingApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillPrintingApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillPrintingApp().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
