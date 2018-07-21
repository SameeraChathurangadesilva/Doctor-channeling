/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.dto;

/**
 *
 * @author sameera
 */
public class ViewAppointmentDTO {
    
    private String apid;
    private String dcname;
    private String ptid;
    private String apno;
    private String time;
    private String date;

    public ViewAppointmentDTO() {
    }

    public ViewAppointmentDTO(String apid, String dcname, String ptid, String apno, String time, String date) {
        this.apid = apid;
        this.dcname = dcname;
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
     * @return the dcname
     */
    public String getDcname() {
        return dcname;
    }

    /**
     * @param dcname the dcname to set
     */
    public void setDcname(String dcname) {
        this.dcname = dcname;
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


