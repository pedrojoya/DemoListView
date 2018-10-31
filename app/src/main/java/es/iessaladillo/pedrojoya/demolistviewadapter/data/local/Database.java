package es.iessaladillo.pedrojoya.demolistviewadapter.data.local;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import es.iessaladillo.pedrojoya.demolistviewadapter.data.local.model.Student;

public class Database {

    private static Database instance;

    private final ArrayList<Student> students;
    private final MutableLiveData<List<Student>> studentsLiveData = new MutableLiveData<>();

    private Database() {
//        students = new ArrayList<>();
        students = new ArrayList<>(Arrays.asList(
                new Student(1, "Baldomero", 23),
                new Student(2, "Germán Ginés", 67),
                new Student(6, "Elvira", 28),
                new Student(3, "Gernaro", 24),
                new Student(4, "Ambrosio", 61),
                new Student(8, "Blanca", 20),
                new Student(9, "Clara", 17),
                new Student(5, "Godolfredo", 17),
                new Student(7, "Luna", 54),
                new Student(10, "Magdalena", 27),
                new Student(11, "Ataulfo", 37),
                new Student(12, "Josefa", 32),
                new Student(13, "Umberta", 21),
                new Student(14, "Adolfo", 35),
                new Student(15, "Filomeno", 18),
                new Student(16, "Atanasio", 42),
                new Student(17, "Gumersindo", 22),
                new Student(18, "Ramiro", 34),
                new Student(19, "Isidro", 25),
                new Student(20, "Fulgencio", 49),
                new Student(21, "Rodolfo", 45)));
        studentsLiveData.setValue(new ArrayList<>(students));
    }

    @NonNull
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public LiveData<List<Student>> queryStudents() {
        return studentsLiveData;
    }

    public void deleteStudent(Student student) {
        students.remove(student);
        studentsLiveData.setValue(new ArrayList<>(students));
    }

    public void insertStudent(Student student) {
        students.add(student);
        studentsLiveData.setValue(new ArrayList<>(students));
    }
}
