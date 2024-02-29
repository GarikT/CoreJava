package homework.medicalCenterByKaren;

import homework.medicalCenterByKaren.model.Doctor;
import homework.medicalCenterByKaren.model.Patient;
import homework.medicalCenterByKaren.storage.PersonStorage;
import homework.medicalCenterByKaren.util.DateUtil;

import java.text.ParseException;
import java.util.Date;

public class MedicalCenterMain {
    static PersonStorage personStorage = new PersonStorage();
    public static void main(String[] args) throws ParseException {
        Doctor doctor = new Doctor("D001", "Dr. Poxos", "Poxosyan", "dr.poxos@mail.com", "0987654", "dentist");
        Doctor doctor1 = new Doctor("D002", "Dr. Petros", "Petrosyan", "dr.petros@mail.com", "092345", "surgeon");
        personStorage.add(doctor);
        personStorage.add(doctor1);

        String appointmentDateStr = "29/02/2024 10:00";
        Date appointmentDate = DateUtil.stringToDateTime(appointmentDateStr);
        Patient patient = new Patient("12345", "Martiros", "Martirosyan", "mart@mail.com", "1234567", doctor, new Date(), appointmentDate );
        personStorage.add(patient);

        String appointmentDateStr1 = "29/02/2024 10:20";
        Date appointmentDate1 = DateUtil.stringToDateTime(appointmentDateStr1);
        Patient patient1 = new Patient("2342342", "Poxosuhi", "Poxosyan", "poxosuhi@mail.com", "0923842", doctor, new Date(), appointmentDate1 );
        if(personStorage.isValidDate(doctor, appointmentDate1)){
            personStorage.add(patient1);
        }
        System.out.println("Doctors");
        personStorage.printDoctors();
        System.out.println("Patients");
        personStorage.printPatients();
    }
}
