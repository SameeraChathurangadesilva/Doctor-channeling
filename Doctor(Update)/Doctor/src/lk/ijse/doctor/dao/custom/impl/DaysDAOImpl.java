/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.doctor.dao.custom.DaysDAO;
import lk.ijse.doctor.db.ConnectionFactory;
import lk.ijse.doctor.dto.DaysDTO;
import lk.ijse.doctor.dto.ViewDoctorScheduleDTO;

/**
 *
 * @author sameera
 */
public class DaysDAOImpl implements DaysDAO {

    private Connection connection;

    public DaysDAOImpl() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(DaysDTO dto) throws Exception {

        String sql = "INSERT INTO days VALUES(?,?)";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getDayid());
        pstm.setString(2, dto.getDays());
        int result = pstm.executeUpdate();

        return (result > 0);
    }

    @Override
    public boolean update(DaysDTO dto) throws Exception {

        String sql = "UPDATE days set days = ? WHERE dayid= ?";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getDays());
        pstm.setString(2, dto.getDayid());
        int result = pstm.executeUpdate();

        return (result > 0);
    }

    @Override
    public DaysDTO search(String key) throws Exception {

        String sql = "SELETE * FROM days WHERE dayid ='" + key + "' ";

        DaysDTO days = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {

            days = new DaysDTO(rst.getString("dayid"),
                    rst.getString("days"));
        }
        return days;
    }

    @Override
    public boolean delete(String key) throws Exception {

        String sql = "DELETE FROM days WHERE dayid ='" + key + "'";

        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }

    @Override
    public ArrayList<DaysDTO> getAll() throws Exception {

        String sql = "SELECT * FROM days";

        ArrayList<DaysDTO> allDays = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()) {
            if (allDays == null) {
                allDays = new ArrayList<>();
            }

            DaysDTO dto = new DaysDTO(
                    rst.getString("dayid"),
                    rst.getString("days"));
            allDays.add(dto);
        }
        return allDays;

    }

    @Override
    public ArrayList<ViewDoctorScheduleDTO> getAllDetails() throws Exception {
        
        String sql = "select dc.dcid , dc.hpid ,dc.spid ,dc.name ,dc.gender ,dc.dcfree , sc.scid ,dy.dayid ,dy.days,sc.doctorin,sc.doctorout ,sc.patientcount \n"
                + "from doctor dc , schedule sc ,days dy\n"
                + "where dc.dcid = sc.dcid and dy.dayid = sc.dayid;";

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<ViewDoctorScheduleDTO> getAll = new ArrayList<>();
        while (rst.next()) {
            ViewDoctorScheduleDTO viewDoctorSchedule = new ViewDoctorScheduleDTO();
            viewDoctorSchedule.setDcid(rst.getString(1));
            viewDoctorSchedule.setHpid(rst.getString(2));
            viewDoctorSchedule.setSpid(rst.getString(3));
            viewDoctorSchedule.setDoctorname(rst.getString(4));
            viewDoctorSchedule.setGender(rst.getString(5));
            viewDoctorSchedule.setDcfee(rst.getString(6));
            viewDoctorSchedule.setScid(rst.getString(7));
            viewDoctorSchedule.setDayid(rst.getString(8));
            viewDoctorSchedule.setDays(rst.getString(9));
            viewDoctorSchedule.setDoctorin(rst.getString(10));
            viewDoctorSchedule.setDoctorout(rst.getString(11));
            viewDoctorSchedule.setPatientCount(rst.getString(12));
            getAll.add(viewDoctorSchedule);
        }
        return getAll;
    }

    @Override
    public ViewDoctorScheduleDTO getAllDetails(String dcid) throws Exception {
       
        String sql = "select dc.dcid , dc.hpid ,dc.spid ,dc.name ,dc.gender ,dc.dcfree , sc.scid ,dy.dayid ,dy.days,sc.doctorin,sc.doctorout ,sc.patientcount \n"
                + "from doctor dc , schedule sc ,days dy\n"
                + "where dc.dcid = sc.dcid and dy.dayid = sc.dayid and dc.dcid like '"+dcid+"%'";

        ViewDoctorScheduleDTO viewDoctorSchedule = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {

            viewDoctorSchedule = new ViewDoctorScheduleDTO();
            rst.getString(1);
            rst.getString(2);
            rst.getString(3);
            rst.getString(4);
            rst.getString(5);
            rst.getString(6);
            rst.getString(7);
            rst.getString(8);
            rst.getString(9);
            rst.getString(10);
            rst.getString(11);
            rst.getString(12);
        }
        return viewDoctorSchedule;
    }
}
