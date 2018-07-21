/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.doctor.controller.custom.PaymentControler;
import lk.ijse.doctor.dao.DAOFactroy;
import lk.ijse.doctor.dao.custom.PaymentDAO;
import lk.ijse.doctor.dto.PaymentDTO;

/**
 *
 * @author sameera
 */
public class PaymentControlerImpl implements PaymentControler{
    
    private PaymentDAO paymentDAO;
    
    public PaymentControlerImpl(){
        paymentDAO =(PaymentDAO) DAOFactroy.getInstance().getDAO(DAOFactroy.DAOTypes.PAYMENT);
    }

    @Override
    public boolean add(PaymentDTO dto) throws Exception {
        return paymentDAO.add(dto);
    }

    @Override
    public boolean update(PaymentDTO dto) throws Exception {
        return paymentDAO.update(dto);
    }

    @Override
    public boolean delete(String key) throws Exception {
        return  paymentDAO.delete(key);
    }

    @Override
    public PaymentDTO search(String key) throws Exception {
        return paymentDAO.search(key);
    }

    @Override
    public ArrayList<PaymentDTO> getAll() throws Exception {
        return  paymentDAO.getAll();
    }
    
}
