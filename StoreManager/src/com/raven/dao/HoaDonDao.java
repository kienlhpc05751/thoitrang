package com.raven.dao;

import com.microsoft.sqlserver.jdbc.SQLServerXAResource;
import com.raven.db.DBHelper;
import com.raven.model.HoaDon;
import com.raven.model.Sanpham;
import com.raven.utils.XDate;
//import com.raven.model.Sanpham;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract public class HoaDonDao extends StoreDao<HoaDon, String> {

    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = DBHelper.query(sql, args);
            while (rs.next()) {
                HoaDon enity = new HoaDon();
                enity.setMaHD(rs.getString("maHD"));
                enity.setMaKH(rs.getString("maKH"));
                enity.setMaNV(rs.getString("maNV"));
                enity.setNgayTao(rs.getDate("NgayTao"));
                enity.setTongTien(rs.getDouble("TongTien"));
                list.add(enity);
            }

            rs.getStatement().getConnection().close();
            return list;
//                        System.out.println(List);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
     String INSERT_SQL = "insert into hoadon values(?,?,?,?,?)";
     
     
    String UPDATE_SQL = "UPDATE hoadon SET MaKH=?, MaNV=?,NgayTao=?,TongTien=? WHERE MaHD=?";
    
//    String DELETE_SQL = "DELETE FROM hoadon WHERE MaHD=?";
        String DELETE_SQL = "DECLARE @HoaDonID NVARCHAR(10);\n" +
