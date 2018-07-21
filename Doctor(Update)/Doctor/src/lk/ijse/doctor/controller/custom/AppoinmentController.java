/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.controller.custom;

import java.util.ArrayList;
import lk.ijse.doctor.controller.SuperController;
import lk.ijse.doctor.dto.AppoinmentDTO;
import lk.ijse.doctor.dto.ViewAppointmentDTO;



/**
 *
 * @author sameera
 */
public interface AppoinmentController extends SuperController<AppoinmentDTO>{
    
    public ArrayList<String> seratchIds()throws Exception;
    
    public ArrayList<ViewAppointmentDTO> getAllAppointment(String apid)throws Exception;
    
    public ArrayList<ViewAppointmentDTO> loadAppointmentDetails()throws Exception;
    
}
