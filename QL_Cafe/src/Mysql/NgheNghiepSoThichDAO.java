/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mysql;

import Models.NgheNghiepSoThich;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NgheNghiepSoThichDAO {

    private Connection connection;

    public NgheNghiepSoThichDAO(Connection connection) {
        this.connection = connection;
    }

    public void addNgheNghiepSoThich(int idNgheNghiep, int idSoThich) {
        String query = "INSERT INTO nghenghiep_sothich (id_nghenghiep, id_sothich) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idNgheNghiep);
            preparedStatement.setInt(2, idSoThich);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean deleteNgheNghiepSoThich(String id) {
        String query = "DELETE FROM nghenghiep_sothich WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id);
            return preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Integer> getSoThichByNgheNghiep(int idNgheNghiep) {
        List<Integer> soThichList = new ArrayList<>();
        String query = "SELECT id_sothich FROM nghenghiep_sothich WHERE id_nghenghiep = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idNgheNghiep);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    soThichList.add(resultSet.getInt("id_sothich"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return soThichList;
    }

    public List<NgheNghiepSoThich> getAllNgheNghiepSoThich() {
        List<NgheNghiepSoThich> ngheNghiepSoThichList = new ArrayList<>();
        String query = "SELECT * FROM nghenghiep_sothich";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                NgheNghiepSoThich ngheNghiepSoThich = new NgheNghiepSoThich();
                ngheNghiepSoThich.setId(resultSet.getInt("id"));
                ngheNghiepSoThich.setId_nghenghiep(resultSet.getInt("id_nghenghiep"));
                ngheNghiepSoThich.setId_sothich(resultSet.getInt("id_sothich"));

                ngheNghiepSoThichList.add(ngheNghiepSoThich);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ngheNghiepSoThichList;
    }

    public NgheNghiepSoThich getNgheNghiepSoThich(String id) {
        String query = "SELECT * FROM nghenghiep_sothich where id = " + id;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                NgheNghiepSoThich ngheNghiepSoThich = new NgheNghiepSoThich();
                ngheNghiepSoThich.setId(resultSet.getInt("id"));
                ngheNghiepSoThich.setId_nghenghiep(resultSet.getInt("id_nghenghiep"));
                ngheNghiepSoThich.setId_sothich(resultSet.getInt("id_sothich"));
                return ngheNghiepSoThich;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    
     public void updateNgheNghiepSoThich(int id, int newIdNgheNghiep, int newIdSoThich) {
        String query = "UPDATE nghenghiep_sothich SET id_nghenghiep = ?, id_sothich = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, newIdNgheNghiep);
            preparedStatement.setInt(2, newIdSoThich);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Các phương thức khác tùy thuộc vào yêu cầu của bạn
}
