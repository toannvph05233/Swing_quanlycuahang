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
public class NgheNghiep {
    private String TenNgheNghiep, MaNgheNghiep;
   
    public NgheNghiep(){
        this.MaNgheNghiep = "";
        this.TenNgheNghiep = "";
    }
    
    public NgheNghiep(String ma, String ten){
        this.MaNgheNghiep = ma;
        this.TenNgheNghiep = ten;
    }
    public void SetMaNgheNghiep(String ma){
        this.MaNgheNghiep = ma;
    }
    public String GetMaNgheNghiep(){
        return this.MaNgheNghiep;
    }
    
    public void SetTenNgheNghiep(String ten){
        this.TenNgheNghiep = ten;
    }
    public String GetTenNgheNghiep(){
        return this.TenNgheNghiep;
    }
    @Override
    public String toString(){
        return this.TenNgheNghiep;
    }
    
}
