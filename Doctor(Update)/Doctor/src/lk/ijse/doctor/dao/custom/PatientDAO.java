/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.dao.custom;

import java.util.ArrayList;
import lk.ijse.doctor.dao.SuperDAO;
import lk.ijse.doctor.dto.CurentIdDTO;
import lk.ijse.doctor.dto.PatientDTO;

/**
 *
 * @author sameera
 */
public interface PatientDAO extends SuperDAO<PatientDTO> {

    public ArrayList<String> allPatientIds() throws Exception;

    public PatientDTO searchName(String name) throws Exception;

    public ArrayList<PatientDTO> sePatientDTOs(String ptid) throws Exception;

    public ArrayList<PatientDTO> sePatientDTO(String name) throws Exception;

    public ArrayList<String> patientName() throws Exception;

    public CurentIdDTO searchAppNo(String dcid) throws Exception;

    public CurentIdDTO searchAppDate(String dcid, String date) throws Exception;

    public boolean updatePatient(CurentIdDTO curentIdDTO) throws Exception;

    public boolean addPatientCurrent(CurentIdDTO curentIdDTO) throws Exception;

    public boolean deletePatientCurrent(String dcid) throws Exception;

}
