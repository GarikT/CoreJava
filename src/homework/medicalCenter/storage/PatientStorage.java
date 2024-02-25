package homework.medicalCenter.storage;

import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;

public class PatientStorage {
    private Patient[] patients = new Patient[10];
    private int size;
    public void add(Patient newPatient) {
        if(size == patients.length){
            extend();
        }
        patients[size++] = newPatient;
    }

    private void extend() {
        Patient[] temp = new Patient[size + 10];
        System.arraycopy(patients, 0, temp, 0, size);
        patients = temp;
    }
    public boolean isEmpty(){
        boolean result = false;
        if(size <= 0){
            System.out.println("No patients");
            result = true;
        }
        return result;
    }
    public void print(){
        if(!isEmpty()) {
            for (int i = 0; i < size; i++) {
                System.out.println(patients[i]);
            }
        }
    }

    public void printByDoctor(Doctor d) {
        if(!isEmpty()) {
            for (int i = 0; i < size; i++) {
                if(patients[i].getDoctor().equals(d)){
                    System.out.println(patients[i]);
                }
            }
        }
    }
}
