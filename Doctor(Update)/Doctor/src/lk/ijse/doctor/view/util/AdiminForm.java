/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.view.util;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import lk.ijse.doctor.controller.ControllerFactory;
import lk.ijse.doctor.controller.custom.DaysController;
import lk.ijse.doctor.controller.custom.DoctorController;
import lk.ijse.doctor.controller.custom.HospitalController;
import lk.ijse.doctor.controller.custom.ScheduleController;
import lk.ijse.doctor.controller.custom.SpecialityController;
import lk.ijse.doctor.dto.DaysDTO;
import lk.ijse.doctor.dto.DoctorDTO;
import lk.ijse.doctor.dto.HospitalDTO;
import lk.ijse.doctor.dto.ScheduleDTO;
import lk.ijse.doctor.dto.SpecialityDTO;
import lk.ijse.doctor.dto.ViewDoctorScheduleDTO;
import lk.ijse.doctor.idgenerator.IdGenerator;

/**
 *
 * @author sameera
 */
public class AdiminForm extends javax.swing.JPanel {
    
    private HospitalController ctrlHospital;
    private SpecialityController ctrlspeciality;
    private DefaultTableModel dtmHosptal;
    private DefaultTableModel dtmSpeciality;
    private DefaultTableModel dtmDoctorSchedule;
    private DoctorController doctorController;
    private DaysController ctrlDays;
    private ScheduleController scheduleController;
    private DoctorController ctrlDoctor;
    private String dateName = "";

    /**
     * Creates new form AdiminForm
     */
    public AdiminForm() {
        initComponents();
        ctrlHospital = (HospitalController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.HOSPITAL);
        ctrlspeciality = (SpecialityController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.SPECIALITY);
        dtmHosptal = (DefaultTableModel) tblHospital.getModel();
        dtmSpeciality = (DefaultTableModel) tblSpeciality.getModel();
        dtmDoctorSchedule = (DefaultTableModel) tblDoctorSchedule.getModel();
        doctorController = (DoctorController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.DOCTOR);
        ctrlDays = (DaysController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.DAYS);
        scheduleController = (ScheduleController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.SCHEDULE);
        ctrlDoctor = (DoctorController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.DOCTOR);
        setEnableHopital(false);
        setEnableSpecialiy(false);
        setEnableDoctorSchedule(false);
        loadDataHospiatal();
        handEventHospital();
        handEventSpeciality();
        loadDataSpeciality();
        loadDoctorSchedule();
        
    }
    
