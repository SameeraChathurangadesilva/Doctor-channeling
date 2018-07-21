/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author sameera
 */

public class PaymentDTO extends  SuperDTO implements Serializable {
   
    private String payid;
    
    private String  apid;
    
    private String amount;
   
    private String date;
    
    public PaymentDTO() {
    }

    public PaymentDTO(String payid, String apid, String amount, String date) {
        this.payid = payid;
        this.apid = apid;
        this.amount = amount;
        this.date = date;
    }

    /**
     * @return the payid
     */
    public String getPayid() {
        return payid;
    }

    /**
     * @param payid the payid to set
     */
    public void setPayid(String payid) {
        this.payid = payid;
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
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
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
