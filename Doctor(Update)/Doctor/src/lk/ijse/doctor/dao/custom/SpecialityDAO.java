/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.dao.custom;

import java.util.ArrayList;
import lk.ijse.doctor.dao.SuperDAO;
import lk.ijse.doctor.dto.SpecialityDTO;

/**
 *
 * @author sameera
 */
public interface SpecialityDAO extends SuperDAO<SpecialityDTO>{
    
    public SpecialityDTO searchName(String name)throws Exception;
    
    public ArrayList<String> getAllSpecialityNames()throws Exception;
    
}
