/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.dao.custom.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.doctor.dao.custom.DoctorDAO;
import lk.ijse.doctor.db.ConnectionFactory;
import lk.ijse.doctor.dto.DoctorDTO;
import lk.ijse.doctor.dto.ViewDoctorDTO;

/**
 *
 * @author sameera
 */
public class DoctorDAOImpl implements DoctorDAO {

    private Connection connection;

    public DoctorDAOImpl() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public DoctorDTO search(String key) throws Exception {

        String sql = "SELECT * FROM  doctor WHERE dcid ='" + key + "'";

        DoctorDTO doctor = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            doctor = new DoctorDTO(rst.getString("dcid"),
                    rst.getString("hpid"),
                    rst.getString("spid"),
                    rst.getString("name"),
                    rst.getString("gender"),
                    rst.getBigDecimal("dcfree"));
        }
        return doctor;
    }

    @Override
    public boolean delete(String key) throws Exception {

        String sql = "DELETE FROM doctor WHERE dcid= '" + key + "'";

        Statement stm = connection.createStatement();
        int afftectedRows = stm.executeUpdate(sql);

        return (afftectedRows > 0);
    }

    @Override
    public ArrayList<DoctorDTO> getAll() throws Exception {

        String sql = "SELECT * FROM doctor";

        ArrayList<DoctorDTO> allDoctors = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()) {
            if (allDoctors == null) {
                allDoctors = new ArrayList<>();
            }

            DoctorDTO dto = new DoctorDTO(rst.getString("dcid"),
                    rst.getString("hpid"),
                    rst.getString("spid"),
                    rst.getString("name"),
                    rst.getString("gender"),
                    rst.getBigDecimal("dcfree"));
            allDoctors.add(dto);
        }
        return allDoctors;
    }

    @Override
    public ArrayList<String> getAllNames() throws Exception {

        String sql = "SELECT name FROM  doctor";

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String> nameList = new ArrayList<>();
        while (rst.next()) {
            nameList.add(rst.getString("name"));
        }
        return nameList;
    }

    @Override
    public DoctorDTO searchName(String name) throws Exception {

        String sql = "SELECT * FROM doctor WHERE name ='" + name + "'";

        DoctorDTO doctor = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {

            doctor = new DoctorDTO(
                    rst.getString("dcid"),
                    rst.getString("hpid"),
                    rst.getString("spid"),
                    rst.getString("name"),
                    rst.getString("gender"),
                    rst.getBigDecimal("dcfree"));
        }
        return doctor;
    }

    @Override
    public ViewDoctorDTO searchList(String name) throws Exception {
        String SQL = "Select d.dcid,h.name,s.name,d.name,gender,dcfree\n"
                + "from Doctor d,Hospital h,Speciality s\n"
                + "where s.spid=d.spid and d.hpid=h.hpid and d.name like '"+name+"%'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ViewDoctorDTO v = null;
        //ArrayList<ViewDoctorDTO> allArrayList = new ArrayList<>();
        if (rst.next()) {
            v = new ViewDoctorDTO();
            v.setDocID(rst.getString(1));
            v.setHosName(rst.getString(2));
            v.setSpName(rst.getString(3));
            v.setDocName(rst.getString(4));
            v.setGender(rst.getString(5));
            v.setFeer(rst.getDouble(6));
            //allArrayList.add(v);
        }
        return v;
    }

    @Override
    public boolean add(ArrayList<DoctorDTO> doctorDTOs) throws Exception {
        String sql = "INSERT INTO doctor VALUES(?,?,?,?,?,?)";

        PreparedStatement pstm = connection.prepareStatement(sql);
        for(DoctorDTO dto:doctorDTOs){
        pstm.setString(1, dto.getDcid());
        pstm.setString(2, dto.getHpid());
        pstm.setString(3, dto.getSpid());
        pstm.setString(4, dto.getName());
        pstm.setString(5, dto.getGender());
        pstm.setBigDecimal(6, dto.getDcfree());
        }
        int result = pstm.executeUpdate();

        return (result > 0);
    }

    @Override
    public boolean update(ArrayList<DoctorDTO> doctorDTOs) throws Exception {
        String sql = "UPDATE doctor SET hpid =?,spid =?, name=?, gender =? ,dcfree =? WHERE dcid =?";

        PreparedStatement pstm = connection.prepareStatement(sql);
        for(DoctorDTO dto : doctorDTOs){
        pstm.setString(1, dto.getHpid());
        pstm.setString(2, dto.getSpid());
        pstm.setString(3, dto.getName());
        pstm.setString(4, dto.getGender());
        pstm.setBigDecimal(5, dto.getDcfree());
        pstm.setString(6, dto.getDcid());
        }
        int result = pstm.executeUpdate();
        
        return (result > 0);
    }

    @Override
    public boolean add(DoctorDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(DoctorDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ViewDoctorDTO> searchDoctorSpeciality(String name) throws Exception {
        
        String SQL = "Select d.dcid,h.name,s.name,d.name,gender,dcfree\n"
                + "from Doctor d,Hospital h,Speciality s\n"
                + "where s.spid=d.spid and d.hpid=h.hpid and s.name like '"+name+"%'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        ArrayList<ViewDoctorDTO> viewDoctorDTOs = new ArrayList<>();
        while (rst.next()) {
            ViewDoctorDTO v = new ViewDoctorDTO();
            v.setDocID(rst.getString(1));
            v.setHosName(rst.getString(2));
            v.setSpName(rst.getString(3));
            v.setDocName(rst.getString(4));
            v.setGender(rst.getString(5));
            v.setFeer(rst.getDouble(6));
            viewDoctorDTOs.add(v);
        }
        return viewDoctorDTOs;
    }
}
