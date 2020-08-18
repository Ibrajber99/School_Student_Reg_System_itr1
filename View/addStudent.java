/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * this form is for adding a new student to the table very user friendly UI
 */
public class addStudent extends javax.swing.JFrame {

    /**
     * Creates new form addStudent
     */
    DataBase db = new DataBase();
    ImageIntializer ig = new ImageIntializer();
    ButtonGroup progGroup = new ButtonGroup();
    ButtonGroup genderGroup = new ButtonGroup();
    String userName_ = "";
    String passWord_ = "";

    private addStudent() {
        initComponents();
    }

    public addStudent(String userName, String passWord) {
        initComponents();
        setAssests();
        this.setResizable(false);
        String path = db.adminImg(userName, passWord);
        ImageIcon img = new ImageIcon(path);
        imgLogo.setIcon(img);
        this.passWord_ = passWord;
        this.userName_ = userName;
        adminNameLbl.setText(this.userName_);
        this.setTitle("Add Student");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fNameLbl = new javax.swing.JLabel();
        lNameLbl = new javax.swing.JLabel();
        DOBLbl = new javax.swing.JLabel();
        femaleBtn = new javax.swing.JRadioButton();
        buissBtn = new javax.swing.JRadioButton();
        gpaLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        maleBtn = new javax.swing.JRadioButton();
        csBtn = new javax.swing.JRadioButton();
        bioBtn = new javax.swing.JRadioButton();
        genderLbl = new javax.swing.JLabel();
        GPATxt = new javax.swing.JTextField();
        fNameTxt = new javax.swing.JTextField();
        lNameTxt = new javax.swing.JTextField();
        DOBTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        submitBtn = new javax.swing.JButton();
        dashBoardBtn = new javax.swing.JButton();
        imgLogo = new javax.swing.JLabel();
        adminNameLbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        backgroundLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fNameLbl.setText("First name: ");
        getContentPane().add(fNameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 70, 30));

