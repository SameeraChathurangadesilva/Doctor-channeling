/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.controller.custom;

import java.util.ArrayList;
import lk.ijse.doctor.controller.SuperController;
import lk.ijse.doctor.dto.DoctorDTO;
import lk.ijse.doctor.dto.ViewDoctorDTO;

/**
 *
 * @author sameera
 */
public interface DoctorController extends SuperController<DoctorDTO>{
    
    public ArrayList<String> getAllNames()throws Exception;
    
    public DoctorDTO searchName(String name)throws Exception;
    
   public ViewDoctorDTO searchList(String name)throws Exception;
   
   public ArrayList<ViewDoctorDTO> searchDoctorSpeciality(String name)throws Exception;
   
   
   @Override
    public default boolean add(DoctorDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   public boolean  add(ArrayList<DoctorDTO> doctorDTOs)throws Exception;
   
   public boolean  update(ArrayList<DoctorDTO> doctorDTOs)throws Exception;
  
   
   @Override
    public default boolean update(DoctorDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
