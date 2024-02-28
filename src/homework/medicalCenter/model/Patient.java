package homework.medicalCenter.model;
import homework.medicalCenter.util.DateUtil;

import java.util.Date;

public class Patient extends Person {
    private Doctor doctor;
    private Date registrationDate;

    public Patient() {
    }

    public Patient(String id, String name, String surname, String email, String phoneNumber, Doctor doctor, Date registrationDate) {
        super(id, name, surname, email, phoneNumber);
        this.doctor = doctor;
        this.registrationDate = registrationDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "" + super.toString() + "Patient{" +
                "doctor=" + doctor +
                ", registrationDate='" + DateUtil.dateToString(registrationDate)  + '\'' +
                "} ";
    }
}
