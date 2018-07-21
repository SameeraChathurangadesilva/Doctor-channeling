/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.doctor.controller.custom.PatientController;
import lk.ijse.doctor.dao.DAOFactroy;
import lk.ijse.doctor.dao.custom.PatientDAO;
import lk.ijse.doctor.dto.CurentIdDTO;
import lk.ijse.doctor.dto.PatientDTO;

/**
 *
 * @author sameera
 */
public class PatientControllerImpl implements PatientController{
    
    private PatientDAO patinetDAO;
    
    public PatientControllerImpl(){
        patinetDAO =(PatientDAO) DAOFactroy.getInstance().getDAO(DAOFactroy.DAOTypes.PATIENT);
    }

    @Override
    public boolean add(PatientDTO dto) throws Exception {
        return patinetDAO.add(dto);
    }

    @Override
    public boolean update(PatientDTO dto) throws Exception {
        return patinetDAO.update(dto);
    }

    @Override
    public boolean delete(String key) throws Exception {
        return patinetDAO.delete(key);
    }

    @Override
    public PatientDTO search(String key) throws Exception {
        return patinetDAO.search(key);
    }

    @Override
    public ArrayList<PatientDTO> getAll() throws Exception {
        return patinetDAO.getAll();
    }

    @Override
    public ArrayList<String> allPatientIds() throws Exception {
       return patinetDAO.allPatientIds();
    }

    @Override
    public PatientDTO searchName(String name) throws Exception {
        return  patinetDAO.searchName(name);
    }

    @Override
    public ArrayList<PatientDTO> sePatientDTOs(String ptid) throws Exception {
        return patinetDAO.sePatientDTOs(ptid);
    }

    @Override
    public ArrayList<PatientDTO> sePatientDTO(String name) throws Exception {
        return patinetDAO.sePatientDTO(name);
    }

    @Override
    public ArrayList<String> patientName() throws Exception {
        return patinetDAO.patientName();
    }

    @Override
    public CurentIdDTO searchAppNo(String dcid) throws Exception {
        return patinetDAO.searchAppNo(dcid);
    }

    @Override
    public boolean updatePatient(CurentIdDTO curentIdDTO) throws Exception {
        return patinetDAO.updatePatient(curentIdDTO);
    }

    @Override
    public boolean addPatientCurrent(CurentIdDTO curentIdDTO) throws Exception {
        return patinetDAO.addPatientCurrent(curentIdDTO);
    }

    @Override
    public boolean deletePatientCurrent(String dcid) throws Exception {
        return patinetDAO.deletePatientCurrent(dcid);
    }

    @Override
    public CurentIdDTO searchAppDate(String dcid, String date) throws Exception {
        return patinetDAO.searchAppDate(dcid, date);
    }

}
