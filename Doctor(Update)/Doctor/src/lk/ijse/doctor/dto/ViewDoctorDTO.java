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
public class ViewDoctorDTO {
    private String docID;
    private String hosName;
    private String spName;
    private String docName;
    private String gender;
    private double feer;

    public ViewDoctorDTO() {
    }

    public ViewDoctorDTO(String docID, String hosName, String spName, String docName, String gender, double feer) {
        this.docID = docID;
        this.hosName = hosName;
        this.spName = spName;
        this.docName = docName;
        this.gender = gender;
        this.feer = feer;
    }

    /**
     * @return the docID
     */
    public String getDocID() {
        return docID;
    }

    /**
     * @param docID the docID to set
     */
    public void setDocID(String docID) {
        this.docID = docID;
    }

    /**
     * @return the hosName
     */
    public String getHosName() {
        return hosName;
    }

    /**
     * @param hosName the hosName to set
     */
    public void setHosName(String hosName) {
        this.hosName = hosName;
    }

    /**
     * @return the spName
     */
    public String getSpName() {
        return spName;
    }

    /**
     * @param spName the spName to set
     */
    public void setSpName(String spName) {
        this.spName = spName;
    }

    /**
     * @return the docName
     */
    public String getDocName() {
        return docName;
    }

    /**
     * @param docName the docName to set
     */
    public void setDocName(String docName) {
        this.docName = docName;
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
     * @return the feer
     */
    public double getFeer() {
        return feer;
    }

    /**
     * @param feer the feer to set
     */
    public void setFeer(double feer) {
        this.feer = feer;
    }
    
    
}
