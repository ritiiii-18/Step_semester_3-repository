class SrmStudent {
    static String collegeName;
    static String academicYear;

    static {
        collegeName = "SRM Institute of Science and Technology";
        academicYear = "2025-2026";
        System.out.println("College info loaded");
    }

    String name;

    SrmStudent(String name) {
        this.name = name;
        System.out.println("Student record created: " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};

        SrmStudent[] students = new SrmStudent[names.length];

        for (int i = 0; i < names.length; i++) {
            students[i] = new SrmStudent(names[i]);
        }
    }
}
