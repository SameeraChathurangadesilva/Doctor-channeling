/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.view.util;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.ijse.doctor.controller.ControllerFactory;
import lk.ijse.doctor.controller.custom.DoctorController;
import lk.ijse.doctor.controller.custom.HospitalController;
import lk.ijse.doctor.controller.custom.PatientController;
import lk.ijse.doctor.controller.custom.ScheduleController;
import lk.ijse.doctor.dto.CurentIdDTO;
import lk.ijse.doctor.dto.ScheduleDTO;
import lk.ijse.doctor.dto.ViewDoctorDTO;
import lk.ijse.doctor.dto.ViewScheduleDTO;
import lk.ijse.doctor.idgenerator.IdGenerator;

/**
 *
 * @author sameera
 */
public class SelectDoctor extends javax.swing.JPanel {

    private DoctorController ctrlDoctor;
    private HospitalController ctrlHospital;
    private DefaultTableModel dtmDoctor;
    private DefaultTableModel dtmSchedule;
    private ScheduleController ctrlSchedule;
    private PatientController ctrlPatient;

    private String comdata = "";
    public static String dateNew = "";
    public static String scids = "";

    /**
     * Creates new form SelectDoctor
     */
    public SelectDoctor() {
        initComponents();
        btnNext.setEnabled(false);
        ctrlDoctor = (DoctorController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.DOCTOR);
        ctrlHospital = (HospitalController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.HOSPITAL);
        ctrlSchedule = (ScheduleController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.SCHEDULE);
        ctrlPatient = (PatientController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.PATIENT);
        dtmDoctor = (DefaultTableModel) tblDoctor.getModel();
        dtmSchedule = (DefaultTableModel) tblSchedule.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBorder = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoctor = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSchedule = new javax.swing.JTable();
        cmbload = new javax.swing.JComboBox();
        txtSearch = new javax.swing.JTextField();
        datePicker = new org.jdesktop.swingx.JXDatePicker();
        goBtn = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBorder.setPreferredSize(new java.awt.Dimension(1141, 657));
        pnlBorder.setLayout(new javax.swing.BoxLayout(pnlBorder, javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Select Doctor");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 155, 46));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Search :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 75, 65, 31));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Select Schedule");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 317, 186, 46));

