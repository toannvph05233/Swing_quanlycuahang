/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Long
 */
public class KhoangGia {
    private String TenKhoangGia, MaKhoangGia;
   
    public KhoangGia(){
        this.MaKhoangGia = "";
        this.TenKhoangGia = "";
    }
    
    public KhoangGia(String ma, String ten){
        this.MaKhoangGia = ma;
        this.TenKhoangGia = ten;
    }
    public void SetMaKhoangGia(String ma){
        this.MaKhoangGia = ma;
    }
    public String GetMaKhoangGia(){
        return this.MaKhoangGia;
    }
    
    public void SetTenKhoangGia(String ten){
        this.TenKhoangGia = ten;
    }
    public String GetTenKhoangGia(){
        return this.TenKhoangGia;
    }
    @Override
    public String toString(){
        return this.TenKhoangGia;
    }
    
}
