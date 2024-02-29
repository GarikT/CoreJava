package homework.medicalCenterByKaren.model;

public class Doctor extends Person{
    private String profession;

    public Doctor() {
    }

    public Doctor(String ID, String name, String surname, String email, String phone, String profession) {
        super(ID, name, surname, email, phone);
        this.profession = profession;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "profession='" + profession + '\'' +
                "} " + super.toString();
    }
}
