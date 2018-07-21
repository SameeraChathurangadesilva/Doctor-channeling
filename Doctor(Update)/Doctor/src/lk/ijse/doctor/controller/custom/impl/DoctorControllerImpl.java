/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.controller.custom.impl;

import com.mysql.jdbc.Connection;
import java.util.ArrayList;
import lk.ijse.doctor.controller.custom.DoctorController;
import lk.ijse.doctor.dao.DAOFactroy;
import lk.ijse.doctor.dao.custom.DoctorDAO;
import lk.ijse.doctor.db.ConnectionFactory;
import lk.ijse.doctor.dto.DoctorDTO;
import lk.ijse.doctor.dto.ViewDoctorDTO;

/**
 *
 * @author sameera
 */
public class DoctorControllerImpl implements DoctorController{
    
    private DoctorDAO doctorDAO;
    
    public DoctorControllerImpl(){
        doctorDAO =(DoctorDAO) DAOFactroy.getInstance().getDAO(DAOFactroy.DAOTypes.DOCTOR);
    }
    
    @Override
    public boolean delete(String key) throws Exception {
        return doctorDAO.delete(key);
    }

    @Override
    public DoctorDTO search(String key) throws Exception {
        return doctorDAO.search(key);
    }

    @Override
    public ArrayList<DoctorDTO> getAll() throws Exception {
       return doctorDAO.getAll();
    }

    @Override
    public ArrayList<String> getAllNames() throws Exception {
        return  doctorDAO.getAllNames();
    }

    @Override
    public DoctorDTO searchName(String name)throws Exception {
        return doctorDAO.searchName(name);
    }

    @Override
    public ViewDoctorDTO searchList(String name) throws Exception {
       return  doctorDAO.searchList(name);
    }

    @Override
    public boolean add(ArrayList<DoctorDTO> doctorDTOs) throws Exception {
        return doctorDAO.add(doctorDTOs);
    }

    @Override
    public boolean update(ArrayList<DoctorDTO> doctorDTOs) throws Exception {
        return doctorDAO.update(doctorDTOs);
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
        return doctorDAO.searchDoctorSpeciality(name);
    }
}
