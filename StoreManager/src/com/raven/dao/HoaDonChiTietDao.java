/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.dao;

import com.raven.db.DBHelper;
import com.raven.model.HoaDonChiTiet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
abstract public class HoaDonChiTietDao extends StoreDao<HoaDonChiTiet, String>{
  
     @Override
    protected List<HoaDonChiTiet> selectBySql(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = DBHelper.query(sql, args);
            while (rs.next()) {
                HoaDonChiTiet enity = new HoaDonChiTiet();
                enity.setMaHDCT(rs.getString("maHD"));
                enity.setMaHDn(rs.getString("maKH"));
                enity.setMaBienTheSP(rs.getString("maNV"));
                enity.setMaGG(rs.getString(4));
                enity.setSoLuong(rs.getInt(5));
                enity.setThanhTien(rs.getDouble(6));
                list.add(enity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
     String INSERT_SQL = "INSERT INTO sanpham(BienTheSP,Maloai,TenSP,KichCo,MauSac,GiaBan,SoLuong)Values(?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE sanpham SET MaLoai=?, TenSP=?,KichCo=?,MauSac=?,GiaBan=?,SoLuong=? WHERE BienTheSP=?";
    String DELETE_SQL = "DELETE FROM sanpham WHERE BienTheSP=?";
    String SELECT_ALL_SQL = "SELECT * FROM sanpham";
    String SELECT_BY_ID_SQL = "SELECT * FROM sanpham WHERE BienTheSP=?";
    String sql = " select * from san "
            + "where HoTen like ? AND "
            + "MaNH NOT IN (select MaNH from HocVien where MaKH = ?)";
    //
    String sqlNH1 = "select * from NguoiHoc where MaNH not in ( select MaNH from HocVien)";
    String sqlNH = "select * from nguoihoc where maNH not in (select maNH from hocvien where makh = ?)";

    @Override
    public void insert(HoaDonChiTiet enity) {

        DBHelper.update(INSERT_SQL, enity.getMaHDCT(), enity.getMaHDn(), enity.getMaBienTheSP(), enity.getMaGG(),
                enity.getGhiChu(),enity.getSoLuong(),enity.getThanhTien());
    }

    @Override
    public void update(HoaDonChiTiet enity) {
      DBHelper.update(UPDATE_SQL, enity.getMaHDCT(), enity.getMaHDn(), enity.getMaBienTheSP(), enity.getMaGG(),
                enity.getGhiChu(),enity.getSoLuong(),enity.getThanhTien());
    }
    @Override
    public void delete(String id) {
        DBHelper.update(DELETE_SQL, id);
    }

    @Override
    public HoaDonChiTiet selectById(String k) {

        List<HoaDonChiTiet> list = this.selectBySql(SELECT_BY_ID_SQL, k);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);

    }

    
    
}
