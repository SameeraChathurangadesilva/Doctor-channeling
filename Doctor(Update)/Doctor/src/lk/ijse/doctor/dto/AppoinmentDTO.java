/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.dto;

import java.io.Serializable;
import java.sql.Date;



/**
 *
 * @author sameera
 */

public class AppoinmentDTO extends SuperDTO implements Serializable {
   
    private String apid;
    
    private String dcid;
    
    private String ptid;
    
    
    private String apno;
   
    private String time;
   
    private String date;
   

    public AppoinmentDTO() {
    }

    public AppoinmentDTO(String apid, String dcid, String ptid, String apno, String time, String date) {
        this.apid = apid;
        this.dcid = dcid;
        this.ptid = ptid;
        this.apno = apno;
        this.time = time;
        this.date = date;
    }
    
    
    /**
     * @return the apid
     */
    public String getApid() {
        return apid;
    }

    /**
     * @param apid the apid to set
     */
    public void setApid(String apid) {
        this.apid = apid;
    }

    /**
     * @return the dcid
     */
    public String getDcid() {
        return dcid;
    }

    /**
     * @param dcid the dcid to set
     */
    public void setDcid(String dcid) {
        this.dcid = dcid;
    }

    /**
     * @return the ptid
     */
    public String getPtid() {
        return ptid;
    }

    /**
     * @param ptid the ptid to set
     */
    public void setPtid(String ptid) {
        this.ptid = ptid;
    }

    /**
     * @return the apno
     */
    public String getApno() {
        return apno;
    }

    /**
     * @param apno the apno to set
     */
    public void setApno(String apno) {
        this.apno = apno;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }


}
