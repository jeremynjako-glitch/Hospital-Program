package Subclasses;

public class Nurse extends AbstractMedicalStaff {
    public Nurse(String nurseId, String name, int age, String gender, int contact, String availability) {
        super(nurseId, name, age, gender, contact, availability);
    }

    public Nurse() {
    }

    @Override
    public void updateProfile() {
        System.out.println("Nurse " + super.getName() + " profile updated.");
    }

    @Override
    public void assignPatient() {
        System.out.println("Nurse " + this.getName() + " assigned to patient.");
    }

    public void checkAvailability() {
        System.out.println("Nurse " + this.getName() + " availability: " + this.getAvailability());
    }
}