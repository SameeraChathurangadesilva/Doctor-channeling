/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.doctor.controller.custom.HospitalController;
import lk.ijse.doctor.dao.DAOFactroy;
import lk.ijse.doctor.dao.custom.HospitalDAO;
import lk.ijse.doctor.dto.HospitalDTO;

/**
 *
 * @author sameera
 */
public class HospitalControllerImpl implements HospitalController{
    
    private HospitalDAO hospitalDAO;
    
    public HospitalControllerImpl(){
        hospitalDAO =(HospitalDAO) DAOFactroy.getInstance().getDAO(DAOFactroy.DAOTypes.HOSPITAL);
    }

    @Override
    public boolean add(HospitalDTO dto) throws Exception {
       return hospitalDAO.add(dto);
    }

    @Override
    public boolean update(HospitalDTO dto) throws Exception {
        return hospitalDAO.update(dto);
    }

    @Override
    public boolean delete(String key) throws Exception {
        return hospitalDAO.delete(key);
    }

    @Override
    public HospitalDTO search(String key) throws Exception {
        return hospitalDAO.search(key);
    }

    @Override
    public ArrayList<HospitalDTO> getAll() throws Exception {
        return hospitalDAO.getAll();
    }

    @Override
    public HospitalDTO serachName(String name) throws Exception {
        return hospitalDAO.serachName(name);
    }

    @Override
    public ArrayList<String> getAllHospitalNames() throws Exception {
        return hospitalDAO.getAllHospitalNames();
    }    
}
