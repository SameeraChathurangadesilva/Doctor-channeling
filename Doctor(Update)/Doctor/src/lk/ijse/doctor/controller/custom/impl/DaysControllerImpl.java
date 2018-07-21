/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.controller.custom.impl;

import com.mysql.jdbc.Connection;
import java.util.ArrayList;
import lk.ijse.doctor.controller.custom.DaysController;
import lk.ijse.doctor.dao.DAOFactroy;
import lk.ijse.doctor.dao.custom.DaysDAO;
import lk.ijse.doctor.dao.custom.DoctorDAO;
import lk.ijse.doctor.dao.custom.ScheduleDAO;
import lk.ijse.doctor.db.ConnectionFactory;
import lk.ijse.doctor.dto.DaysDTO;
import lk.ijse.doctor.dto.DoctorDTO;
import lk.ijse.doctor.dto.ScheduleDTO;
import lk.ijse.doctor.dto.ViewDoctorScheduleDTO;

/**
 *
 * @author sameera
 */
public class DaysControllerImpl implements DaysController{
    
    private DaysDAO dayDAO;
    private DoctorDAO doctorDAO;
    private ScheduleDAO scheduleDAO;
    
    public DaysControllerImpl(){
        dayDAO =(DaysDAO) DAOFactroy.getInstance().getDAO(DAOFactroy.DAOTypes.DAYS);
        doctorDAO=(DoctorDAO) DAOFactroy.getInstance().getDAO(DAOFactroy.DAOTypes.DOCTOR);
        scheduleDAO=(ScheduleDAO) DAOFactroy.getInstance().getDAO(DAOFactroy.DAOTypes.SCHEDULE);
    }
    
    @Override
    public boolean delete(String key) throws Exception {
        return dayDAO.delete(key)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       ;
    }

    @Override
    public DaysDTO search(String key) throws Exception {
        return dayDAO.search(key);
    }

    @Override
    public ArrayList<DaysDTO> getAll() throws Exception {
        return dayDAO.getAll();
    }

    @Override
    public boolean add(DaysDTO daysDTO, ArrayList<DoctorDTO> doctorDTOs, ArrayList<ScheduleDTO> scheduleDTOs) throws Exception {
        Connection connection=(Connection) ConnectionFactory.getInstance().getConnection();
        try{
            connection.setAutoCommit(false);
        boolean isAddedDay=dayDAO.add(daysDTO);
        if(isAddedDay){
            boolean isAddedDoctor=doctorDAO.add(doctorDTOs);
            if(isAddedDoctor){
                boolean isAddedSch=scheduleDAO.add(scheduleDTOs);
                if(isAddedSch){
                    connection.commit();
                    return true;
                }
            }
        }
        connection.rollback();
        return false;
        }finally{
            connection.setAutoCommit(true);
        }
    }    

    @Override
    public boolean update(DaysDTO daysDTO, ArrayList<DoctorDTO> doctorDTOs, ArrayList<ScheduleDTO> scheduleDTOs) throws Exception {
        Connection connection =(Connection) ConnectionFactory.getInstance().getConnection();
        
        try{
            connection.setAutoCommit(false);
            boolean isupdateDays=dayDAO.update(daysDTO);
            if(isupdateDays){
                boolean isupdateDoctor=doctorDAO.update(doctorDTOs);
                if(isupdateDoctor){
                    boolean isupdateSchedule=scheduleDAO.update(scheduleDTOs);
                    if(isupdateSchedule){
                        connection.commit();
                        return true;
                    }
                }
            }
            connection.rollback();
            return  false;
        }finally{
            connection.setAutoCommit(true);
        }
    }

    @Override
    public boolean add(DaysDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public  boolean update(DaysDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ViewDoctorScheduleDTO> getAllDetails() throws Exception {
        return dayDAO.getAllDetails();
    }

    @Override
    public ViewDoctorScheduleDTO getAllDetails(String dcid) throws Exception {
        return dayDAO.getAllDetails(dcid);
    }
}
