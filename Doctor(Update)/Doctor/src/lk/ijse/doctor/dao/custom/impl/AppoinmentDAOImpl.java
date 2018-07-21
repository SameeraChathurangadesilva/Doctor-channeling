/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.dao.custom.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.doctor.dao.custom.AppoinmentDAO;
import lk.ijse.doctor.db.ConnectionFactory;
import lk.ijse.doctor.dto.AppoinmentDTO;
import lk.ijse.doctor.dto.ViewAppointmentDTO;

/**
 *
 * @author sameera
 */
public class AppoinmentDAOImpl implements AppoinmentDAO {

    private Connection connection;

    public AppoinmentDAOImpl() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(AppoinmentDTO dto) throws Exception {

        String sql = "INSERT INTO appoinment VALUES(?,?,?,?,?,?)";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getApid());
        pstm.setString(2, dto.getDcid());
        pstm.setString(3, dto.getPtid());
        pstm.setString(4, dto.getApno());
        pstm.setString(5, dto.getTime());
        pstm.setString(6, dto.getDate());

        int result = pstm.executeUpdate();

        return (result > 0);
    }

    @Override
    public boolean update(AppoinmentDTO dto) throws Exception {

        String sql = "UPDATE appoinment SET dcid = ?,ptid =?,apno =? ,time =? ,date =? WHERE apid = ? ";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getDcid());
        pstm.setString(2, dto.getPtid());
        pstm.setString(3, dto.getApno());
        pstm.setString(4, dto.getTime());
        pstm.setString(5, dto.getDate());
        pstm.setString(6, dto.getApid());

        int result = pstm.executeUpdate();

        return (result > 0);
    }

    @Override
    public AppoinmentDTO search(String key) throws Exception {

        String sql = "SELECT * FROM  appoinment WHERE apid ='" + key + "'";

        AppoinmentDTO appoinment = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            appoinment = new AppoinmentDTO(rst.getString("apid"),
                    rst.getString("dcid"),
                    rst.getString("ptid"),
                    rst.getString("apno"),
                    rst.getString("time"),
                    rst.getString("date"));
        }
        return appoinment;
    }

    @Override
    public boolean delete(String key) throws Exception {

        String sql = "DELETE FROM appoinment WHERE apid ='" + key + "'";

        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }

    @Override
    public ArrayList<AppoinmentDTO> getAll() throws Exception {

        String sql = "SELECT * FROM  appoinment";

        ArrayList<AppoinmentDTO> allAppointment = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()) {
            if (allAppointment == null) {
                allAppointment = new ArrayList<>();
            }
            AppoinmentDTO dto = new AppoinmentDTO(rst.getString("apid"),
                    rst.getString("dcid"),
                    rst.getString("ptid"),
                    rst.getString("apno"),
                    rst.getString("time"),
                    rst.getString("date"));
            allAppointment.add(dto);
        }
        return allAppointment;
    }

    @Override
    public ArrayList<String> seratchIds() throws Exception {

        String sql = "SELECT apid FROM appoinment";

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String> getIds = new ArrayList<>();
        while (rst.next()) {
            getIds.add(rst.getString("apid"));
        }
        return getIds;
    }

    @Override
    public ArrayList<ViewAppointmentDTO> getAllAppointment(String apid) throws Exception {

        String sql = "select ap.apid ,dc.name ,ap.ptid ,ap.apno ,ap.time ,ap.date \n"
                + "from appoinment ap ,doctor dc\n"
                + "where ap.dcid =dc.dcid  and ap.apid like '"+apid+"%'";
        
        
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<ViewAppointmentDTO> getAll = new ArrayList<>();
        while(rst.next()) {
             ViewAppointmentDTO viewAppointment = new ViewAppointmentDTO();
            viewAppointment.setApid(rst.getString(1));
            viewAppointment.setDcname(rst.getString(2));
            viewAppointment.setPtid(rst.getString(3));
            viewAppointment.setApno(rst.getString(4));
            viewAppointment.setTime(rst.getString(5));
            viewAppointment.setDate(rst.getString(6));
            getAll.add(viewAppointment);

        }
        return getAll;
    }

    @Override
    public ArrayList<ViewAppointmentDTO> loadAppointmentDetails() throws Exception {

        String sql = "select ap.apid ,dc.name ,p.ptid ,ap.apno ,ap.time ,ap.date \n"
                + "from patient p ,appoinment ap ,doctor dc\n"
                + "where p.ptid =ap.ptid and dc.dcid =ap.dcid";

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<ViewAppointmentDTO> getAll = new ArrayList<>();
        while (rst.next()) {

            ViewAppointmentDTO viewAppointment = new ViewAppointmentDTO();
            viewAppointment.setApid(rst.getString(1));
            viewAppointment.setDcname(rst.getString(2));
            viewAppointment.setPtid(rst.getString(3));
            viewAppointment.setApno(rst.getString(4));
            viewAppointment.setTime(rst.getString(5));
            viewAppointment.setDate(rst.getString(6));
            getAll.add(viewAppointment);
        }
        return getAll;
    }
}
