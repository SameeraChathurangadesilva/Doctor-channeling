/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.doctor.controller.custom.ScheduleController;
import lk.ijse.doctor.dao.DAOFactroy;
import lk.ijse.doctor.dao.custom.ScheduleDAO;
import lk.ijse.doctor.dto.ScheduleDTO;
import lk.ijse.doctor.dto.ViewScheduleDTO;

/**
 *
 * @author sameera
 */
public class ScheduleControllerImpl implements ScheduleController{
    
    private ScheduleDAO scheduleDAO;
    
    public ScheduleControllerImpl(){
        scheduleDAO =(ScheduleDAO) DAOFactroy.getInstance().getDAO(DAOFactroy.DAOTypes.SCHEDULE);
    }
    
    @Override
    public boolean delete(String key) throws Exception {
        return  scheduleDAO.delete(key);
    }

    @Override
    public ScheduleDTO search(String key) throws Exception {
       return scheduleDAO.search(key);
    }

    @Override
    public ArrayList<ScheduleDTO> getAll() throws Exception {
        return  scheduleDAO.getAll();
    }

    @Override
    public boolean add(ArrayList<ScheduleDTO> scheduleDTOs) throws Exception {
        return scheduleDAO.add(scheduleDTOs);
    }
    @Override
    public boolean add(ScheduleDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ViewScheduleDTO> searchIdsQ() throws Exception {
        return  scheduleDAO.searchIdsQ();
    }

    @Override
    public boolean update(ArrayList<ScheduleDTO> scheduleDTOs) throws Exception {
        return  scheduleDAO.update(scheduleDTOs);
    }

    @Override
    public boolean update(ScheduleDTO dto) throws Exception {
        return scheduleDAO.update(dto);
    }

    @Override
    public ScheduleDTO searchDoctorA(String dcid) throws Exception {
        return scheduleDAO.searchDoctorA(dcid);
    }
}
