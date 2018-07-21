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

public class ScheduleDTO extends  SuperDTO implements Serializable {
   
    private String scid;
    
    private String dcid;
    
    private String dayid;
    
    private String doctorin;
   
    private String doctorout;
    
    private Integer patientcount;
  

    public ScheduleDTO() {
    }

    public ScheduleDTO(String scid, String dcid, String dayid, String doctorin, String doctorout, Integer patientcount) {
        this.scid = scid;
        this.dcid = dcid;
        this.dayid = dayid;
        this.doctorin = doctorin;
        this.doctorout = doctorout;
        this.patientcount = patientcount;
    }
    
    

    public String getScid() {
        return scid;
    }

    public void setScid(String scid) {
        this.scid = scid;
    }

    public String getDoctorin() {
        return doctorin;
    }

    public void setDoctorin(String doctorin) {
        this.doctorin = doctorin;
    }

    public String getDoctorout() {
        return doctorout;
    }

    public void setDoctorout(String doctorout) {
        this.doctorout = doctorout;
    }

    public Integer getPatientcount() {
        return patientcount;
    }

    public void setPatientcount(Integer patientcount) {
        this.patientcount = patientcount;
    }

    public String getDcid() {
        return dcid;
    }

    public void setDcid(String dcid) {
        this.dcid = dcid;
    }

    public String getDayid() {
        return dayid;
    }

    public void setDayid(String dayid) {
        this.dayid = dayid;
    }
}
