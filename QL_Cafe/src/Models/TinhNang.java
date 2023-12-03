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
public class TinhNang {
    private String TenTinhNang, MaTinhNang;
   
    public TinhNang(){
        this.MaTinhNang = "";
        this.TenTinhNang = "";
    }
    
    public TinhNang(String ma, String ten){
        this.MaTinhNang = ma;
        this.TenTinhNang = ten;
    }
    public void SetMaTinhNang(String ma){
        this.MaTinhNang = ma;
    }
    public String GetMaTinhNang(){
        return this.MaTinhNang;
    }
    
    public void SetTenTinhNang(String ten){
        this.TenTinhNang = ten;
    }
    public String GetTenTinhNang(){
        return this.TenTinhNang;
    }
    @Override
    public String toString(){
        return this.TenTinhNang;
    }
    
}
