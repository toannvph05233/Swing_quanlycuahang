/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author LONG
 */
public class SanPham {
    private String MaSanPham, TenSanPham, MaHangSanXuat, MaMauSac, MaKieuDang, MaTinhNang, MaKhoangGia, DVT;
    private int DonGia;
    
    public SanPham(){
        this.MaSanPham="";
        this.TenSanPham="";
        this.MaHangSanXuat="";
        this.MaMauSac="";
        this.MaKieuDang="";
        this.MaTinhNang="";
        this.MaKhoangGia="";
        this.DVT="";
        this.DonGia=0;
    }
    public SanPham(String masp, String tensp, String mahangsanxuat, String mamausac, String makieudang, String matinhnang, String makhoanggia, int gia, String dvt){
        this.MaSanPham=masp;
        this.TenSanPham=tensp;
        this.MaHangSanXuat=mahangsanxuat;
        this.MaMauSac=mamausac;
        this.MaKieuDang=makieudang;
        this.MaTinhNang=matinhnang;
        this.MaKhoangGia=makhoanggia;
        this.DVT=dvt;
        this.DonGia=gia;       
    }
    
    public void SetMaSanPham(String masp){
        this.MaSanPham=masp;
    }
    public String GetMaSanPham(){
        return this.MaSanPham;
    }
    public void SetTenSanPham(String tensp){
        this.TenSanPham=tensp;
    }
    public String GetTenSanPham(){
        return this.TenSanPham;
    }
    
    public void SetMaHangSanXuat(String mahangsanxuat){
        this.MaHangSanXuat=mahangsanxuat;
    }
    public String GetMaHangSanXuat(){
        return this.MaHangSanXuat;
    }
    
    public void SetMaMauSac(String mamausac){
        this.MaMauSac=mamausac;
    }
    public String GetMaMauSac(){
        return this.MaMauSac;
    }
    
    public void SetMaKieuDang(String makieudang){
        this.MaKieuDang=makieudang;
    }
    public String GetMaKieuDang(){
        return this.MaKieuDang;
    }
    
    public void SetMaTinhNang(String mahangsanxuat){
        this.MaTinhNang=mahangsanxuat;
    }
    public String GetMaTinhNang(){
        return this.MaTinhNang;
    }
    
    public void SetMaKhoangGia(String mahangsanxuat){
        this.MaKhoangGia=mahangsanxuat;
    }
    public String GetMaKhoangGia(){
        return this.MaKhoangGia;
    }
    
    public void SetDonGia(int gia){
        this.DonGia=gia;
    }
    public int GetDonGia(){
        return this.DonGia;
    }
    public void SetDVT(String dvt){
        this.DVT=dvt;
    }
    public String GetDVT(){
        return this.DVT;
    }
    
    
}
