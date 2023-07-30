/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline_reservation_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author 91975
 */
public class Booking extends javax.swing.JFrame {

    /**
     * Creates new form Booking
     */
    public Booking() {
        initComponents();
        DisplayTr();
        txtNat.setEditable(false);
        txtPassName.setEditable(false);
        txtPasspNo.setEditable(false);
        txtGen.setEditable(false);
        GetFlight();
        DisplayBooking();
    }

    Connection con = null;                                                  
      PreparedStatement pst = null;
      ResultSet Rs = null,Rs1 = null;
      Statement St = null,St1 = null;
      
      private void DisplayTr(){
         
           try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_db", "root", "");
            St=con.createStatement();
            String sql = "SELECT * FROM `passenger_tb`";
            Rs=St.executeQuery(sql);
            while(Rs.next()){
               String PId = String.valueOf(Rs.getInt("PId"));
               txtPassId.addItem(PId);
            }
            
            
        }catch(Exception e){
                 JOptionPane.showMessageDialog(null, e);
        }
              
}
      private void GetFlight(){
         
           try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_db", "root", "");
            St=con.createStatement();
            String sql = "SELECT * FROM `flight_tb`";
            Rs=St.executeQuery(sql);
            while(Rs.next()){
               String FCode = Rs.getString("FCode");
               txtFCode.addItem(FCode);
            }
            
            
        }catch(Exception e){
                 JOptionPane.showMessageDialog(null, e);
        }
              
}
    
     private void getPassInfo(){
     
         String sql = "SELECT * FROM `passenger_tb` WHERE PId="+txtPassId.getSelectedItem().toString();
         Statement St;
          ResultSet Rs;
          try{
               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_db", "root", "");
               St=con.createStatement();
               Rs = St.executeQuery(sql);
               if(Rs.next()){
                  txtPassName.setText(Rs.getString("PName"));
                  txtGen.setText(Rs.getString("PGen"));
                  txtPasspNo.setText(Rs.getString("PPassNo"));
                  txtNat.setText(Rs.getString("PNet"));
                  
               }
          }catch(Exception e){
          
          }
     }
     
     private void DisplayBooking(){
         
           try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_db", "root", "");
            St=con.createStatement();
            Rs=St.executeQuery("SELECT * FROM `booking_tb`");
           
            BookingList.setModel(DbUtils.resultSetToTableModel(Rs));
            
        }catch(Exception e){
                 
        }
              
          }
      
      int txtTId=0;
      private void CountFlight(){
            try{
                St1 = con.createStatement();
                Rs1 = St1.executeQuery("SELECT Max(TicketId) FROM `booking_tb`");
                Rs1.next();
                txtTId = Rs1.getInt(1)+1;
            }catch(Exception e){
            
            }
      }
      
      
    @SuppressWarnings("unchecked")
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPassName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFCode = new javax.swing.JComboBox();
        txtPasspNo = new javax.swing.JTextField();
        btnBook = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BookingList = new javax.swing.JTable();
        txtAmt = new javax.swing.JTextField();
        txtNat = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPassId = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtGen = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 0, 0));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setText("Passenger Name");

        txtPassName.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtPassName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtPassName.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                txtPassNameAncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        txtPassName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassNameActionPerformed(evt);
            }
        });
        txtPassName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassNameKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel2.setText("Flight Code");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel3.setText("Passport Number");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel4.setText("Gender");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel5.setText("Amount");

        txtFCode.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        txtPasspNo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtPasspNo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtPasspNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasspNoActionPerformed(evt);
            }
        });
        txtPasspNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasspNoKeyPressed(evt);
            }
        });

        btnBook.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnBook.setForeground(new java.awt.Color(0, 0, 255));
        btnBook.setText("Book");
        btnBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBookMouseClicked(evt);
            }
        });
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnReset.setForeground(new java.awt.Color(0, 0, 255));
        btnReset.setText("Reset");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnBack.setForeground(new java.awt.Color(0, 0, 255));
        btnBack.setText("Back");
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 36)); // NOI18N
        jLabel6.setText("Booking");

        BookingList.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BookingList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(BookingList);

        txtAmt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtAmt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtAmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmtActionPerformed(evt);
            }
        });
        txtAmt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAmtKeyPressed(evt);
            }
        });

        txtNat.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtNat.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtNat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNatActionPerformed(evt);
            }
        });
        txtNat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNatKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel7.setText("Nationality");

        txtPassId.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtPassId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPassIdMouseClicked(evt);
            }
        });
        txtPassId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassIdActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel8.setText("Passsenger Id");

        txtGen.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtGen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtGen.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                txtGenAncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        txtGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGenActionPerformed(evt);
            }
        });
        txtGen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGenKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(txtPassId, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txtPassName, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtFCode, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtGen, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPasspNo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(33, 33, 33)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(txtAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(txtNat, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)))
                .addContainerGap())
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(btnBook)
                .addGap(163, 163, 163)
                .addComponent(btnReset)
                .addGap(152, 152, 152)
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPasspNo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNat)
                                    .addComponent(txtPassName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtGen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPassId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(51, 51, 51)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBook)
                    .addComponent(btnReset)
                    .addComponent(btnBack))
                .addGap(36, 36, 36)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPassNameAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtPassNameAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassNameAncestorMoved

    private void txtPassNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassNameActionPerformed

    private void txtPassNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassNameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassNameKeyPressed

    private void txtPasspNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasspNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasspNoActionPerformed

    private void txtPasspNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasspNoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasspNoKeyPressed

    private void btnBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookMouseClicked
        // TODO add your handling code here:
        if(txtPassId.getSelectedIndex() == -1||txtFCode.getSelectedIndex() == -1||txtAmt.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Missing Information");

        }else{

            try{
                CountFlight();
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_db", "root", "");
                PreparedStatement Add = con.prepareStatement("INSERT INTO `booking_tb`(`TicketId`, `PName`, `FCode`, `PGen`, `PPassNo`, `Amount`, `Nationality`)  VALUES(?,?,?,?,?,?,?)");
                Add.setInt(1, txtTId);
                Add.setString(2, txtPassName.getText());
                Add.setString(3, txtFCode.getSelectedItem().toString());
                Add.setString(4, txtGen.getText());
                Add.setString(5, txtPasspNo.getText());
                Add.setInt(6, Integer.valueOf(txtAmt.getText()));
                Add.setString(7, txtNat.getText());
                int w = Add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Tcket Booked");
                con.close();
                DisplayBooking();
                Clear();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnBookMouseClicked

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBookActionPerformed

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        // TODO add your handling code here:

        Clear();
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        // TODO add your handling code here:

        new MainForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtAmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmtActionPerformed

    private void txtAmtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmtKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmtKeyPressed

    private void txtNatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNatActionPerformed

    private void txtNatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNatKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNatKeyPressed

    private void txtPassIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassIdMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassIdMouseClicked

    private void txtPassIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassIdActionPerformed
        // TODO add your handling code here:
        getPassInfo();
    }//GEN-LAST:event_txtPassIdActionPerformed

    private void txtGenAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtGenAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGenAncestorMoved

    private void txtGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGenActionPerformed

    private void txtGenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGenKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGenKeyPressed

    private void Clear(){

    txtFCode.setSelectedIndex(-1);
        //txtPassId.setSelectedIndex(-1);
        txtPassName.setText("");
        txtPasspNo.setText("");
        txtGen.setText("");
        txtNat.setText("");
        txtAmt.setText("");

}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Booking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BookingList;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTextField txtAmt;
    private javax.swing.JComboBox txtFCode;
    private javax.swing.JTextField txtGen;
    private javax.swing.JTextField txtNat;
    private javax.swing.JComboBox txtPassId;
    private javax.swing.JTextField txtPassName;
    private javax.swing.JTextField txtPasspNo;
    // End of variables declaration//GEN-END:variables
}
