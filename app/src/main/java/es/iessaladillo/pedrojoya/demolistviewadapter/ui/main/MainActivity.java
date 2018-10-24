package es.iessaladillo.pedrojoya.demolistviewadapter.ui.main;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProviders;
import es.iessaladillo.pedrojoya.demolistviewadapter.R;

public class MainActivity extends AppCompatActivity {

    @SuppressWarnings("FieldCanBeLocal")
    private MainActivityAdapter listAdapter;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        setupViews();
    }

    private void setupViews() {
        setupListView();
    }

    private void setupListView() {
        listAdapter = new MainActivityAdapter(R.layout.activity_main_item, viewModel.getStudents());
        ListView lstStudents = ActivityCompat.requireViewById(this, R.id.lstStudents);
        lstStudents.setAdapter(listAdapter);
    }


}
