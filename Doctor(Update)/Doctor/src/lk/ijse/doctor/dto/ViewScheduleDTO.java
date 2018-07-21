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
public class ViewScheduleDTO {
    
    private String scid;
    private String dcid;
    private String days;
    private String doctorin;
    private String doctorout;
    private String patientcount;

    public ViewScheduleDTO() {
    }

    public ViewScheduleDTO(String scid, String dcid, String days, String doctorin, String doctorout, String patientcount) {
        this.scid = scid;
        this.dcid = dcid;
        this.days = days;
        this.doctorin = doctorin;
        this.doctorout = doctorout;
        this.patientcount = patientcount;
    }

    /**
     * @return the scid
     */
    public String getScid() {
        return scid;
    }

    /**
     * @param scid the scid to set
     */
    public void setScid(String scid) {
        this.scid = scid;
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
     * @return the days
     */
    public String getDays() {
        return days;
    }

    /**
     * @param days the days to set
     */
    public void setDays(String days) {
        this.days = days;
    }

    /**
     * @return the doctorin
     */
    public String getDoctorin() {
        return doctorin;
    }

    /**
     * @param doctorin the doctorin to set
     */
    public void setDoctorin(String doctorin) {
        this.doctorin = doctorin;
    }

    /**
     * @return the doctorout
     */
    public String getDoctorout() {
        return doctorout;
    }

    /**
     * @param doctorout the doctorout to set
     */
    public void setDoctorout(String doctorout) {
        this.doctorout = doctorout;
    }

    /**
     * @return the patientcount
     */
    public String getPatientcount() {
        return patientcount;
    }

    /**
     * @param patientcount the patientcount to set
     */
    public void setPatientcount(String patientcount) {
        this.patientcount = patientcount;
    }
    
    
    
}
