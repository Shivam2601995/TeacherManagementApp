package services;
public class Teacher  {

    private String fullName;
    private int age;
    private String dateOfBirth;
    private int numberOfClasses;

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getNumberOfClasses() {
        return numberOfClasses;
    }
    public void setNumberOfClasses(int numberOfClasses) {
        this.numberOfClasses = numberOfClasses;
    }

    public Teacher(){};
    public Teacher(String fullName, int age, String dateOfBirth, int numberOfClasses) {
        this.fullName = fullName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.numberOfClasses = numberOfClasses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "fullName=" + fullName +
                ", age=" + age +
                ", dateOfBirth=" + dateOfBirth +
                ", numberOfClasses=" + numberOfClasses +
                '}';
    }

}