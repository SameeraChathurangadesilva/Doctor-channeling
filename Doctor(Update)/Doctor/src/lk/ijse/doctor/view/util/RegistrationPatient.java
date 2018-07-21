/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.view.util;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import lk.ijse.doctor.common.Validations;
import lk.ijse.doctor.controller.ControllerFactory;
import lk.ijse.doctor.controller.custom.RegistrationController;
import lk.ijse.doctor.dto.RegistrationDTO;
import lk.ijse.doctor.idgenerator.IdGenerator;

/**
 *
 * @author sameera
 */
public class RegistrationPatient extends javax.swing.JPanel {
    
    private RegistrationController ctrlRegistration;
    private DefaultTableModel dtmRegistration;
    private String gender;

    /**
     * Creates new form RegistrationPatient
     */
    public RegistrationPatient() {
        initComponents();
        ctrlRegistration = (RegistrationController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.REGISTRATION);
        dtmRegistration = (DefaultTableModel) tblRegistration.getModel();
        loadData();
        //setEnable(false);
        handEvent();
    }
    
    private void handEvent() {
        
        tblRegistration.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tblRegistration.getSelectedRowCount() <= 0) {
                    return;
                }
                String rgid = dtmRegistration.getValueAt(tblRegistration.getSelectedRow(), 0).toString();
                
