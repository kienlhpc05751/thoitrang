/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

import java.util.Date;

/**
 *
 * @author Asus
 */
public class HoaDon {

    private String maHD;
    private String maKH;
    private String maNV;
    private Date ngayTao;
    private Double tongTien;

    public HoaDon() {

    }

    public HoaDon(String maHD, String Makh,String maNV, Date ngaytao, Double Tongtien) {
        this.maHD = maHD;
        this.maKH = Makh;
        this.maNV = maNV;
        this.ngayTao = ngaytao;
        this.tongTien = Tongtien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String Makh) {
        this.maKH = Makh;
    }
    
    public String getMaNV(){
        return maNV;
    }
    
    public void setMaNV(String maNV){
        this.maNV = maNV;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngaytao) {
        this.ngayTao = ngaytao;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double Tongtien) {
        this.tongTien = Tongtien;
    }

}
