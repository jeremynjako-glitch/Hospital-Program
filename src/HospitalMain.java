import AbstractFiles.AbstractMedicalStaff;
import AbstractFiles.AbstractPerson;
import InterfaceClasses.Management;
import Subclasses.*;
import java.util.ArrayList;
import java.util.List;



class Hospital implements Management {
    private final String department;
    private List<AbstractMedicalStaff> staffList = new ArrayList<>();
    private List<Patient> patientList = new ArrayList<>();

    public Hospital(String department) {
        this.department = department;
    }

    public void addStaff(AbstractMedicalStaff person){
        boolean add = staffList.add(person);
    }

    @Override
    public void checkDepartment() {
        System.out.println("Checking department: " + this.department);
    }

    @Override
    public String getDepartment() {
        return department;
    }

    public static void main(String[] args) {


        Patient patient1 = new Patient("P001", "John Kamau", 30, "Male", 1234567890,
                "O+", "2026-02-25", "Active");

        Doctor doctor1 = new Doctor("D001", "Dr. Smith", 45, "Male", 987654321,
                "Cardiology", 12345, "Available");


        Nurse nurse1 = new Nurse("N001", "Sarah Wilson", 28, "Female", 1122334455, "On Duty");

        Appointment appt = new Appointment("John Kamau", "Dr. Smith", "10:00 AM", "Scheduled", "2026-02-26");

        Medicine med = new Medicine("M001", "2026-01-01", "2027-01-01", 100);


        String[] staff = {"Dr. Smith", "Sarah Wilson"};
        String[] patients = {"John Kamau"};
        Hospital hospital = new Hospital("Cardiology");

        System.out.println("=== HOSPITAL MANAGEMENT SYSTEM ===");


        AbstractPerson[] persons = {patient1, doctor1, nurse1};
        for (AbstractPerson p : persons) {
            System.out.println(p.getName() + " (ID: " + p.getId() + ", Age: " + p.getAge() + ")");
            p.updateProfile();
        }


        System.out.println("\n--- Staff Actions ---");
        doctor1.assignPatient();
        doctor1.updateAvailability();
        doctor1.viewPatients();

        nurse1.checkAvailability();
        nurse1.assignPatient();

        System.out.println("\n--- Patient & Supply Actions ---");
        patient1.register();
        med.checkSupply();
        hospital.checkDepartment();

        System.out.println("\n--- Appointment Details ---");
        System.out.println("Appointment: " + appt.getPatient() + " with " + appt.getDoctor() +
                " on " + appt.getDate());
    }

}