                try {
                    RegistrationDTO registration = ctrlRegistration.search(rgid);
                    
                    if (registration != null) {
                        txtRegistrationId.setText(registration.getRgid());
                        txtRegistrationName.setText(registration.getName());
                        txtRegistrationAddress.setText(registration.getAddress());
                        cmbGender.setSelectedItem(registration.getGender());
                        txtNic.setText(registration.getNic());
                        txtAge.setText("" + registration.getAge());
                        txtTelephoneNo.setText("" + registration.getTeleno());
                        setEnable(true, btnSave, txtRegistrationId);
                    }
                    
                    
                } catch (Exception ex) {
                    Logger.getLogger(RegistrationPatient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }
    
    private void loadData() {
        
        try {
            dtmRegistration.setRowCount(0);
            ArrayList<RegistrationDTO> registrationDTOs = ctrlRegistration.getAll();
            for (RegistrationDTO registration : registrationDTOs) {
                Object[] rowdata = {
                    
                    registration.getRgid(),
                    registration.getName(),
                    registration.getAddress(),
                    registration.getGender(),
                    registration.getNic(),
                    registration.getAge(),
                    registration.getTeleno()};
                dtmRegistration.addRow(rowdata);
                
            }
        } catch (Exception ex) {
            Logger.getLogger(RegistrationPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void clearField() {
        txtRegistrationId.setText("");
        txtRegistrationName.setText("");
        txtRegistrationAddress.setText("");
        cmbGender.setSelectedItem("");
        txtNic.setText("");
        txtAge.setText("");
        txtTelephoneNo.setText("");
    }
    
    private void setEnable(boolean enable, JComponent... cmp) {
        txtRegistrationId.setEnabled(enable);
        txtRegistrationName.setEnabled(enable);
        txtRegistrationAddress.setEnabled(enable);
        cmbGender.setEnabled(enable);
        txtNic.setEnabled(enable);
        txtAge.setEnabled(enable);
        txtTelephoneNo.setEnabled(enable);
        btnSave.setEnabled(enable);
        btnDelete.setEnabled(enable);
        for (JComponent jcmp : cmp) {
            jcmp.setEnabled(!enable);
        }
    }
    
    private void doValidata() {
        String rgid = txtRegistrationId.getText();
        String name = txtRegistrationName.getText();
        String address = txtRegistrationAddress.getText();
        String gender = (String) cmbGender.getSelectedItem();
        String nic = txtNic.getText();
        String age = txtAge.getText();
        String teleno = txtTelephoneNo.getText();
        
        btnSave.setEnabled(false);
        
        if (!rgid.isEmpty()) {
            if (name.matches("[A-Za-z ]+")) {
                if (!address.isEmpty()) {
                    if (!gender.isEmpty()) {
                        if (nic.matches("\\d{9}[V]")) {
                            if (!age.isEmpty()) {
                                if (teleno.matches("\\d{10}")) {
                                    btnSave.setEnabled(true);
                                }
                            }
                        }
                    }
                }
            }
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

        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtRegistrationId = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtRegistrationName = new javax.swing.JTextField();
        txtRegistrationAddress = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cmbGender = new javax.swing.JComboBox();
        txtNic = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTelephoneNo = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnNewRegistation = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistration = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setText("Registration Patient");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 230, 28));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Registration Id:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 110, 30));

        txtRegistrationId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRegistrationIdKeyReleased(evt);
            }
        });
        add(txtRegistrationId, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 190, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Patient Name :");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 110, 30));

        txtRegistrationName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRegistrationNameActionPerformed(evt);
            }
        });
        txtRegistrationName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRegistrationNameKeyReleased(evt);
            }
        });
        add(txtRegistrationName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 190, 30));

        txtRegistrationAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRegistrationAddressKeyReleased(evt);
            }
        });
        add(txtRegistrationAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 190, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Patient Address :");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 110, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Gender :");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 110, 30));

        cmbGender.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "FeMale" }));
        cmbGender.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cmbGenderKeyReleased(evt);
            }
        });
        add(cmbGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 190, 30));

        txtNic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNicKeyReleased(evt);
            }
        });
        add(txtNic, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 190, 30));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("NIC :");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 110, 30));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("Age :");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 110, 30));

        txtAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAgeKeyReleased(evt);
            }
        });
        add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 190, 30));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setText("Telephone No :");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 110, 30));

        txtTelephoneNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelephoneNoActionPerformed(evt);
            }
        });
        txtTelephoneNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelephoneNoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelephoneNoKeyReleased(evt);
            }
        });
        add(txtTelephoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 190, 30));
        add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 190, 30));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setText("Registration Id:");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 110, 30));

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 160, 30));

        btnNewRegistation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNewRegistation.setText("New Registration");
        btnNewRegistation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRegistationActionPerformed(evt);
            }
        });
        add(btnNewRegistation, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 75, 160, 30));

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, 160, 30));

        tblRegistration.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblRegistration.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Registration Id", "Patient Name", "Patient Address", "Gender", "Nic", "Age", "Tele no"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRegistration.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblRegistration.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblRegistration);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 720, 390));
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewRegistationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRegistationActionPerformed
        clearField();
        
        if (dtmRegistration.getRowCount() > 0) {
            tblRegistration.getSelectionModel().clearSelection();
        }
        
        setEnable(true, btnSave, btnDelete);
        txtRegistrationId.requestFocusInWindow();
        
        try {
            String id =IdGenerator.getNewRegistrationIds("Registration", "rgid", "R");
            txtRegistrationId.setText(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistrationPatient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNewRegistationActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String rgid = txtRegistrationId.getText();
        String name = txtRegistrationName.getText();
        String address = txtRegistrationAddress.getText();
        if (cmbGender.getSelectedItem().equals("Male")) {
            gender = "Male";
        }
        if (cmbGender.getSelectedItem().equals("FeMale")) {
            gender = "FeMale";
        }
        String nic = txtNic.getText();
        int age = Integer.parseInt(txtAge.getText());
        int teleno = Integer.parseInt(txtTelephoneNo.getText());
        //setEnable(true, btnSave, txtRegistrationId);
        RegistrationDTO registration = new RegistrationDTO(rgid, name, address, gender, nic, age, teleno);
        
        try {
            
            boolean result = false;
            
            if (txtRegistrationId.isEnabled()) {
                result = ctrlRegistration.add(registration);
            } else {
                result = ctrlRegistration.update(registration);
            }
            if (result) {
                loadData();
                clearField();
                //setEnable(false);
                btnNewRegistation.requestFocusInWindow();
            } else {
                ImageIcon icons = new ImageIcon(this.getClass().getResource("/lk/ijse/doctor/icons/error_icon.png"));
                JOptionPane.showMessageDialog(this,
                        "Registration has  been fail to add",
                        "Error",
                        JOptionPane.ERROR_MESSAGE,
                        icons);
                txtRegistrationId.requestFocusInWindow();
                txtRegistrationId.selectAll();
            }
        } catch (SQLException ex) {
            
            String errormsg;
            
            ImageIcon icons = new ImageIcon(this.getClass().getResource("/lk/ijse/doctor/icons/error_icon.png"));
            
            switch (ex.getErrorCode()) {
                case 1062:
                    errormsg = "Duplicate entry has been found. Please enter valid Registration Id to proceed.";
                    break;
                default:
                    errormsg = "Registration has been failed to add";
                    break;
            }
            JOptionPane.showMessageDialog(this,
                    errormsg,
                    "Error",
                    JOptionPane.ERROR_MESSAGE,
                    icons);
            txtRegistrationId.requestFocusInWindow();
            txtRegistrationId.selectAll();
            
        } catch (Exception ex) {
            
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtRegistrationIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRegistrationIdKeyReleased
        doValidata();
    }//GEN-LAST:event_txtRegistrationIdKeyReleased

    private void txtRegistrationNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRegistrationNameKeyReleased
        //doValidata();
        //if(evt.getKeyCode()==KeyEvent.VK_BACK_SPACE){
            Validations.name(txtRegistrationName);
        //}
        
    }//GEN-LAST:event_txtRegistrationNameKeyReleased

    private void txtRegistrationAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRegistrationAddressKeyReleased
        doValidata();
        
        //Validations.name(txtRegistrationAddress);
    }//GEN-LAST:event_txtRegistrationAddressKeyReleased

    private void cmbGenderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbGenderKeyReleased
        doValidata();
    }//GEN-LAST:event_cmbGenderKeyReleased

    private void txtNicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNicKeyReleased
        doValidata();
        
       //Validations.validateNIC(txtNic);
    }//GEN-LAST:event_txtNicKeyReleased

    private void txtAgeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgeKeyReleased
        //doValidata();
        
        //Validation.
    }//GEN-LAST:event_txtAgeKeyReleased

    private void txtTelephoneNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelephoneNoKeyReleased
        //doValidata();
        Validations.phoneNumber(txtTelephoneNo, evt);
        
    }//GEN-LAST:event_txtTelephoneNoKeyReleased

    private void txtTelephoneNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelephoneNoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_BACK_SPACE){
            btnSave.doClick();
        }

    }//GEN-LAST:event_txtTelephoneNoKeyPressed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String rgid = dtmRegistration.getValueAt(tblRegistration.getSelectedRow(), 0).toString();
        
        try {
            boolean deleted = ctrlRegistration.delete(rgid);
            if (deleted) {
                loadData();
                clearField();
                setEnable(false);
                tblRegistration.clearSelection();
                btnNewRegistation.requestFocusInWindow();
            } else {
                ImageIcon icons = new ImageIcon(this.getClass().getResource("/lk/ijse/doctor/icons/error_icon.png"));
                JOptionPane.showMessageDialog(this,
                        "Registration deletion has been failed,please try again.",
                        "Delete Error",
                        JOptionPane.ERROR_MESSAGE,
                        icons);
            }
        } catch (Exception ex) {
            ImageIcon icons = new ImageIcon(this.getClass().getResource("/lk/ijse/doctor/icons/error_icon.png"));
            JOptionPane.showMessageDialog(this,
                    "Registration deletion has been failed,please try again.",
                    "Delete Error",
                    JOptionPane.ERROR_MESSAGE,
                    icons);
            Logger.getLogger(RegistrationPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtTelephoneNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelephoneNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelephoneNoActionPerformed

    private void txtRegistrationNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRegistrationNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRegistrationNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNewRegistation;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbGender;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTable tblRegistration;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtNic;
    private javax.swing.JTextField txtRegistrationAddress;
    private javax.swing.JTextField txtRegistrationId;
    private javax.swing.JTextField txtRegistrationName;
    private javax.swing.JTextField txtTelephoneNo;
    // End of variables declaration//GEN-END:variables
}
