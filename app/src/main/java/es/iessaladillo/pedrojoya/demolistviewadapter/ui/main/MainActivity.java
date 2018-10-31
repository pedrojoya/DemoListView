package es.iessaladillo.pedrojoya.demolistviewadapter.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProviders;
import es.iessaladillo.pedrojoya.demolistviewadapter.R;
import es.iessaladillo.pedrojoya.demolistviewadapter.data.local.model.Student;

public class MainActivity extends AppCompatActivity {

    private MainActivityAdapter listAdapter;
    private MainActivityViewModel viewModel;
    private TextView lblEmptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        setupViews();
    }

    private void setupViews() {
        setupListView();
        setupFab();
    }

    private void setupFab() {
        FloatingActionButton fab = ActivityCompat.requireViewById(this, R.id.fab);
        fab.setOnClickListener(v -> addStudent());
    }

    private void setupListView() {
        lblEmptyView = ActivityCompat.requireViewById(this, R.id.lblEmptyView);
        listAdapter = new MainActivityAdapter();
        listAdapter.setOnDeleteListener(position -> deleteStudent(listAdapter.getItem(position)));
        listAdapter.setOnShowListener(position -> showStudent(listAdapter.getItem(position)));
        viewModel.getStudents(false).observe(this, students -> {
            listAdapter.submitList(students);
            lblEmptyView.setVisibility(students.size() > 0 ? View.INVISIBLE : View.VISIBLE);
        });
        ListView lstStudents = ActivityCompat.requireViewById(this, R.id.lstStudents);
        lstStudents.setAdapter(listAdapter);
        /* RECOMIENDO USAR LAS OTRAS TÉCNICAS EXPLICADAS.
           LO DEJO A TÍTULO INFORMATIVO.
        lstStudents.setEmptyView(lblEmptyView);
        lstStudents.setOnItemClickListener(
            (parent, view, position, id) -> showItem(listAdapter.getItem(position)));
        */
    }

    private void showStudent(Student student) {
        // TODO: START ANOTHER ACTIVITY INSTEAD TO EDIT STUDENT DATA.
        Toast.makeText(this, student.getName(), Toast.LENGTH_SHORT).show();
    }

    private void addStudent() {
        // TODO: START ANOTHER ACTIVITY INSTEAD TO ADD NEW STUDENT.
        Student student = new Student(34,  "Perico", 44);
        viewModel.addStudent(student);
    }

    private void deleteStudent(Student student) {
        viewModel.deleteStudent(student);
    }

}
