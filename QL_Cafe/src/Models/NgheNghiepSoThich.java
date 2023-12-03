/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author johntoan98gmail.com
 */
public class NgheNghiepSoThich {
    int id,id_nghenghiep,id_sothich;

    public NgheNghiepSoThich() {
    }

    public NgheNghiepSoThich(int id, int id_nghenghiep, int id_sothich) {
        this.id = id;
        this.id_nghenghiep = id_nghenghiep;
        this.id_sothich = id_sothich;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_nghenghiep() {
        return id_nghenghiep;
    }

    public void setId_nghenghiep(int id_nghenghiep) {
        this.id_nghenghiep = id_nghenghiep;
    }

    public int getId_sothich() {
        return id_sothich;
    }

    public void setId_sothich(int id_sothich) {
        this.id_sothich = id_sothich;
    }
    
    
}
