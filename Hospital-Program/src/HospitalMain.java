import AbstractFiles.AbstractPerson;
import HospitalMain.java.Manageable;
import Subclasses.*;

class Hospital implements Manageable {
    private String department;
    private String[] staffList;
    private String[] patientList;

    public Hospital(String department, String[] staffList, String[] patientList) {
        this.department = department;
        this.staffList = staffList;
        this.patientList = patientList;
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

        AbstractPerson patient1 = new Patient("P001", "John Doe", 30, "Male", 1234567890,
                "O+", "2026-02-25", "Active");

        Doctor doctor1 = new Doctor("D001", "Dr. Smith", 45, "Male", 987654321,
                "Cardiology", 12345, "Available");

        AbstractPerson nurse1 = new Nurse("N001", "Sarah Wilson", 28, "Female", 1122334455, "On Duty");

        Appointment appt = new Appointment("John Doe", "Dr. Smith", "10:00 AM", "Scheduled", "2026-02-26");

        Medicine med = new Medicine("M001", "2026-01-01", "2027-01-01", 100);

        String[] staff = {"Dr. Smith", "Sarah Wilson"};
        String[] patients = {"John Doe"};
        Hospital hospital = new Hospital("Cardiology", staff, patients);

        System.out.println("=== HOSPITAL MANAGEMENT SYSTEM ===");

        AbstractPerson[] persons = {patient1, doctor1, (AbstractPerson) nurse1};
        for (AbstractPerson p : persons) {
            System.out.println(p.getName() + " (ID: " + p.getId() + ", Age: " + p.getAge() + ")");
            p.updateProfile();
        }

        doctor1.assignPatient();
        doctor1.updateAvailability();
        doctor1.viewPatients();

        nurse1.checkAvailability();
        nurse1.assignPatient();

        patient1.register();

        med.checkSupply();
        hospital.checkDepartment();

        System.out.println("Appointment: " + appt.getPatient() + " with " + appt.getDoctor() +
                " on " + appt.getDate());
    }
}