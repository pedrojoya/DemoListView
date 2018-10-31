package es.iessaladillo.pedrojoya.demolistviewadapter.ui.main;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import es.iessaladillo.pedrojoya.demolistviewadapter.data.local.Database;
import es.iessaladillo.pedrojoya.demolistviewadapter.data.local.model.Student;

@SuppressWarnings("WeakerAccess")
public class MainActivityViewModel extends ViewModel {

    private final Database database = Database.getInstance();
    private LiveData<List<Student>> students;

    public MainActivityViewModel() {
        getStudents(true);
    }

    LiveData<List<Student>> getStudents(boolean forceLoad) {
        if (forceLoad) {
            students = database.queryStudents();
        }
        return students;
    }

    public void deleteStudent(Student student) {
        database.deleteStudent(student);
    }

    public void addStudent(Student student) {
        database.insertStudent(student);
    }
}
