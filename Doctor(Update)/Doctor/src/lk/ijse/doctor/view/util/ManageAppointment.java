/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.view.util;

import java.awt.event.KeyEvent;
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
import lk.ijse.doctor.controller.custom.AppoinmentController;
import lk.ijse.doctor.controller.custom.DoctorController;
import lk.ijse.doctor.dto.AppoinmentDTO;
import lk.ijse.doctor.dto.DoctorDTO;
import lk.ijse.doctor.dto.ViewAppointmentDTO;

/**
 *
 * @author sameera
 */
public class ManageAppointment extends javax.swing.JPanel {

    private AppoinmentController ctrlAppointment;
    private DoctorController ctrlDoctor;
    private DefaultTableModel dtm;
    private String DoctroNames = "";

    /**
     * Creates new form ManageAppointment
     */
    public ManageAppointment() {
        initComponents();
        ctrlAppointment = (AppoinmentController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.APPOINMENT);
        ctrlDoctor = (DoctorController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.DOCTOR);
        dtm = (DefaultTableModel) tblLoad.getModel();
        setEnable(false);
        //loadIds();
        //loadDate();
        handEvent();
        clearField();
        loadDoctorIds();
        loadData();
    }
    private void handEvent(){
        
        tblLoad.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tblLoad.getSelectedRowCount() <= 0) {
                    return;
                }
                
                String apid =tblLoad.getValueAt(tblLoad.getSelectedRow(), 0).toString();
                
