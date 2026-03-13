package Subclasses;

public class Appointment {
    private String patient;
    private String doctor;
    private String time;
    private String status;
    private String date;

    public Appointment(String patient, String doctor, String time, String status, String date) {
        this.patient = patient;
        this.doctor = doctor;
        this.time = time;
        this.status = status;
        this.date = date;
    }

    public String getPatient() { return patient; }
    public String getDoctor() { return doctor; }
    public String getTime() { return time; }
    public String getStatus() { return status; }
    public String getDate() { return date; }
}