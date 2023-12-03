/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Interface.BanHang.JpTuVan;
import Interface.Home.JpHome;
import Interface.QuanLy.JpQuanLy;
import Interface.Setting.JpSetting;
import Models.Ban;
import Models.TaiKhoan;
import Mysql.ConnectSQL;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import Interface.ThongKe.JpThongKe;
/**
 *
 * @author LONG
 */
public final class frmMain extends javax.swing.JFrame {
    ConnectSQL cn = new ConnectSQL();
    /**
     * Creates new form frmMain
     */
    public TaiKhoan loadtaikhoan(String user, String pass){
       return cn.GetTaiKhoan(user, pass);       
    }    
    public frmMain() {
        initComponents();
        fill();
        Clock clock= new Clock(); 
        clock.start(); 
        txtqtv.setText(Run.tk.GetUsername());
        if(Run.tk.GetLv() != 1)
        {
            btnQuanLy.setEnabled(false);
            btnThongKe.setEnabled(false);
       }
        
       
    }
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss_a");
    public class Clock extends Thread{ 
    public Clock(){    } 
    @Override
    public void run(){ 
        while(true){ 
//            int bandat =0, banpv=0;
//            ArrayList<Ban> arrBan = cn.GetBan(0);
//            for(int i = 0;i<arrBan.size();i++){
//                if(arrBan.get(i).GetTrangThai().equals("Đang phục vụ")){
//                    banpv++;
//                }
//                if(arrBan.get(i).GetTrangThai().equals("Đã đặt trước")){
//                    bandat++;
//                }            
//            } 
            
            Calendar calendar = Calendar.getInstance();                
            String str;  
            str= sdf.format(calendar.getTime()); 
            lbltime.setText(str); 
        try{ 
            sleep(1000); 
          } catch(Exception e){ 
             System.out.println(e); 
            } 
      } 
    }
    }
    public void fill(){
        home = new JpHome();
        jpLayout.add(home);
        jpLayout.updateUI();
//        mp3 = new MP3 ("src/Sound/Ai la trieu phu - ai la trieu phu.MP3");
//        mp3.play();
        btnmute.setVisible(false);
 
        //Khai bao dinh dang ngay thang
        
      
    }
    MP3 mp3;
    JpTuVan tuvan;
    JpHome home ;
    JpSetting Set;
    JpQuanLy ql;
    JpThongKe tk ;
    public void reloadPanel(int i) {
        jpLayout.removeAll();
        switch (i) {
            case 1:
                if (tuvan == null) {
                    tuvan= new JpTuVan();
                } 
                btnBanHang.setPressedIcon(new ImageIcon("down.png"));
//                mp3 = new MP3 ("src/Sound/kasya.MP3");
//                mp3.play();
                jpLayout.add(tuvan);
                break;
            case 2:
                if (home == null) {
                    home = new JpHome();
                }
                btnTrangChu.setPressedIcon(new ImageIcon("down.png"));
//                mp3 = new MP3 ("src/Sound/kasya.MP3");
//                mp3.play();
                jpLayout.add(home);
                break;
            case 3:
                if(ql == null){
                    ql = new JpQuanLy();
                }
                btnQuanLy.setPressedIcon(new ImageIcon("down.png"));
                jpLayout.add(ql);
//                mp3 = new MP3 ("src/Sound/kasya.MP3");
//                mp3.play();
                break;
            case 4:
                tk = new JpThongKe();
                
                btnThongKe.setPressedIcon(new ImageIcon("down.png"));
                jpLayout.add(tk);
//                mp3 = new MP3 ("src/Sound/kasya.MP3");
//                mp3.play();
                break;
            case 5:
                if (Set == null) {
                    Set = new JpSetting();
                } 
                btnThietLap.setPressedIcon(new ImageIcon("down.png"));
//                mp3 = new MP3 ("src/Sound/kasya.MP3");
//                mp3.play();
                jpLayout.add(Set);
                break;                
            default:
                break;
        }
        jpLayout.updateUI();
    }   
    class MP3 {
    private Player player;
    private String filename;
    
