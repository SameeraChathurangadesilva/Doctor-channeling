/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.controller.custom;

import java.util.ArrayList;
import lk.ijse.doctor.controller.SuperController;
import lk.ijse.doctor.dto.DaysDTO;
import lk.ijse.doctor.dto.DoctorDTO;
import lk.ijse.doctor.dto.ScheduleDTO;
import lk.ijse.doctor.dto.ViewDoctorScheduleDTO;

/**
 *
 * @author sameera
 */
public interface DaysController extends  SuperController<DaysDTO>{
    
    
    @Override
    public  default boolean add(DaysDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean add(DaysDTO daysDTO,ArrayList<DoctorDTO> doctorDTOs,ArrayList<ScheduleDTO> scheduleDTOs)throws Exception;
    
    public boolean update(DaysDTO daysDTO,ArrayList<DoctorDTO> doctorDTOs,ArrayList<ScheduleDTO> scheduleDTOs)throws Exception;
    
    
    
    
    @Override
    public default boolean update(DaysDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<ViewDoctorScheduleDTO> getAllDetails()throws Exception;
    
    public ViewDoctorScheduleDTO getAllDetails(String dcid)throws Exception;
    
}
