package AbstractFiles;

public abstract class AbstractMedicalStaff extends AbstractPerson {
    private String availability;

    public AbstractMedicalStaff(String id, String name, int age, String gender, int contact, String availability) {
        super(id, name, age, gender, contact);
        this.availability = availability;
    }

    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }

    public abstract void assignPatient();
}