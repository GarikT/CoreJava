package homework.medicalCenter.model;

public class Patient extends Person {
    private Doctor doctor;
    private String registrationDate;

    public Patient() {
    }

    public Patient(String id, String name, String surname, String email, String phoneNumber, Doctor doctor, String registrationDate) {
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

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "" + super.toString() + "Patient{" +
                "doctor=" + doctor +
                ", registrationDate='" + registrationDate + '\'' +
                "} ";
    }
}
