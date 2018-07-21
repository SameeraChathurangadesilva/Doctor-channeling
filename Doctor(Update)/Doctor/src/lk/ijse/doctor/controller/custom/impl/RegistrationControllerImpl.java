/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.doctor.controller.custom.RegistrationController;
import lk.ijse.doctor.dao.DAOFactroy;
import lk.ijse.doctor.dao.custom.RegistrationDAO;
import lk.ijse.doctor.dto.RegistrationDTO;

/**
 *
 * @author sameera
 */
public class RegistrationControllerImpl implements RegistrationController{
    
    private RegistrationDAO registrationDAO;
    
    public RegistrationControllerImpl(){
        registrationDAO =(RegistrationDAO) DAOFactroy.getInstance().getDAO(DAOFactroy.DAOTypes.REGISTRATION);
    }

    @Override
    public boolean add(RegistrationDTO dto) throws Exception {
        return registrationDAO.add(dto);
    }

    @Override
    public boolean update(RegistrationDTO dto) throws Exception {
        return registrationDAO.update(dto);
    }

    @Override
    public boolean delete(String key) throws Exception {
        return registrationDAO.delete(key);
    }

    @Override
    public RegistrationDTO search(String key) throws Exception {
       return registrationDAO.search(key);
    }

    @Override
    public ArrayList<RegistrationDTO> getAll() throws Exception {
        return  registrationDAO.getAll();
    }

    @Override
    public ArrayList<String> getAllRegIds() throws Exception {
       return  registrationDAO.getAllRegIds();
    }
    
}
