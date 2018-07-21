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
import lk.ijse.doctor.dao.custom.PatientDAO;
import lk.ijse.doctor.db.ConnectionFactory;
import lk.ijse.doctor.dto.CurentIdDTO;
import lk.ijse.doctor.dto.PatientDTO;

/**
 *
 * @author sameera
 */
public class PatientDAOImpl implements PatientDAO {

    private Connection connection;

    public PatientDAOImpl() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(PatientDTO dto) throws Exception {

        String sql = "INSERT INTO patient VALUES(?,?,?,?,?,?,?)";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getPtid());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getAddress());
        pstm.setString(4, dto.getGender());
        pstm.setString(5, dto.getNic());
        pstm.setInt(6, dto.getAge());
        pstm.setInt(7, dto.getTeleno());
        int result = pstm.executeUpdate();

        return (result > 0);
    }

    @Override
    public boolean update(PatientDTO dto) throws Exception {

        String sql = "UPDATE patient SET name =?,address =?,gender = ?,nic =?,age =?,teleno =? WHERE ptid =?";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getAddress());
        pstm.setString(3, dto.getGender());
        pstm.setString(4, dto.getNic());
        pstm.setInt(5, dto.getAge());
        pstm.setInt(6, dto.getTeleno());
        pstm.setString(7, dto.getPtid());
        int result = pstm.executeUpdate();

        return (result > 0);
    }

    @Override
    public PatientDTO search(String key) throws Exception {

        String sql = "SELECT * FROM patient WHERE ptid ='" + key + "'";

        PatientDTO patient = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            patient = new PatientDTO(
                    rst.getString("ptid"),
                    rst.getString("name"),
                    rst.getString("address"),
                    rst.getString("gender"),
                    rst.getString("nic"),
                    rst.getInt("age"),
                    rst.getInt("teleno"));
        }
        return patient;
    }

    @Override
    public boolean delete(String key) throws Exception {

        String sql = "DELETE FROM patient WHERE ptid  ='" + key + "'";

        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }

    @Override
    public ArrayList<PatientDTO> getAll() throws Exception {

        String sql = "SELECT * FROM patient";

        ArrayList<PatientDTO> allPatinets = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()) {

            if (allPatinets == null) {
                allPatinets = new ArrayList<>();
            }

            PatientDTO dto = new PatientDTO(
                    rst.getString("ptid"),
                    rst.getString("name"),
                    rst.getString("address"),
                    rst.getString("gender"),
                    rst.getString("nic"),
                    rst.getInt("age"),
                    rst.getInt("teleno"));
            allPatinets.add(dto);
        }
        return allPatinets;
    }

    @Override
    public ArrayList<String> allPatientIds() throws Exception {

        String sql = "SELECT ptid FROM patient";

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String> ptidList = new ArrayList<>();
        while (rst.next()) {
            ptidList.add(rst.getString("ptid"));
        }
        return ptidList;
    }

    @Override
    public PatientDTO searchName(String name) throws Exception {

        String sql = "SELECT * FROM patient WHERE name ='" + name + "'";

        PatientDTO patient = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            patient = new PatientDTO(
                    rst.getString("ptid"),
                    rst.getString("name"),
                    rst.getString("address"),
                    rst.getString("gender"),
                    rst.getString("nic"),
                    rst.getInt("age"),
                    rst.getInt("teleno"));
        }
        return patient;
    }

    @Override
    public ArrayList<PatientDTO> sePatientDTOs(String ptid) throws Exception {
        String sql = "SELECT * FROM patient WHERE ptid like '" + ptid + "%'";

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<PatientDTO> getall = new ArrayList<>();
        while (rst.next()) {
            PatientDTO patientDTO = new PatientDTO();
            patientDTO.setPtid(rst.getString("ptid"));
            patientDTO.setName(rst.getString("name"));
            patientDTO.setAddress(rst.getString("address"));
            patientDTO.setGender(rst.getString("gender"));
            patientDTO.setNic(rst.getString("nic"));
            patientDTO.setAge(rst.getInt("age"));
            patientDTO.setTeleno(rst.getInt("teleno"));
            getall.add(patientDTO);

        }
        return getall;
    }

    @Override
    public ArrayList<PatientDTO> sePatientDTO(String name) throws Exception {
        String sql = "SELECT * FROM patient WHERE name like '" + name + "%'";

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<PatientDTO> getAllArrayList = new ArrayList<>();
        while (rst.next()) {

            PatientDTO pdto = new PatientDTO();
            pdto.setPtid(rst.getString("ptid"));
            pdto.setName(rst.getString("name"));
            pdto.setAddress(rst.getString("address"));
            pdto.setGender(rst.getString("gender"));
            pdto.setNic(rst.getString("nic"));
            pdto.setAge(rst.getInt("age"));
            pdto.setTeleno(rst.getInt("teleno"));
            getAllArrayList.add(pdto);
        }
        return getAllArrayList;
    }

    @Override
    public ArrayList<String> patientName() throws Exception {
        String sql = "SELECT name FROM patient";

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String> getAll = new ArrayList<>();
        while (rst.next()) {
            getAll.add(rst.getString("name"));
        }
        return getAll;
    }

    @Override
    public CurentIdDTO searchAppNo(String scid) throws Exception {

        String sql = "SELECT * FROM curentid WHERE scid ='" + scid + "'";

        CurentIdDTO no = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            no = new CurentIdDTO(
                    rst.getString("dcid"),
                    rst.getString("scid"),
                    rst.getString("cunId"),
                    rst.getString("date"));
        }
        return no;
    }

    @Override
    public boolean updatePatient(CurentIdDTO curentIdDTO) throws Exception {
        String sql = "UPDATE curentId set scid =?, CunId = ? ,date = ? WHERE dcid =?";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, curentIdDTO.getScid());
        pstm.setString(2, curentIdDTO.getCunId());
        pstm.setString(3, curentIdDTO.getDate());
        pstm.setString(4, curentIdDTO.getDcid());
        int result = pstm.executeUpdate();

        return (result) > 0;
    }

    @Override
    public boolean addPatientCurrent(CurentIdDTO curentIdDTO) throws Exception {

        String sql = "INSERT INTO  curentId VALUES (?,?,?,?)";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, curentIdDTO.getDcid());
        pstm.setString(2, curentIdDTO.getScid());
        pstm.setString(3, curentIdDTO.getCunId());
        pstm.setString(4, curentIdDTO.getDate());
        int result = pstm.executeUpdate();

        return (result > 0);
    }

    @Override
    public boolean deletePatientCurrent(String dcid) throws Exception {

        String sql = "DELETE FROM curentId WHERE CunId  ='" + dcid + "'";

        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }

    @Override
    public CurentIdDTO searchAppDate(String dcid, String date) throws Exception {
        String sql = "SELECT * FROM curentid WHERE dcid ='" + dcid + "' and date='" + date + "'";

        CurentIdDTO no = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            no = new CurentIdDTO(
                    rst.getString("dcid"),
                    rst.getString("scid"),
                    rst.getString("cunId"),
                    rst.getString("date"));
        }
        return no;
    }
}
