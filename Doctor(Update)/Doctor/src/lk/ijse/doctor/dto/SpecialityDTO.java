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

public class SpecialityDTO extends  SuperDTO implements Serializable {
    
    private String spid;
    
    private String name;
    

    public SpecialityDTO() {
    }

    public SpecialityDTO(String spid, String name) {
        this.spid = spid;
        this.name = name;
    }

   
    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
