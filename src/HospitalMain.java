import AbstractFiles.AbstractMedicalStaff;
import AbstractFiles.AbstractPerson;
import InterfaceClasses.Management;
import Subclasses.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;


class Hospital implements Management, Serializable {
    private static final long serialVersionUID = 1L;
    private final String department;
    private List<AbstractMedicalStaff> staffList = new ArrayList<>();
    private List<Patient> patientList = new ArrayList<>();

    public Hospital(String department, String[] strings, String[] strings1) {
        this.department = department;
    }

    public void saveHospitalData(String filename){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(this); // Saves the entire Hospital object and all lists inside it
            System.out.println("Data successfully saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    public static Hospital loadHospitalData(String filename) {
        File file = new File(filename);
        if (!file.exists()){
            System.out.println("No existing data found at "+ filename);
            return null;
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Hospital) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data: " + e.getMessage());
            return null;
        }
    }

    public void addStaff(AbstractMedicalStaff person) {
        if (person != null) {
            staffList.add(person);
        }
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
        Hospital hospital = new Hospital("Cardiology", new String[]{}, new String[]{});

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


        String filePath = "hospital_data.ser";

        File file = new File(filePath);
        if (file.exists()) {
            hospital = Hospital.loadHospitalData(filePath);
            System.out.println("Existing data loaded for department: " + hospital.getDepartment());
        } else {

            hospital = new Hospital("Cardiology", new String[]{}, new String[]{});
            System.out.println("No existing data found. Created new Hospital instance.");
        }
        hospital.saveHospitalData(filePath);
    }
}

