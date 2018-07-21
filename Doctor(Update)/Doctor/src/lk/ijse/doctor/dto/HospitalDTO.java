/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.dto;

import java.io.Serializable;


/**
 *
 * @author sameera
 */

public class HospitalDTO extends  SuperDTO implements Serializable {
    
    
    private String hpid;
    
    private String name;
   

    public HospitalDTO() {
    }

    public HospitalDTO(String hpid, String name) {
        this.hpid = hpid;
        this.name = name;
    }

   

    public String getHpid() {
        return hpid;
    }

    public void setHpid(String hpid) {
        this.hpid = hpid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