                try {
                    AppoinmentDTO appoinment =ctrlAppointment.search(apid);
                    if(appoinment != null){
                        txtAppointmnetId.setText(appoinment.getApid());
                        cmbLoadDoctorNames.setSelectedItem(appoinment.getDcid());
                        txtpatientId.setText(appoinment.getPtid());
                        txtAppointmentNo.setText(appoinment.getApno());
                        txtAppointmentTime.setText(appoinment.getTime());
                        txtAppointmentDate.setText(appoinment.getDate());
                    }
                    setEnable(true, btnUpdate,txtAppointmnetId,cmbLoadDoctorNames,txtpatientId);
                    
                } catch (Exception ex) {
                    Logger.getLogger(ManageAppointment.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
//    private void loadDate(){
//        
//        dtm.setRowCount(0);
//        try {
//            ArrayList<AppoinmentDTO> details =ctrlAppointment.getAll();
//            
//            if(details == null){
//                return;
//            }
//            for(AppoinmentDTO appoinment : details){
//               Object [] rowdata ={
//                   appoinment.getApid(),
//                   appoinment.getDcid(),
//                   appoinment.getPtid(),
//               appoinment.getPayid(),
//               appoinment.getApno(),
//               appoinment.getTime(),
//               appoinment.getDate()};
//               dtm.addRow(rowdata);
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(ManageAppointment.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    private void loadData() {

        try {

            dtm.setRowCount(0);
            ArrayList<ViewAppointmentDTO> getAll = ctrlAppointment.loadAppointmentDetails();

            if (getAll == null) {
                return;
            }
            for (ViewAppointmentDTO viewAppointment : getAll) {

                Object[] rowdata = {
                    viewAppointment.getApid(),
                    viewAppointment.getDcname(),
                    viewAppointment.getPtid(),
                    viewAppointment.getApno(),
                    viewAppointment.getTime(),
                    viewAppointment.getDate()};
                dtm.addRow(rowdata);
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clearField() {
        txtAppointmnetId.setText("");
        cmbLoadDoctorNames.setSelectedItem("");
        txtpatientId.setText("");
        txtAppointmentNo.setText("");
        txtAppointmentTime.setText("");
        txtAppointmentDate.setText("");
    }

    private void setEnable(boolean enable, JComponent... cmp) {
        txtAppointmnetId.setEnabled(enable);
        cmbLoadDoctorNames.setEnabled(enable);
        txtpatientId.setEnabled(enable);
        txtAppointmentNo.setEnabled(enable);
        txtAppointmentTime.setEnabled(enable);
        txtAppointmentDate.setEnabled(enable);
        btnUpdate.setEnabled(enable);
        btnDelete.setEnabled(enable);
        for (JComponent jcmp : cmp) {
            jcmp.setEnabled(!enable);
        }
    }

    private void doValidata() {
        String apid = txtAppointmnetId.getText();
        String dname = cmbLoadDoctorNames.getSelectedItem().toString();
        String ptid = txtpatientId.getText();
        String payid = txtpatientId.getText();
        String apno = txtAppointmentNo.getText();
        String atime = txtAppointmentTime.getText();
        String adate = txtAppointmentDate.getText();

        btnUpdate.setEnabled(false);

        if (!apid.isEmpty()) {
            if (!dname.isEmpty()) {
                if (!ptid.isEmpty()) {
                    if (!payid.isEmpty()) {
                        if (!apno.isEmpty()) {
                            if (!atime.isEmpty()) {
                                if (!adate.isEmpty()) {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtpatientId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAppointmentNo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAppointmentTime = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtAppointmentDate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLoad = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        cmbLoadDoctorNames = new javax.swing.JComboBox();
        txtAppointmnetId = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Manage Appointment");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 235, 35));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Appointment Id :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 121, 27));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Doctor Id:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 107, 27));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Patient  id :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 107, 27));

        txtpatientId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtpatientIdMouseClicked(evt);
            }
        });
        txtpatientId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpatientIdKeyReleased(evt);
            }
        });
        add(txtpatientId, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 171, 27));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Appointment No :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 120, 27));

        txtAppointmentNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAppointmentNoKeyReleased(evt);
            }
        });
        add(txtAppointmentNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 171, 27));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Appointment Time :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 130, 27));

        txtAppointmentTime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAppointmentTimeKeyReleased(evt);
            }
        });
        add(txtAppointmentTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 171, 27));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Appointment Date :");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 140, 27));

        txtAppointmentDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAppointmentDateActionPerformed(evt);
            }
        });
        txtAppointmentDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAppointmentDateKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAppointmentDateKeyReleased(evt);
            }
        });
        add(txtAppointmentDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 171, 27));

        tblLoad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblLoad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Appointment Id", "Doctor Name", "Patient Id", "Appointment No", "Appointment Time", "Appointment Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLoad.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblLoad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoadMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLoad);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 720, 420));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Search :");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 60, 27));

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 110, 30));

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 110, 30));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Search :");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 60, 27));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 110, 30));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 170, 30));

        cmbLoadDoctorNames.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbLoadDoctorNamesItemStateChanged(evt);
            }
        });
        cmbLoadDoctorNames.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cmbLoadDoctorNamesKeyReleased(evt);
            }
        });
        add(cmbLoadDoctorNames, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 170, 30));

        txtAppointmnetId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAppointmnetIdKeyReleased(evt);
            }
        });
        add(txtAppointmnetId, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 170, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void txtAppointmentDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAppointmentDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAppointmentDateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearField();

        if (dtm.getRowCount() > 0) {
            tblLoad.getSelectionModel().clearSelection();
        }
        setEnable(true, btnUpdate, btnDelete);
        txtAppointmnetId.requestFocusInWindow();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        String apid = txtAppointmnetId.getText();
        String ptid = txtpatientId.getText();
        String apno = txtAppointmentNo.getText();
        String time = txtAppointmentTime.getText();
        String date = txtAppointmentDate.getText();

        AppoinmentDTO appoinment = new AppoinmentDTO(apid, DoctroNames, ptid, apno, time, date);
        try {
            boolean result = ctrlAppointment.update(appoinment);
            if (result) {
                //loadDate();
                loadData();
                clearField();
                setEnable(false);
                btnClear.requestFocusInWindow();
                JOptionPane.showMessageDialog(this, "Update sussed..");
            } else {
                JOptionPane.showMessageDialog(this, "Update Fail..");
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoadMouseClicked

        String apid = tblLoad.getValueAt(tblLoad.getSelectedRow(), 0).toString();
        String dname = tblLoad.getValueAt(tblLoad.getSelectedRow(), 1).toString();
        String ptid = tblLoad.getValueAt(tblLoad.getSelectedRow(), 2).toString();
        String apno = tblLoad.getValueAt(tblLoad.getSelectedRow(), 3).toString();
        String aptime = tblLoad.getValueAt(tblLoad.getSelectedRow(), 4).toString();
        String apdate = tblLoad.getValueAt(tblLoad.getSelectedRow(), 5).toString();
        txtAppointmnetId.setText(apid);
        cmbLoadDoctorNames.setSelectedItem(dname);
        txtpatientId.setText(ptid);
        txtAppointmentNo.setText(apno);
        txtAppointmentTime.setText(aptime);
        txtAppointmentDate.setText(apdate);

        setEnable(true, btnUpdate, txtAppointmnetId, txtpatientId);
    }//GEN-LAST:event_tblLoadMouseClicked

    private void txtpatientIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtpatientIdMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpatientIdMouseClicked

    private void txtpatientIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpatientIdKeyReleased
        doValidata();
    }//GEN-LAST:event_txtpatientIdKeyReleased

    private void txtAppointmentNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAppointmentNoKeyReleased
        doValidata();
    }//GEN-LAST:event_txtAppointmentNoKeyReleased

    private void txtAppointmentTimeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAppointmentTimeKeyReleased
        doValidata();
    }//GEN-LAST:event_txtAppointmentTimeKeyReleased

    private void txtAppointmentDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAppointmentDateKeyReleased
        doValidata();
    }//GEN-LAST:event_txtAppointmentDateKeyReleased

    private void txtAppointmentDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAppointmentDateKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnUpdate.doClick();
        }
    }//GEN-LAST:event_txtAppointmentDateKeyPressed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        String apid = tblLoad.getValueAt(tblLoad.getSelectedRow(), 0).toString();

        try {
            boolean result = ctrlAppointment.delete(apid);
            if (result) {
                //loadDate();
                loadData();
                clearField();
                setEnabled(false);
                tblLoad.clearSelection();
                btnClear.requestFocusInWindow();
            } else {
                ImageIcon icons = new ImageIcon(this.getClass().getResource("/lk/ijse/doctor/icons/error_icon.png"));

                JOptionPane.showMessageDialog(this,
                        "Appoinment deletion has been failed,try again",
                        "Delete Error",
                        JOptionPane.ERROR_MESSAGE,
                        icons);
            }
        } catch (Exception ex) {
            ImageIcon icons = new ImageIcon(this.getClass().getResource("/lk/ijse/doctor/icons/error_icon.png"));

            JOptionPane.showMessageDialog(this,
                    "Appoinment deletion has been failed,try again",
                    "Delete Error",
                    JOptionPane.ERROR_MESSAGE,
                    icons);
            Logger.getLogger(ManageAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
       
        try {
            ArrayList<ViewAppointmentDTO> getAll = ctrlAppointment.getAllAppointment(txtSearch.getText());
            dtm.setRowCount(0);
            for (ViewAppointmentDTO v : getAll) {
                Object[] rowdata = {
                    v.getApid(),
                    v.getDcname(),
                    v.getPtid(),
                    v.getApno(),
                    v.getTime(),
                    v.getDate()};
                dtm.addRow(rowdata);
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     

    }//GEN-LAST:event_txtSearchKeyReleased

    private void cmbLoadDoctorNamesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbLoadDoctorNamesItemStateChanged

        String name = cmbLoadDoctorNames.getSelectedItem().toString();

        try {
            DoctorDTO doctor = ctrlDoctor.searchName(name);
            DoctroNames = doctor.getDcid();
        } catch (Exception ex) {
            Logger.getLogger(ManageAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbLoadDoctorNamesItemStateChanged

    private void cmbLoadDoctorNamesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbLoadDoctorNamesKeyReleased
        doValidata();
    }//GEN-LAST:event_cmbLoadDoctorNamesKeyReleased

    private void txtAppointmnetIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAppointmnetIdKeyReleased
        doValidata();
    }//GEN-LAST:event_txtAppointmnetIdKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cmbLoadDoctorNames;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLoad;
    private javax.swing.JTextField txtAppointmentDate;
    private javax.swing.JTextField txtAppointmentNo;
    private javax.swing.JTextField txtAppointmentTime;
    private javax.swing.JTextField txtAppointmnetId;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtpatientId;
    // End of variables declaration//GEN-END:variables

//    private void searchAppointment(){
//        
//        try {
//            String apid =txtSearchbar.getText();
//            dtm.setRowCount(0);
//            AppoinmentDTO appoinment =ctrlAppointment.search(apid);
//            Object [] rowdata ={appoinment.getApid(),appoinment.getDcid(),appoinment.getPtid(),appoinment.getPayid(),appoinment.getApno(),appoinment.getTime(),appoinment.getDate()};
//            dtm.addRow(rowdata);
//        } catch (Exception ex) {
//            Logger.getLogger(ManageAppointment.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    private void loadIds() {
//      
//        try {
//            ArrayList<String> getIds =ctrlAppointment.seratchIds();
//            for(String id : getIds){
//                cmbAppointIds.addItem(id);
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(ManageAppointment.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    private void loadDoctorIds() {

        try {
            ArrayList<String> getAllNames = ctrlDoctor.getAllNames();
            for (String allName : getAllNames) {
                cmbLoadDoctorNames.addItem(allName);
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