        btnNext.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jPanel2.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(979, 587, 129, 31));

        tblDoctor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblDoctor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doctor Id", "Hospital Name", "Speciality Name", "Doctor Name", "Gender", "Dcfree"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDoctorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDoctor);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 125, 1079, 159));

        tblSchedule.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Schedule id", "Doctor Id", "Day Id", "Doctor In", "Doctor Out", "Patient Count", "Current No"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblScheduleMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSchedule);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 374, 1079, 183));

        cmbload.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbload.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "speciality", "doctorname" }));
        cmbload.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmbload.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbloadItemStateChanged(evt);
            }
        });
        jPanel2.add(cmbload, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 75, 125, 32));

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
        });
        jPanel2.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 75, 168, 32));
        jPanel2.add(datePicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(952, 317, 156, 38));

        goBtn.setText("Go");
        goBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBtnActionPerformed(evt);
            }
        });
        jPanel2.add(goBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 310, -1, 50));

        pnlBorder.add(jPanel2);

        add(pnlBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        scids = tblSchedule.getValueAt(tblSchedule.getSelectedRow(), 0).toString();
        AddPatients addPatients = new AddPatients();
        pnlBorder.removeAll();
        pnlBorder.repaint();
        pnlBorder.revalidate();
        pnlBorder.add(addPatients);
        addPatients.setVisible(true);
    }//GEN-LAST:event_btnNextActionPerformed

    private void tblDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDoctorMouseClicked
        String dcid = tblDoctor.getValueAt(tblDoctor.getSelectedRow(), 0).toString();

        try {
            ArrayList<ViewScheduleDTO> viewScheduleList = ctrlSchedule.searchIdsQ();
            dtmSchedule.setRowCount(0);
            for (ViewScheduleDTO viewScheduleList1 : viewScheduleList) {
                if (viewScheduleList1.getDcid().equals(dcid)) {
                    CurentIdDTO searchAppNo = ctrlPatient.searchAppNo(dcid);
                    String cunId;
                    if (searchAppNo != null) {
                        cunId = searchAppNo.getCunId();
                    } else {
                        cunId = "0";
                    }

                    Object[] rowdata = {
                        viewScheduleList1.getScid(),
                        viewScheduleList1.getDcid(),
                        viewScheduleList1.getDays(),
                        viewScheduleList1.getDoctorin(),
                        viewScheduleList1.getDoctorout(),
                        viewScheduleList1.getPatientcount(),
                        cunId};
                    dtmSchedule.addRow(rowdata);
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(SelectDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblDoctorMouseClicked

    private void cmbloadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbloadItemStateChanged
        comdata = cmbload.getSelectedItem().toString();
    }//GEN-LAST:event_cmbloadItemStateChanged

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String name = cmbload.getSelectedItem().toString();
        comdata = name;
        if (comdata.equals("speciality")) {
            try {
                ArrayList<ViewDoctorDTO> getAll = ctrlDoctor.searchDoctorSpeciality(txtSearch.getText());
                dtmDoctor.setRowCount(0);
                for (ViewDoctorDTO all : getAll) {
                    Object[] rowdata = {all.getDocID(), all.getHosName(), all.getSpName(), all.getDocName(), all.getGender(), all.getFeer()};
                    dtmDoctor.addRow(rowdata);
                }
            } catch (Exception ex) {
                Logger.getLogger(SelectDoctor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (comdata.equals("doctorname")) {
            try {
                ViewDoctorDTO all = ctrlDoctor.searchList(txtSearch.getText());
                dtmDoctor.setRowCount(0);
                Object[] rowdata = {all.getDocID(), all.getHosName(), all.getSpName(), all.getDocName(), all.getGender(), all.getFeer()};
                dtmDoctor.addRow(rowdata);
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(this, "Not Found..");
            } catch (Exception ex) {
                Logger.getLogger(SelectDoctor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void tblScheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblScheduleMouseClicked
        int pCount = Integer.parseInt(tblSchedule.getValueAt(tblSchedule.getSelectedRow(), 5).toString());
        int curNo = Integer.parseInt(tblSchedule.getValueAt(tblSchedule.getSelectedRow(), 6).toString());
        if (pCount == curNo) {
            btnNext.setEnabled(false);
            int resp = JOptionPane.showConfirmDialog(this, "Are  you sure want to make appoinment fo next day???", "Confirm", JOptionPane.YES_NO_OPTION);
            if (resp == 0) {
                JOptionPane.showMessageDialog(this, "Please select a day for appontment", "Confirm", JOptionPane.YES_OPTION);
            } else {

            }
        } else {
            btnNext.setEnabled(true);
        }


    }//GEN-LAST:event_tblScheduleMouseClicked

    private void goBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBtnActionPerformed
        try {
            Date date = datePicker.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E");
            String newDate = sdf.format(date);
            dateNew = newDate;
            String dcids = tblSchedule.getValueAt(tblSchedule.getSelectedRow(), 1).toString();
            String dIn = tblSchedule.getValueAt(tblSchedule.getSelectedRow(), 3).toString();
            String dOut = tblSchedule.getValueAt(tblSchedule.getSelectedRow(), 4).toString();
            String pCount = tblSchedule.getValueAt(tblSchedule.getSelectedRow(), 5).toString();
            String scid = IdGenerator.getNewScheduleIds("schedule", "scid", "SC");
            ScheduleDTO sch = new ScheduleDTO(scid, dcids, dateNew, dIn, dOut, Integer.parseInt(pCount));
            try {
                boolean add = ctrlSchedule.add(sch);
//                ctrlPatient.sear
                if (add) {
                    System.out.println("success schedule");
                }
            } catch (Exception ex) {
                Logger.getLogger(SelectDoctor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SelectDoctor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SelectDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_goBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JComboBox cmbload;
    private org.jdesktop.swingx.JXDatePicker datePicker;
    private javax.swing.JButton goBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlBorder;
    private javax.swing.JTable tblDoctor;
    private javax.swing.JTable tblSchedule;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
