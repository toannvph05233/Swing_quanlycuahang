/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mysql;

import Models.KhoangGia;
import Models.KieuDang;
import Models.MauSac;
import Models.NgheNghiep;

import Models.NgheNghiepSoThich;
import Models.SanPham;
import Models.SoThich;
import Models.TinhNang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johntoan98gmail.com
 */
public class SearchSanPhamDAO {

    private Connection connection;

    public SearchSanPhamDAO(Connection connection) {
        this.connection = connection;
    }

    public List<SanPham> searchSanPham(String tenKieuDang, String tenMauSac, String tenTinhNang, String tenKhoangGia, List<Integer> listId) {
        String query = "SELECT SanPham.* FROM sanpham "
                + "JOIN hangsanxuat ON sanpham.MaHangSanXuat = hangsanxuat.MaHangSanXuat "
                + "JOIN kieudang ON sanpham.MaKieuDang = kieudang.MaKieuDang "
                + "JOIN mausac ON sanpham.MaMauSac = mausac.MaMauSac "
                + "JOIN tinhnang ON sanpham.MaTinhNang = tinhnang.MaTinhNang "
                + "JOIN khoanggia ON sanpham.MaKhoangGia = khoanggia.MaKhoangGia "
                + "LEFT JOIN nghenghiep_sothich ON sanpham.id_nghenghiep_sothich = nghenghiep_sothich.id "
                + "WHERE "
                + "(? IS NULL OR kieudang.TenKieuDang = ?) AND "
                + "(? IS NULL OR mausac.TenMauSac = ?) AND "
                + "(? IS NULL OR tinhnang.TenTinhNang = ?) AND "
                + "(? IS NULL OR khoanggia.TenKhoangGia = ?) AND "
                + "(? IS NULL OR (FIND_IN_SET(nghenghiep_sothich.id, ?)))";

        List<SanPham> sanPhamList = new ArrayList<>();
        String idss_nn = null;
        StringBuilder result = new StringBuilder("");

        for (int i = 0; i < listId.size(); i++) {
            result.append(listId.get(i));
            if (i < listId.size() - 1) {
                result.append(",");
            }
        }
        if (!result.equals("")) {
            idss_nn = result.toString();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, tenKieuDang);
            preparedStatement.setString(2, tenKieuDang);
            preparedStatement.setString(3, tenMauSac);
            preparedStatement.setString(4, tenMauSac);
            preparedStatement.setString(5, tenTinhNang);
            preparedStatement.setString(6, tenTinhNang);
            preparedStatement.setString(7, tenKhoangGia);
            preparedStatement.setString(8, tenKhoangGia);
            preparedStatement.setString(9, idss_nn);
            preparedStatement.setString(10, idss_nn);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
                    sanPhamList.add(sp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sanPhamList;
    }

    public List<Integer> searchNgheNghiepSoThich(String tenNghenghiep, String tenSoThich) {
        String query = "SELECT nghenghiep_sothich.id FROM nghenghiep_sothich "
                + "JOIN nghenghiep ON nghenghiep.Manghenghiep = nghenghiep_sothich.id_nghenghiep "
                + "JOIN sothich ON sothich.Masothich = nghenghiep_sothich.id_sothich "
                + "WHERE "
                + "(? IS NULL OR nghenghiep.Tennghenghiep = ?) AND "
                + "(? IS NULL OR sothich.TenSoThich = ?)";
        List<Integer> ngheNghiepSoThichList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, tenNghenghiep);
            preparedStatement.setString(2, tenNghenghiep);
            preparedStatement.setString(3, tenSoThich);
            preparedStatement.setString(4, tenSoThich);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    ngheNghiepSoThichList.add(resultSet.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ngheNghiepSoThichList;
    }

    public List<KhoangGia> getAllKhoangGia() {
        List<KhoangGia> khoangGiaList = new ArrayList<>();
        String query = "SELECT * FROM khoanggia";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                KhoangGia khoangGia = new KhoangGia();
                khoangGia.SetMaKhoangGia(resultSet.getString("MaKhoangGia"));
                khoangGia.SetTenKhoangGia(resultSet.getString("TenKhoangGia"));

                khoangGiaList.add(khoangGia);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return khoangGiaList;
    }

    public List<TinhNang> getAllTinhNang() {
        List<TinhNang> tinhNangs = new ArrayList<>();
        String query = "SELECT * FROM TinhNang";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                TinhNang tinhNang = new TinhNang();
                tinhNang.SetMaTinhNang(resultSet.getString("MaTinhNang"));
                tinhNang.SetTenTinhNang(resultSet.getString("TenTinhNang"));

                tinhNangs.add(tinhNang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tinhNangs;
    }

    public List<KieuDang> getAllKieuDang() {
        List<KieuDang> kieuDangs = new ArrayList<>();
        String query = "SELECT * FROM KieuDang";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                KieuDang kd = new KieuDang();
                kd.SetMaKieuDang(resultSet.getString("MaKieuDang"));
                kd.SetTenKieuDang(resultSet.getString("TenKieuDang"));

                kieuDangs.add(kd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return kieuDangs;
    }

    public List<MauSac> getAllMauSac() {
        List<MauSac> mauSacs = new ArrayList<>();
        String query = "SELECT * FROM MauSac";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                MauSac mauSac = new MauSac();
                mauSac.SetMaMauSac(resultSet.getString("MaMauSac"));
                mauSac.SetTenMauSac(resultSet.getString("TenMauSac"));

                mauSacs.add(mauSac);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mauSacs;
    }

    public List<SoThich> getAllSoThich() {
        List<SoThich> mauSacs = new ArrayList<>();
        String query = "SELECT * FROM SoThich";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                SoThich mauSac = new SoThich();
                mauSac.SetMaSoThich(resultSet.getString("MaSoThich"));
                mauSac.SetTenSoThich(resultSet.getString("TenSoThich"));

                mauSacs.add(mauSac);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mauSacs;
    }

    public List<NgheNghiep> getAllNgheNghiep() {
        List<NgheNghiep> mauSacs = new ArrayList<>();
        String query = "SELECT * FROM NgheNghiep";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                NgheNghiep mauSac = new NgheNghiep();
                mauSac.SetMaNgheNghiep(resultSet.getString("MaNgheNghiep"));
                mauSac.SetTenNgheNghiep(resultSet.getString("TenNgheNghiep"));

                mauSacs.add(mauSac);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mauSacs;
    }
}
