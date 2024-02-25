package homework.medicalCenter.storage;

import homework.medicalCenter.model.Doctor;

public class DoctorStorage {
    private Doctor[] doctors = new Doctor[10];
    private int size;


    public void add(Doctor newDoctor) {
        if(size == doctors.length){
            extend();
        }
        doctors[size++] = newDoctor;
    }

    private void extend() {
        Doctor[] temp = new Doctor[size + 10];
        System.arraycopy(doctors, 0, temp, 0, size);
        doctors = temp;
    }

    public Doctor findDoctorById(String id) {
        Doctor result = null;
        for (int i = 0; i < size; i++) {
            if(doctors[i].getId().equals(id)){
                result = doctors[i];
                break;
            }
        }
        return result;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(doctors[i]);
        }
    }

    public void printByProfession(String profession) {
        if(size <= 0){
            System.out.println("No doctors");
            return;
        }
        int count = 0;
        for (int i = 0; i < size; i++) {
            if(doctors[i].getProfession().equals(profession)){
                System.out.println(doctors[i]);
                count++;
            }
        }
        if(count == 0){
            System.out.println("No doctor found with " + profession + " profession.");
        }
    }

    public void deleteById(String enteredId) {
        int index = findById(enteredId);
        if(index != -1){
            for (int i = index + 1; i < size; i++) {
                doctors[i-1] = doctors[i];
            }
            size--;
            System.out.println("Doctor with " + enteredId + " ID successfully removed.");
        }
    }
    public int findById(String id){
        int result = -1;
        if(size > 0){
            for (int i = 0; i < size; i++) {
                if(doctors[i].getId().equals(id)){
                    result = i;
                    break;
                }
            }
        }
        return result;

    }
}
