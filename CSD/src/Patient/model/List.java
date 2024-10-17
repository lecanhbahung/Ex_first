package Patient.model;

import Patient.view.Validation;

import java.util.LinkedList;
import java.util.Queue;

public class List {

    private Queue<Patient> patientQueue = new LinkedList<>();

    public void registerPatient() {
        String name = Validation.getValue("Input patient name: ");
        int age = Integer.parseInt(Validation.getValue("Input patient age: "));
        Patient newPatient = new Patient(name, age);
        patientQueue.offer(newPatient);
        System.out.println("Patient registered: " + newPatient);
    }

    public void processPatient() {
        if (patientQueue.isEmpty()) {
            System.out.println("Empty");
        } else {
            Patient currentPatient = patientQueue.poll();
            System.out.println("Processing patient: ");
            currentPatient.display();
        }
    }

    public void displayQueue() {
        if (patientQueue.isEmpty()) {
            System.out.println("Empty.");
        } else {
            System.out.println("Current patients in queue:");
            for (Patient patient : patientQueue) {
                    patient.display();
            }
        }
    }
}
