/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.view.util;

import com.jidesoft.swing.AutoCompletion;
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
import lk.ijse.doctor.controller.ControllerFactory;
import lk.ijse.doctor.controller.custom.PatientController;
import lk.ijse.doctor.dto.PatientDTO;
import lk.ijse.doctor.dto.RegistrationDTO;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author sameera
 */
public class ManagePatient extends javax.swing.JPanel {

    private PatientController ctrlPatient;
    private DefaultTableModel dtmPatient;
    private String gender;

    private String comboData = "";

    /**
     * Creates new form ManagePatient
     */
    public ManagePatient() {
        initComponents();
        ctrlPatient = (PatientController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.PATIENT);
        dtmPatient = (DefaultTableModel) tblPatient.getModel();
        setenable(false);
        //loadPatientsids();
        loadData();
        handEvent();
        clearFiled();

        //AutoCompleteDecorator.decorate(cmbLoadPatientIds);
        //AutoCompletion ac = new AutoCompletion(cmbLoadPatientIds);
    }

    private void handEvent() {

        tblPatient.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tblPatient.getSelectedRowCount() <= 0) {
                    return;
                }
                String rgid = dtmPatient.getValueAt(tblPatient.getSelectedRow(), 0).toString();

                try {
                    PatientDTO patient = ctrlPatient.search(rgid);

                    if (patient != null) {
                        txtPatientId.setText(patient.getPtid());
                        txtPatientName.setText(patient.getName());
                        txtPatientAddress.setText(patient.getAddress());
                        cmbGender.setSelectedItem(patient.getGender());
                        txtNic.setText(patient.getNic());
                        txtAge.setText("" + patient.getAge());
                        txtTeleNo.setText("" + patient.getTeleno());
                    }
                    setenable(true, btnUpdate,txtPatientId);

                } catch (Exception ex) {
                    Logger.getLogger(RegistrationPatient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void loadData() {

        dtmPatient.setRowCount(0);

        try {
            ArrayList<PatientDTO> allPatients = ctrlPatient.getAll();

            if (allPatients == null) {
                return;
            }

            for (PatientDTO patient : allPatients) {
                Object[] d = {patient.getPtid(),
                    patient.getName(),
                    patient.getAddress(),
                    patient.getGender(),
                    patient.getNic(),
                    patient.getAge(),
                    patient.getTeleno()};
                dtmPatient.addRow(d);
            }
        } catch (Exception ex) {
            Logger.getLogger(ManagePatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clearFiled() {
        txtPatientId.setText("");
        txtPatientName.setText("");
        txtPatientAddress.setText("");
        cmbGender.setSelectedItem("");
        txtNic.setText("");
        txtAge.setText("");
        txtTeleNo.setText("");
    }

    private void setenable(boolean enable, JComponent... cmp) {
        txtPatientId.setEnabled(enable);
        txtPatientName.setEnabled(enable);
        txtPatientAddress.setEnabled(enable);
        cmbGender.setEnabled(enable);
        txtNic.setEnabled(enable);
        txtAge.setEnabled(enable);
        txtTeleNo.setEnabled(enable);
        btnUpdate.setEnabled(enable);
        btnDelete.setEnabled(enable);
        for (JComponent jcmp : cmp) {
            jcmp.setEnabled(!enable);
        }
    }

    private void doValidata() {
        String ptid = txtPatientId.getText();
        String name = txtPatientName.getText();
        String address = txtPatientAddress.getText();
        String gender = (String) cmbGender.getSelectedItem();
        String nic = txtNic.getText();
        String age = txtAge.getText();
        String teleno = txtTeleNo.getText();

        btnUpdate.setEnabled(false);

        if (!ptid.isEmpty()) {
            if (name.matches("[A-Za-z ]+")) {
                if (!address.isEmpty()) {
                    if (!gender.isEmpty()) {
                        if (nic.matches("\\d{9}[V]")) {
                            if (!age.isEmpty()) {
                                if (teleno.matches("\\d{10}")) {
                                    btnUpdate.setEnabled(true);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPatientAddress = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNic = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTeleNo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatient = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        cmbGender = new javax.swing.JComboBox();
        txtPatientName = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        cmdPatient = new javax.swing.JComboBox();
        txtSearch = new javax.swing.JTextField();
        txtPatientId = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Manage Patient");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 178, 40));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Patient Name :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 100, 36));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Patient Address :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 110, 36));

        txtPatientAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatientAddressActionPerformed(evt);
            }
        });
        txtPatientAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPatientAddressKeyReleased(evt);
            }
        });
        add(txtPatientAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 202, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Gender :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 70, 36));

        txtNic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNicKeyReleased(evt);
            }
        });
        add(txtNic, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 202, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("NIC :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 70, 36));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Age :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 70, 36));

        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
            }
        });
        txtAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAgeKeyReleased(evt);
            }
        });
        add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 202, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Telephone No :");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 110, 36));

        txtTeleNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTeleNoActionPerformed(evt);
            }
        });
        txtTeleNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTeleNoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTeleNoKeyReleased(evt);
            }
        });
        add(txtTeleNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 202, 30));

        tblPatient.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblPatient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient Id", "Patient Name", "Patient Address", "Gender", "NIC", "Age", "Tele .nol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPatient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblPatient.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPatientMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPatient);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 740, 430));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Patient Id :");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 70, 36));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, 100, 30));

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 120, 30));

        cmbGender.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cmbGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "FeMale" }));
        cmbGender.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cmbGenderKeyReleased(evt);
            }
        });
        add(cmbGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 200, 30));

        txtPatientName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatientNameActionPerformed(evt);
            }
        });
        add(txtPatientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 202, 30));

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, 100, 30));

        cmdPatient.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmdPatient.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ptid", "name" }));
        cmdPatient.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmdPatient.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmdPatientItemStateChanged(evt);
            }
        });
        cmdPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPatientActionPerformed(evt);
            }
        });
        add(cmdPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 90, 30));

        txtSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });
        add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 170, 30));

        txtPatientId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPatientIdKeyReleased(evt);
            }
        });
        add(txtPatientId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 200, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void txtPatientAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatientAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPatientAddressActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String ptid = txtPatientId.getText();
        String name = txtPatientName.getText();
        String address = txtPatientAddress.getText();
        if (cmbGender.getSelectedItem().equals("Male")) {
            gender = "Male";
        }
        if (cmbGender.getSelectedItem().equals("FeMale")) {
            gender = "FeMale";
        }
        String nic = txtNic.getText();
        int age = Integer.parseInt(txtAge.getText());
        int teleno = Integer.parseInt(txtTeleNo.getText());

        PatientDTO patient = new PatientDTO(ptid, name, address, gender, nic, age, teleno);

        try {
            boolean result = ctrlPatient.update(patient);
            if (result) {
                loadData();
                clearFiled();
                setenable(false);
                btnClear.requestFocusInWindow();
            } else {
                JOptionPane.showMessageDialog(this, "update fail...");
            }
        } catch (Exception ex) {
            Logger.getLogger(ManagePatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearFiled();

        if (dtmPatient.getRowCount() > 0) {
            tblPatient.getSelectionModel().clearSelection();
        }
        setenable(true, btnUpdate, btnDelete);
        txtPatientId.requestFocusInWindow();

    }//GEN-LAST:event_btnClearActionPerformed

    private void tblPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPatientMouseClicked
        //
    }//GEN-LAST:event_tblPatientMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        String ptid = dtmPatient.getValueAt(tblPatient.getSelectedRow(), 0).toString();

        try {
            boolean result = ctrlPatient.delete(ptid);
            if (result) {
                loadData();
                clearFiled();
                setenable(false);
                tblPatient.clearSelection();
                btnClear.requestFocusInWindow();
            } else {
                ImageIcon icons = new ImageIcon("/lk/ijse/doctor/icons/error_icon.png");

                JOptionPane.showMessageDialog(this,
                        "Patient deletion has been failed,try again",
                        "Delete Error",
                        JOptionPane.ERROR_MESSAGE,
                        icons);
            }
        } catch (Exception ex) {

            ImageIcon icon = new ImageIcon("/lk/ijse/doctor/icons/error_icon.png");

            JOptionPane.showMessageDialog(this,
                    "Patient deletion has been failed,try again",
                    "Delete Error",
                    JOptionPane.ERROR_MESSAGE,
                    icon);
            Logger.getLogger(ManagePatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtPatientNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatientNameActionPerformed
        doValidata();
    }//GEN-LAST:event_txtPatientNameActionPerformed

    private void txtPatientAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPatientAddressKeyReleased
        doValidata();
    }//GEN-LAST:event_txtPatientAddressKeyReleased

    private void cmbGenderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbGenderKeyReleased
        doValidata();
    }//GEN-LAST:event_cmbGenderKeyReleased

    private void txtNicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNicKeyReleased
        doValidata();
    }//GEN-LAST:event_txtNicKeyReleased

    private void txtAgeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgeKeyReleased
        doValidata();
    }//GEN-LAST:event_txtAgeKeyReleased

    private void txtTeleNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTeleNoActionPerformed
        //
    }//GEN-LAST:event_txtTeleNoActionPerformed

    private void txtTeleNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTeleNoKeyReleased
        doValidata();
    }//GEN-LAST:event_txtTeleNoKeyReleased

    private void txtTeleNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTeleNoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnUpdate.doClick();
        }
    }//GEN-LAST:event_txtTeleNoKeyPressed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String id = cmdPatient.getSelectedItem().toString();
        comboData = id;
        if (comboData.equals("ptid")) {
            try {
                ArrayList<PatientDTO> getAll = ctrlPatient.sePatientDTOs(txtSearch.getText());
                dtmPatient.setRowCount(0);
                for (PatientDTO all : getAll) {
                    Object[] r = {all.getPtid(), all.getName(), all.getAddress(), all.getGender(), all.getNic(), all.getAge(), all.getTeleno()};
                    dtmPatient.addRow(r);
                }
            } catch (Exception ex) {
                Logger.getLogger(ManagePatient.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (comboData.equals("name")) {
            try {
                ArrayList<PatientDTO> getAll = ctrlPatient.sePatientDTO(txtSearch.getText());
                dtmPatient.setRowCount(0);
                for (PatientDTO all : getAll) {
                    Object[] r = {all.getPtid(), all.getName(), all.getAddress(), all.getGender(), all.getNic(), all.getAge(), all.getTeleno()};
                    dtmPatient.addRow(r);
                }
            } catch (Exception ex) {
                Logger.getLogger(ManagePatient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        //
    }//GEN-LAST:event_txtSearchActionPerformed

    private void cmdPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPatientActionPerformed
        //
    }//GEN-LAST:event_cmdPatientActionPerformed

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        //
    }//GEN-LAST:event_txtSearchKeyTyped

    private void cmdPatientItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmdPatientItemStateChanged
        comboData = cmdPatient.getSelectedItem().toString();
    }//GEN-LAST:event_cmdPatientItemStateChanged

    private void txtPatientIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPatientIdKeyReleased
        doValidata();
    }//GEN-LAST:event_txtPatientIdKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cmbGender;
    private javax.swing.JComboBox cmdPatient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPatient;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtNic;
    private javax.swing.JTextField txtPatientAddress;
    private javax.swing.JTextField txtPatientId;
    private javax.swing.JTextField txtPatientName;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTeleNo;
    // End of variables declaration//GEN-END:variables

//    private void loadPatientsids() {
//
//        try {
//            ArrayList<String> idList = ctrlPatient.allPatientIds();
//            for (String ptid : idList) {
//                cmbLoadPatientIds.addItem(ptid);
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(ManagePatient.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

}
