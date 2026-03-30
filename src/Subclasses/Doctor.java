package Subclasses;

import java.util.HashSet;
import java.util.Set;
import AbstractFiles.AbstractMedicalStaff;

public class Doctor extends AbstractMedicalStaff {
    private Set<Patient> assignedPatients = new HashSet<>();
    private String specialization;
    private int licenseNumber;

    public Doctor(String doctorID, String name, int age, String gender, int contact,
                  String specialization, int licenseNumber, String availability) {
        super(doctorID, name, age, gender, contact, availability);
        this.specialization = specialization;
        this.licenseNumber = licenseNumber;
    }

    public void assignPatient(Patient p){
        assignedPatients.add(p);
        System.out.println("Patient "+ p.getName() +" assigned to Doctor" + this.getName());
    }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public int getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(int licenseNumber) { this.licenseNumber = licenseNumber; }

    @Override
    public void updateProfile() {
        System.out.println("Doctor " + super.getName() + " profile updated.");
    }

    @Override
    public void assignPatient() {
        System.out.println("Doctor " + this.getName() + " assigned to patient.");
    }

    public void updateAvailability() {
        System.out.println("Doctor " + this.getName() + " availability updated to " + this.getAvailability());
    }

    public void viewPatients() {
        System.out.println("Doctor " + this.getName() + " viewing patient list.");
    }
}