    public MP3(String filename) {
        this.filename = filename;
    }
    
    public void stop() {
        if (player != null)
            player.close();
    }
    
    public void play() {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filename));
            player = new Player(bis);
        } catch (FileNotFoundException | JavaLayerException ex) {
            System.out.println(ex);
        }
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    player.play();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }).start();
    }
}
        //Lam gi do trong thoi gian phat nhac

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jPanel2 = new javax.swing.JPanel();
        btnThietLap = new javax.swing.JButton();
        btnQuanLy = new javax.swing.JButton();
        btnBanHang = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        jpLayout = new javax.swing.JPanel();
        btnthoat = new javax.swing.JButton();
        btnTrangChu = new javax.swing.JButton();
        btnSound = new javax.swing.JButton();
        btnmute = new javax.swing.JButton();
        lbltime = new javax.swing.JLabel();
        txtqtv = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hệ chuyên gia tư vấn");
        setBackground(Color.decode("#e6e6e6")
        );
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setForeground(new java.awt.Color(255, 204, 255));
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1280, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel2.setBackground(Color.decode("#e6e6e6"));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 0), 2));
        jPanel2.setPreferredSize(new java.awt.Dimension(1280, 600));

        btnThietLap.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThietLap.setForeground(new java.awt.Color(51, 51, 51));
        btnThietLap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/Settings-L-icon.png"))); // NOI18N
        btnThietLap.setText("THIẾT LẬP");
        btnThietLap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThietLap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThietLapActionPerformed(evt);
            }
        });

        btnQuanLy.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnQuanLy.setForeground(new java.awt.Color(51, 51, 51));
        btnQuanLy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/icon-hoc-nau-an-Huong-nghiep-a-au-2015.png"))); // NOI18N
        btnQuanLy.setText("QUẢN LÝ");
        btnQuanLy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuanLy.setPreferredSize(new java.awt.Dimension(140, 49));
        btnQuanLy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyActionPerformed(evt);
            }
        });

        btnBanHang.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBanHang.setForeground(new java.awt.Color(51, 51, 51));
        btnBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/icon tu van .png"))); // NOI18N
        btnBanHang.setText("HỆ TƯ VẤN");
        btnBanHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBanHang.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnBanHang.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHangActionPerformed(evt);
            }
        });

        btnThongKe.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(51, 51, 51));
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/thongke.png"))); // NOI18N
        btnThongKe.setText("THỐNG KÊ");
        btnThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        jpLayout.setBackground(Color.decode("#e6e6e6")
        );
        jpLayout.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 0), new java.awt.Color(0, 51, 51)));
        jpLayout.setLayout(new java.awt.BorderLayout());

        btnthoat.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        btnthoat.setForeground(new java.awt.Color(0, 51, 0));
        btnthoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/Logout.png"))); // NOI18N
        btnthoat.setText("Đăng xuất");
        btnthoat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnthoat.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnthoat.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthoatActionPerformed(evt);
            }
        });

        btnTrangChu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnTrangChu.setForeground(new java.awt.Color(51, 51, 51));
        btnTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/HOME.png"))); // NOI18N
        btnTrangChu.setText("TRANG CHỦ");
        btnTrangChu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnTrangChu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnTrangChu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnTrangChuFocusGained(evt);
            }
        });
        btnTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnTrangChuMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseReleased(evt);
            }
        });
        btnTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangChuActionPerformed(evt);
            }
        });

        btnSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/Sound.png"))); // NOI18N
        btnSound.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoundActionPerformed(evt);
            }
        });

        btnmute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/mute.png"))); // NOI18N
        btnmute.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnmute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmuteActionPerformed(evt);
            }
        });

        lbltime.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbltime.setForeground(new java.awt.Color(51, 102, 0));
        lbltime.setText("jLabel1");

        txtqtv.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtqtv.setForeground(new java.awt.Color(204, 0, 0));
        txtqtv.setText("jLabel1");

        jLabel1.setForeground(new java.awt.Color(51, 51, 0));
        jLabel1.setText("QTV:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnTrangChu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBanHang)
                .addGap(18, 18, 18)
                .addComponent(btnQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThongKe)
                .addGap(18, 18, 18)
                .addComponent(btnThietLap)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnmute, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSound, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(lbltime, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtqtv))
                    .addComponent(btnthoat))
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 1254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThietLap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnQuanLy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtqtv)
                                    .addComponent(lbltime)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSound, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnthoat))
                                .addGap(0, 3, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnmute, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTrangChu, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jpLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1241, 1241, 1241)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed
        reloadPanel(1);
    }//GEN-LAST:event_btnBanHangActionPerformed
    public void thoat()
    {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
        int kq=JOptionPane.showConfirmDialog(null, "Bạn có muốn đóng phần mềm ?","FBI Warning",JOptionPane.YES_NO_OPTION);
        if(kq==0)
        {
        System.exit(0);
       }
}
    private void btnthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthoatActionPerformed
        // TODO add your handling code here:
        int kq=JOptionPane.showConfirmDialog(null, "Đăng xuất khỏi tài khoản " +Run.tk.GetUsername()+ "?","FBI Warning",JOptionPane.YES_NO_OPTION);
        if(kq==0)
        {
//            MP3 mp3 = new MP3 ("src/Sound/tyaran.MP3");
//            mp3.play();
            Run.frmlg.setVisible(true);
            Run.frmlg.thoat();
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_btnthoatActionPerformed

    private void btnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangChuActionPerformed
        // TODO add your handling code here:
        reloadPanel(2);
    }//GEN-LAST:event_btnTrangChuActionPerformed

    private void btnThietLapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThietLapActionPerformed
        // TODO add your handling code here:
        reloadPanel(5);
    }//GEN-LAST:event_btnThietLapActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        reloadPanel(4);
