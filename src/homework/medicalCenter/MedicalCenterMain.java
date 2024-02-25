package homework.medicalCenter;

import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.storage.DoctorStorage;
import homework.medicalCenter.storage.PatientStorage;

import java.util.Scanner;

public class MedicalCenterMain {
    static Scanner scanner = new Scanner(System.in);
    static PatientStorage patientStorage = new PatientStorage();
    static DoctorStorage doctorStorage = new DoctorStorage();

    public static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning){
            printMenu();
            String input = scanner.nextLine();
            switch(input){
                case "0":
                    isRunning = false;
                    break;
                case "1":
                    addDoctor();
                    break;
                case "2":
                    searchDoctorByProfession();
                    break;
                case "3":
                    deleteDoctorById();
                    break;
                case "4":
                    changeDoctorById();
                    break;
                case "5":
                    addPatient();
                    break;
                case "6":
                    printAllPatientsByDoctor();
                    break;
                case "7":
                    printAllPatients();
                    break;
                case "8":
                    printAllDoctors();
                    break;
                default:
                    System.out.println("invalid command. Please try again!");
                    break;
            }
        }
    }

    private static void addPatient() {
        System.out.println("Please enter doctor ID for this new patient");
        String doctorID = scanner.nextLine();
        Doctor d = doctorStorage.findDoctorById(doctorID);
        if( d == null ){
            System.out.println("A doctor with " + doctorID + " ID does not exist");
            return;
        }
        System.out.println("Please enter patient's id");
        String id = scanner.nextLine();
        System.out.println("Please enter patient's name:");
        String name = scanner.nextLine();
        System.out.println("Please enter patient's surname:");
        String surname = scanner.nextLine();
        System.out.println("Please enter patient's email:");
        String email = scanner.nextLine();
        System.out.println("Please enter patient's phone number:");
        String phone = scanner.nextLine();
        System.out.println("Please enter patient's registration date:");
        String regdate = scanner.nextLine();
        Patient patient = new Patient(id, name, surname, email, phone, d, regdate);
        patientStorage.add(patient);
        System.out.println("Patient added");

    }

    private static void printAllPatientsByDoctor() {
        if(patientStorage.isEmpty()){
            System.out.println("No patients");
            return;
        }
        System.out.println("Please enter doctor ID");
        String doctorID = scanner.nextLine();
        Doctor d = doctorStorage.findDoctorById(doctorID);
        if( d == null ){
            System.out.println("A doctor with " + doctorID + " ID does not exist");
            return;
        }
        patientStorage.printByDoctor(d);

    }

    private static void printAllPatients() {
        patientStorage.print();
    }

//    private static void addPatient() {
//
//    }

    private static void changeDoctorById() {
        System.out.println("please enter doctor ID: ");
        String enteredId = scanner.nextLine();
        Doctor d = doctorStorage.findDoctorById(enteredId);
        if( d == null ){
            System.out.println("A doctor with " + enteredId + " ID does not exist");
            return;
        }
        System.out.println("Please enter doctor's name:");
        String name = scanner.nextLine();
        d.setName(name);
        System.out.println("Please enter doctor's surname:");
        String surname = scanner.nextLine();
        d.setSurname(surname);
        System.out.println("Please enter doctor's email:");
        String email = scanner.nextLine();
        d.setEmail(email);
        System.out.println("Please enter doctor's phone number:");
        String phone = scanner.nextLine();
        d.setPhoneNumber(phone);
        System.out.println("Please enter doctor's profession:");
        String profession = scanner.nextLine();
        d.setProfession(profession);
        System.out.println("Doctor updated");

    }

    private static void deleteDoctorById() {
        System.out.println("please enter doctor ID: ");
        String enteredId = scanner.nextLine();
        Doctor d = doctorStorage.findDoctorById(enteredId);
        if( d == null ){
            System.out.println("A doctor with " + enteredId + " ID does not exist");
            return;
        }
        doctorStorage.deleteById(enteredId);
    }

    private static void searchDoctorByProfession() {
        System.out.println("Please enter profession");
        String profession = scanner.nextLine();
        doctorStorage.printByProfession(profession);
    }

    private static void printAllDoctors() {
        doctorStorage.print();
    }

    private static void addDoctor() {
        System.out.println("Please enter doctor ID");
        String enteredId = scanner.nextLine();
        Doctor d = doctorStorage.findDoctorById(enteredId);
        if( d != null ){
            System.out.println("A doctor with this ID already exists");
            return;
        }
        System.out.println("Please enter doctor's name:");
        String name = scanner.nextLine();
        System.out.println("Please enter doctor's surname:");
        String surname = scanner.nextLine();
        System.out.println("Please enter doctor's email:");
        String email = scanner.nextLine();
        System.out.println("Please enter doctor's phone number:");
        String phone = scanner.nextLine();
        System.out.println("Please enter doctor's profession:");
        String profession = scanner.nextLine();
        Doctor newDoctor = new Doctor(enteredId, name, surname, email, phone, profession);
        doctorStorage.add(newDoctor);
        System.out.println("Doctor added");
    }

    private static void printMenu() {
        System.out.println("Please enter 0 to QUIT");
        System.out.println("Please enter 1 to ADD DOCTOR");
        System.out.println("Please enter 2 to SEARCH DOCTOR BY PROFESSION");
        System.out.println("Please enter 3 to DELETE DOCTOR BY ID");
        System.out.println("Please enter 4 to CHANGE DOCTOR BY ID");
        System.out.println("Please enter 5 to ADD PATIENT");
        System.out.println("Please enter 6 to PRINT ALL PATIENTS BY DOCTOR");
        System.out.println("Please enter 7 to PRINT ALL PATIENTS");
        System.out.println("Please enter 8 to PRINT ALL DOCTORS");
    }
}
