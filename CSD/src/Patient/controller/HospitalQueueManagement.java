package Patient.controller;

import Patient.model.List;
import Patient.view.Menu;

public class HospitalQueueManagement extends Menu<String> {
    List list;
    static String[] chon={"Register a new patient","Process a patient","Display","Exit"};
    public HospitalQueueManagement() {
        super("Hospital Queue Management System:", chon);
        list=new List();
    }

    @Override
    public void execute(int choice) {
        switch (choice){
            case 1:list.registerPatient();break;
            case 2:list.processPatient();break;
            case 3:list.displayQueue();break;
            case 4:System.exit(0);break;
        }
    }

    public static void main(String[] args) {
        new HospitalQueueManagement().run();
    }
}


