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
public class ViewDoctorScheduleDTO {
    
    private String dcid;
    
    private String hpid;
    
    private String spid;
    
    private String Doctorname;
    
    private String gender;
    
    private String  dcfee;
    
    private String scid;
    
    private String dayid;
    
    private String days;
    
    private String doctorin;
    
    private String doctorout;
    
    private String patientCount;

    public ViewDoctorScheduleDTO() {
    }

    public ViewDoctorScheduleDTO(String dcid, String hpid, String spid, String Doctorname, String gender, String dcfee, String scid, String dayid, String days, String doctorin, String doctorout, String patientCount) {
        this.dcid = dcid;
        this.hpid = hpid;
        this.spid = spid;
        this.Doctorname = Doctorname;
        this.gender = gender;
        this.dcfee = dcfee;
        this.scid = scid;
        this.dayid = dayid;
        this.days = days;
        this.doctorin = doctorin;
        this.doctorout = doctorout;
        this.patientCount = patientCount;
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
     * @return the hpid
     */
    public String getHpid() {
        return hpid;
    }

    /**
     * @param hpid the hpid to set
     */
    public void setHpid(String hpid) {
        this.hpid = hpid;
    }

    /**
     * @return the spid
     */
    public String getSpid() {
        return spid;
    }

    /**
     * @param spid the spid to set
     */
    public void setSpid(String spid) {
        this.spid = spid;
    }

    /**
     * @return the Doctorname
     */
    public String getDoctorname() {
        return Doctorname;
    }

    /**
     * @param Doctorname the Doctorname to set
     */
    public void setDoctorname(String Doctorname) {
        this.Doctorname = Doctorname;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the dcfee
     */
    public String getDcfee() {
        return dcfee;
    }

    /**
     * @param dcfee the dcfee to set
     */
    public void setDcfee(String dcfee) {
        this.dcfee = dcfee;
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
     * @return the dayid
     */
    public String getDayid() {
        return dayid;
    }

    /**
     * @param dayid the dayid to set
     */
    public void setDayid(String dayid) {
        this.dayid = dayid;
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
     * @return the patientCount
     */
    public String getPatientCount() {
        return patientCount;
    }

    /**
     * @param patientCount the patientCount to set
     */
    public void setPatientCount(String patientCount) {
        this.patientCount = patientCount;
    }
    
    
    
}
