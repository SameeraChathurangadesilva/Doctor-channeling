/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.controller.custom;

import java.util.ArrayList;
import lk.ijse.doctor.controller.SuperController;
import lk.ijse.doctor.dto.RegistrationDTO;

/**
 *
 * @author sameera
 */
public interface RegistrationController extends SuperController<RegistrationDTO>{
    
    public ArrayList<String> getAllRegIds()throws Exception;
    
}
