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

public class DaysDTO extends  SuperDTO implements Serializable {
   
    private String dayid;
    
    private String days;
  
    public DaysDTO() {
    }

    public DaysDTO(String dayid, String days) {
        this.dayid = dayid;
        this.days = days;
    }
    
    public String getDayid() {
        return dayid;
    }

    public void setDayid(String dayid) {
        this.dayid = dayid;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }
}
