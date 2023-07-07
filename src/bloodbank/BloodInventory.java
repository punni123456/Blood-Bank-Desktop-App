/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbank;

import static bloodbank.BloodBank.con;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class BloodInventory extends javax.swing.JFrame {

    /**
     * Creates new form BloodInventory
     */
    public BloodInventory() {
        initComponents();
        show_user();
    }
    
        public ArrayList<User1> userList(){
        ArrayList<User1> userList =new ArrayList<>();
         try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=BLOOD_BANK_MANAGEMENT_SYSTEM;user=sa;password=12345";
        
        Connection con = DriverManager.getConnection(url);
        String query1 = "SELECT  * FROM BloodInventory";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query1);
        User1 user1;
        while(rs.next()){
            user1=new User1(rs.getInt("BagNumber"),rs.getInt("QuantityAvailable"),rs.getString("RedBloodCells"),rs.getString("WhiteBloodCells"),rs.getString("Platelets"),rs.getString("Plasma"),rs.getString("Heamoglobin"),rs.getInt("donorID"));
            userList.add(user1);
        
        }
        
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null,ex);
 
           

         }
         return userList;
    }
    
        public void show_user(){
        ArrayList<User1> list= userList();
        DefaultTableModel model = (DefaultTableModel)jTable1_Display_user1.getModel();
        Object[] row =new Object[8];
        
        for(int i=0;i<list.size();i++){
        
        row[0]=list.get(i).getBagNumber();
        row[1]=list.get(i).getQuantityAvailable();
        row[2]=list.get(i).getRedBloodCells();
        row[3]=list.get(i).getWhiteBloodCells();
        row[4]=list.get(i).getPlatelets();
        row[5]=list.get(i).getPlasma();
        row[6]=list.get(i).getHeamoglobin();
        row[7]=list.get(i).getDonorID();
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_Display_user1 = new javax.swing.JTable();
        back = new javax.swing.JButton();
        btn_max = new javax.swing.JButton();
        txt_max = new javax.swing.JTextField();
        btn_delete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1133, 599));

        jPanel1.setPreferredSize(new java.awt.Dimension(1047, 569));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Blood Inventory");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(358, 13, 409, 81);

        jTable1_Display_user1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BagNumber", "QuantityAvailable", "RedBloodCells", "WhiteBloodCells", "Platelets", "Plasma", "Heamoglobin", "donorID"
            }
        ));
        jScrollPane1.setViewportView(jTable1_Display_user1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 90, 1040, 400);

        back.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        back.setForeground(new java.awt.Color(255, 0, 0));
        back.setText("Back to Menu");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back);
        back.setBounds(40, 20, 195, 54);

        btn_max.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        btn_max.setForeground(new java.awt.Color(255, 0, 0));
        btn_max.setText("Highest Bag Quantity");
        btn_max.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_maxActionPerformed(evt);
            }
        });
        jPanel1.add(btn_max);
        btn_max.setBounds(120, 530, 290, 50);
        jPanel1.add(txt_max);
        txt_max.setBounds(440, 530, 150, 50);

        btn_delete.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 0, 0));
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel1.add(btn_delete);
        btn_delete.setBounds(820, 530, 140, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/DDForm.jpg"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(-7, -10, 1140, 610);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1125, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        HomePage h = new HomePage();
        h.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void btn_maxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_maxActionPerformed
        // TODO add your handling code here:
          try{
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=BLOOD_BANK_MANAGEMENT_SYSTEM;user=sa;password=12345";
        
        con = DriverManager.getConnection(url);
            
          
            //String query="";
           
          String query="SELECT MAX(QuantityAvailable) 'MAX(QuantityAvailable)' FROM BloodInventory  ";
            
          
            
             
           // System.out.println(query);
            PreparedStatement pst=con.prepareStatement(query);
        //pst.setString(1, textFieldSearch.getText());
         ResultSet rs=pst.executeQuery();
         
         if(rs.next()){
         String sum=rs.getString("MAX(QuantityAvailable)");
         txt_max.setText(sum);
         }
         
          /* while(rs.next()) 
               String s[]={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)};
              model.addRow(s);
           }*/
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_btn_maxActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=BLOOD_BANK_MANAGEMENT_SYSTEM;user=sa;password=12345";
        
        con = DriverManager.getConnection(url);
        int row =jTable1_Display_user1.getSelectedRow();
        String value = (jTable1_Display_user1.getModel().getValueAt(row, 0).toString());
        String query1 = "DELETE FROM BloodInventory where BagNumber="+value;
        PreparedStatement pst = con.prepareStatement(query1);
        pst.executeUpdate();
        DefaultTableModel model = (DefaultTableModel)jTable1_Display_user1.getModel();
        model.setRowCount(0);
        
    show_user();
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
            java.util.logging.Logger.getLogger(BloodInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BloodInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BloodInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BloodInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BloodInventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_max;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1_Display_user1;
    private javax.swing.JTextField txt_max;
    // End of variables declaration//GEN-END:variables
}
