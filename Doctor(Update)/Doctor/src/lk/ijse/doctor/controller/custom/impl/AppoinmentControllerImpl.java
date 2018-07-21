/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.doctor.controller.custom.AppoinmentController;
import lk.ijse.doctor.dao.DAOFactroy;
import lk.ijse.doctor.dao.custom.AppoinmentDAO;
import lk.ijse.doctor.dto.AppoinmentDTO;
import lk.ijse.doctor.dto.ViewAppointmentDTO;

/**
 *
 * @author sameera
 */
public class AppoinmentControllerImpl implements AppoinmentController{
    
    private AppoinmentDAO appoinmentDAO;
    
    public AppoinmentControllerImpl(){
        appoinmentDAO =(AppoinmentDAO) DAOFactroy.getInstance().getDAO(DAOFactroy.DAOTypes.APPOINMENT);
    }

    @Override
    public boolean add(AppoinmentDTO dto) throws Exception {
        return  appoinmentDAO.add(dto);
    }

    @Override
    public boolean update(AppoinmentDTO dto) throws Exception {
        return appoinmentDAO.update(dto);
    }

    @Override
    public boolean delete(String key) throws Exception {
        return  appoinmentDAO.delete(key);
    }

    @Override
    public AppoinmentDTO search(String key) throws Exception {
       return appoinmentDAO.search(key);
    }

    @Override
    public ArrayList<AppoinmentDTO> getAll() throws Exception {
        return appoinmentDAO.getAll();
    }

    @Override
    public ArrayList<String> seratchIds() throws Exception {
       return  appoinmentDAO.seratchIds();
    }

    @Override
    public ArrayList<ViewAppointmentDTO> getAllAppointment(String apid) throws Exception {
        return appoinmentDAO.getAllAppointment(apid);
    }

    @Override
    public ArrayList<ViewAppointmentDTO> loadAppointmentDetails() throws Exception {
        return appoinmentDAO.loadAppointmentDetails();
    }
}
