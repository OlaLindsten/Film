package Filmer;

import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author olalindsten
 */
public class connection extends javax.swing.JFrame {

    /**
     * Creates new form connection
     */
    public connection() {
        initComponents();
        show_filmer();
        setTitle("Olas Filmdatabas");
    }

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/filmregister", "root", "");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Film> getFilmerList() {

        ArrayList<Film> filmerList = new ArrayList<Film>();
        Connection connection = getConnection();

        String query = "SELECT * FROM `filmer`";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Film film;
            while (rs.next()) {
                film = new Film(rs.getInt("id"), rs.getString("titel"), rs.getString("genre"), rs.getString("regissör"), rs.getString("betyg"), rs.getString("längd"));
                filmerList.add(film);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filmerList;
    }

    public void show_filmer() {

        ArrayList<Film> list = getFilmerList();
        DefaultTableModel model = (DefaultTableModel) Jtabel.getModel();
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {

            row[0] = list.get(i).getId();
            row[1] = list.get(i).getTitel();
            row[2] = list.get(i).getGenre();
            row[3] = list.get(i).getRegissör();
            row[4] = list.get(i).getBetyg();
            row[5] = list.get(i).getLängd();

            model.addRow(row);
        }
    }

    //excute query
    public void executeSQLQuery(String query, String message) {
        Connection conn = getConnection();
        Statement st;

        try {
            st = conn.createStatement();
            if ((st.executeUpdate(query)) == 1) {

                DefaultTableModel model = (DefaultTableModel) Jtabel.getModel();
                model.setRowCount(0);
                show_filmer();
                JOptionPane.showMessageDialog(null, "Data " + message + " Lyckades");
                //Rensa text fälten
                text_titel.setText("");
                text_genre.setText("");
                text_regissor.setText("");
                text_betyg.setText("");
                text_langd.setText("");
            } else {

                JOptionPane.showMessageDialog(null, "Datan togs inte bort " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        Jtabel = new javax.swing.JTable();
        text_titel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Jtitel = new javax.swing.JLabel();
        jgenre = new javax.swing.JLabel();
        jregissor = new javax.swing.JLabel();
        jbetyg = new javax.swing.JLabel();
        jlangd = new javax.swing.JLabel();
        Juppdatera = new javax.swing.JButton();
        spara = new javax.swing.JButton();
        jRensa = new javax.swing.JButton();
        jta_bort = new javax.swing.JButton();
        text_genre = new javax.swing.JTextField();
        text_regissor = new javax.swing.JTextField();
        text_betyg = new javax.swing.JTextField();
        text_langd = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Olas filmdatabas");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(480, 6, 210, 30);

        Jtabel.setAutoCreateRowSorter(true);
        Jtabel.setBackground(new java.awt.Color(0, 0, 0));
        Jtabel.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Jtabel.setForeground(new java.awt.Color(240, 240, 240));
        Jtabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Titel", "Genre", "Regissör", "Betyg", "Längd"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Jtabel.setFocusable(false);
        Jtabel.setGridColor(new java.awt.Color(255, 0, 0));
        Jtabel.setSelectionBackground(new java.awt.Color(255, 255, 255));
        Jtabel.setSelectionForeground(new java.awt.Color(0, 0, 0));
        Jtabel.setSurrendersFocusOnKeystroke(true);
        Jtabel.getTableHeader().setReorderingAllowed(false);
        Jtabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtabelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Jtabel);
        if (Jtabel.getColumnModel().getColumnCount() > 0) {
            Jtabel.getColumnModel().getColumn(0).setResizable(false);
            Jtabel.getColumnModel().getColumn(0).setPreferredWidth(20);
            Jtabel.getColumnModel().getColumn(1).setResizable(false);
            Jtabel.getColumnModel().getColumn(1).setPreferredWidth(170);
            Jtabel.getColumnModel().getColumn(2).setResizable(false);
            Jtabel.getColumnModel().getColumn(2).setPreferredWidth(80);
            Jtabel.getColumnModel().getColumn(3).setResizable(false);
            Jtabel.getColumnModel().getColumn(3).setPreferredWidth(90);
            Jtabel.getColumnModel().getColumn(4).setResizable(false);
            Jtabel.getColumnModel().getColumn(4).setPreferredWidth(80);
            Jtabel.getColumnModel().getColumn(5).setResizable(false);
            Jtabel.getColumnModel().getColumn(5).setPreferredWidth(50);
        }
        Jtabel.getAccessibleContext().setAccessibleDescription("");

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(116, 50, 844, 392);

        text_titel.setSelectedTextColor(new java.awt.Color(0, 0, 255));
        text_titel.setSelectionColor(new java.awt.Color(153, 153, 153));
        text_titel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_titelActionPerformed(evt);
            }
        });
        jPanel1.add(text_titel);
        text_titel.setBounds(1130, 114, 146, 32);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Filmer/bio.jpg"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(1170, 610));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 1010, 570);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(null);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Lägg till en film");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(70, 30, 190, 30);

        Jtitel.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        Jtitel.setForeground(new java.awt.Color(255, 255, 255));
        Jtitel.setText("Title");
        jPanel2.add(Jtitel);
        Jtitel.setBounds(28, 116, 80, 28);

        jgenre.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        jgenre.setForeground(new java.awt.Color(255, 255, 255));
        jgenre.setText("Genre");
        jPanel2.add(jgenre);
        jgenre.setBounds(28, 178, 80, 28);

        jregissor.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        jregissor.setForeground(new java.awt.Color(255, 255, 255));
        jregissor.setText("Regissör");
        jPanel2.add(jregissor);
        jregissor.setBounds(30, 238, 80, 28);

        jbetyg.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        jbetyg.setForeground(new java.awt.Color(255, 255, 255));
        jbetyg.setText("Betyg");
        jPanel2.add(jbetyg);
        jbetyg.setBounds(32, 298, 70, 28);

        jlangd.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        jlangd.setForeground(new java.awt.Color(255, 255, 255));
        jlangd.setText("Längd");
        jPanel2.add(jlangd);
        jlangd.setBounds(32, 358, 80, 28);

        Juppdatera.setBackground(new java.awt.Color(255, 255, 255));
        Juppdatera.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Juppdatera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Filmer/update.png"))); // NOI18N
        Juppdatera.setText(" Uppdatera");
        Juppdatera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JuppdateraActionPerformed(evt);
            }
        });
        jPanel2.add(Juppdatera);
        Juppdatera.setBounds(22, 500, 134, 33);

        spara.setBackground(new java.awt.Color(255, 255, 255));
        spara.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        spara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Filmer/add.png"))); // NOI18N
        spara.setText(" Lägg till");
        spara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sparaActionPerformed(evt);
            }
        });
        jPanel2.add(spara);
        spara.setBounds(22, 444, 134, 33);

        jRensa.setBackground(new java.awt.Color(255, 255, 255));
        jRensa.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jRensa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Filmer/clear.png"))); // NOI18N
        jRensa.setText(" Rensa");
        jRensa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRensaActionPerformed(evt);
            }
        });
        jPanel2.add(jRensa);
        jRensa.setBounds(172, 500, 134, 32);

        jta_bort.setBackground(new java.awt.Color(255, 255, 255));
        jta_bort.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jta_bort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Filmer/delete.png"))); // NOI18N
        jta_bort.setText(" Ta bort");
        jta_bort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jta_bortActionPerformed(evt);
            }
        });
        jPanel2.add(jta_bort);
        jta_bort.setBounds(172, 444, 134, 34);

        text_genre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_genreActionPerformed(evt);
            }
        });
        jPanel2.add(text_genre);
        text_genre.setBounds(130, 176, 146, 30);
        jPanel2.add(text_regissor);
        text_regissor.setBounds(132, 236, 146, 32);
        jPanel2.add(text_betyg);
        text_betyg.setBounds(132, 294, 144, 32);

        text_langd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_langdActionPerformed(evt);
            }
        });
        jPanel2.add(text_langd);
        text_langd.setBounds(132, 356, 144, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(1000, 0, 310, 570);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1314, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /*    */

    private void text_titelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_titelActionPerformed


    }//GEN-LAST:event_text_titelActionPerformed

    private void text_genreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_genreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_genreActionPerformed

    private void sparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sparaActionPerformed

        if (text_titel.getText().equals("")
                || text_genre.getText().equals("")
                || text_regissor.getText().equals("")
                || text_betyg.getText().equals("")
                || text_langd.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Var vänlig skriv i alla boxar");
        } else {
            String query = "INSERT INTO `filmer`(`titel`, `genre`, `regissör`, `betyg`, `längd`) "
                    + "VALUES ('" + text_titel.getText() + "','" + text_genre.getText() + "','" + text_regissor.getText() + "',"
                    + "'" + text_betyg.getText() + "','" + text_langd.getText() + "')";

            executeSQLQuery(query, "Inlagt");
        }
    }//GEN-LAST:event_sparaActionPerformed

    private void JtabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtabelMouseClicked

        int i = Jtabel.getSelectedRow();
        TableModel model = Jtabel.getModel();
        text_titel.setText(model.getValueAt(i, 1).toString());
        text_genre.setText(model.getValueAt(i, 2).toString());
        text_regissor.setText(model.getValueAt(i, 3).toString());
        text_betyg.setText(model.getValueAt(i, 4).toString());
        text_langd.setText(model.getValueAt(i, 5).toString());

    }//GEN-LAST:event_JtabelMouseClicked

    private void jta_bortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jta_bortActionPerformed

        int i = Jtabel.getSelectedRow();
        String id = Jtabel.getModel().getValueAt(i, 0).toString();
        String query = "delete from filmer where id = " + id;

        executeSQLQuery(query, "Borttagen");
    }//GEN-LAST:event_jta_bortActionPerformed

    private void JuppdateraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JuppdateraActionPerformed

        Connection conn = getConnection();

        int i = Jtabel.getSelectedRow();
        String id = Jtabel.getModel().getValueAt(i, 0).toString();

        String query = "UPDATE `filmer` SET `titel`='" + text_titel.getText() + "',`genre`='" + text_genre.getText()
                + "',`regissör`='" + text_regissor.getText() + "',`betyg`='" + text_betyg.getText()
                + "',`längd`='" + text_langd.getText() + "' WHERE `id`= " + id;

        executeSQLQuery(query, "Uppdaterad");

    }//GEN-LAST:event_JuppdateraActionPerformed

    private void jRensaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRensaActionPerformed

        //Rensa text fälten
        text_titel.setText("");
        text_genre.setText("");
        text_regissor.setText("");
        text_betyg.setText("");
        text_langd.setText("");

    }//GEN-LAST:event_jRensaActionPerformed

    private void text_langdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_langdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_langdActionPerformed

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
            java.util.logging.Logger.getLogger(connection.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(connection.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(connection.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(connection.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new connection().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Jtabel;
    private javax.swing.JLabel Jtitel;
    private javax.swing.JButton Juppdatera;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jRensa;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jbetyg;
    private javax.swing.JLabel jgenre;
    private javax.swing.JLabel jlangd;
    private javax.swing.JLabel jregissor;
    private javax.swing.JButton jta_bort;
    private javax.swing.JButton spara;
    private javax.swing.JTextField text_betyg;
    private javax.swing.JTextField text_genre;
    private javax.swing.JTextField text_langd;
    private javax.swing.JTextField text_regissor;
    private javax.swing.JTextField text_titel;
    // End of variables declaration//GEN-END:variables
}
