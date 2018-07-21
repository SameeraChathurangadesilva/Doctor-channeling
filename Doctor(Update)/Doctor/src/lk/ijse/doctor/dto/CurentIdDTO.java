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
public class CurentIdDTO {
    
    private String dcid;

    private String scid;

    private String cunId;
    
    private String date ;

    public CurentIdDTO() {
    }

    public CurentIdDTO(String dcid, String scid, String cunId, String date) {
        this.dcid = dcid;
        this.scid = scid;
        this.cunId = cunId;
        this.date = date;
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
     * @return the cunId
     */
    public String getCunId() {
        return cunId;
    }

    /**
     * @param cunId the cunId to set
     */
    public void setCunId(String cunId) {
        this.cunId = cunId;
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