//        this.dispose();
//        Run.rerun();
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnTrangChuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnTrangChuFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnTrangChuFocusGained

    private void btnTrangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseClicked
               // TODO add your handling code here:
                
    }//GEN-LAST:event_btnTrangChuMouseClicked

    private void btnTrangChuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseEntered
              // TODO add your handling code here:
               
    }//GEN-LAST:event_btnTrangChuMouseEntered

    private void btnTrangChuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseExited
        // TODO add your handling code here:
         
    }//GEN-LAST:event_btnTrangChuMouseExited

    private void btnTrangChuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnTrangChuMouseReleased

    private void btnTrangChuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMousePressed
        
    }//GEN-LAST:event_btnTrangChuMousePressed
    MP3 nhacnen;
    private void btnSoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoundActionPerformed
        // TODO add your handling code here:
        nhacnen = new MP3 ("src/Sound/Fur Elise - Richard Clayderman.MP3");
        nhacnen.play();
        btnSound.setVisible(false);
        btnmute.setVisible(true);
        
        
    }//GEN-LAST:event_btnSoundActionPerformed

    private void btnmuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmuteActionPerformed
       nhacnen.stop();
       btnSound.setVisible(true);
       btnmute.setVisible(false);
    }//GEN-LAST:event_btnmuteActionPerformed

    private void btnQuanLyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyActionPerformed
        // TODO add your handling code here:
        
        reloadPanel(3);
        
    }//GEN-LAST:event_btnQuanLyActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnQuanLy;
    private javax.swing.JButton btnSound;
    private javax.swing.JButton btnThietLap;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTrangChu;
    private javax.swing.JButton btnmute;
    private javax.swing.JButton btnthoat;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpLayout;
    private javax.swing.JLabel lbltime;
    private javax.swing.JLabel txtqtv;
    // End of variables declaration//GEN-END:variables
}
