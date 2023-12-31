/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.QuanLy;

import Interface.Run;
import Models.NgheNghiepSoThich;
import Mysql.ConnectSQL;
import Mysql.NgheNghiepSoThichDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author johntoan98gmail.com
 */
public class Jp_QLSoThich_NgheNghiep extends javax.swing.JPanel {

    ConnectSQL connectSQL = new ConnectSQL();
    NgheNghiepSoThichDAO ngheNghiepSoThichDAO = new NgheNghiepSoThichDAO(connectSQL.getCn());

    /**
     * Creates new form Jp_QLSoThich_NgheNghiep
     */
    public static Jp_QLSoThich_NgheNghiep sothich_nghenghiep;

    public Jp_QLSoThich_NgheNghiep() {
        initComponents();
        sothich_nghenghiep = this;

        FillTable();
    }

    public void FillTable() {
        ArrayList<NgheNghiepSoThich> arrTable = (ArrayList<NgheNghiepSoThich>) ngheNghiepSoThichDAO.getAllNgheNghiepSoThich();
        DefaultTableModel tbmodel = new DefaultTableModel();
        tbmodel.addColumn("id");
        tbmodel.addColumn("Mã sở thích");
        tbmodel.addColumn("Mã nghề nghiệp");

        if (arrTable != null) {
            int sosothich = 0;
            for (NgheNghiepSoThich l : arrTable) {
                sosothich++;
                tbmodel.addRow(new Object[]{l.getId(), l.getId_sothich(), l.getId_nghenghiep()});
            }
            lblthongtin.setText(String.valueOf(sosothich) + " value");
        } else {
            JOptionPane.showMessageDialog(null, "Không có sở thích nào");
        }
        tbSoThich.setModel(tbmodel);
        for (int i = 0; i < tbSoThich.getColumnCount(); i++) {
            Class<?> col = tbSoThich.getColumnClass(i);
            tbSoThich.setDefaultEditor(col, null);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbSoThich = new javax.swing.JTable();
        bntThem = new javax.swing.JButton();
        bntSua = new javax.swing.JButton();
        bntXoa = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblthongtin = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(816, 448));

        tbSoThich.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSoThich.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSoThichMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSoThich);

        bntThem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntThem.setForeground(new java.awt.Color(51, 51, 0));
        bntThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/file_add.png"))); // NOI18N
        bntThem.setText("Thêm");
        bntThem.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        bntThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntThemActionPerformed(evt);
            }
        });

        bntSua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntSua.setForeground(new java.awt.Color(51, 51, 0));
        bntSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/document_edit.png"))); // NOI18N
        bntSua.setText("Sửa");
        bntSua.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        bntSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSuaActionPerformed(evt);
            }
        });

        bntXoa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntXoa.setForeground(new java.awt.Color(51, 51, 0));
        bntXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/file_delete.png"))); // NOI18N
        bntXoa.setText("Xóa");
        bntXoa.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        bntXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntXoaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 0));
        jLabel3.setText("Quản lý sở thích - nghề nghiệp");

        lblthongtin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblthongtin.setForeground(new java.awt.Color(153, 0, 0));
        lblthongtin.setText("Total");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 51));
        jLabel2.setText("Tổng số sở thích - nghề nghiệp:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblthongtin)
                .addGap(89, 89, 89))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bntXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntSua, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntThem, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(bntThem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bntSua, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bntXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(lblthongtin))
                .addGap(60, 60, 60))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbSoThichMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSoThichMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbSoThichMouseClicked

    private void bntThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntThemActionPerformed
        DLQl_Them_So_Thich_Nghe_Nghiep b = new DLQl_Them_So_Thich_Nghe_Nghiep(Run.QlCafe, true);
        b.setVisible(true);
    }//GEN-LAST:event_bntThemActionPerformed

    private void bntSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSuaActionPerformed
        int select = tbSoThich.getSelectedRow();
        if (select < 0) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn sở thích nào !");
        } else {
            String masothich = tbSoThich.getValueAt(select, 0) + "";

            DLQl_Sua_So_Thich_Nghe_Nghiep sua = new DLQl_Sua_So_Thich_Nghe_Nghiep(Run.QlCafe, true, masothich);
            sua.setVisible(true);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_bntSuaActionPerformed

    private void bntXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntXoaActionPerformed
        int[] selectedRows = tbSoThich.getSelectedRows();

        if (selectedRows.length <= 0) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn item nào !");
        } else {
            String ma = tbSoThich.getValueAt(1, 0) + "";
            int qs;
            qs = JOptionPane.showConfirmDialog(null, "Xóa item: \n " + ma, "Xóa sở thích - nghề nghiệp", JOptionPane.YES_NO_OPTION);
            if (qs == JOptionPane.YES_OPTION) {
                boolean xoa = ngheNghiepSoThichDAO.deleteNgheNghiepSoThich(ma);

                if (xoa == true) {
                    FillTable();
                    try {
                        Jp_QLSanPham.sp.Fillcbb();
                        Jp_QLSanPham.sp.FillTable(null);
                        Jp_QLSanPham.sp.updateUI();
                    } catch (Exception e) {

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Không xóa được vì đã liên kết với các bảng khác. !");
                }

            }
        }
    }//GEN-LAST:event_bntXoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntSua;
    private javax.swing.JButton bntThem;
    private javax.swing.JButton bntXoa;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblthongtin;
    private javax.swing.JTable tbSoThich;
    // End of variables declaration//GEN-END:variables
}
