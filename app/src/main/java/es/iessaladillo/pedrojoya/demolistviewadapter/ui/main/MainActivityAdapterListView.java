package es.iessaladillo.pedrojoya.demolistviewadapter.ui.main;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import es.iessaladillo.pedrojoya.demolistviewadapter.R;
import es.iessaladillo.pedrojoya.demolistviewadapter.base.GenericAdapter;
import es.iessaladillo.pedrojoya.demolistviewadapter.base.GenericViewHolder;
import es.iessaladillo.pedrojoya.demolistviewadapter.data.local.model.Student;

@SuppressWarnings("unused")
class MainActivityAdapterListView extends GenericAdapter<Student, MainActivityAdapterListView.ViewHolder> {

    interface OnDeleteListener {
        void onDelete(int position);
    }

    interface OnShowListener {
        void onShow(int position);
    }

    MainActivityAdapterListView() {
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
        viewHolder.bind(getItem(position));
    }

    @Override
    protected ViewHolder onCreateViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    class ViewHolder extends GenericViewHolder {
        private final TextView lblName;
        private final TextView lblAge;
        private final Button btnDelete;

        @SuppressWarnings("unused")
        ViewHolder(View itemView) {
            super(itemView);
            lblName = ViewCompat.requireViewById(itemView, R.id.lblName);
            lblAge = ViewCompat.requireViewById(itemView, R.id.lblAge);
            btnDelete = ViewCompat.requireViewById(itemView, R.id.btnDelete);
        }

        void bind(Student item) {
            if (item.getName().startsWith("B")) {
                lblName.setTextColor(ContextCompat.getColor(lblName.getContext(), R.color.red));
            } else {
                lblName.setTextColor(ContextCompat.getColor(lblName.getContext(), R.color.black));
            }
            lblName.setText(item.getName());
            lblAge.setText(String.valueOf(item.getAge()));
            if (onDeleteListener != null) {
                btnDelete.setOnClickListener(v -> onDeleteListener.onDelete(getAdapterPosition()));
            }
            if (onShowListener != null) {
                itemView.setOnClickListener(v -> onShowListener.onShow(getAdapterPosition()));
            }
        }
    }

}
