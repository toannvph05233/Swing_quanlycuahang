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
public class KieuDang {
    private String TenKieuDang, MaKieuDang;
   
    public KieuDang(){
        this.MaKieuDang = "";
        this.TenKieuDang = "";
    }
    
    public KieuDang(String ma, String ten){
        this.MaKieuDang = ma;
        this.TenKieuDang = ten;
    }
    public void SetMaKieuDang(String ma){
        this.MaKieuDang = ma;
    }
    public String GetMaKieuDang(){
        return this.MaKieuDang;
    }
    
    public void SetTenKieuDang(String ten){
        this.TenKieuDang = ten;
    }
    public String GetTenKieuDang(){
        return this.TenKieuDang;
    }
    @Override
    public String toString(){
        return this.TenKieuDang;
    }
    
}
