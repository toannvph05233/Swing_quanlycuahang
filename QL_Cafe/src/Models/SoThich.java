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
public class SoThich {
    private String TenSoThich, MaSoThich;
   
    public SoThich(){
        this.MaSoThich = "";
        this.TenSoThich = "";
    }
    
    public SoThich(String ma, String ten){
        this.MaSoThich = ma;
        this.TenSoThich = ten;
    }
    public void SetMaSoThich(String ma){
        this.MaSoThich = ma;
    }
    public String GetMaSoThich(){
        return this.MaSoThich;
    }
    
    public void SetTenSoThich(String ten){
        this.TenSoThich = ten;
    }
    public String GetTenSoThich(){
        return this.TenSoThich;
    }
    @Override
    public String toString(){
        return this.TenSoThich;
    }
    
}
