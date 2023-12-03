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
public class HangSanXuat {
    private String TenHangSanXuat, MaHangSanXuat;
   
    public HangSanXuat(){
        this.MaHangSanXuat = "";
        this.TenHangSanXuat = "";
    }
    
    public HangSanXuat(String ma, String ten){
        this.MaHangSanXuat = ma;
        this.TenHangSanXuat = ten;
    }
    public void SetMaHangSanXuat(String ma){
        this.MaHangSanXuat = ma;
    }
    public String GetMaHangSanXuat(){
        return this.MaHangSanXuat;
    }
    
    public void SetTenHangSanXuat(String ten){
        this.TenHangSanXuat = ten;
    }
    public String GetTenHangSanXuat(){
        return this.TenHangSanXuat;
    }
    
    @Override
    public String toString(){
        return this.TenHangSanXuat;
    }

}
