/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author sameera
 */

public class DoctorDTO extends  SuperDTO implements Serializable {
   
    private String dcid;
    
    private String hpid;
   
    private String spid;
   
    private String name;
   
    private String gender;
    
    private BigDecimal dcfree;
    
    
    
   
    public DoctorDTO() {
    }

    public DoctorDTO(String dcid, String hpid, String spid, String name, String gender, BigDecimal dcfree) {
        this.dcid = dcid;
        this.hpid = hpid;
        this.spid = spid;
        this.name = name;
        this.gender = gender;
        this.dcfree = dcfree;
    }

    public String getDcid() {
        return dcid;
    }

    public void setDcid(String dcid) {
        this.dcid = dcid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BigDecimal getDcfree() {
        return dcfree;
    }

    public void setDcfree(BigDecimal dcfree) {
        this.dcfree = dcfree;
    }

    public String getHpid() {
        return hpid;
    }

    public void setHpid(String hpid) {
        this.hpid = hpid;
    }

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }
}