    private void handEventSpeciality() {
        
        tblSpeciality.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            
            @Override
            public void valueChanged(ListSelectionEvent e) {
                
                if (tblSpeciality.getSelectedRowCount() <= 0) {
                    return;
                }
                String spid = dtmSpeciality.getValueAt(tblSpeciality.getSelectedRow(), 0).toString();
                
                try {
                    SpecialityDTO specialtiy = ctrlspeciality.search(spid);
                    
                    if (specialtiy != null) {
                        txtSpecialityId.setText(specialtiy.getSpid());
                        txtSpecialityName.setText(specialtiy.getName());
                    }
                    
                    setEnableSpecialiy(true, btnSaveSpeciality, txtSpecialityId);
                } catch (Exception ex) {
                    Logger.getLogger(AdiminForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void handEventHospital() {
        tblHospital.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            
            @Override
            public void valueChanged(ListSelectionEvent e) {
                
                if (tblHospital.getSelectedRowCount() <= 0) {
                    return;
                }
                String hpid = dtmHosptal.getValueAt(tblHospital.getSelectedRow(), 0).toString();
                try {
                    HospitalDTO hospital = ctrlHospital.search(hpid);
                    
                    if (hospital != null) {
                        txtHospitalId.setText(hospital.getHpid());
                        txtHospitalName.setText(hospital.getName());
                    }
                    
                    setEnableHopital(true, btnSave, txtHospitalId);
                } catch (Exception ex) {
                    Logger.getLogger(AdiminForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void loadDataSpeciality() {
        
        dtmSpeciality.setRowCount(0);
        try {
            ArrayList<SpecialityDTO> allSpecitaly = ctrlspeciality.getAll();
            
            if (allSpecitaly == null) {
                return;
            }
            for (SpecialityDTO speciality : allSpecitaly) {
                Object[] d = {speciality.getSpid(),
                    speciality.getName()};
                dtmSpeciality.addRow(d);
            }
        } catch (Exception ex) {
            Logger.getLogger(AdiminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadDataHospiatal() {
        
        dtmHosptal.setRowCount(0);
        
        try {
            ArrayList<HospitalDTO> allHospital = ctrlHospital.getAll();
            
            if (allHospital == null) {
                return;
            }
            for (HospitalDTO hospital : allHospital) {
                Object[] d = {hospital.getHpid(),
                    hospital.getName()};
                dtmHosptal.addRow(d);
            }
        } catch (Exception ex) {
            Logger.getLogger(AdiminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadDoctorSchedule() {
        
        try {
            dtmDoctorSchedule.setRowCount(0);
            ArrayList<ViewDoctorScheduleDTO> getAll = ctrlDays.getAllDetails();
            for (ViewDoctorScheduleDTO all : getAll) {
                Object[] rowdata = {
                    all.getDcid(),
                    all.getHpid(),
                    all.getSpid(),
                    all.getDoctorname(),
                    all.getGender(),
                    all.getDcfee(),
                    all.getScid(),
                    all.getDayid(),
                    all.getDays(),
                    all.getDoctorin(),
                    all.getDoctorout(),
                    all.getPatientCount()};
                dtmDoctorSchedule.addRow(rowdata);
            }
        } catch (Exception ex) {
            Logger.getLogger(AdiminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void clearFiledHospital() {
        txtHospitalId.setText("");
        txtHospitalName.setText("");
        txtSearchBar.setText("");
    }
    
    private void clearFiledSpeciality() {
        txtSpecialityId.setText("");
        txtSpecialityName.setText("");
        txtSearchSpeciality.setText("");
    }
    
    private void setEnableSpecialiy(boolean enable, JComponent... cmp) {
        txtSpecialityId.setEnabled(enable);
        txtSpecialityName.setEnabled(enable);
        btnSaveSpeciality.setEnabled(enable);
        btnDeleteSpeciality.setEnabled(enable);
        for (JComponent jcmp : cmp) {
            jcmp.setEnabled(!enable);
        }
    }
    
    private void setEnableHopital(boolean enable, JComponent... cmp) {
        txtHospitalId.setEnabled(enable);
        txtHospitalName.setEnabled(enable);
        btnSave.setEnabled(enable);
        btnDelete.setEnabled(enable);
        for (JComponent jcmp : cmp) {
            jcmp.setEnabled(!enable);
        }
    }
    
    private void doValidateHospital() {
        String hpid = txtHospitalId.getText();
        String name = txtHospitalName.getText();
        
        btnSave.setEnabled(false);
        
        if (!hpid.isEmpty()) {
            if (name.matches("[A-Za-z ]+")) {
                btnSave.setEnabled(true);
                
            }
        }
    }
    
    private void doValidateSpecility() {
        String spid = txtSpecialityId.getText();
        String spname = txtSpecialityName.getText();
        
        btnSaveSpeciality.setEnabled(false);
        
        if (!spid.isEmpty()) {
            if (spname.matches("[A-Za-z ]+")) {
                btnSaveSpeciality.setEnabled(true);
            }
        }
    }
    
    private void clearDoctorSchedule() {
        txtdoctorId.setText("");
        txtHospitalIds.setText("");
        txtSpeciality.setText("");
        txtDoctorName.setText("");
        cmbGender.setSelectedItem("");
        txtDoctorFree.setText("");
        txtScheduleId.setText("");
        txtDayId.setText("");
        
        txtDoctorIn.setText("");
        txtDoctorOut.setText("");
        txtPatientCount.setText("");
    }
    
    private void setEnableDoctorSchedule(boolean enable, JComponent... cmp) {
        txtdoctorId.setEnabled(enable);
        txtHospitalIds.setEnabled(enable);
        txtSpeciality.setEnabled(enable);
        txtDoctorName.setEnabled(enable);
        cmbGender.setEnabled(enable);
        txtDoctorFree.setEnabled(enable);
        txtScheduleId.setEnabled(enable);
        txtDayId.setEnabled(enable);
        
        txtDoctorIn.setEnabled(enable);
        txtDoctorOut.setEnabled(enable);
        txtPatientCount.setEnabled(enable);
        //btnSaveDoctor.setEnabled(enable);
        btnDeleteDoctor.setEnabled(enable);
        btnUpdate.setEnabled(enable);
        for (JComponent jcmp : cmp) {
            jcmp.setEnabled(!enable);
        }
    }
    
    private void doValidateDoctorSchedule() {
        String dcid = txtdoctorId.getText();
        String hpid = txtHospitalIds.getText();
        String spid = txtSpeciality.getText();
        String dcname = txtDoctorName.getText();
        String gender = cmbGender.getSelectedItem().toString();
        String dcfree = txtDoctorFree.getText();
        String scid = txtScheduleId.getText();
        String dayid = txtDayId.getText();
        
        String din = txtDoctorIn.getText();
        String dout = txtDoctorOut.getText();
        String patientcount = txtPatientCount.getText();
        
        btnSaveDoctor.setEnabled(false);
        
        if (!dcid.isEmpty()) {
            if (!hpid.isEmpty()) {
                if (!spid.isEmpty()) {
                    if (dcname.matches("[A-Za-z ]+")) {
                        if (!gender.isEmpty()) {
                            if (!dcfree.isEmpty()) {
                                if (!scid.isEmpty()) {
                                    if (!dayid.isEmpty()) {
                                        
                                        if (!din.isEmpty()) {
                                            if (!dout.isEmpty()) {
                                                if (!patientcount.isEmpty()) {
                                                    btnSaveDoctor.setEnabled(true);
                                                }
                                            }
                                            
                                        }
                                    }
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSearchBar = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtHospitalId = new javax.swing.JTextField();
        txtHospitalName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnNewHospital = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblHospital = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSearchSpeciality = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSpeciality = new javax.swing.JTable();
        btnSaveSpeciality = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtSpecialityId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSpecialityName = new javax.swing.JTextField();
        btnNewSpeciality = new javax.swing.JButton();
        btnDeleteSpeciality = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtdoctorId = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtDoctorName = new javax.swing.JTextField();
        cmbGender = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtDoctorFree = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtScheduleId = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtDayId = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtDoctorIn = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtDoctorOut = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtPatientCount = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDoctorSchedule = new javax.swing.JTable();
        btnSaveDoctor = new javax.swing.JButton();
        btnNewDoctorSchedule = new javax.swing.JButton();
        btnDeleteDoctor = new javax.swing.JButton();
        txtHospitalIds = new javax.swing.JTextField();
        txtSpeciality = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        dates = new com.toedter.calendar.JDateChooser();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Manage Hospital");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 19, -1, 31));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Search :");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 25));

        txtSearchBar.setBorder(null);
        txtSearchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchBarActionPerformed(evt);
            }
        });
        txtSearchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchBarKeyReleased(evt);
            }
        });
        jPanel3.add(txtSearchBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 73, 207, 30));

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel3.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(895, 320, 100, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Hospital Id :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(788, 195, -1, 33));

        txtHospitalId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHospitalIdKeyReleased(evt);
            }
        });
        jPanel3.add(txtHospitalId, new org.netbeans.lib.awtextra.AbsoluteConstraints(892, 196, 222, 33));

        txtHospitalName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHospitalNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHospitalNameKeyReleased(evt);
            }
        });
        jPanel3.add(txtHospitalName, new org.netbeans.lib.awtextra.AbsoluteConstraints(892, 256, 222, 33));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Hospital name:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 260, -1, 33));

        btnNewHospital.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNewHospital.setText("New Hospital");
        btnNewHospital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewHospitalActionPerformed(evt);
            }
        });
        jPanel3.add(btnNewHospital, new org.netbeans.lib.awtextra.AbsoluteConstraints(991, 123, -1, 30));

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel3.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1015, 320, 100, 30));

        tblHospital.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hospital Id", "Hospital Name"
            }
        ));
        tblHospital.setColumnSelectionAllowed(true);
        tblHospital.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblHospital.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(tblHospital);
        if (tblHospital.getColumnModel().getColumnCount() > 0) {
            tblHospital.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 720, 460));

        jTabbedPane1.addTab("Hospital", jPanel3);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Manage Speciality");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Search :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 60, 30));

        txtSearchSpeciality.setBorder(null);
        txtSearchSpeciality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchSpecialityActionPerformed(evt);
            }
        });
        jPanel2.add(txtSearchSpeciality, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 170, 30));

        tblSpeciality.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Speciality Id", "Speciality Name"
            }
        ));
        tblSpeciality.setColumnSelectionAllowed(true);
        tblSpeciality.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblSpeciality.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblSpeciality);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 110, 700, 430));

        btnSaveSpeciality.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSaveSpeciality.setText("Save");
        btnSaveSpeciality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSpecialityActionPerformed(evt);
            }
        });
        jPanel2.add(btnSaveSpeciality, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 310, 140, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Speciality Id :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 180, 90, 40));

        txtSpecialityId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSpecialityIdKeyReleased(evt);
            }
        });
        jPanel2.add(txtSpecialityId, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 180, 210, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Speciality Name :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 240, 130, 40));

        txtSpecialityName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSpecialityNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSpecialityNameKeyReleased(evt);
            }
        });
        jPanel2.add(txtSpecialityName, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 240, 210, 30));

        btnNewSpeciality.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNewSpeciality.setText("New speciality");
        btnNewSpeciality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewSpecialityActionPerformed(evt);
            }
        });
        jPanel2.add(btnNewSpeciality, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 110, 140, 30));

        btnDeleteSpeciality.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteSpeciality.setText("Delete");
        btnDeleteSpeciality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSpecialityActionPerformed(evt);
            }
        });
        jPanel2.add(btnDeleteSpeciality, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 310, 140, 30));

        jTabbedPane1.addTab("Speciality", jPanel2);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setText("Manage Doctor Schedule");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 270, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Speciality Id:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, 20));

        txtdoctorId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdoctorIdActionPerformed(evt);
            }
        });
        txtdoctorId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdoctorIdKeyReleased(evt);
            }
        });
        jPanel1.add(txtdoctorId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 160, 20));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Hospital Id :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, 20));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Doctor Id :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 80, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Doctor Name :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 90, 20));

        txtDoctorName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDoctorNameKeyReleased(evt);
            }
        });
        jPanel1.add(txtDoctorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 160, 20));

        cmbGender.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "FeMale" }));
        cmbGender.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cmbGenderKeyReleased(evt);
            }
        });
        jPanel1.add(cmbGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 160, 20));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Gender :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, 20));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("Doctor Free :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 100, 20));

        txtDoctorFree.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDoctorFreeKeyReleased(evt);
            }
        });
        jPanel1.add(txtDoctorFree, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 160, 20));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("Schedule Id :");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 100, 20));

        txtScheduleId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtScheduleIdKeyReleased(evt);
            }
        });
        jPanel1.add(txtScheduleId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 160, 20));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setText("Day Id :");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 100, 20));

        txtDayId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDayIdKeyReleased(evt);
            }
        });
        jPanel1.add(txtDayId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 160, 20));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setText("Doctor in :");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 100, 20));

        txtDoctorIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDoctorInActionPerformed(evt);
            }
        });
        txtDoctorIn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDoctorInKeyReleased(evt);
            }
        });
        jPanel1.add(txtDoctorIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 160, 20));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setText("Doctor out :");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 100, 20));

        txtDoctorOut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDoctorOutKeyReleased(evt);
            }
        });
        jPanel1.add(txtDoctorOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 160, 20));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel20.setText("Patient Count :");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 100, 20));

        txtPatientCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatientCountActionPerformed(evt);
            }
        });
        txtPatientCount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPatientCountKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPatientCountKeyReleased(evt);
            }
        });
        jPanel1.add(txtPatientCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, 160, 20));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel21.setText("Days :");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, 20));

        tblDoctorSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doctor Id", "Hpt. Name", "Spt. Name", "Do.Name", "Gender", "Do.free", "Schedule Id", "Day Id", "Days", "Do.in", "Do.out", "Pa.count"
            }
        ));
        tblDoctorSchedule.setColumnSelectionAllowed(true);
        tblDoctorSchedule.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDoctorSchedule.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDoctorSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDoctorScheduleMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDoctorSchedule);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 790, 470));

        btnSaveDoctor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSaveDoctor.setText("Save");
        btnSaveDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDoctorActionPerformed(evt);
            }
        });
        jPanel1.add(btnSaveDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 540, 100, 30));

        btnNewDoctorSchedule.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNewDoctorSchedule.setText("New Doctor Schedule");
        btnNewDoctorSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewDoctorScheduleActionPerformed(evt);
            }
        });
        jPanel1.add(btnNewDoctorSchedule, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, 40));

        btnDeleteDoctor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteDoctor.setText("Delete");
        btnDeleteDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDoctorActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeleteDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 100, 30));

        txtHospitalIds.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHospitalIdsKeyReleased(evt);
            }
        });
        jPanel1.add(txtHospitalIds, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 160, 20));

        txtSpeciality.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSpecialityKeyReleased(evt);
            }
        });
        jPanel1.add(txtSpeciality, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 160, -1));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, -1, 30));
        jPanel1.add(dates, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 390, 160, -1));

        jTabbedPane1.addTab("Doctor Schedule", jPanel1);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 660));
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewHospitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewHospitalActionPerformed
        clearFiledHospital();

        if (dtmHosptal.getRowCount() > 0) {
            tblHospital.getSelectionModel().clearSelection();
        }
        setEnableHopital(true, btnSave, btnDelete);
        txtHospitalId.requestFocusInWindow();
        
        try {
            String hpid = IdGenerator.getNewHospitalIds("hospital", "hpid", "HP");
            txtHospitalId.setText(hpid);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdiminForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdiminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNewHospitalActionPerformed

    private void btnSaveDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDoctorActionPerformed
        try {
            Date date = dates.getDate();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E");
            String newDate = sdf.format(date);
            String dcid = txtdoctorId.getText();
            String hpid = txtHospitalIds.getText();
            String spid = txtSpeciality.getText();
            String dname = txtDoctorName.getText();
            String gender = (String) cmbGender.getSelectedItem();
            BigDecimal dcfree = BigDecimal.valueOf(Double.parseDouble(txtDoctorFree.getText()));
            
            String scid = txtScheduleId.getText();
            String dayid = txtDayId.getText();
            String days = newDate;//(String) cmbDays.getSelectedItem();
            String doctorin = txtDoctorIn.getText();
            String doctorOut = txtDoctorOut.getText();
            int pcount = Integer.parseInt(txtPatientCount.getText());
            
            ArrayList<DoctorDTO> doctorDTOs = new ArrayList<>();
            DoctorDTO doctorDTO = new DoctorDTO();
            doctorDTO.setDcfree(dcfree);
            doctorDTO.setDcid(dcid);
            doctorDTO.setGender(gender);
            doctorDTO.setHpid(hpid);
            doctorDTO.setName(dname);
            doctorDTO.setSpid(spid);
            
            doctorDTOs.add(doctorDTO);
            
            ArrayList<ScheduleDTO> scheduleDTOs = new ArrayList<>();
            ScheduleDTO scheduleDTO = new ScheduleDTO();
            scheduleDTO.setDayid(dayid);
            scheduleDTO.setDcid(dcid);
            scheduleDTO.setDoctorin(doctorin);
            scheduleDTO.setDoctorout(doctorOut);
            scheduleDTO.setPatientcount(pcount);
            scheduleDTO.setScid(scid);
            
            scheduleDTOs.add(scheduleDTO);
            
            DaysDTO daysDTO = new DaysDTO(dayid, days);
            boolean isAdded = ctrlDays.add(daysDTO, doctorDTOs, scheduleDTOs);
            if (isAdded) {
                loadDoctorSchedule();
                clearDoctorSchedule();
                setEnableDoctorSchedule(false);
                btnSaveDoctor.requestFocusInWindow();
                JOptionPane.showMessageDialog(this, "Added Success");
            } else {
                JOptionPane.showMessageDialog(this, "Fail..");
            }
        } catch (Exception ex) {
            Logger.getLogger(AdiminForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSaveDoctorActionPerformed

    private void btnNewDoctorScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewDoctorScheduleActionPerformed
        clearDoctorSchedule();

        if (dtmDoctorSchedule.getRowCount() > 0) {
            tblDoctorSchedule.getSelectionModel().clearSelection();
            
        }
        setEnableDoctorSchedule(true, btnUpdate, btnDeleteDoctor);
        txtdoctorId.requestFocusInWindow();
        
        try {
            String dcid = IdGenerator.getNewDoctorIds("doctor", "dcid", "DC");
            txtdoctorId.setText(dcid);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdiminForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdiminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            String scid = IdGenerator.getNewScheduleIds("schedule", "scid", "SC");
            txtScheduleId.setText(scid);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdiminForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdiminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            String dayid = IdGenerator.getNewDaysIds("days", "dayid", "DY");
            txtDayId.setText(dayid);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdiminForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdiminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNewDoctorScheduleActionPerformed

    private void btnDeleteDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDoctorActionPerformed

        try {
            String scheduleid = dtmDoctorSchedule.getValueAt(tblDoctorSchedule.getSelectedRow(), 6).toString();
            String doctorid = dtmDoctorSchedule.getValueAt(tblDoctorSchedule.getSelectedRow(), 0).toString();
            String dayid = dtmDoctorSchedule.getValueAt(tblDoctorSchedule.getSelectedRow(), 7).toString();
            
            boolean deteleDOctor = ctrlDoctor.delete(dayid);
            boolean deteleDay = ctrlDays.delete(dayid);
            boolean deleteSchedule = scheduleController.delete(dayid);
            
            if (deteleDOctor) {
                if (deteleDay) {
                    if (deleteSchedule) {
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Delete Ok..");
            }
        } catch (Exception ex) {
            Logger.getLogger(AdiminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        loadDoctorSchedule();
    }//GEN-LAST:event_btnDeleteDoctorActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        HospitalDTO hospital = new HospitalDTO(
                txtHospitalId.getText(),
                txtHospitalName.getText());

        try {
            
            boolean result = false;
            
            if (txtHospitalId.isEnabled()) {
                result = ctrlHospital.add(hospital);
            } else {
                result = ctrlHospital.update(hospital);
            }
            if (result) {
                loadDataHospiatal();
                clearFiledHospital();
                setEnableHopital(false);
                btnNewHospital.requestFocusInWindow();
            } else {
                ImageIcon icons = new ImageIcon(this.getClass().getResource("/lk/ijse/doctor/icons/error_icon.png"));
                JOptionPane.showMessageDialog(this,
                        "Hospital has been fail to add",
                        "Error",
                        JOptionPane.ERROR_MESSAGE,
                        icons);
                txtHospitalId.requestFocusInWindow();
                txtHospitalId.selectAll();
            }
            
        } catch (SQLException ex) {
            String errormsg;
            
            ImageIcon icons = new ImageIcon(this.getClass().getResource("/lk/ijse/doctor/icons/error_icon.png"));
            
            switch (ex.getErrorCode()) {
                case 1062:
                    errormsg = "Duplicate entry has been found. Please enter valid Hospital Id to proceed.";
                    break;
                default:
                    errormsg = "Hospital has been failed to add";
                    break;
            }
            
            JOptionPane.showMessageDialog(this,
                    errormsg,
                    "Error",
                    JOptionPane.ERROR_MESSAGE,
                    icons);
            txtHospitalId.requestFocusInWindow();
            txtHospitalId.selectAll();
        } catch (Exception ex) {
            
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtHospitalNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHospitalNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnSave.doClick();
        }
    }//GEN-LAST:event_txtHospitalNameKeyPressed

    private void txtHospitalIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHospitalIdKeyReleased
        doValidateHospital();
    }//GEN-LAST:event_txtHospitalIdKeyReleased

    private void txtHospitalNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHospitalNameKeyReleased
        doValidateHospital();
    }//GEN-LAST:event_txtHospitalNameKeyReleased

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String hpid = dtmHosptal.getValueAt(tblHospital.getSelectedRow(), 0).toString();

        try {
            boolean deleted = ctrlHospital.delete(hpid);
            
            if (deleted) {
                loadDataHospiatal();
                clearFiledHospital();
                setEnableHopital(false);
                tblHospital.clearSelection();
                btnNewHospital.requestFocusInWindow();
            } else {
                ImageIcon icon = new ImageIcon(this.getClass().getResource("/lk/ijse/doctor/icons/error_icon.png"));
                JOptionPane.showMessageDialog(this,
                        "Hospital deletion has been failed,please try again.",
                        "Delete Error",
                        JOptionPane.ERROR_MESSAGE,
                        icon);
            }
        } catch (Exception ex) {
            ImageIcon icon = new ImageIcon(this.getClass().getResource("/lk/ijse/doctor/icons/error_icon.png"));
            JOptionPane.showMessageDialog(this,
                    "Hospital deletion has been failed,please try again.",
                    "Delete Error",
                    JOptionPane.ERROR_MESSAGE,
                    icon);
            Logger.getLogger(AdiminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnNewSpecialityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewSpecialityActionPerformed
        clearFiledSpeciality();

        if (dtmSpeciality.getRowCount() > 0) {
            tblSpeciality.getSelectionModel().clearSelection();
        }
        setEnableSpecialiy(true, btnSaveSpeciality, btnDeleteSpeciality);
        txtSpecialityId.requestFocusInWindow();
        
        try {
            String spid = IdGenerator.getNewSpecialityIds("speciality", "spid", "SP");
            txtSpecialityId.setText(spid);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdiminForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdiminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNewSpecialityActionPerformed

    private void btnSaveSpecialityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSpecialityActionPerformed
        SpecialityDTO speciality = new SpecialityDTO(
                txtSpecialityId.getText(),
                txtSpecialityName.getText());

        try {
            boolean result = false;
            
            if (txtSpecialityId.isEnabled()) {
                result = ctrlspeciality.add(speciality);
            } else {
                result = ctrlspeciality.update(speciality);
            }
            if (result) {
                loadDataSpeciality();
                clearFiledSpeciality();
                setEnableSpecialiy(false);
                btnSaveSpeciality.requestFocusInWindow();
            } else {
                ImageIcon icons = new ImageIcon(this.getClass().getResource("/lk/ijse/doctor/icons/error_icon.png"));
                JOptionPane.showMessageDialog(this,
                        "Speciality has been fail to add",
                        "Error",
                        JOptionPane.ERROR_MESSAGE,
                        icons);
                txtSpecialityId.requestFocusInWindow();
                txtSpecialityId.selectAll();
            }
        } catch (SQLException ex) {
            
            String errormsg;
            
            ImageIcon icons = new ImageIcon(this.getClass().getResource("/lk/ijse/doctor/icons/error_icon.png"));
            
            switch (ex.getErrorCode()) {
                case 1062:
                    errormsg = "Duplicate entry has been found. Please enter valid Speciality Id to proceed.";
                    break;
                default:
                    errormsg = "Specialty has been fail to add";
                    break;
            }
            
            JOptionPane.showMessageDialog(this,
                    errormsg,
                    "Error",
                    JOptionPane.ERROR_MESSAGE,
                    icons);
            txtSpecialityId.requestFocusInWindow();
            txtSpecialityId.selectAll();
        } catch (Exception ex) {
            
        }
    }//GEN-LAST:event_btnSaveSpecialityActionPerformed

    private void txtSpecialityNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSpecialityNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnSaveSpeciality.doClick();
        }
    }//GEN-LAST:event_txtSpecialityNameKeyPressed

    private void txtSpecialityIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSpecialityIdKeyReleased
        doValidateSpecility();
    }//GEN-LAST:event_txtSpecialityIdKeyReleased

    private void txtSpecialityNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSpecialityNameKeyReleased
        doValidateSpecility();
    }//GEN-LAST:event_txtSpecialityNameKeyReleased

    private void btnDeleteSpecialityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSpecialityActionPerformed

        String spid = dtmSpeciality.getValueAt(tblSpeciality.getSelectedRow(), 0).toString();
        
        try {
            boolean deleted = ctrlspeciality.delete(spid);
            if (deleted) {
                clearFiledSpeciality();
                loadDataSpeciality();
                setEnableSpecialiy(false);
                tblSpeciality.clearSelection();
                btnNewSpeciality.requestFocusInWindow();
            } else {
                ImageIcon icons = new ImageIcon(this.getClass().getResource("/lk/ijse/doctor/icons/error_icon.png"));
                
                JOptionPane.showMessageDialog(this,
                        "Speciality deletion has been failed, Please try again. ",
                        "Delete Error",
                        JOptionPane.ERROR_MESSAGE,
                        icons);
            }
        } catch (Exception ex) {
            ImageIcon icons = new ImageIcon(this.getClass().getResource("/lk/ijse/doctor/icons/error_icon.png"));
            
            JOptionPane.showMessageDialog(this,
                    "Speciality deletion has been failed, Please try again. ",
                    "Delete Error",
                    JOptionPane.ERROR_MESSAGE,
                    icons);
            Logger.getLogger(AdiminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteSpecialityActionPerformed

    private void txtSearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchBarActionPerformed
        searchHospiatal();
    }//GEN-LAST:event_txtSearchBarActionPerformed

    private void txtSearchSpecialityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchSpecialityActionPerformed
        searchSpeciality();
        //clearFiledSpeciality();
    }//GEN-LAST:event_txtSearchSpecialityActionPerformed

    private void txtDoctorInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDoctorInActionPerformed

    }//GEN-LAST:event_txtDoctorInActionPerformed

    private void txtSearchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBarKeyReleased
        //
    }//GEN-LAST:event_txtSearchBarKeyReleased

    private void txtdoctorIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdoctorIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdoctorIdActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        try {
            String dcid = txtdoctorId.getText();
            String hpid = txtHospitalIds.getText();
            String spid = txtSpeciality.getText();
            String dcname = txtDoctorName.getText();
            String gender = cmbGender.getSelectedItem().toString();
            BigDecimal dcfree = BigDecimal.valueOf(Double.parseDouble(txtDoctorFree.getText()));
            String scid = txtScheduleId.getText();
            String dayid = txtDayId.getText();
            Date date = dates.getDate();
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E");
            String newDate = sdf.format(date);
            String days = newDate;
            String doctorin = txtDoctorIn.getText();
            String doctorout = txtDoctorOut.getText();
            int pcount = Integer.parseInt(txtPatientCount.getText());
            
            ArrayList<DoctorDTO> doctorDTOs = new ArrayList<>();
            DoctorDTO doctorDTO = new DoctorDTO();
            doctorDTO.setDcid(dcid);
            doctorDTO.setHpid(hpid);
            doctorDTO.setSpid(spid);
            doctorDTO.setName(dcname);
            doctorDTO.setGender(gender);
            doctorDTO.setDcfree(dcfree);
            
            doctorDTOs.add(doctorDTO);
            
            ArrayList<ScheduleDTO> scheduleDTOs = new ArrayList<>();
            ScheduleDTO scheduleDTO = new ScheduleDTO();
            scheduleDTO.setScid(scid);
            scheduleDTO.setDcid(dcid);
            scheduleDTO.setDayid(dayid);
            scheduleDTO.setDoctorin(doctorin);
            scheduleDTO.setDoctorout(doctorout);
            scheduleDTO.setPatientcount(pcount);
            
            scheduleDTOs.add(scheduleDTO);
            
            DaysDTO daysDTO = new DaysDTO(dayid, days);
            
            boolean update = ctrlDays.update(daysDTO, doctorDTOs, scheduleDTOs);
            if (update) {
                loadDoctorSchedule();
                clearDoctorSchedule();
                setEnableDoctorSchedule(false);
                btnUpdate.requestFocusInWindow();
                JOptionPane.showMessageDialog(this, "Update sussed..");
            } else {
                JOptionPane.showMessageDialog(this, "Update Fail...");
            }
        } catch (Exception ex) {
            Logger.getLogger(AdiminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtPatientCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatientCountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPatientCountActionPerformed

    private void txtPatientCountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPatientCountKeyReleased
        doValidateDoctorSchedule();
    }//GEN-LAST:event_txtPatientCountKeyReleased

    private void txtPatientCountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPatientCountKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnSaveDoctor.doClick();
        }
    }//GEN-LAST:event_txtPatientCountKeyPressed

    private void txtdoctorIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdoctorIdKeyReleased
        doValidateDoctorSchedule();
    }//GEN-LAST:event_txtdoctorIdKeyReleased

    private void txtHospitalIdsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHospitalIdsKeyReleased
        doValidateDoctorSchedule();
    }//GEN-LAST:event_txtHospitalIdsKeyReleased

    private void txtSpecialityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSpecialityKeyReleased
        doValidateDoctorSchedule();
    }//GEN-LAST:event_txtSpecialityKeyReleased

    private void txtDoctorNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDoctorNameKeyReleased
        doValidateDoctorSchedule();
    }//GEN-LAST:event_txtDoctorNameKeyReleased

    private void cmbGenderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbGenderKeyReleased
        doValidateDoctorSchedule();
    }//GEN-LAST:event_cmbGenderKeyReleased

    private void txtDoctorFreeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDoctorFreeKeyReleased
        doValidateDoctorSchedule();
    }//GEN-LAST:event_txtDoctorFreeKeyReleased

    private void txtScheduleIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtScheduleIdKeyReleased
        doValidateDoctorSchedule();
    }//GEN-LAST:event_txtScheduleIdKeyReleased

    private void txtDayIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDayIdKeyReleased
        doValidateDoctorSchedule();
    }//GEN-LAST:event_txtDayIdKeyReleased

    private void txtDoctorInKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDoctorInKeyReleased
        doValidateDoctorSchedule();
    }//GEN-LAST:event_txtDoctorInKeyReleased

    private void txtDoctorOutKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDoctorOutKeyReleased
        doValidateDoctorSchedule();
    }//GEN-LAST:event_txtDoctorOutKeyReleased

    private void tblDoctorScheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDoctorScheduleMouseClicked
        try {
            String dcid = tblDoctorSchedule.getValueAt(tblDoctorSchedule.getSelectedRow(), 0).toString();
            String hpip = tblDoctorSchedule.getValueAt(tblDoctorSchedule.getSelectedRow(), 1).toString();
            String spid = tblDoctorSchedule.getValueAt(tblDoctorSchedule.getSelectedRow(), 2).toString();
            String dcname = tblDoctorSchedule.getValueAt(tblDoctorSchedule.getSelectedRow(), 3).toString();
            String gender = tblDoctorSchedule.getValueAt(tblDoctorSchedule.getSelectedRow(), 4).toString();
            String dcfree = tblDoctorSchedule.getValueAt(tblDoctorSchedule.getSelectedRow(), 5).toString();
            String scid = tblDoctorSchedule.getValueAt(tblDoctorSchedule.getSelectedRow(), 6).toString();
            String dayid = tblDoctorSchedule.getValueAt(tblDoctorSchedule.getSelectedRow(), 7).toString();
            String days = tblDoctorSchedule.getValueAt(tblDoctorSchedule.getSelectedRow(), 8).toString();
            String doctorin = tblDoctorSchedule.getValueAt(tblDoctorSchedule.getSelectedRow(), 9).toString();
            String doctorout = tblDoctorSchedule.getValueAt(tblDoctorSchedule.getSelectedRow(), 10).toString();
            String patientcount = tblDoctorSchedule.getValueAt(tblDoctorSchedule.getSelectedRow(), 11).toString();
            txtdoctorId.setText(dcid);
            txtHospitalIds.setText(hpip);
            txtSpeciality.setText(spid);
            txtDoctorName.setText(dcname);
            cmbGender.setSelectedItem(gender);
            txtDoctorFree.setText(dcfree);
            txtScheduleId.setText(scid);
            txtDayId.setText(dayid);
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = sdf.parse(days);

            dates.setDate(parse);
            txtDoctorIn.setText(doctorin);
            txtDoctorOut.setText(doctorout);
            txtPatientCount.setText(patientcount);

            setEnableDoctorSchedule(true, btnSaveDoctor, txtdoctorId, txtScheduleId, txtDayId);
        } catch (ParseException ex) {
            Logger.getLogger(AdiminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblDoctorScheduleMouseClicked
    
    private void searchHospiatal() {
        
        try {
            String name = txtSearchBar.getText();
            
            HospitalDTO hospital = ctrlHospital.serachName(name);
            dtmHosptal.setRowCount(0);
            Object[] rowdata = {hospital.getHpid(), hospital.getName()};
            dtmHosptal.addRow(rowdata);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Not Found...");
            Logger.getLogger(AdiminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void searchSpeciality() {
        
        try {
            String name = txtSearchSpeciality.getText();
            dtmSpeciality.setRowCount(0);
            SpecialityDTO speciality = ctrlspeciality.searchName(name);
            Object[] rowdata = {speciality.getSpid(), speciality.getName()};
            dtmSpeciality.addRow(rowdata);
        } catch (Exception ex) {
            Logger.getLogger(AdiminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteDoctor;
    private javax.swing.JButton btnDeleteSpeciality;
    private javax.swing.JButton btnNewDoctorSchedule;
    private javax.swing.JButton btnNewHospital;
    private javax.swing.JButton btnNewSpeciality;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveDoctor;
    private javax.swing.JButton btnSaveSpeciality;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cmbGender;
    private com.toedter.calendar.JDateChooser dates;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblDoctorSchedule;
    private javax.swing.JTable tblHospital;
    private javax.swing.JTable tblSpeciality;
    private javax.swing.JTextField txtDayId;
    private javax.swing.JTextField txtDoctorFree;
    private javax.swing.JTextField txtDoctorIn;
    private javax.swing.JTextField txtDoctorName;
    private javax.swing.JTextField txtDoctorOut;
    private javax.swing.JTextField txtHospitalId;
    private javax.swing.JTextField txtHospitalIds;
    private javax.swing.JTextField txtHospitalName;
    private javax.swing.JTextField txtPatientCount;
    private javax.swing.JTextField txtScheduleId;
    private javax.swing.JTextField txtSearchBar;
    private javax.swing.JTextField txtSearchSpeciality;
    private javax.swing.JTextField txtSpeciality;
    private javax.swing.JTextField txtSpecialityId;
    private javax.swing.JTextField txtSpecialityName;
    private javax.swing.JTextField txtdoctorId;
    // End of variables declaration//GEN-END:variables

}
