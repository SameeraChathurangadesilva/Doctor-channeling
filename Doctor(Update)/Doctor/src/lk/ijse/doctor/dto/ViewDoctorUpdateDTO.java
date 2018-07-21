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
public class ViewDoctorUpdateDTO {
    
    private String dcid;
    
    private String date;
    
    private String patientCount;

    public ViewDoctorUpdateDTO(String dcid, String date, String patientCount) {
        this.dcid = dcid;
        this.date = date;
        this.patientCount = patientCount;
    }

    public ViewDoctorUpdateDTO() {
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
