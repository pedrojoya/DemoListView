package es.iessaladillo.pedrojoya.demolistviewadapter.ui.main;

import java.util.List;

import androidx.lifecycle.ViewModel;
import es.iessaladillo.pedrojoya.demolistviewadapter.data.local.Database;
import es.iessaladillo.pedrojoya.demolistviewadapter.data.local.model.Student;

class MainActivityViewModel extends ViewModel {

    private final Database database = Database.getInstance();
    private List<Student> students;

    List<Student> getStudents() {
        if (students == null) {
            students = database.queryStudents();
        }
        return students;
    }

}
