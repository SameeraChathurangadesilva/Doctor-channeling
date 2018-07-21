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
import lk.ijse.doctor.dao.custom.PaymentDAO;
import lk.ijse.doctor.db.ConnectionFactory;
import lk.ijse.doctor.dto.PaymentDTO;

/**
 *
 * @author sameera
 */
public class PaymentDAOImpl implements PaymentDAO{
    
    private Connection connection;
    
    public PaymentDAOImpl(){
        connection =ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(PaymentDTO dto) throws Exception {
       
        String sql ="INSERT INTO payment VALUES(?,?,?,?)";
        
        PreparedStatement pstm =connection.prepareStatement(sql);
        
        pstm.setString(1, dto.getPayid());
        pstm.setString(2,dto.getApid());
        pstm.setString(3, dto.getAmount());
        pstm.setString(4, dto.getDate());
        int result = pstm.executeUpdate();
        
        return (result > 0);
        
    }

    @Override
    public boolean update(PaymentDTO dto) throws Exception {
        
        String sql= "UPDATE payment SET apid = ?,amount=?,date=? WHERE payid=?";
        
        PreparedStatement pstm =connection.prepareStatement(sql);
        
        pstm.setString(1,dto.getAmount());
        pstm.setString(2, dto.getApid());
        pstm.setString(3,dto.getDate());
        pstm.setString(4,dto.getPayid());
        int result =pstm.executeUpdate();
        
        return (result > 0);
    }

    @Override
    public PaymentDTO search(String key) throws Exception {
       
        String sql ="SELECT * FROM  payment WHERE payid='"+key+"'";
        
        PaymentDTO payment = null;
        
        Statement stm =connection.createStatement();
        ResultSet rst =stm.executeQuery(sql);
        if(rst.next()){
            payment =new PaymentDTO(
                    rst.getString("payid"),
                    rst.getString("apid"),
                    rst.getString("amount "),
                    rst.getString("Data"));
        }
        return payment;
    }

    @Override
    public boolean delete(String key) throws Exception {
        
        String sql ="DELETE FROM payment WHERE payid ='"+key+"'";
        
        Statement stm =connection.createStatement();
        int afftected =stm.executeUpdate(sql);
        
        return (afftected > 0);
    }

    @Override
    public ArrayList<PaymentDTO> getAll() throws Exception {
        
        String sql = "SELECT * FROM payment";

        ArrayList<PaymentDTO> allPayments = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()) {
            if (allPayments == null) {
                allPayments = new ArrayList<>();
            }

            PaymentDTO dto = new PaymentDTO(
                    rst.getString("payid"),
                    rst.getString("apid"),
                    rst.getString("amount"),
                    rst.getString("Data"));
            allPayments.add(dto);
        }
        return allPayments;
    }
    
}
