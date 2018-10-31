package es.iessaladillo.pedrojoya.demolistviewadapter.ui.main;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import es.iessaladillo.pedrojoya.demolistviewadapter.R;
import es.iessaladillo.pedrojoya.demolistviewadapter.base.GenericAdapter;
import es.iessaladillo.pedrojoya.demolistviewadapter.data.local.model.Student;

class MainActivityAdapter extends GenericAdapter<Student, MainActivityAdapter.ViewHolder> {

    interface OnDeleteListener {
        void onDelete(int position);
    }

    interface OnShowListener {
        void onShow(int position);
    }

    MainActivityAdapter() {
        super(R.layout.activity_main_item);
    }

    private OnDeleteListener onDeleteListener;

    private OnShowListener onShowListener;

    void setOnDeleteListener(OnDeleteListener onDeleteListener) {
        this.onDeleteListener = onDeleteListener;
    }

    void setOnShowListener(OnShowListener onShowListener) {
        this.onShowListener = onShowListener;
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    protected void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.bind(getItem(position), position);
    }

    @Override
    protected ViewHolder onCreateViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    class ViewHolder {
        private final View itemView;
        private final TextView lblName;
        private final TextView lblAge;
        private final Button btnDelete;

        ViewHolder(View itemView) {
            this.itemView = itemView;
            lblName = ViewCompat.requireViewById(itemView, R.id.lblName);
            lblAge = ViewCompat.requireViewById(itemView, R.id.lblAge);
            btnDelete = ViewCompat.requireViewById(itemView, R.id.btnDelete);
        }

        // TODO: Remove position parameter
        void bind(Student item, int position) {
            if (item.getName().startsWith("B")) {
                lblName.setTextColor(ContextCompat.getColor(lblName.getContext(), R.color.red));
            } else {
                lblName.setTextColor(ContextCompat.getColor(lblName.getContext(), R.color.black));
            }
            lblName.setText(item.getName());
            lblAge.setText(String.valueOf(item.getAge()));
            if (onDeleteListener != null) {
                // TODO: Use adapterPosition property instead of position.
                btnDelete.setOnClickListener(v -> onDeleteListener.onDelete(position));
            }
            if (onShowListener != null) {
                // TODO: Use adapterPosition property instead of position.
                itemView.setOnClickListener(v -> onShowListener.onShow(position));
            }
        }
    }

}
