/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.idgenerator;

import java.sql.SQLException;
import java.text.NumberFormat;

/**
 *
 * @author sameera
 */
public class IdGenerator {

    public static String getNewRegistrationIds(String tableName, String column, String prefix) throws ClassNotFoundException, SQLException {
        String lastId = IdController.getLastId(tableName, column);
        if (lastId != null) {
            int id = Integer.parseInt(lastId.split(prefix)[1]);
            id++;
            NumberFormat numberFormat = NumberFormat.getIntegerInstance();
            numberFormat.setMaximumIntegerDigits(3);
            numberFormat.setMinimumIntegerDigits(3);
            numberFormat.setGroupingUsed(false);
            String newId = numberFormat.format(id);
            return prefix + newId;
        } else {
            return prefix + "001";
        }
    }

    public static String getNewAppointmentIds(String tableName, String column, String prefix) throws ClassNotFoundException, SQLException {
        String lastId = IdController.getLastId(tableName, column);
        if (lastId != null) {
            int id = Integer.parseInt(lastId.split(prefix)[1]);
            id++;
            NumberFormat numberFormat = NumberFormat.getIntegerInstance();
            numberFormat.setMaximumIntegerDigits(3);
            numberFormat.setMinimumIntegerDigits(3);
            numberFormat.setGroupingUsed(false);
            String newId = numberFormat.format(id);
            return prefix + newId;
        } else {
            return prefix + "001";
        }
    }

    public static String getNewPaymenyIds(String tableName, String column, String prefix) throws ClassNotFoundException, SQLException {
        String lastId = IdController.getLastId(tableName, column);
        if (lastId != null) {
            int id = Integer.parseInt(lastId.split(prefix)[1]);
            id++;
            NumberFormat numberFormat = NumberFormat.getIntegerInstance();
            numberFormat.setMaximumIntegerDigits(3);
            numberFormat.setMinimumIntegerDigits(3);
            numberFormat.setGroupingUsed(false);
            String newId = numberFormat.format(id);
            return prefix + newId;
        } else {
            return prefix + "001";
        }
    }

    public static String getNewHospitalIds(String tableName, String column, String prefix) throws ClassNotFoundException, SQLException {
        String lastId = IdController.getLastId(tableName, column);
        if (lastId != null) {
            int id = Integer.parseInt(lastId.split(prefix)[1]);
            id++;
            NumberFormat numberFormat = NumberFormat.getIntegerInstance();
            numberFormat.setMaximumIntegerDigits(3);
            numberFormat.setMinimumIntegerDigits(3);
            numberFormat.setGroupingUsed(false);
            String newId = numberFormat.format(id);
            return prefix + newId;
        } else {
            return prefix + "001";
        }
    }

    public static String getNewSpecialityIds(String tableName, String column, String prefix) throws ClassNotFoundException, SQLException {
        String lastId = IdController.getLastId(tableName, column);
        if (lastId != null) {
            int id = Integer.parseInt(lastId.split(prefix)[1]);
            id++;
            NumberFormat numberFormat = NumberFormat.getIntegerInstance();
            numberFormat.setMaximumIntegerDigits(3);
            numberFormat.setMinimumIntegerDigits(3);
            numberFormat.setGroupingUsed(false);
            String newId = numberFormat.format(id);
            return prefix + newId;
        } else {
            return prefix + "001";
        }
    }

    public static String getNewDoctorIds(String tableName, String column, String prefix) throws ClassNotFoundException, SQLException {
        String lastId = IdController.getLastId(tableName, column);
        if (lastId != null) {
            int id = Integer.parseInt(lastId.split(prefix)[1]);
            id++;
            NumberFormat numberFormat = NumberFormat.getIntegerInstance();
            numberFormat.setMaximumIntegerDigits(3);
            numberFormat.setMinimumIntegerDigits(3);
            numberFormat.setGroupingUsed(false);
            String newId = numberFormat.format(id);
            return prefix + newId;
        } else {
            return prefix + "001";
        }
    }

    public static String getNewScheduleIds(String tableName, String column, String prefix) throws ClassNotFoundException, SQLException {
        String lastId = IdController.getLastId(tableName, column);
        if (lastId != null) {
            int id = Integer.parseInt(lastId.split(prefix)[1]);
            id++;
            NumberFormat numberFormat = NumberFormat.getIntegerInstance();
            numberFormat.setMaximumIntegerDigits(3);
            numberFormat.setMinimumIntegerDigits(3);
            numberFormat.setGroupingUsed(false);
            String newId = numberFormat.format(id);
            return prefix + newId;
        } else {
            return prefix + "001";
        }
    }

    public static String getNewDaysIds(String tableName, String column, String prefix) throws ClassNotFoundException, SQLException {
        String lastId = IdController.getLastId(tableName, column);
        if (lastId != null) {
            int id = Integer.parseInt(lastId.split(prefix)[1]);
            id++;
            NumberFormat numberFormat = NumberFormat.getIntegerInstance();
            numberFormat.setMaximumIntegerDigits(3);
            numberFormat.setMinimumIntegerDigits(3);
            numberFormat.setGroupingUsed(false);
            String newId = numberFormat.format(id);
            return prefix + newId;
        } else {
            return prefix + "001";
        }
    }
}
