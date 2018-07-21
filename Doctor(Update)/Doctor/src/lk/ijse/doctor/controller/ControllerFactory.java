/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.controller;

import lk.ijse.doctor.controller.custom.impl.AppoinmentControllerImpl;
import lk.ijse.doctor.controller.custom.impl.DaysControllerImpl;
import lk.ijse.doctor.controller.custom.impl.DoctorControllerImpl;
import lk.ijse.doctor.controller.custom.impl.HospitalControllerImpl;
import lk.ijse.doctor.controller.custom.impl.PatientControllerImpl;
import lk.ijse.doctor.controller.custom.impl.PaymentControlerImpl;
import lk.ijse.doctor.controller.custom.impl.RegistrationControllerImpl;
import lk.ijse.doctor.controller.custom.impl.ScheduleControllerImpl;
import lk.ijse.doctor.controller.custom.impl.SpecialityControllerImpl;




/**
 *
 * @author sameera
 */
public class ControllerFactory {
    
    public enum ControllerTypes{
        PATIENT,REGISTRATION,HOSPITAL,SPECIALITY,DAYS,DOCTOR,SCHEDULE,PAYMENT,APPOINMENT;
    }
    
    private static ControllerFactory ctrlFactory;
    
    private ControllerFactory(){
        
    }
    
    public static ControllerFactory getInstance(){
        if(ctrlFactory == null){
            ctrlFactory =new ControllerFactory();
        }
        return ctrlFactory;
    }
    
    public SuperController getController(ControllerTypes controllerTypes){
        switch (controllerTypes) {
            case PATIENT:
                return new PatientControllerImpl();
            case REGISTRATION:
                return new RegistrationControllerImpl();
            case HOSPITAL:
                return new HospitalControllerImpl();
            case SPECIALITY:
                return new SpecialityControllerImpl();
            case DAYS:
                return new DaysControllerImpl();
            case DOCTOR:
                return new DoctorControllerImpl();
            case SCHEDULE:
                return new ScheduleControllerImpl();
            case PAYMENT:
                return new PaymentControlerImpl();
            case APPOINMENT:
                return new AppoinmentControllerImpl();
            default:
                return null;
        }
    }
}
