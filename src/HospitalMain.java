import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import AbstractFiles.AbstractException;
import AbstractFiles.AbstractMedicalStaff;
import AbstractFiles.AbstractPerson;
import InterfaceClasses.Management;
import Subclasses.*;


public class HospitalMain implements Management, Serializable {
    private static final long serialVersionUID = 1L;
    private final String department;
    private List<AbstractMedicalStaff> staffList = new ArrayList<>();
    private List<Patient> patientList = new ArrayList<>();

    public HospitalMain(String department) {
        this.department = department;
    }


    public void saveHospitalData(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(this);
            System.out.println("Data successfully saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    public static HospitalMain loadHospitalData(String filename) {
        File file = new File(filename);
        if (!file.exists()) return null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (HospitalMain) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }


    @Override public void checkDepartment() { System.out.println("Dept: " + department); }
    @Override public String getDepartment() { return department; }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "hospital_data.ser";


        HospitalMain hospital = HospitalMain.loadHospitalData(filePath);
        if (hospital == null) {
            hospital = new HospitalMain("General Ward");
        }

        boolean running = true;
        while (running) {
            System.out.println("\n--- Hospital System ---");
            System.out.println("1. Register Doctor\n2. Save & Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                if (choice == 1) {
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Age: ");
                    int age = scanner.nextInt();

                    if (age < 0) throw new AbstractException("Age cannot be negative");

                    Doctor d = new Doctor("D"+(int)(Math.random()*100), name, age, "M", 0, "Gen", 0, "Yes");
                    hospital.staffList.add(d);
                } else if (choice == 2) {
                    hospital.saveHospitalData(filePath);
                    running = false;
                }
            } catch (AbstractException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}

