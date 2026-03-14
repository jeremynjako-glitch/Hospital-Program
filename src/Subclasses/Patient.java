package Subclasses;

import AbstractFiles.AbstractPerson;

public class Patient extends AbstractPerson {
    private String bloodGroup;
    private String admissionDate;
    private String status;

    public Patient(String patientID, String name, int age, String gender, int contact,
                   String bloodGroup, String admissionDate, String status) {
        super(patientID, name, age, gender, contact);
        this.bloodGroup = bloodGroup;
        this.admissionDate = admissionDate;
        this.status = status;
    }

    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }
    public String getAdmissionDate() { return admissionDate; }
    public void setAdmissionDate(String admissionDate) { this.admissionDate = admissionDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public void updateProfile() {
        System.out.println("Patient " + this.getName() + " profile updated.");
    }

    public void register() {
        System.out.println("Patient " + this.getName() + " registered successfully.");
    }
}