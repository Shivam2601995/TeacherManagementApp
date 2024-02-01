package services;
import java.util.*;

public class TeacherManagementApp {
    private static TeacherOperations to = new TeacherOperations();
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {

        while(true)
        {
            System.out.println("\n\n<<<<Teacher Management App>>>>");
            System.out.println("1>>Show All Teachers");
            System.out.println("2>>Add a Teacher");
            System.out.println("3>>Filter the Teacher");
            System.out.println("4>>Search for Teacher");
            System.out.println("5>>Update a Teacher Record ");
            System.out.println("6>>Delete a Teacher Record ");
            System.out.println("7>>Sort");
            System.out.println("8>>Exit");
            System.out.print("\nEnter Your Choice :");
            int choice=getIntegerInput();
            switch(choice)
            {
                case 1:
                    showAllteacher();
                    break;
                case 2 :
                    addTeacher();
                    break;
                case 3 :
                    filterTeacher();
                    break;
                case 4 :
                    System.out.print("\nEnter the name you want to search : ");
                    String name=sc.nextLine();
                    List<Teacher>teacher=to.searchTeacher(name);
                    displayTeacher(teacher);
                    break;
                case 5:
                    updateTeacher();
                    break;
                case 6:
                    removeTeacher();
                    break;
                case 7:
                    to.sortTeachersByName();
                    break;

                case 8 :
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice please Enter valid number");


            }


        }
    }

    private static void showAllteacher() {
        List<Teacher> teachers=to.getAllTeachers();
        if(teachers.isEmpty())
        {
            System.out.println("\nNo Teacher Found in File ");
        }
        else
        {
            System.out.println("\n\n");
            int count=0;
            for(Teacher teacher : teachers)
            {
                count++;
                System.out.println("Teacher ("+count+"). "+"Name="+teacher.getFullName()+" "+"Age="+teacher.getAge()+" "+"DOB="+teacher.getDateOfBirth()+" "+"Classes="+teacher.getNumberOfClasses());
            }
        }
    }

    private static void addTeacher() {
        System.out.print("\n\nEnter the full name :");
        String fullName=sc.nextLine();
        System.out.print("Enter age :");
        int age=getIntegerInput();
        System.out.print("Enter the Date of Birth :");
        String dob=sc.nextLine();
        System.out.print("Enter the number of classes :");
        int numberOfClasses=getIntegerInput();

        Teacher newTeacher =new Teacher(fullName,age,dob,numberOfClasses);
        to.addTeacher(newTeacher);
        System.out.println("\nTeacher added Succesfully");


    }

    private static void filterTeacher() {
        System.out.println("\n\n<<<Filter By Criteria>>>");
        System.out.println("1>>Filter By age");
        System.out.println("2>>Filter By number of classes");
        System.out.print("Enter the Choice :");
        int filterChoice=getIntegerInput();

        switch(filterChoice)
        {
            case 1 :
                System.out.print("\nEnter the age to filter :");
                int ageToFilter=getIntegerInput();
                List<Teacher>filterdByAge=to.filterByAge(ageToFilter);
                displayTeacher(filterdByAge);
                break;
            case 2:
                System.out.print("\nEnter number of classes to filter :");
                int classToFilter=getIntegerInput();
                List<Teacher>FilterdbyClass=to.filterByNumberOfClasses(classToFilter);
                displayTeacher(FilterdbyClass);
                break;
            default:
                System.out.println("\nInvalid Choice.Press either 1 or 2 >>");
        }

    }

    private static void updateTeacher() {
        System.out.print("\nEnter the name u have to update :");
        String NameToUpdate=sc.nextLine();
        System.out.println("\nEnter the teacher's detail to be updated :");
        System.out.print("\nEnter fullname :");
        String fullName=sc.nextLine();
        System.out.print("\nEnter the age of teacher :");
        int age=getIntegerInput();
        System.out.print("\nEnter the Date of Birth :");
        String dob=sc.nextLine();
        System.out.print("\nEnter the number of classes :");
        int numberOfClasses=getIntegerInput();
        Teacher updateTeacher =new Teacher(fullName,age,dob,numberOfClasses);
        to.updateTeacher(NameToUpdate,updateTeacher);

    }

    private static void removeTeacher() {
        System.out.print("\n\nEnter the full name :");
        String name=sc.nextLine();
        to.removeTeacher(name);
    }

    private static void displayTeacher(List<Teacher> filteredTeachers) {
        if(filteredTeachers.isEmpty())
        {
            System.out.println("\nNo teacher Found through Matching Criteria");
        }
        else
        {
            System.out.println("\n\nFiltered Teachers");
            for(Teacher teacher : filteredTeachers)
            {
                System.out.println(teacher);
            }
        }
    }

    private static int getIntegerInput() {
        boolean flag = true;
        String str = "0";
        while(flag) {
            str = sc.nextLine();
            int i = 0;
            for(i = 0;i<str.length();i ++) {
                if(str.charAt(i) < '0' || str.charAt(i) > '9') break;
            }
            if(i != str.length()) {
                System.out.println("\n!!! Enter a Valid Integer !!!\nEnter Again :");
            }
            else {
                break;
            }
        }
        return Integer.parseInt(str);

    }

}