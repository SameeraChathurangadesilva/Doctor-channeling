/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.doctor.controller.custom.SpecialityController;
import lk.ijse.doctor.dao.DAOFactroy;
import lk.ijse.doctor.dao.custom.SpecialityDAO;
import lk.ijse.doctor.dto.SpecialityDTO;

/**
 *
 * @author sameera
 */
public class SpecialityControllerImpl implements SpecialityController{
    
    private SpecialityDAO specialityDAO;
    
    public SpecialityControllerImpl(){
        specialityDAO =(SpecialityDAO) DAOFactroy.getInstance().getDAO(DAOFactroy.DAOTypes.SPECIALITY);
    }
    @Override
    public boolean add(SpecialityDTO dto) throws Exception {
        return specialityDAO.add(dto);
    }

    @Override
    public boolean update(SpecialityDTO dto) throws Exception {
        return  specialityDAO.update(dto);
    }

    @Override
    public boolean delete(String key) throws Exception {
       return  specialityDAO.delete(key);
    }

    @Override
    public SpecialityDTO search(String key) throws Exception {
        return  specialityDAO.search(key);
    }

    @Override
    public ArrayList<SpecialityDTO> getAll() throws Exception {
        return  specialityDAO.getAll();
    }

    @Override
    public SpecialityDTO searchName(String name) throws Exception {
        return specialityDAO.searchName(name);
    }

    @Override
    public ArrayList<String> getAllSpecialityNames() throws Exception {
        return specialityDAO.getAllSpecialityNames();
    }

    
}
