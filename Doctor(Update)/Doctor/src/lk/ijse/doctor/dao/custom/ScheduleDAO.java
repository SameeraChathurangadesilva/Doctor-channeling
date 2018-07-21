/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.dao.custom;

import java.util.ArrayList;
import lk.ijse.doctor.dao.SuperDAO;
import lk.ijse.doctor.dto.ScheduleDTO;
import lk.ijse.doctor.dto.ViewScheduleDTO;

/**
 *
 * @author sameera
 */
public interface ScheduleDAO extends SuperDAO<ScheduleDTO>{
    
    public boolean add(ArrayList<ScheduleDTO>scheduleDTOs)throws Exception;
    
    @Override
    public default boolean add(ScheduleDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
    
    public ArrayList<ViewScheduleDTO> searchIdsQ()throws Exception;
    
    public boolean  update(ArrayList<ScheduleDTO> scheduleDTOs)throws Exception;
    
    
     
    @Override
    public default boolean update(ScheduleDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public ScheduleDTO  searchDoctorA(String dcid)throws Exception;
}
