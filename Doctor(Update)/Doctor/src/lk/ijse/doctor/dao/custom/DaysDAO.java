/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.dao.custom;

import java.util.ArrayList;
import lk.ijse.doctor.dao.SuperDAO;
import lk.ijse.doctor.dto.DaysDTO;
import lk.ijse.doctor.dto.ViewDoctorScheduleDTO;

/**
 *
 * @author sameera
 */
public interface DaysDAO extends SuperDAO<DaysDTO>{
    
     public ArrayList<ViewDoctorScheduleDTO> getAllDetails()throws Exception;
     
     public ViewDoctorScheduleDTO getAllDetails(String dcid)throws Exception;
}
