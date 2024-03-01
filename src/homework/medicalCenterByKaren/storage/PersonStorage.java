package homework.medicalCenterByKaren.storage;


import homework.medicalCenterByKaren.exception.PersonNotFoundException;
import homework.medicalCenterByKaren.model.Doctor;
import homework.medicalCenterByKaren.model.Patient;
import homework.medicalCenterByKaren.model.Person;

import java.util.Calendar;
import java.util.Date;

public class PersonStorage {
    private Person[] people = new Person[10];
    private int size;

    public void add(Person person){
        if(people.length == size){
            extend();
        }
        people[size++] = person;
    }

    public void printDoctors(){
        for (int i = 0; i < size; i++) {
            if(people[i] instanceof Doctor){
                System.out.println(people[i]);
            }
        }
    }

    public Doctor getDoctorById(String id) throws PersonNotFoundException {
        for (int i = 0; i < size; i++) {
            if(people[i] instanceof Doctor doctor ){
                if(doctor.getID().equals(id)){
                    return (Doctor) people[i];
                }
            }
        }
        //return null;
        throw new PersonNotFoundException("Doctor with " + id + " not found");
    }

    public void printPatients(){
        for (int i = 0; i < size; i++) {
            if(people[i] instanceof Patient){
                System.out.println(people[i]);
            }
        }
    }

    private void extend() {
        Person[] temp = new Person[people.length + 10];
        System.arraycopy(people, 0, temp, 0, size);
        people = temp;
    }
    public boolean isValidDate(Doctor doctor, Date appointmentDateTime){
        for (int i = 0; i < size; i++) {
            if(people[i] instanceof Patient patient){
                if(patient.getDoctor().getID().equals(doctor.getID())){
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(patient.getAppointmentDateTime());
                    calendar.add(Calendar.MINUTE, 29);
                    Date appointmentDatePlus30Min = calendar.getTime();
                    if(appointmentDateTime.after(appointmentDatePlus30Min)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
