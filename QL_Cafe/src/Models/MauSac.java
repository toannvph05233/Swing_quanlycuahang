/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author ACER
 */
public class MauSac {
    private String TenMauSac, MaMauSac;
   
    public MauSac(){
        this.MaMauSac = "";
        this.TenMauSac = "";
    }
    
    public MauSac(String ma, String ten){
        this.MaMauSac = ma;
        this.TenMauSac = ten;
    }
    public void SetMaMauSac(String ma){
        this.MaMauSac = ma;
    }
    public String GetMaMauSac(){
        return this.MaMauSac;
    }
    
    public void SetTenMauSac(String ten){
        this.TenMauSac = ten;
    }
    public String GetTenMauSac(){
        return this.TenMauSac;
    }
    @Override
    public String toString(){
        return this.TenMauSac;
    }
}
