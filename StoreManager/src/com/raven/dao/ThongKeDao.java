package com.raven.dao;

import java.util.ArrayList;
import java.util.List;
import com.raven.db.DBHelper;
import java.sql.*;

public class ThongKeDao {

    public List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = DBHelper.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    
    public List<Object[]> daban(){
           String sql = "SELECT SUM(hct.SoLuong) AS SoLuongDaBan, SUM(hct.thanhTien) as tong FROM hoadonchitiet hct";
           String[] cols ={"SoLuongDaBan","tong"};
           return  this.getListOfArray(sql, cols);
    }

    public List<Object[]> gettopsp(Integer top) {
        String sql = "EXEC TopSellingProducts @TopN = ?;";
        String[] cols = {"bienthesp","tenSP", "TotalQuantitySold"};
        return this.getListOfArray(sql, cols, top);
    }

    public List<Object[]> getBangDiem(Integer makh) {
        String sql = "{CALL sp_BangDiem(?)}";
        String[] cols = {"MaNH", "HoTen", "Diem"};
        return this.getListOfArray(sql, cols, makh);
    }

    public List<Object[]> getBangDiemChuyenDe() {
        String sql = "{CALL sp_ThongKeDiem}";
        String[] cols = {"ChuyenDe", "SoHV", "ThapNhat", "CaoNhat", "TrungBinh"};
        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getLuongNguoiHoc() {
        String sql = "{CALL sp_ThongKeNguoiHoc}";
        String[] cols = {"Nam", "SoLuong", "DauTien", "CuoiCung"};
        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getDoanhThu(Integer nam) {
        String sql = "{CALL  sp_ThongKeDoanhThu(?)}";
        String[] cols = {"ChuyenDe", "SoKH", "SoHV", "DoanhThu", "ThapNhat", "CaoNhat", "TrungBinh"};
        return this.getListOfArray(sql, cols, nam);
    }

    public List<Integer> selectYears() {
        String sql = "Select DISTINCT year(NgayKG) from KhoaHoc ORDER BY year DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = DBHelper.query(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}