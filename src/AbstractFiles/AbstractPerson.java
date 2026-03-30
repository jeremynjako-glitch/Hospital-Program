package AbstractFiles;

import javax.sound.midi.InvalidMidiDataException;
import java.lang.IllegalArgumentException;
public abstract class AbstractPerson{

    private String id;
    private String name;
    private int age;
    private String gender;
    private int contact;

    public AbstractPerson(String id, String name, int age, String gender, int contact) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
    }

    public String getId() { return id; }
    public void setId(String id) throws InvalidMidiDataException{this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) throws InvalidMidiDataException {
        if (age < 0 || age > 120){
            throw new IllegalArgumentException("Please input an age between 0 and 120.");
        }
        this.age = age;
    }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public int getContact() { return contact; }
    public void setContact(int contact) { this.contact = contact; }


    public abstract void updateProfile();
}