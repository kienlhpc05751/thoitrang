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
    String DELETE_SQL = "DECLARE @HoaDonID NVARCHAR(10);\n"
            + "SET @HoaDonID = ?;\n"
            + "\n"
            + "BEGIN TRANSACTION;\n"
            + "\n"
            + "DELETE FROM hoadonchitiet WHERE MaHD = @HoaDonID;\n"
            + "\n"
            + "DELETE FROM hoadon WHERE MaHD = @HoaDonID; COMMIT;";

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
        DBHelper.update(UPDATE_SQL, enity.getMaKH(), enity.getMaNV(), enity.getNgayTao(),
                enity.getTongTien(), enity.getMaHD());
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

}
