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
import lk.ijse.doctor.dao.custom.SpecialityDAO;
import lk.ijse.doctor.db.ConnectionFactory;
import lk.ijse.doctor.dto.SpecialityDTO;

/**
 *
 * @author sameera
 */
public class SpecialityDAOImpl implements SpecialityDAO{
    
    private Connection connection;
    
    public SpecialityDAOImpl(){
        connection =ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(SpecialityDTO dto) throws Exception {
        
        String sql ="INSERT INTO speciality VALUES(?,?)";
        
        PreparedStatement pstm =connection.prepareStatement(sql);
        
        pstm.setString(1, dto.getSpid());
        pstm.setString(2,dto.getName());
        int result = pstm.executeUpdate();
        
        return (result > 0);
    }

    @Override
    public boolean update(SpecialityDTO dto) throws Exception {
        
        String sql ="UPDATE speciality SET name =? WHERE spid=?";
        
        PreparedStatement pstm =connection.prepareStatement(sql);
        
        pstm.setString(1,dto.getName());
        pstm.setString(2, dto.getSpid());
        int result  =pstm.executeUpdate();
        
        return  (result > 0);
    }

    @Override
    public SpecialityDTO search(String key) throws Exception {
       
        String sql = "SELECT * FROM speciality WHERE spid='" + key + "'";

        SpecialityDTO speciality = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            speciality = new SpecialityDTO(
                    rst.getString("spid"),
                    rst.getString("name"));
        }
        return speciality;
    }

    @Override
    public boolean delete(String key) throws Exception {
        
        String sql ="DELETE FROM speciality WHERE spid ='"+key+"'";
        
        Statement stm= connection.createStatement();
        int affectedRows= stm.executeUpdate(sql);
        
        return (affectedRows > 0);
    }

    @Override
    public ArrayList<SpecialityDTO> getAll() throws Exception {
        
        String sql ="SELECT * FROM speciality";
        
        ArrayList<SpecialityDTO > allSpeciality =null;
        
        Statement stm =connection.createStatement();
        ResultSet rst =stm.executeQuery(sql);
        while(rst.next()){
            if(allSpeciality ==null){
                allSpeciality =new ArrayList<>();
            }
            SpecialityDTO speciality =new SpecialityDTO(
                    rst.getString("spid"), 
                    rst.getString("name"));
            allSpeciality.add(speciality);
        }
        return  allSpeciality;
    }

    @Override
    public SpecialityDTO searchName(String name) throws Exception {
        
        String sql ="SELECT * FROM speciality WHERE name ='"+name+"'";
        
        SpecialityDTO speciality =null;
        
        Statement stm =connection.createStatement();
        ResultSet rst =stm .executeQuery(sql);
        if(rst.next()){
            
            speciality =new SpecialityDTO(
                    rst.getString("spid"),
                    rst.getString("name"));
        }
        return speciality;
    }

    @Override
    public ArrayList<String> getAllSpecialityNames() throws Exception {
       
        String sql ="SELECT name FROM speciality";
        
        Statement stm =connection.createStatement();
        ResultSet rst =stm.executeQuery(sql);
        ArrayList<String> nameList =new ArrayList<>();
        while(rst.next()){
            nameList.add(rst.getString("name"));
        }
        return nameList;
   }
    
}
