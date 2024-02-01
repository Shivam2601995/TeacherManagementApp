package services;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Comparator;
import java.util.Collections;


public class TeacherOperations {
    private String FILE_NAME = "record.txt";
    private List<Teacher> teachers;

    public TeacherOperations() {
        this.teachers = new ArrayList<>();
    }

    private static Teacher parseTeacher(String line) {
        String[] parts = line.split(",");
        // Extracting values from the string parts
        String fullName = getValueFromPart(parts[0]);
        int age = Integer.parseInt(getValueFromPart(parts[1]));
        String dateOfBirth = getValueFromPart(parts[2]);
        String temp = getValueFromPart(parts[3]);
        temp = temp.substring(0, temp.length() - 1);
        int numberOfClasses = Integer.parseInt(temp);
        return new Teacher(fullName, age, dateOfBirth, numberOfClasses);
    }

    private static String getValueFromPart(String part) {
        // Extracting the value part from the format 'key=value'
        String str = part.split("=")[1].trim();
        return str;
    }

    public boolean addTeacher(Teacher teacher) {
        try {
            File file = new File(FILE_NAME);

            if (!file.exists()) {
                file.createNewFile();
            }

            // Open the file in append mode
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write the Teacher object to the file
            bufferedWriter.write(teacher.toString());
            bufferedWriter.newLine();

            // Close the file
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public List<Teacher> getAllTeachers() {

        List<Teacher> teachers = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return teachers;
        }

        try {
            FileReader fileReader = new FileReader(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Parse each line to create a Teacher object
                Teacher teacher = parseTeacher(line);
                //System.out.println(line);
                teachers.add(teacher);
            }

            // Close the file
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return teachers;
    }


    public List<Teacher> filterByAge(int age) {
        List<Teacher> teachers = getAllTeachers(), result = new ArrayList<>();
        for (Teacher teacher : teachers) {
            if (teacher.getAge() == age) {
                result.add(teacher);
            }
        }
        return result;
    }

    public List<Teacher> filterByNumberOfClasses(int numberOfClasses) {
        List<Teacher> teachers = getAllTeachers(), result = new ArrayList<>();
        for (Teacher teacher : teachers) {
            if (teacher.getNumberOfClasses() == numberOfClasses) {
                result.add(teacher);
            }
        }
        return result;
    }

    public List<Teacher> searchTeacher(String name) {
        List<Teacher> teachers = getAllTeachers(), result = new ArrayList<>();
        for (Teacher teacher : teachers) {
            if (teacher.getFullName() == name) {
                result.add(teacher);
            }
        }
        return result;
    }

    public boolean updateTeacher(String name, Teacher updatedTeacher) {
        List<Teacher> teachers = getAllTeachers();
        boolean teacherFound = false;

        // Search for the teacher by name
        for (int i = 0; i < teachers.size(); i++) {
            Teacher existingTeacher = teachers.get(i);
            String str = existingTeacher.getFullName();
            if (str.equals(name)) {
                // Update the teacher with the new information
                teachers.set(i, updatedTeacher);
                teacherFound = true;
                break;
            }
        }

        // If the teacher was found, save the updated list back to the file
        if (teacherFound) {
            try {
                FileWriter fileWriter = new FileWriter(FILE_NAME);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                // Write each updated teacher to the file
                for (Teacher teacher : teachers) {
                    bufferedWriter.write(teacher.toString());
                    bufferedWriter.newLine();
                }

                // Close the file
                bufferedWriter.close();

                return true; // Update successful
            } catch (IOException e) {
                e.printStackTrace();
                return false; // Update failed
            }
        } else {
            // Teacher not found
            return false;
        }
    }

    public boolean removeTeacher(String name) {
        List<Teacher> teachers = getAllTeachers();

        boolean teacherFound = false;

        // Use Iterator to safely remove elements during iteration
        Iterator<Teacher> iterator = teachers.iterator();
        while (iterator.hasNext()) {
            Teacher existingTeacher = iterator.next();
            String str = existingTeacher.getFullName();
            if (str.equals(name)) {
                // Remove the teacher from the list
                iterator.remove();
                teacherFound = true;
            }
        }

        // If the teacher was found and removed, save the updated list back to the file
        if (teacherFound) {
            try {
                FileWriter fileWriter = new FileWriter(FILE_NAME);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                // Write each remaining teacher to the file
                for (Teacher teacher : teachers) {
                    bufferedWriter.write(teacher.toString());
                    bufferedWriter.newLine();
                }

                // Close the file
                bufferedWriter.close();

                return true; // Removal successful
            } catch (IOException e) {
                e.printStackTrace();
                return false; // Removal failed
            }
        } else {
            // Teacher not found
            return false;
        }
    }

    public void sortTeachersByName() {
        List<Teacher> teachers = getAllTeachers();

        // Sort teachers by name
        Collections.sort(teachers, Comparator.comparing(Teacher::getFullName));

        // Write the sorted data back to the file
        try {
            FileWriter fileWriter = new FileWriter(FILE_NAME);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write each sorted teacher to the file
            for (Teacher teacher : teachers) {
                bufferedWriter.write(teacher.toString());
                bufferedWriter.newLine();
            }

            // Close the file
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}