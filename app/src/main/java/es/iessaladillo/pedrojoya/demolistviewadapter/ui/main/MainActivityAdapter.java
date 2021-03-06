package es.iessaladillo.pedrojoya.demolistviewadapter.ui.main;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import es.iessaladillo.pedrojoya.demolistviewadapter.R;
import es.iessaladillo.pedrojoya.demolistviewadapter.data.local.model.Student;

class MainActivityAdapter extends ListAdapter<Student, MainActivityAdapter.ViewHolder> {

    private OnDeleteListener onDeleteListener;
    private OnShowListener onShowListener;

    MainActivityAdapter() {
        super(new DiffUtil.ItemCallback<Student>() {
            @Override
            public boolean areItemsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
                return TextUtils.equals(oldItem.getName(), newItem.getName()) && oldItem.getAge()
                    == newItem.getAge();
            }
        });
    }

    @Override
    public Student getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout
            .activity_main_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

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

    interface OnDeleteListener {
        void onDelete(int position);
    }

    interface OnShowListener {
        void onShow(int position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView lblName;
        private final TextView lblAge;
        private final Button btnDelete;

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