        lNameLbl.setText("Last Name:");
        getContentPane().add(lNameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 90, 30));

        DOBLbl.setText("DOB: ");
        getContentPane().add(DOBLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 40, 30));

        femaleBtn.setText("Female");
        getContentPane().add(femaleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        buissBtn.setText("Bussiness");
        getContentPane().add(buissBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, -1, -1));

        gpaLbl.setText("GPA: ");
        getContentPane().add(gpaLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 70, 40));

        jLabel1.setText("Program");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 70, 40));

        maleBtn.setText("Male");
        getContentPane().add(maleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, -1, -1));

        csBtn.setText("CS");
        getContentPane().add(csBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, -1));

        bioBtn.setText("Bio");
        getContentPane().add(bioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, -1));

        genderLbl.setText("Gender");
        getContentPane().add(genderLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 60, 20));

        GPATxt.setBorder(null);
        getContentPane().add(GPATxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 150, 20));

        fNameTxt.setBorder(null);
        getContentPane().add(fNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 150, 20));

        lNameTxt.setBorder(null);
        getContentPane().add(lNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 150, 20));

        DOBTxt.setBorder(null);
        getContentPane().add(DOBTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 150, 20));

        jLabel2.setText("1.1 - 4.0");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 120, 20));

        jLabel4.setText("Format: DD/MM/YY");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 120, 20));

        submitBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        getContentPane().add(submitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 130, 50));

        dashBoardBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dashBoardBtn.setText("Dashboard");
        dashBoardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashBoardBtnActionPerformed(evt);
            }
        });
        getContentPane().add(dashBoardBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 130, 50));

        imgLogo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        getContentPane().add(imgLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 234, 220));

        adminNameLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        adminNameLbl.setText("d");
        getContentPane().add(adminNameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 150, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("ADMIN:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 60, 30));
        getContentPane().add(backgroundLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        // TODO add your handling code here:
        if (checkAllFields()) {
            Student s = new Student();
            s.setFirstName(fNameTxt.getText());
            s.setLastName(lNameTxt.getText());
            s.setDOB(DOBTxt.getText());
            if (maleBtn.isSelected()) {
                s.setGender("M");
            } else {
                s.setGender("F");
            }

            if (csBtn.isSelected()) {
                s.setProgram("CS");
            } else if (bioBtn.isSelected()) {
                s.setProgram("Bio");
            } else {
                s.setProgram("Buiss");
            }
            s.setGPA(Float.parseFloat(GPATxt.getText()));
            if (db.insertNewStudent(s)) {
                JOptionPane.showMessageDialog(null, "Student Has been  successfully Added");
                reSetAssests();
            }

        } else {
            JOptionPane.showMessageDialog(null, "One or More of the fields is Empty or out of Format");
        }
    }//GEN-LAST:event_submitBtnActionPerformed

    private void dashBoardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashBoardBtnActionPerformed
        // TODO add your handling code here:
        new adminHomePage(this.userName_, this.passWord_).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_dashBoardBtnActionPerformed

    private void reSetAssests() {
        maleBtn.setSelected(false);
        maleBtn.setEnabled(false);

        femaleBtn.setSelected(false);
        femaleBtn.setEnabled(false);

        csBtn.setSelected(false);
        bioBtn.setSelected(false);
        buissBtn.setSelected(false);

        fNameTxt.setText("");

        lNameTxt.setText("");

        DOBTxt.setText("");

        GPATxt.setText("");
    }

    private boolean checkAllFields() {
        return (csBtn.isSelected() || buissBtn.isSelected() || bioBtn.isSelected())
                && (maleBtn.isSelected() || femaleBtn.isSelected())
                && (checkTextFields() && validateGPA() && validateDateFormat());
    }

    private boolean checkTextFields() {
        return !fNameTxt.getText().isEmpty() && !lNameTxt.getText().isEmpty()
                && !GPATxt.getText().isEmpty() && !DOBTxt.getText().isEmpty();
    }

    private boolean validateGPA() {
        System.out.println(Float.parseFloat(GPATxt.getText()));
        return Float.parseFloat(GPATxt.getText()) > 1.0
                && Float.parseFloat(GPATxt.getText()) <= 4.0;
    }

    private boolean validateDateFormat() {

        String strDate = DOBTxt.getText();

        if (strDate.trim().equals("")) {
            return true;
        } /* Date is not 'null' */ else {
            /*
	     * Set preferred date format,
	     * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
            SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
            sdfrmt.setLenient(false);
            /* Create Date object
	     * parse the string into date 
             */
            try {
                Date javaDate = sdfrmt.parse(strDate);
                System.out.println(strDate + " is valid date format");
            } /* Date format is invalid */ catch (ParseException e) {
                System.out.println(strDate + " is Invalid Date format");
                return false;
            }
            /* Return true if date format is valid */
            return true;
        }
    }
    

    private void setAssests() {
        progGroup.add(csBtn);
        progGroup.add(bioBtn);
        progGroup.add(buissBtn);

        genderGroup.add(femaleBtn);
        genderGroup.add(maleBtn);
        ig.setImage("images/adminHomePage.png", backgroundLbl);
        ig.setImage("images/home-run.png", dashBoardBtn);
        ig.setImage("images/correct.png", submitBtn);

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
            java.util.logging.Logger.getLogger(addStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DOBLbl;
    private javax.swing.JTextField DOBTxt;
    private javax.swing.JTextField GPATxt;
    private javax.swing.JLabel adminNameLbl;
    private javax.swing.JLabel backgroundLbl;
    private javax.swing.JRadioButton bioBtn;
    private javax.swing.JRadioButton buissBtn;
    private javax.swing.JRadioButton csBtn;
    private javax.swing.JButton dashBoardBtn;
    private javax.swing.JLabel fNameLbl;
    private javax.swing.JTextField fNameTxt;
    private javax.swing.JRadioButton femaleBtn;
    private javax.swing.JLabel genderLbl;
    private javax.swing.JLabel gpaLbl;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lNameLbl;
    private javax.swing.JTextField lNameTxt;
    private javax.swing.JRadioButton maleBtn;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
}