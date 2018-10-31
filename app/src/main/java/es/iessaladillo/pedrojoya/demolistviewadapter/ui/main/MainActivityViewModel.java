package es.iessaladillo.pedrojoya.demolistviewadapter.ui.main;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import es.iessaladillo.pedrojoya.demolistviewadapter.data.local.Database;
import es.iessaladillo.pedrojoya.demolistviewadapter.data.local.model.Student;

@SuppressWarnings("WeakerAccess")
public class MainActivityViewModel extends ViewModel {

    private final Database database = Database.getInstance();
    private final MutableLiveData<List<Student>> students = new MutableLiveData<>();

    public MainActivityViewModel() {
        getStudents(true);
    }

    LiveData<List<Student>> getStudents(boolean forceLoad) {
        if (forceLoad) {
            // TODO: Make database queryStudebt() return LiveData.
            List<Student> myStudents = database.queryStudents();
            students.setValue(myStudents);
        }
        return students;
    }

    public void deleteStudent(Student student) {
        database.deleteStudent(student);
        // TODO: Make database queryStudebt() return LiveData.
        getStudents(true);
    }

    public void addStudent(Student student) {
        database.insertStudent(student);
        // TODO: Make database queryStudebt() return LiveData.
        getStudents(true);
    }
}
