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
import lk.ijse.doctor.dao.custom.RegistrationDAO;
import lk.ijse.doctor.db.ConnectionFactory;
import lk.ijse.doctor.dto.RegistrationDTO;

/**
 *
 * @author sameera
 */
public class RegistrationDAOImpl implements RegistrationDAO{
    
    private Connection connection;
    
    public RegistrationDAOImpl(){
        connection =ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(RegistrationDTO dto) throws Exception {
        
        String sql ="INSERT INTO Registration VALUES(?,?,?,?,?,?,?)";
        
        PreparedStatement pstm =connection.prepareStatement(sql);
        
        pstm.setString(1,dto.getRgid());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getAddress());
        pstm.setString(4, dto.getGender());
        pstm.setString(5, dto.getNic());
        pstm.setInt(6,dto.getAge());
        pstm.setInt(7,dto.getTeleno());
        int result = pstm.executeUpdate();
        
        return (result > 0);
    }

    @Override
    public boolean update(RegistrationDTO dto) throws Exception {
       
        String sql ="UPDATE Registration SET name=?,address=?,gender=?,nic=? ,age=?, teleno=? WHERE rgid=? ";
        
        PreparedStatement pstm =connection.prepareStatement(sql);
        
        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getAddress());
        pstm.setString(3,dto.getGender());
        pstm.setString(4, dto.getNic());
        pstm.setInt(5,dto.getAge());
        pstm.setInt(6,dto.getTeleno());
        pstm.setString(7, dto.getRgid());
        int result = pstm.executeUpdate();
        
        return (result > 0);
    }

    @Override
    public RegistrationDTO search(String key) throws Exception {
       
        String sql = "SELECT * FROM Registration WHERE rgid ='" + key + "'";

        RegistrationDTO registration = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {

            registration = new RegistrationDTO(
                    rst.getString("rgid"),
                    rst.getString("name"),
                    rst.getString("address"),
                    rst.getString("gender"),
                    rst.getString("nic"),
                    rst.getInt("age"),
                    rst.getInt("teleno"));
        }
        return registration;
    }

    @Override
    public boolean delete(String key) throws Exception {
        
        String sql ="DELETE FROM Registration WHERE rgid='"+key+"'";
        
        Statement stm =connection.createStatement();
        int affected =stm.executeUpdate(sql);
        
        return (affected > 0);
    }

    @Override
    public ArrayList<RegistrationDTO> getAll() throws Exception {
        
        String sql = "SELECT * FROM Registration";

        ArrayList<RegistrationDTO> allRegistration = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while(rst.next()) {
            if (allRegistration == null) {
                allRegistration = new ArrayList<>();
            }

            RegistrationDTO dto = new RegistrationDTO(
                    rst.getString("rgid"),
                    rst.getString("name"),
                    rst.getString("address"),
                    rst.getString("gender"),
                    rst.getString("nic"),
                    rst.getInt("age"),
                    rst.getInt("teleno"));
            allRegistration.add(dto);
        }
        return allRegistration;
    }

    @Override
    public ArrayList<String> getAllRegIds() throws Exception {
        
        String sql="SELECT rgid FROM Registration";
        
        Statement stm =connection.createStatement();
        ResultSet rst =stm.executeQuery(sql);
        ArrayList<String> rgidList=new ArrayList<>();
        while(rst.next()){
            rgidList.add(rst.getString("rgid"));
        }
        return rgidList;
    }
    
}
