package bloodbank;


import static bloodbank.BloodBank.con;
import bloodbank.HomePage;
import bloodbank.UserRecipient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author acer
 */
public class RecipientDetails extends javax.swing.JFrame {

    /**
     * Creates new form RecipientDetails
     */
    
    public RecipientDetails() {
        initComponents();
        showUserRecipient();
        
    }
    
    public ArrayList<UserRecipient>userRecipientList(){
            ArrayList<UserRecipient>userRecipientList = new ArrayList<> ();
            
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://localhost:1433;databaseName=BLOOD_BANK_MANAGEMENT_SYSTEM;user=sa;password=12345";
        
                Connection connection = DriverManager.getConnection(url);
                String queryR = "SELECT * FROM Recipient ";
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(queryR);
                UserRecipient userrecipient;
                while(rs.next()){
                    userrecipient = new UserRecipient(rs.getInt("recipient_ID"), rs.getString("recipient_name"), rs.getString("recipient_age"), rs.getString("recipient_gender"), rs.getString("recipient_Bloodgroup"), rs.getString("recipient_Bloodquantity"), rs.getString("City_ID"), rs.getString("staff_ID"), rs.getString("recipient_reg_date"));
                    userRecipientList.add(userrecipient);
                }
                
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex);
            }
            return userRecipientList;
        }
    public void showUserRecipient(){
        ArrayList<UserRecipient> list = userRecipientList();
        DefaultTableModel model= (DefaultTableModel) receipient_table.getModel();
        Object[] row = new Object[9];
        for(int i=0; i<list.size(); i++){
            row[0]=list.get(i).getrecipient_ID();
            row[1]=list.get(i).getrecipient_name();
            row[2]=list.get(i).getrecipient_age();
            row[3]=list.get(i).getrecipient_gender();
            row[4]=list.get(i).getrecipient_Bloodgroup();
            row[5]=list.get(i).getrecipient_Bloodquantity();
            row[6]=list.get(i).getCity_ID();
            row[7]=list.get(i).getstaff_ID();
            row[8]=list.get(i).getrecipient_reg_date();
            model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        receipient_table = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        btn_asc = new javax.swing.JButton();
        btn_dsec = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Algerian", 1, 32)); // NOI18N
        jLabel2.setText("All Receipient Details");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(340, 20, 460, 50);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(0, 70, 1040, 10);

        receipient_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Age", "Gender", "Blood Group", "Blood Quantity", "City ID", "Staff ID", "Registration Date"
            }
        ));
        jScrollPane1.setViewportView(receipient_table);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(22, 92, 1000, 380);
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(0, 490, 1040, 10);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 51, 51));
        jButton1.setText("Back to Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(50, 23, 160, 40);

        btn_asc.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btn_asc.setForeground(new java.awt.Color(255, 0, 0));
        btn_asc.setText("Sort Blood Quantity in Ascending Order");
        btn_asc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ascActionPerformed(evt);
            }
        });
        jPanel2.add(btn_asc);
        btn_asc.setBounds(60, 500, 330, 50);

        btn_dsec.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        btn_dsec.setForeground(new java.awt.Color(255, 0, 0));
        btn_dsec.setText("Sort Blood Quantity in descending Order");
        btn_dsec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dsecActionPerformed(evt);
            }
        });
        jPanel2.add(btn_dsec);
        btn_dsec.setBounds(430, 500, 360, 50);

        btn_delete.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 0, 0));
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel2.add(btn_delete);
        btn_delete.setBounds(850, 500, 150, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/DDForm.jpg"))); // NOI18N
        jLabel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jLabel1ComponentShown(evt);
            }
        });
        jPanel2.add(jLabel1);
        jLabel1.setBounds(1, -4, 1040, 570);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1041, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel1ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1ComponentShown

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        HomePage hp = new HomePage();
        hp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_ascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ascActionPerformed
        // TODO add your handling code here:
         DefaultTableModel model= (DefaultTableModel) receipient_table.getModel();
          model.setRowCount(0);
        try{
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=BLOOD_BANK_MANAGEMENT_SYSTEM;user=sa;password=12345";
        
        con = DriverManager.getConnection(url);
            
          
            String query="";
           
            query="SELECT * FROM Recipient Order by recipient_Bloodquantity asc ";
            
            
            System.out.println(query);
            PreparedStatement pst=con.prepareStatement(query);
        //    pst.setString(1, textFieldSearch.getText());
            ResultSet rs=pst.executeQuery();
           while(rs.next()) {
               String s[]={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)};
              model.addRow(s);
           }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_btn_ascActionPerformed

    private void btn_dsecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dsecActionPerformed
        // TODO add your handling code here:
              DefaultTableModel model= (DefaultTableModel) receipient_table.getModel();
          model.setRowCount(0);
        try{
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=BLOOD_BANK_MANAGEMENT_SYSTEM;user=sa;password=12345";
        
        con = DriverManager.getConnection(url);
            
          
            String query="";
           
            query="SELECT * FROM Recipient Order by recipient_Bloodquantity desc";
            
            
            System.out.println(query);
            PreparedStatement pst=con.prepareStatement(query);
        //    pst.setString(1, textFieldSearch.getText());
            ResultSet rs=pst.executeQuery();
           while(rs.next()) {
               String s[]={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)};
              model.addRow(s);
           }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_btn_dsecActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=BLOOD_BANK_MANAGEMENT_SYSTEM;user=sa;password=12345";
        
        con = DriverManager.getConnection(url);
        int row =receipient_table.getSelectedRow();
        String value = (receipient_table.getModel().getValueAt(row, 0).toString());
        String query1 = "DELETE FROM Recipient where recipient_ID="+value;
        PreparedStatement pst = con.prepareStatement(query1);
        pst.executeUpdate();
        DefaultTableModel model = (DefaultTableModel)receipient_table.getModel();
        model.setRowCount(0);
        
     showUserRecipient();
        JOptionPane.showMessageDialog(null,"Deleted Successfully");
        
         }
         catch(Exception e){
        
        JOptionPane.showMessageDialog(null,e);        
        }

    
    }//GEN-LAST:event_btn_deleteActionPerformed

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
            java.util.logging.Logger.getLogger(RecipientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecipientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecipientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecipientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecipientDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_asc;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_dsec;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable receipient_table;
    // End of variables declaration//GEN-END:variables
}
