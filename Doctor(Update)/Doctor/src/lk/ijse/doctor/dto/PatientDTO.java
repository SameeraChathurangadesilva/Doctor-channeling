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

public class PatientDTO extends  SuperDTO implements Serializable {
  
    private String ptid;
   
    private String name;
   
    private String address;
   
    private String gender;
   
    private String nic;
    
    private Integer age;
  
    private Integer teleno;
   
    public PatientDTO() {
    }

    public PatientDTO(String ptid, String name, String address, String gender, String nic, Integer age, Integer teleno) {
        this.ptid = ptid;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.nic = nic;
        this.age = age;
        this.teleno = teleno;
    }

  

    public String getPtid() {
        return ptid;
    }

    public void setPtid(String ptid) {
        this.ptid = ptid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getTeleno() {
        return teleno;
    }

    public void setTeleno(Integer teleno) {
        this.teleno = teleno;
    }
}
