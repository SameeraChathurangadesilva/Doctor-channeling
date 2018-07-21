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
import lk.ijse.doctor.dao.custom.ScheduleDAO;
import lk.ijse.doctor.db.ConnectionFactory;
import lk.ijse.doctor.dto.ScheduleDTO;
import lk.ijse.doctor.dto.ViewScheduleDTO;

/**
 *
 * @author sameera
 */
public class ScheduleDAOImpl implements ScheduleDAO {

    private Connection connection;

    public ScheduleDAOImpl() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public ScheduleDTO search(String key) throws Exception {

        String sql = "SELECT * FROM schedule WHERE scid='" + key + "'";

        ScheduleDTO schedule = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            schedule = new ScheduleDTO(
                    rst.getString("scid"),
                    rst.getString("dcid"),
                    rst.getString("dayid"),
                    rst.getString("doctorin"),
                    rst.getString("doctorout"),
                    rst.getInt("patientcount"));
        }
        return schedule;
    }

    @Override
    public boolean delete(String key) throws Exception {

        String sql = "DELETE FROM schedule WHERE scid ='" + key + "'";

        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }

    @Override
    public ArrayList<ScheduleDTO> getAll() throws Exception {

        String sql = "SELECT * FROM schedule";

        ArrayList<ScheduleDTO> allSchedule = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()) {
            if (allSchedule == null) {
                allSchedule = new ArrayList<>();
            }

            ScheduleDTO dto = new ScheduleDTO(
                    rst.getString("scid"),
                    rst.getString("dcid"),
                    rst.getString("dayid"),
                    rst.getString("doctorin"),
                    rst.getString("doctorout"),
                    rst.getInt("patientcount"));
            allSchedule.add(dto);
        }
        return allSchedule;
    }

    @Override
    public boolean add(ArrayList<ScheduleDTO> scheduleDTOs) throws Exception {
        String sql = "INSERT INTO schedule VALUES(?,?,?,?,?,?)";

        PreparedStatement pstm = connection.prepareStatement(sql);
        for (ScheduleDTO dto : scheduleDTOs) {
            pstm.setString(1, dto.getScid());
            pstm.setString(2, dto.getDcid());
            pstm.setString(3, dto.getDayid());
            pstm.setString(4, dto.getDoctorin());
            pstm.setString(5, dto.getDoctorout());
            pstm.setInt(6, dto.getPatientcount());
        }
        int result = pstm.executeUpdate();

        return (result > 0);
    }

    @Override
    public boolean add(ScheduleDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ViewScheduleDTO> searchIdsQ() throws Exception {

        String sql = "select sc.scid ,sc.dcid ,d.days , doctorin,doctorout ,patientcount \n"
                + "from schedule sc ,days d \n"
                + "where d.dayid = sc.dayid; ";

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<ViewScheduleDTO> getAll = new ArrayList<>();
        while (rst.next()) {

            ViewScheduleDTO viewSchedule = new ViewScheduleDTO();
            viewSchedule.setScid(rst.getString("scid"));
            viewSchedule.setDcid(rst.getString("dcid"));
            viewSchedule.setDays(rst.getString("days"));
            viewSchedule.setDoctorin(rst.getString("doctorin"));
            viewSchedule.setDoctorout(rst.getString("doctorout"));
            viewSchedule.setPatientcount(rst.getString("patientcount"));
            getAll.add(viewSchedule);
        }
        return getAll;
    }

    @Override
    public boolean update(ArrayList<ScheduleDTO> scheduleDTOs) throws Exception {
        String sql = "UPDATE schedule SET dcid=?,dayid=?,doctorin=?, doctorout=?, patientcount=? WHERE scid =? ";

        PreparedStatement pstm = connection.prepareStatement(sql);
        for (ScheduleDTO dto : scheduleDTOs) {
            pstm.setString(1, dto.getDcid());
            pstm.setString(2, dto.getDayid());
            pstm.setString(3, dto.getDoctorin());
            pstm.setString(4, dto.getDoctorout());
            pstm.setInt(5, dto.getPatientcount());
            pstm.setString(6, dto.getScid());
        }
        int result = pstm.executeUpdate();

        return (result > 0);
    }

    @Override
    public boolean update(ScheduleDTO dto) throws Exception {
        String sql = "UPDATE schedule SET dcid=?,dayid=?,doctorin=?, doctorout=?, patientcount=? WHERE scid =? ";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getDcid());
        pstm.setString(2, dto.getDayid());
        pstm.setString(3, dto.getDoctorin());
        pstm.setString(4, dto.getDoctorout());
        pstm.setInt(5, dto.getPatientcount());
        pstm.setString(6, dto.getScid());

        int result = pstm.executeUpdate();

        return (result > 0);
    }

    @Override
    public ScheduleDTO searchDoctorA(String dcid) throws Exception {

        String sql = "SELECT * FROM schedule WHERE dcid='" + dcid + "'";

        ScheduleDTO scheduleDTO = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            scheduleDTO = new ScheduleDTO(
                    rst.getString("scid"),
                    rst.getString("dcid"),
                    rst.getString("dayid"),
                    rst.getString("doctorin"),
                    rst.getString("doctorout"),
                    rst.getInt("patientcount"));
        }
        return scheduleDTO;
    }
}
