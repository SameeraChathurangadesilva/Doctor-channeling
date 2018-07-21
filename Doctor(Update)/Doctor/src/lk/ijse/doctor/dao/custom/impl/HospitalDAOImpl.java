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
import lk.ijse.doctor.dao.custom.HospitalDAO;
import lk.ijse.doctor.db.ConnectionFactory;
import lk.ijse.doctor.dto.HospitalDTO;

/**
 *
 * @author sameera
 */
public class HospitalDAOImpl implements HospitalDAO{
    
    private Connection connection;
    
    public HospitalDAOImpl(){
        connection =ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(HospitalDTO dto) throws Exception {
        
        String sql ="INSERT INTO hospital VALUES(?,?)";
        
        PreparedStatement pstm =connection.prepareStatement(sql);
        
        pstm.setString(1, dto.getHpid());
        pstm.setString(2, dto.getName());
        int result = pstm.executeUpdate();
        
        return  (result > 0);
    }

    @Override
    public boolean update(HospitalDTO dto) throws Exception {
        
        String sql ="UPDATE hospital SET name = ? WHERE hpid = ?";
        
        PreparedStatement pstm =connection.prepareStatement(sql);
        
        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getHpid());
        int result  = pstm .executeUpdate();
        
        return  (result > 0);
    }

    @Override
    public HospitalDTO search(String key) throws Exception {
       
        String sql ="SELECT * FROM hospital WHERE hpid ='"+key+"'";
        
        HospitalDTO hospital = null;
        
        Statement stm =connection.createStatement();
        ResultSet rst =stm.executeQuery(sql);
        if(rst.next()){
            hospital =new HospitalDTO(rst.getString("hpid"), 
                    rst.getString("name"));
        }
        return hospital;
    }

    @Override
    public boolean delete(String key) throws Exception {
        
        String sql ="DELETE FROM hospital WHERE hpid ='"+key+"'";
        
        Statement stm =connection.createStatement();
        int afftectedRows =stm.executeUpdate(sql);
        
        return (afftectedRows > 0);
    }

    @Override
    public ArrayList<HospitalDTO> getAll() throws Exception {
       
        String sql = "SELECT * FROM hospital";

        ArrayList<HospitalDTO> allHospitals = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()) {
            if (allHospitals == null) {
                allHospitals = new ArrayList<>();
            }
            HospitalDTO dto = new HospitalDTO(rst.getString("hpid"),
                    rst.getString("name"));
            allHospitals.add(dto);
        }
        return allHospitals;
    }

    @Override
    public HospitalDTO serachName(String name) throws Exception {
        
       String sql ="SELECT * FROM hospital WHERE name ='"+name+"'";
       
       HospitalDTO hospital = null;
       
       Statement stm =connection.createStatement();
       ResultSet rst =stm .executeQuery(sql);
       if(rst.next()){
           
           hospital  =new HospitalDTO(
                   rst.getString("hpid"),
                   rst.getString("name"));
       }
       return hospital;
   }

    @Override
    public ArrayList<String> getAllHospitalNames() throws Exception {
        
        String sql ="SELECT name FROM hospital";
        
        Statement stm =connection.createStatement();
        ResultSet rst =stm.executeQuery(sql);
        ArrayList<String> nameList =new ArrayList<>();
        while(rst.next()){
            nameList.add(rst.getString("name"));
        }
        return nameList;
    }
}
