package Mysql;

import Models.Ban;
import Models.ChiTietHD;
import Models.DsOrder;
import Models.HoaDon;
import Models.HangSanXuat;
import Models.MauSac;
import Models.TinhNang;
import Models.KieuDang;
import Models.KhoangGia;
import Models.NgheNghiep;
import Models.SoThich;
import Models.TaiKhoan;
import Models.SanPham;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author long
 */
public class ConnectSQL {
    private Connection cn;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
    public ConnectSQL(){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlcafe?useUnicode=true&characterEncoding=utf8", "root", "12345678");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Kết nối thất bại !");
        }        
    }
    
// Hãng Sản Xuất
    // Xuất thông tin hãng
    public ArrayList<HangSanXuat> GetHangSanXuat(){
        ArrayList<HangSanXuat> arrhangsanxuat = null;
        String sql = "Select * From hangsanxuat";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrhangsanxuat = new ArrayList<HangSanXuat>();
            while(rs.next()){
                HangSanXuat hangsanxuat = new HangSanXuat(rs.getString(1), rs.getString(2));
                arrhangsanxuat.add(hangsanxuat);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrhangsanxuat; 
    }
    
    
    public String GetMaHangSanXuat(String TenHangSanXuat){
        String mahangsanxuat = null;
        String sql = "Select MaHangSanXuat From hangsanxuat Where TenHangSanXuat = '"+TenHangSanXuat+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                mahangsanxuat = rs.getString(1);
            }
 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được mã hãng sản xuất !");
        }
        return mahangsanxuat; 
    }
    
    public Vector GetNhomHangSanXuat(){
        Vector arrhsx = null;
        String sql = "Select * From hangsanxuat";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrhsx = new Vector();
            HangSanXuat all = new HangSanXuat(null, "Tất cả các hãng");
            arrhsx.add(all);            
            while(rs.next()){
                HangSanXuat sp = new HangSanXuat(rs.getString(1), rs.getString(2));
                arrhsx.add(sp);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrhsx; 
    }
    // Nhận thông tin hãng
    public int InsertHangSanXuat(HangSanXuat b){
        int insert = 0;
        String sql = "Insert into hangsanxuat (TenHangSanXuat) values ('"+b.GetTenHangSanXuat()+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
        }
        return insert;
    }  
    // Xoá thông tin hãng
    public boolean DeleteHangSanXuat(ArrayList<String> lismahangsanxuat){
        boolean check = false;
        try{
            String sql;
            for(String ma : lismahangsanxuat){
                sql = "Delete From hangsanxuat Where MaHangSanXuat = '"+ma+"'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            } 
            check = true;
        }catch(SQLException ex){
            
        }
        return check;
    } 
    
    public HangSanXuat GetHangSanXuatByMa(String mahangsanxuat){
        HangSanXuat hangsanxuat = null;
        String sql = "Select * From hangsanxuat Where MaHangSanXuat = '"+mahangsanxuat+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                hangsanxuat = new HangSanXuat(rs.getString(1), rs.getString(2));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return hangsanxuat; 
    } 
    // Cập nhật thông tin hãng
   public int UpdateHangSanXuat(HangSanXuat b){
        int update = 0;
        String sql = "UPDATE hangsanxuat SET TenHangSanXuat = '"+b.GetTenHangSanXuat()+"' WHERE MaHangSanXuat = '"+b.GetMaHangSanXuat()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update hãng không thành công !");
        }
        return update;
    }
   // Tìm thông tin hãng
   public ArrayList<HangSanXuat> SearchHangSanXuat(String tenhangsanxuat){
        ArrayList<HangSanXuat> arrtd = null;
        String sql;
            sql = "SELECT * FROM hangsanxuat WHERE TenHangSanXuat LIKE '"+tenhangsanxuat+"%'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<HangSanXuat>();
            while(rs.next()){
                HangSanXuat td = new HangSanXuat(rs.getString(1), rs.getString(2));
                arrtd.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    }
   
   
//Màu Sắc
   // Xuất thông tin màu
    public ArrayList<MauSac> GetMauSac(){
        ArrayList<MauSac> arrmausac = null;
        String sql = "Select * From mausac";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrmausac = new ArrayList<MauSac>();
            while(rs.next()){
                MauSac mausac = new MauSac(rs.getString(1), rs.getString(2));
                arrmausac.add(mausac);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrmausac; 
    }
    
    
    public String GetMaMauSac(String TenMauSac){
        String mamausac = null;
        String sql = "Select MaMauSac From mausac Where TenMauSac = '"+TenMauSac+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                mamausac = rs.getString(1);
            }
 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được mã hãng sản xuất !");
        }
        return mamausac; 
    }
    
    public Vector GetNhomMauSac(){
        Vector arrms = null;
        String sql = "Select * From mausac";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrms = new Vector();
            MauSac all = new MauSac(null, "Tất cả các màu");
            arrms.add(all);            
            while(rs.next()){
                MauSac ms = new MauSac(rs.getString(1), rs.getString(2));
                arrms.add(ms);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrms; 
    }
    // Nhận thông tin hãng
    public int InsertMauSac(MauSac c){
        int insert = 0;
        String sql = "Insert into mausac (TenMauSac) values ('"+c.GetTenMauSac()+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
        }
        return insert;
    }  
    // Xoá thông tin hãng
    public boolean DeleteMauSac(ArrayList<String> lismamausac){
        boolean check = false;
        try{
            String sql;
            for(String ma : lismamausac){
                sql = "Delete From mausac Where MaMauSac = '"+ma+"'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            } 
            check = true;
        }catch(SQLException ex){
            
        }
        return check;
    } 
    
    public MauSac GetMauSacByMa(String mamausac){
        MauSac mausac = null;
        String sql = "Select * From mausac Where MaMauSac = '"+mamausac+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                mausac = new MauSac(rs.getString(1), rs.getString(2));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return mausac; 
    } 
    // Cập nhật thông tin màu
   public int UpdateMauSac(MauSac b){
        int update = 0;
        String sql = "UPDATE mausac SET TenMauSac = '"+b.GetTenMauSac()+"' WHERE MaMauSac = '"+b.GetMaMauSac()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update hãng không thành công !");
        }
        return update;
    }
   // Tìm thông tin màu
   public ArrayList<MauSac> SearchMauSac(String tenmausac){
        ArrayList<MauSac> arrtd = null;
        String sql;
            sql = "SELECT * FROM mausac WHERE TenMauSac LIKE '"+tenmausac+"%'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<MauSac>();
            while(rs.next()){
                MauSac td = new MauSac(rs.getString(1), rs.getString(2));
                arrtd.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    }
   
//Kiểu dáng
   //thông tin kiểu dáng
    public ArrayList<KieuDang> GetKieuDang(){
        ArrayList<KieuDang> arrkieudang = null;
        String sql = "Select * From kieudang";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrkieudang = new ArrayList<KieuDang>();
            while(rs.next()){
                KieuDang kieudang = new KieuDang(rs.getString(1), rs.getString(2));
                arrkieudang.add(kieudang);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrkieudang; 
    }
    
    
    public String GetMaKieuDang(String TenKieuDang){
        String makieudang = null;
        String sql = "Select MaKieuDang From kieudang Where TenKieuDang = '"+TenKieuDang+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                makieudang = rs.getString(1);
            }
 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được mã kiểu dáng !");
        }
        return makieudang; 
    }
    
    public Vector GetNhomKieuDang(){
        Vector arrkd = null;
        String sql = "Select * From kieudang";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrkd = new Vector();
            KieuDang all = new KieuDang(null, "Tất cả kiểu dáng");
            arrkd.add(all);            
            while(rs.next()){
                KieuDang ms = new KieuDang(rs.getString(1), rs.getString(2));
                arrkd.add(ms);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrkd; 
    }
    // Nhận thông tin hãng
    public int InsertKieuDang(KieuDang c){
        int insert = 0;
        String sql = "Insert into kieudang (TenKieuDang) values ('"+c.GetTenKieuDang()+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
        }
        return insert;
    }  
    // Xoá thông tin hãng
    public boolean DeleteKieuDang(ArrayList<String> lismakieudang){
        boolean check = false;
        try{
            String sql;
            for(String ma : lismakieudang){
                sql = "Delete From kieudang Where MaKieuDang = '"+ma+"'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            } 
            check = true;
        }catch(SQLException ex){
            
        }
        return check;
    } 
    
    public KieuDang GetKieuDangByMa(String makieudang){
        KieuDang kieudang = null;
        String sql = "Select * From kieudang Where MaKieuDang = '"+makieudang+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                kieudang = new KieuDang(rs.getString(1), rs.getString(2));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return kieudang; 
    } 
    // Cập nhật thông tin hãng
   public int UpdateKieuDang(KieuDang b){
        int update = 0;
        String sql = "UPDATE kieudang SET TenKieuDang = '"+b.GetTenKieuDang()+"' WHERE MaKieuDang = '"+b.GetMaKieuDang()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update kiểu dáng không thành công !");
        }
        return update;
    }
   // Tìm thông tin kiểu dáng
   public ArrayList<KieuDang> SearchKieuDang(String tenkieudang){
        ArrayList<KieuDang> arrtd = null;
        String sql;
            sql = "SELECT * FROM kieudang WHERE TenKieuDang LIKE '"+tenkieudang+"%'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<KieuDang>();
            while(rs.next()){
                KieuDang td = new KieuDang(rs.getString(1), rs.getString(2));
                arrtd.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    }
   
//Tính năng
   //thông tin tính nang
    public ArrayList<TinhNang> GetTinhNang(){
        ArrayList<TinhNang> arrtinhnang = null;
        String sql = "Select * From tinhnang";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtinhnang = new ArrayList<TinhNang>();
            while(rs.next()){
                TinhNang tinhnang = new TinhNang(rs.getString(1), rs.getString(2));
                arrtinhnang.add(tinhnang);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrtinhnang; 
    }
    
    
    public String GetMaTinhNang(String TenTinhNang){
        String matinhnang = null;
        String sql = "Select MaTinhNang From tinhnang Where TenTinhNang = '"+TenTinhNang+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                matinhnang = rs.getString(1);
            }
 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được mã tính năng !");
        }
        return matinhnang; 
    }
    
    public Vector GetNhomTinhNang(){
        Vector arrtn = null;
        String sql = "Select * From tinhnang";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtn = new Vector();
            TinhNang all = new TinhNang(null, "Tất cả tính năng");
            arrtn.add(all);            
            while(rs.next()){
                TinhNang ms = new TinhNang(rs.getString(1), rs.getString(2));
                arrtn.add(ms);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrtn; 
    }
    // Nhận thông tin hãng
    public int InsertTinhNang(TinhNang c){
        int insert = 0;
        String sql = "Insert into tinhnang (TenTinhNang) values ('"+c.GetTenTinhNang()+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
        }
        return insert;
    }  
    // Xoá thông tin hãng
    public boolean DeleteTinhNang(ArrayList<String> lismatinhnang){
        boolean check = false;
        try{
            String sql;
            for(String ma : lismatinhnang){
                sql = "Delete From tinhnang Where MaTinhNang = '"+ma+"'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            } 
            check = true;
        }catch(SQLException ex){
            
        }
        return check;
    } 
    
    public TinhNang GetTinhNangByMa(String matinhnang){
        TinhNang tinhnang = null;
        String sql = "Select * From tinhnang Where MaTinhNang = '"+matinhnang+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                tinhnang = new TinhNang(rs.getString(1), rs.getString(2));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return tinhnang; 
    } 
    // Cập nhật thông tin hãng
   public int UpdateTinhNang(TinhNang b){
        int update = 0;
        String sql = "UPDATE tinhnang SET TenTinhNang = '"+b.GetTenTinhNang()+"' WHERE MaTinhNang = '"+b.GetMaTinhNang()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update tính năng không thành công !");
        }
        return update;
    }
   // Tìm thông tin kiểu dáng
   public ArrayList<TinhNang> SearchTinhNang(String tentinhnang){
        ArrayList<TinhNang> arrtd = null;
        String sql;
            sql = "SELECT * FROM tinhnang WHERE TenTinhNang LIKE '"+tentinhnang+"%'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<TinhNang>();
            while(rs.next()){
                TinhNang td = new TinhNang(rs.getString(1), rs.getString(2));
                arrtd.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    }
   
//Khoảng giá
   //thông tin khoảng giá
    public ArrayList<KhoangGia> GetKhoangGia(){
        ArrayList<KhoangGia> arrkhoanggia = null;
        String sql = "Select * From khoanggia";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrkhoanggia = new ArrayList<KhoangGia>();
            while(rs.next()){
                KhoangGia khoanggia = new KhoangGia(rs.getString(1), rs.getString(2));
                arrkhoanggia.add(khoanggia);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrkhoanggia; 
    }
    
    
    public String GetMaKhoangGia(String TenKhoangGia){
        String makhoanggia = null;
        String sql = "Select MaKhoangGia From khoanggia Where TenKhoangGia = '"+TenKhoangGia+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                makhoanggia = rs.getString(1);
            }
 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được mã khoảng giá !");
        }
        return makhoanggia; 
    }
    
    public Vector GetNhomKhoangGia(){
        Vector arrkg = null;
        String sql = "Select * From khoanggia";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrkg = new Vector();
            KhoangGia all = new KhoangGia(null, "Tất cả khoảng giá");
            arrkg.add(all);            
            while(rs.next()){
                KhoangGia ms = new KhoangGia(rs.getString(1), rs.getString(2));
                arrkg.add(ms);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrkg; 
    }
    // Nhận thông tin hãng
    public int InsertKhoangGia(KhoangGia c){
        int insert = 0;
        String sql = "Insert into khoanggia (TenKhoangGia) values ('"+c.GetTenKhoangGia()+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
        }
        return insert;
    }  
    // Xoá thông tin hãng
    public boolean DeleteKhoangGia(ArrayList<String> lismakhoanggia){
        boolean check = false;
        try{
            String sql;
            for(String ma : lismakhoanggia){
                sql = "Delete From khoanggia Where MaKhoangGia = '"+ma+"'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            } 
            check = true;
        }catch(SQLException ex){
            
        }
        return check;
    } 
    
    public KhoangGia GetKhoangGiaByMa(String makhoanggia){
        KhoangGia khoanggia = null;
        String sql = "Select * From khoanggia Where MaKhoangGia = '"+makhoanggia+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                khoanggia = new KhoangGia(rs.getString(1), rs.getString(2));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return khoanggia; 
    } 
    // Cập nhật thông tin hãng
   public int UpdateKhoangGia(KhoangGia b){
        int update = 0;
        String sql = "UPDATE khoanggia SET TenKhoangGia = '"+b.GetTenKhoangGia()+"' WHERE MaKhoangGia = '"+b.GetMaKhoangGia()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update khoảng giá không thành công !");
        }
        return update;
    }
   // Tìm thông tin kiểu dáng
   public ArrayList<KhoangGia> SearchKhoangGia(String tenkhoanggia){
        ArrayList<KhoangGia> arrtd = null;
        String sql;
            sql = "SELECT * FROM khoanggia WHERE TenKhoangGia LIKE '"+tenkhoanggia+"%'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<KhoangGia>();
            while(rs.next()){
                KhoangGia td = new KhoangGia(rs.getString(1), rs.getString(2));
                arrtd.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    }
    
//Nghề nghiệp
   //nhan thong tin tu table nghe nghiep
    public ArrayList<NgheNghiep> GetNgheNghiep(){
        ArrayList<NgheNghiep> arrnghenghiep = null;
        String sql = "Select * From nghenghiep";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrnghenghiep = new ArrayList<NgheNghiep>();
            while(rs.next()){
                NgheNghiep nghenghiep = new NgheNghiep(rs.getString(1), rs.getString(2));
                arrnghenghiep.add(nghenghiep);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrnghenghiep; 
    }
    
    
    public String GetMaNgheNghiep(String TenNgheNghiep){
        String manghenghiep = null;
        String sql = "Select MaNgheNghiep From nghenghiep Where TenNgheNghiep = '"+TenNgheNghiep+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                manghenghiep = rs.getString(1);
            }
 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được mã nghề !");
        }
        return manghenghiep; 
    }
    
    public Vector GetNhomNgheNghiep(){
        Vector arrnn = null;
        String sql = "Select * From nghenghiep";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrnn = new Vector();
            NgheNghiep all = new NgheNghiep(null, "Tất cả nghề nghiệp");
            arrnn.add(all);            
            while(rs.next()){
                NgheNghiep ms = new NgheNghiep(rs.getString(1), rs.getString(2));
                arrnn.add(ms);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrnn; 
    }
    // Nhận thông tin hãng
    public int InsertNgheNghiep(NgheNghiep c){
        int insert = 0;
        String sql = "Insert into nghenghiep (TenNgheNghiep) values ('"+c.GetTenNgheNghiep()+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
        }
        return insert;
    }  
    // Xoá thông tin hãng
    public boolean DeleteNgheNghiep(ArrayList<String> lismanghenghiep){
        boolean check = false;
        try{
            String sql;
            for(String ma : lismanghenghiep){
                sql = "Delete From nghenghiep Where MaNgheNghiep = '"+ma+"'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            } 
            check = true;
        }catch(SQLException ex){
            
        }
        return check;
    } 
    
    public NgheNghiep GetNgheNghiepByMa(String manghenghiep){
        NgheNghiep nghenghiep = null;
        String sql = "Select * From nghenghiep Where MaNgheNghiep = '"+manghenghiep+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                nghenghiep = new NgheNghiep(rs.getString(1), rs.getString(2));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return nghenghiep; 
    } 
    
    public NgheNghiep GetNgheNghiepByTen(String manghenghiep){
        NgheNghiep nghenghiep = null;
        String sql = "Select * From nghenghiep Where TenNgheNghiep = '"+manghenghiep+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                nghenghiep = new NgheNghiep(rs.getString(1), rs.getString(2));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return nghenghiep; 
    } 
    // Cập nhật thông tin hãng
   public int UpdateNgheNghiep(NgheNghiep b){
        int update = 0;
        String sql = "UPDATE nghenghiep SET TenNgheNghiep = '"+b.GetTenNgheNghiep()+"' WHERE MaNgheNghiep = '"+b.GetMaNgheNghiep()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update nghề nghiệp không thành công !");
        }
        return update;
    }
   // Tìm thông tin kiểu dáng
   public ArrayList<NgheNghiep> SearchNgheNghiep(String tennghenghiep){
        ArrayList<NgheNghiep> arrtd = null;
        String sql;
            sql = "SELECT * FROM nghenghiep WHERE TenNgheNghiep LIKE '"+tennghenghiep+"%'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<NgheNghiep>();
            while(rs.next()){
                NgheNghiep td = new NgheNghiep(rs.getString(1), rs.getString(2));
                arrtd.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    }

//Sở thích
   //thông tin khoảng giá
    public ArrayList<SoThich> GetSoThich(){
        ArrayList<SoThich> arrsothich = null;
        String sql = "Select * From sothich";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrsothich = new ArrayList<SoThich>();
            while(rs.next()){
                SoThich sothich = new SoThich(rs.getString(1), rs.getString(2));
                arrsothich.add(sothich);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrsothich; 
    }
    
    
    public String GetMaSoThich(String TenSoThich){
        String masothich = null;
        String sql = "Select MaSoThich From sothich Where TenSoThich = '"+TenSoThich+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                masothich = rs.getString(1);
            }
 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được mã sở thích !");
        }
        return masothich; 
    }
    
    public Vector GetNhomSoThich(){
        Vector arrst = null;
        String sql = "Select * From sothich";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrst = new Vector();
            SoThich all = new SoThich(null, "Tất cả sở thích");
            arrst.add(all);            
            while(rs.next()){
                SoThich ms = new SoThich(rs.getString(1), rs.getString(2));
                arrst.add(ms);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrst; 
    }
    // Nhận thông tin hãng
    public int InsertSoThich(SoThich c){
        int insert = 0;
        String sql = "Insert into sothich (TenSoThich) values ('"+c.GetTenSoThich()+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
        }
        return insert;
    }  
    // Xoá thông tin hãng
    public boolean DeleteSoThich(ArrayList<String> lismasothich){
        boolean check = false;
        try{
            String sql;
            for(String ma : lismasothich){
                sql = "Delete From sothich Where MaSoThich = '"+ma+"'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            } 
            check = true;
        }catch(SQLException ex){
            
        }
        return check;
    } 
    
    public SoThich GetSoThichByMa(String masothich){
        SoThich sothich = null;
        String sql = "Select * From sothich Where MaSoThich = '"+masothich+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                sothich = new SoThich(rs.getString(1), rs.getString(2));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return sothich; 
    } 
    
    public SoThich GetSoThichByTen(String masothich){
        SoThich sothich = null;
        String sql = "Select * From sothich Where TenSoThich = '"+masothich+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                sothich = new SoThich(rs.getString(1), rs.getString(2));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return sothich; 
    } 
    
    
    // Cập nhật thông tin hãng
   public int UpdateSoThich(SoThich b){
        int update = 0;
        String sql = "UPDATE sothich SET TenSoThich = '"+b.GetTenSoThich()+"' WHERE MaSoThich = '"+b.GetMaSoThich()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update sở thích không thành công !");
        }
        return update;
    }
   // Tìm thông tin kiểu dáng
   public ArrayList<SoThich> SearchSoThich(String tensothich){
        ArrayList<SoThich> arrtd = null;
        String sql;
            sql = "SELECT * FROM sothich WHERE TenSoThich LIKE '"+tensothich+"%'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<SoThich>();
            while(rs.next()){
                SoThich td = new SoThich(rs.getString(1), rs.getString(2));
                arrtd.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    }   
   
   
   
//    public ArrayList<Ban> GetBan(int maban){
//        ArrayList<Ban> arrBan = null;
//        String sql;
//        if(maban == 0)
//            sql = "Select * From ban";
//        else
//            sql = "Select * From ban Where MaBan = '"+maban+"'";
//        try{
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            arrBan = new ArrayList<Ban>();
//            while(rs.next()){
//                Ban sp = new Ban(rs.getInt(1), rs.getString(2), rs.getString(3));
//                arrBan.add(sp);
//            }
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
//        }
//        return arrBan; 
//    } 
    
    
//    public int UpdateBan(Ban b){
//        int update = 0;
//        String sql = "UPDATE ban SET TenBan = '"+b.GetTenBan()+"', TrangThai = '"+b.GetTrangThai()+"' WHERE MaBan = '"+b.GetMaBan()+"'";
//        try{
//            Statement st = cn.createStatement();
//            update = st.executeUpdate(sql);
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Update bàn không thành công !");
//        }
//        return update;
//    }    
   
//SẢN PHẨM 
    public ArrayList<SanPham> GetSanPhamByMa(String ma){
        ArrayList<SanPham> arrSanPham = null;
        String sql;

            sql = "Select * From sanpham Where MaSanPham = '"+ma+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrSanPham = new ArrayList<SanPham>();
            while(rs.next()){
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
                arrSanPham.add(sp);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách sản phẩm !");
        }
        return arrSanPham;        
    }

    public ArrayList<SanPham> GetSanPham(String ma){
        ArrayList<SanPham> arrSanPham = null;
        String sql;
        if(ma == null){
            sql = "Select * From sanpham";
        }else{
            sql = "Select * From sanpham Where MaHangSanXuat = '"+ma+"'";
        }
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrSanPham = new ArrayList<SanPham>();
            while(rs.next()){
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
                arrSanPham.add(sp);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách sản phẩm !");
        }
        return arrSanPham;        
    }
    
    public int InsertSanPham(SanPham sp){
        int insert = 0;
        String sql = "Insert into sanpham (TenSanPham, MaHangSanXuat, MaMauSac, MaKieuDang, MaTinhNang, MaKhoangGia, DonGia, DVT) values ('"+sp.GetTenSanPham()+"', '"+sp.GetMaHangSanXuat()+"', '"+sp.GetMaMauSac()+"', '"+sp.GetMaKieuDang()+"', '"+sp.GetMaTinhNang()+"', '"+sp.GetMaKhoangGia()+"', '"+sp.GetDonGia()+"', '"+sp.GetDVT()+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
        }
        return insert;
    }
    
    public boolean DeleteSanPham(ArrayList<String> listmasanpham){
        boolean check = false;
        try{
            String sql;
            for(String ma : listmasanpham){
                sql = "Delete From sanpham Where MaSanPham = '"+ma+"'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            } 
            check = true;
        }catch(SQLException ex){
            
        }
        return check;
    }
    
    public int UpdateSanPham(SanPham td){
        int update = 0;
        String sql = "UPDATE sanpham SET TenSanPham = '"+td.GetTenSanPham()+"', MaHangSanXuat = '"+td.GetMaHangSanXuat()+"', MaMauSac = '"+td.GetMaMauSac()+"', MaKieuDang = '"+td.GetMaKieuDang()+"', MaTinhNang = '"+td.GetMaTinhNang()+"', MaKhoangGia = '"+td.GetMaKhoangGia()+"', DonGia = '"+td.GetDonGia()+"', DVT = '"+td.GetDVT()+"' WHERE MaSanPham = '"+td.GetMaSanPham()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update sản phẩm không thành công !");
        }
        return update;
    }  
    

    public ArrayList<SanPham> SearchSanPham(String ten){
        ArrayList<SanPham> arrsp = null;
        String sql;
            sql = "SELECT * FROM sanpham WHERE TenSanPham LIKE '"+ten+"%'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrsp = new ArrayList<SanPham>();
            while(rs.next()){
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
                arrsp.add(sp);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrsp;
    }
    
//     public ArrayList<DsOrder> GetDsOrder(int ma){
//        ArrayList<DsOrder> arrDs = null;
//        String sql;
//            sql = "Select ct.MaMon, TenMon, DVT, SoLuong, Gia, MaHoaDon From chitiethd AS ct INNER JOIN thucdon AS td ON ct.MaMon = td.MaMon Where ct.MaHoaDon = '"+ma+"'";
//        try{
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            arrDs = new ArrayList<DsOrder>();
//            while(rs.next()){
//                DsOrder order = new DsOrder(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
//                arrDs.add(order);
//            }
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Không lấy được danh sách Order !");
//        }
//        return arrDs;        
//    }  
//     
//    public ChiTietHD GetDsChiTiet(String ma, int maban){
//        ChiTietHD arrDs = null;
//        String sql;
//
//            sql = "Select SoLuong, Gia, MaChiTietHD From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon Where MaMon = '"+ma+"' AND MaBan = '"+maban+"' AND hd.TrangThai = 0";
//        try{
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while(rs.next()){
//                arrDs = new ChiTietHD();
//                arrDs.SetSoLuong(rs.getInt(1));
//                arrDs.SetGia(rs.getInt(2));
//                arrDs.SetMaChiTietHD(rs.getInt(3));
//            }
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Không lấy được danh sách Order !");
//        }
//        return arrDs;        
//    } 
//    
//    public int UpdateChiTiet(ChiTietHD ct){
//        int update = 0;
//        String sql = "UPDATE chitiethd SET SoLuong = '"+ct.GetSoLuong()+"', Gia = '"+ct.GetGia()+"' WHERE MaChiTietHD = '"+ct.GetMaChiTietHD()+"'";
//        try{
//            Statement st = cn.createStatement();
//            update = st.executeUpdate(sql);
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Update chi tiết không thành công !");
//        }
//        return update;        
//    }
//    
//    public int HuyHD(HoaDon hd){
//        int update = 0;
//        String sql = "Delete From hoadon WHERE MaHoaDon = '"+hd.GetMaHD()+"'";
//        try{
//            Statement st = cn.createStatement();
//            update = st.executeUpdate(sql);
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Thanh toán không thành công !");
//        }
//        return update;        
//    }  
//    
//    public int ThanhToan(HoaDon hd){
//        int update = 0;
//        String sql = "UPDATE hoadon SET TongTien = '"+hd.GetTongTien()+"', TrangThai = 1 WHERE MaHoaDon = '"+hd.GetMaHD()+"'";
//        try{
//            Statement st = cn.createStatement();
//            update = st.executeUpdate(sql);
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Thanh toán không thành công !");
//        }
//        return update;        
//    }
//    
//    public int UpDateTrangThaiBan(Ban b){
//         int update = 0;
//        String sql = "UPDATE ban SET TrangThai = '"+b.GetTrangThai()+"' WHERE MaBan = '"+b.GetMaBan()+"'";
//        try{
//            Statement st = cn.createStatement();
//            update = st.executeUpdate(sql);
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Update trạng thái bàn không thành công !");
//        }
//        return update;        
//    }
    
    
//    public int InsertHoaDon(HoaDon hd, String gio){
//        int insert = 0;
//        String sql = "Insert into hoadon (MaBan, GioDen, TrangThai) values ('"+hd.GetMaBan()+"', '"+gio+"', '"+hd.GetTrangThai()+"')";
//        try{
//            Statement st = cn.createStatement();
//            insert = st.executeUpdate(sql);
//        }catch(SQLException ex){
//        }
//        return insert;
//    }
    
//    public int DeleteMon(String mamon, int mahd, int maban){
//        int check = 0;
//        try{
//            String sql;
//            sql = "Delete From chitiethd Where MaMon = '"+mamon+"' AND MaHoaDon = '"+mahd+"'";
//            Statement st = cn.createStatement();
//            st.executeUpdate(sql);
//            check = 1;
////            if(CheckDsMon(mahd, maban) == 0){
////                check = 2;
////            }
//        }catch(SQLException ex){
//            
//        }
//        return check;
//    }
    
//    public int CheckDsMon(int mahd, int maban){
//        String sql;
//        int dem = 0;
//            sql = "Select * From hoadon AS hd INNER JOIN chitiethd AS ct ON ct.MaHoaDon = hd.MaHoaDon Where MaBan = '"+maban+"' AND ct.MaHoaDon = '"+mahd+"' AND TrangThai = 0";
//        try{
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while(rs.next()){
//                dem++;
//            }
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Không lấy được danh sách hóa đơn !");
//        }
//        return dem;        
//    }    
    
//    public HoaDon GetHDbyMaBan(int ma){
//        String sql;
//        HoaDon arrhd = null;
//            sql = "Select * From hoadon Where MaBan = '"+ma+"' AND TrangThai = 0";
//        try{
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while(rs.next()){
//                arrhd = new HoaDon(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getTimestamp(4), rs.getInt(5), rs.getInt(6));
//            }
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Không lấy được danh sách hóa đơn !");
//        }
//        return arrhd;        
//    } 
    
//    public int GetMaHD(int ma){
//        String sql;
//        int mahd = 0;
//            sql = "Select MaHoaDon From hoadon Where MaBan = '"+ma+"' AND TrangThai = 0";
//        try{
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while(rs.next()){
//                mahd = rs.getInt(1);
//            }
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
//        }
//        return mahd;        
//    } 
//    
//    public int UpdateHD(HoaDon hd){
//        int update = 0;
//        String sql = "UPDATE hoadon SET GiamGia = '"+hd.GetGiamGia()+"' WHERE MaHoaDon = '"+hd.GetMaHD()+"'";
//        try{
//            Statement st = cn.createStatement();
//            update = st.executeUpdate(sql);
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Giảm giá không thành công !");
//        }
//        return update;
//    }  
//    
//    public int InsertChiTietHD(ChiTietHD cthd){
//        int insert = 0;
//        String sql = "Insert into chitiethd (MaHoaDon, MaMon, SoLuong, Gia) values ('"+cthd.GetMaHD()+"', '"+cthd.GetMaMon()+"', '"+cthd.GetSoLuong()+"', '"+cthd.GetGia()+"')";
//        try{
//            Statement st = cn.createStatement();
//            insert = st.executeUpdate(sql);
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Thêm chi tiết hóa đơn không thành công !"+ex.toString());
//        }
//        return insert;
//    }
    
    public boolean CheckLogin(TaiKhoan tk)
    {
        boolean check = false;
        String sql;
            sql = "Select * From taikhoan Where username = '"+tk.GetUsername()+"' AND password='"+tk.GetPassword()+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                check = true;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi đăng nhập !");
        }
        return check; 
    }
    public boolean CheckUsername(String username)
    {
        boolean check = false;
        String sql;
            sql = "Select * From taikhoan Where username = '"+username;
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                check = true;
            }
        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
             return check; 
        }
        return check; 
    }
    
    
    // Tài khoản
    public int LVTK(TaiKhoan tk)
    {
        int lvtk =0;
        String sql;
            sql = "Select lv From taikhoan Where username = '"+tk.GetUsername()+"' AND password='"+tk.GetPassword()+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                lvtk = rs.getInt(1);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return lvtk; 
    }  
    
    
    
//    public int InsertBan(Ban b){
//        int insert = 0;
//        String sql = "Insert into ban (TenBan, TrangThai) values ('"+b.GetTenBan()+"', '"+b.GetTrangThai()+"')";
//        try{
//            Statement st = cn.createStatement();
//            insert = st.executeUpdate(sql);
//        }catch(SQLException ex){
//        }
//        return insert;
//    }
//    
//    public boolean DeleteBan(ArrayList<Integer> listMaBan){
//        boolean check = false;
//        try{
//            String sql;
//            for(int ma : listMaBan){
//                sql = "Delete From ban Where MaBan = '"+ma+"'";
//                Statement st = cn.createStatement();
//                st.executeUpdate(sql);
//            } 
//            check = true;
//        }catch(SQLException ex){
//            
//        }
//        return check;
//    }    
    
     
    
//    public ArrayList<Ban> SearchBan(String ten){
//        ArrayList<Ban> arrtd = null;
//        String sql;
//            sql = "SELECT * FROM ban WHERE TenBan LIKE '"+ten+"%'";
//        try{
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            arrtd = new ArrayList<Ban>();
//            while(rs.next()){
//                Ban td = new Ban(rs.getInt(1), rs.getString(2), rs.getString(3));
//                arrtd.add(td);
//            }
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "lỗi !");
//        }
//        return arrtd;
//    } 
    
    public ArrayList<TaiKhoan> GetTaiKhoan(){
        ArrayList<TaiKhoan> arrtd = null;
        String sql;
            sql = "SELECT * FROM taikhoan WHERE lv != 1";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<TaiKhoan>();
            while(rs.next()){
                TaiKhoan td = new TaiKhoan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                arrtd.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    }
    public boolean DeleteTaiKhoan(ArrayList<Integer> listMaBan){
        boolean check = false;
        try{
            String sql;
            for(int ma : listMaBan){
                sql = "Delete From taikhoan Where id = '"+ma+"'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            } 
            check = true;
        }catch(SQLException ex){
            
        }
        return check;
    } 
    public int InserTK(TaiKhoan b){
        int insert = 0;
        String sql = "Insert into taikhoan (username, password, lv) values ('"+b.GetUsername()+"', '"+b.GetPassword()+"', '"+b.GetLv()+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return insert;
    } 
    public TaiKhoan GetTaiKhoan(int id){
        TaiKhoan td = null;
        String sql;
            sql = "SELECT * FROM taikhoan WHERE id = '"+id+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
               td  = new TaiKhoan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return td;
    }
   
    public TaiKhoan GetTaiKhoan(String name, String pass){
        TaiKhoan td = null;
        String sql;
            sql = "SELECT * FROM taikhoan Where username = '"+name+"' AND password='"+pass+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
               td  = new TaiKhoan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return td;
    }
    public int UpdateTK(TaiKhoan b){
        int update = 0;
        String sql = "UPDATE taikhoan SET username = '"+b.GetUsername()+"', password = '"+b.GetPassword()+"', lv = '"+b.GetLv()+"' WHERE id = '"+b.GetID()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return update;
    }
//public ArrayList<HoaDon> GetDSHD(){
//        ArrayList<HoaDon> arrDs = null;
//        String sql;
//            sql = "Select * From hoadon Where TrangThai = 1";
//        try{
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            arrDs = new ArrayList<HoaDon>();
//            while(rs.next()){
//                HoaDon order = new HoaDon(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getTimestamp(4), rs.getInt(5), rs.getInt(6));
//                arrDs.add(order);
//            }
//        }catch(SQLException ex){
//        }
//        return arrDs;        
//    }
//     public ArrayList<SanPham> GetDsMonBan(){
//        ArrayList<SanPham> arrDs = null;
//        String sql;
//            sql = "Select TenMon, MaMon, DVT From thucdon WHERE MaMon in (Select MaMon From chitiethd) AND hoadon.TrangThai = 1";
//        try{
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            arrDs = new ArrayList<SanPham>();
//            while(rs.next()){
//                SanPham order = new SanPham();
//                order.SetTenMon(rs.getString(1));
//                order.SetMaMon(rs.getString(2));
//                order.SetDVT(rs.getString(3));
//                arrDs.add(order);
//            }
//        }catch(SQLException ex){
//        }
//        return arrDs;        
//    }  
//     public ArrayList<SanPham> GetChiTietMonByMa(){
//        ArrayList<SanPham> arrDs = null;
//        String sql;
//            sql = "SELECT TenMon, MaMon, DVT FROM thucdon where MaMon in (Select MaMon From chitiethd)";
//        try{
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            arrDs = new ArrayList<SanPham>();
//            while(rs.next()){
//                SanPham order = new SanPham();
//                order.SetTenMon(rs.getString(1));
//                order.SetMaMon(rs.getString(2));
//                order.SetDVT(rs.getString(3));
//                arrDs.add(order);
//            }
//        }catch(SQLException ex){
//        }
//        return arrDs;        
//    }  
//     public ArrayList<DsOrder> GetGiaSoLuong(String ma){
//        ArrayList<DsOrder> arrDs = null;
//        String sql;
//            sql = "Select Gia, SoLuong, TenMon, DVT From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon INNER JOIN thucdon AS td ON td.MaMon = ct.MaMon Where hd.TrangThai = 1 AND ct.MaMon = '"+ma+"'";
//        try{
//            
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            arrDs = new ArrayList<DsOrder>();
//            while(rs.next()){
//                
//                DsOrder order = new DsOrder();
//                order.SetGia(rs.getInt(1));
//                order.SetSoLuong(rs.getInt(2));
//                order.SetTenMon(rs.getString(3));
//                order.SetDVT(rs.getString(4));
//                arrDs.add(order);
//            }
//        }catch(SQLException ex){
//        }
//        return arrDs;        
//    }
//     public ArrayList<DsOrder> GetHdByDate(String d1,String d2, String m){
//        ArrayList<DsOrder> arrDs = null;
//        String sql;
//        if(d1.equals(d2)){
//            sql = "Select Gia, SoLuong, TenMon, DVT From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon INNER JOIN thucdon AS td ON td.MaMon = ct.MaMon Where hd.TrangThai = 1 AND hd.GioDen >= '"+d1+"' AND ct.MaMon ='"+m+"'";
//        }else
//            sql = "Select Gia, SoLuong, TenMon, DVT From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon INNER JOIN thucdon AS td ON td.MaMon = ct.MaMon Where hd.TrangThai = 1 AND hd.GioDen BETWEEN '"+d1+"' AND '"+d2+"' AND ct.MaMon ='"+m+"'";
//        try{
//            
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            arrDs = new ArrayList<DsOrder>();
//            while(rs.next()){
//                DsOrder order = new DsOrder();
//                order.SetGia(rs.getInt(1));
//                order.SetSoLuong(rs.getInt(2));
//                order.SetTenMon(rs.getString(3));
//                order.SetDVT(rs.getString(4));
//                arrDs.add(order);
//            }
//        }catch(SQLException ex){
//        }
//        return arrDs;        
//    } 
//     public ArrayList<DsOrder> GetCtHDByDate(int ma, String d1, String d2){
//        ArrayList<DsOrder> arrDs = null;
//        String sql;
//        if(d1.equals(d2))
//            sql = "Select ct.MaMon, TenMon, DVT, SoLuong, Gia, ct.MaHoaDon From chitiethd AS ct INNER JOIN thucdon AS td ON ct.MaMon = td.MaMon INNER JOIN hoadon AS hd ON hd.MaHoaDon = ct.MaHoaDon Where ct.MaHoaDon = '"+ma+"' AND hd.GioDen >= '"+d1+"'";
//            else
//            sql = "Select ct.MaMon, TenMon, DVT, SoLuong, Gia, ct.MaHoaDon From chitiethd AS ct INNER JOIN thucdon AS td ON ct.MaMon = td.MaMon INNER JOIN hoadon AS hd ON hd.MaHoaDon = ct.MaHoaDon Where ct.MaHoaDon = '"+ma+"' AND hd.GioDen BETWEEN '"+d1+"' AND '"+d2+"'";
//        try{
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            arrDs = new ArrayList<DsOrder>();
//            while(rs.next()){
//                DsOrder order = new DsOrder(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
//                arrDs.add(order);
//            }
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Không lấy được danh sách chi tiết hoa đơn !"+ex.toString());
//        }
//        return arrDs;        
//    }     
}
