/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.dao;

import lk.ijse.doctor.dao.custom.impl.AppoinmentDAOImpl;
import lk.ijse.doctor.dao.custom.impl.DaysDAOImpl;
import lk.ijse.doctor.dao.custom.impl.DoctorDAOImpl;
import lk.ijse.doctor.dao.custom.impl.HospitalDAOImpl;
import lk.ijse.doctor.dao.custom.impl.PatientDAOImpl;
import lk.ijse.doctor.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.doctor.dao.custom.impl.RegistrationDAOImpl;
import lk.ijse.doctor.dao.custom.impl.ScheduleDAOImpl;
import lk.ijse.doctor.dao.custom.impl.SpecialityDAOImpl;



/**
 *
 * @author sameera
 */
public class DAOFactroy {
    
    public enum DAOTypes{
        PATIENT,REGISTRATION,HOSPITAL,SPECIALITY,DAYS,DOCTOR,SCHEDULE,PAYMENT,APPOINMENT;
    }
    
    private static DAOFactroy dAOFactroy;
    
    private DAOFactroy(){
  
    }
    
    public static DAOFactroy getInstance(){
        if(dAOFactroy == null){
            dAOFactroy =new DAOFactroy();
        }
        return dAOFactroy;
    }
    
    public SuperDAO getDAO(DAOTypes daotypes){
        switch (daotypes) {
            case PATIENT:
                return new PatientDAOImpl();
            case REGISTRATION:
                return new RegistrationDAOImpl();
            case HOSPITAL:
                return new HospitalDAOImpl();
            case SPECIALITY:
                return new SpecialityDAOImpl();
            case DAYS:
                return new DaysDAOImpl();

            case DOCTOR:
                return new DoctorDAOImpl();
            case SCHEDULE:
                return new ScheduleDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();
            case APPOINMENT:
                return new AppoinmentDAOImpl();
            default:
                return null;
        }
    }
    
}