"SET @HoaDonID = ?;\n" +
"\n" +
"BEGIN TRANSACTION;\n" +
"\n" +
"-- Step 1: Delete records from hoadonchitiet\n" +
"DELETE FROM hoadonchitiet WHERE MaHD = @HoaDonID;\n" +
"\n" +
"-- Step 2: Delete the specific invoice record from hoadon\n" +
"DELETE FROM hoadon WHERE MaHD = @HoaDonID;\n" +
"\n" +
"COMMIT;";

    String SELECT_ALL_SQL = "SELECT * FROM HoaDon";
    String SELECT_BY_ID_SQL = "SELECT * FROM HoaDon WHERE MaHD=?";
    String sql = " select * from san "
            + "where HoTen like ? AND "
            + "MaNH NOT IN (select MaNH from HocVien where MaKH = ?)";
    //
    String sqlNH1 = "select * from NguoiHoc where MaNH not in ( select MaNH from HocVien)";
    String sqlNH = "select * from nguoihoc where maNH not in (select maNH from hocvien where makh = ?)";

    @Override
    public void insert(HoaDon enity) {

        DBHelper.update(INSERT_SQL, enity.getMaHD(), enity.getMaKH(), enity.getMaNV(), enity.getNgayTao(),
                enity.getTongTien());
    }

    @Override
    public void update(HoaDon enity) {
       DBHelper.update(UPDATE_SQL,  enity.getMaKH(), enity.getMaNV(), enity.getNgayTao(),
                enity.getTongTien(),enity.getMaHD());
    }
    @Override
    public void delete(String id) {
        DBHelper.update(DELETE_SQL, id);
    }

    @Override
    public HoaDon selectById(String k) {

        List<HoaDon> list = this.selectBySql(SELECT_BY_ID_SQL, k);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);

    }
    
        @Override
        public List<HoaDon> selectById1(String k) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    
          @Override
        public List<HoaDon> selectAll() {
                    return this.selectBySql(SELECT_ALL_SQL);

//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public HoaDon selectByName(String k) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    
//
//    public List<HoaDon> selectByS(String ma) {
//        List<HoaDon> list = new ArrayList<>();
//        String sql = "SELECT * FROM HoaDon WHERE maHD = ?";
//        Connection con = DBHelper.getDBConnection();
//        try (PreparedStatement stm = con.prepareStatement(sql)) {
//            stm.setString(1, ma);
//            try (ResultSet rs = stm.executeQuery()) {
//                while (rs.next()) {
//                    HoaDon hd = new HoaDon();
//                    hd.setMaHD(rs.getString("maHD"));
//                    hd.setMaKH(rs.getString("maKH"));
//                    hd.setMaNV(rs.getString("maNV"));
//                    hd.setNgayTao(rs.getDate("Ngaytao"));
//                    hd.setTongTien(rs.getDouble("Tongtien"));
//                    list.add(hd);
//                }
//            }
//        } catch (SQLException ex) {
//            System.out.println("Lỗi SQL: " + ex.getMessage());
//            ex.printStackTrace();
//            // Hoặc ghi log lỗi
//        }
//        return list;
//    }

//    public List<HoaDon> getAllSelectHDCT(String maHD) {
//        List<HoaDon> list = new ArrayList<>();
//        Connection con = DBHelper.getDBConnection();
//        String sql = "select * from ChiTietHoaDon a join HoaDon b on a.MAHD = b.MAHD where a.maHD = ?";
//        try (PreparedStatement psm = con.prepareStatement(sql)) {
//            psm.setString(1, maHD);
//            try (ResultSet rs = psm.executeQuery()) {
//                while (rs.next()) {
//                    HoaDon hd = new HoaDon();
//                    hd.setMaHD(rs.getString("maHD"));
//                    hd.setMaKH(rs.getString("maKH"));
//                    hd.setMaNV(rs.getString("maNV"));
//                    hd.setMaSP(rs.getString("MaSP"));
//                    hd.setMaMau(rs.getInt("MaMau"));
//                    hd.setMaSize(rs.getInt("MaSize"));
//                    hd.setNgayNhap(rs.getString("NgayNhap"));
//                    hd.setTongSoLuong(rs.getInt("TongSoLuong"));
//                    hd.setTongtien(rs.getFloat("tongTien"));
//                    hd.setHinhThucTT(rs.getString("HINHTHUCTT"));
//                    hd.setTrangThaiTT(rs.getBoolean("TRANGTHAITT"));
//                    hd.setSoLuong(rs.getInt("SoLuong"));
//                    hd.setGiamGia(rs.getFloat("GiamGia"));
//                    list.add(hd);
//                }
//            } catch (Exception e) {
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            Logger.getLogger(HoaDonDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }
//
//    public void insertHD(HoaDon hd) {
//        String sql = "insert into hoadon values(?,?,?,?,?,?,?,?)";
//        Connection con = DBHelper.getDBConnection();
//        try {
//            PreparedStatement stm = con.prepareStatement(sql);
//            stm.setString(1, hd.getMaHD());
//            stm.setString(2, hd.getMaKH());
//            stm.setString(3, XDate.toString(hd.getNgayTao(), "dd-MM-yyyy"));
//            stm.setString(4, hd.getMaNV());
//            stm.setString(5,   String.valueOf( hd.getTongTien()));
//            stm.execute();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void updateHD(HoaDon hd) {
//        String sql = "update HoaDon set maKH =?,ngayNhap =?,MaNV=?,tongsoluong=?,tongtien =?, hinhThucTT =?,TrangThaiTT =? where maHD =?";
//        Connection con = DBHelper.getDBConnection();
//        try {
//            PreparedStatement stm = con.prepareStatement(sql);
//            stm.setString(8, hd.getMaHD());
//            stm.setString(1, hd.getMaKH());
//            stm.setString(2, XDate.toString( hd.getNgayTao(),"dd-MM-yyyy"));
//            stm.setString(3, hd.getMaNV());
//            stm.setString(5,String.valueOf(hd.getTongTien()));
////            stm.setFloat(4, hd.getTongtien());
////            stm.setString(6, hd.getHinhThucTT());
////            stm.setBoolean(7, hd.isTrangThaiTT());
//            stm.execute();
//        } catch (Exception e) {
////            e.printStackTrace();
//        }
//    }
//
//    public void deleteHD() {
//
//    }

//    public void insetHDCYT(HoaDon hd) {
//        String sql = "INSERT INTO CHITIETHOADON VALUES(?,?,?,?,?,?,?)";
//        Connection con = DBHelper.getDBConnection();
//        try {
//            PreparedStatement pstm = con.prepareStatement(sql);
//            pstm.setString(1, hd.getMa());
//            pstm.setString(2, hd.getMaHD());
//            pstm.setInt(3, hd.getSoLuong());
//            pstm.setFloat(4, hd.getGia());
//            pstm.setFloat(5, hd.getGiamGia());
//            pstm.setInt(6, hd.getMaMau());
//            pstm.setInt(7, hd.getMaSize());
//            pstm.execute();
//        } catch (SQLException ex) {
//            Logger.getLogger(HoaDonDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
}
