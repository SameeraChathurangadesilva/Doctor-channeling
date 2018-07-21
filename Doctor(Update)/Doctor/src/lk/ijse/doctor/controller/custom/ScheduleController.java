/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.controller.custom;

import java.util.ArrayList;
import lk.ijse.doctor.controller.SuperController;
import lk.ijse.doctor.dto.ScheduleDTO;
import lk.ijse.doctor.dto.ViewScheduleDTO;

/**
 *
 * @author sameera
 */
public interface ScheduleController extends SuperController<ScheduleDTO>{
    
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
