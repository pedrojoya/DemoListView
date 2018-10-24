package es.iessaladillo.pedrojoya.demolistviewadapter.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import es.iessaladillo.pedrojoya.demolistviewadapter.R;
import es.iessaladillo.pedrojoya.demolistviewadapter.data.local.model.Student;

class MainActivityAdapter extends BaseAdapter {

    @NonNull
    private final List<Student> data;
    @LayoutRes
    private final int layoutResid;

    MainActivityAdapter(@LayoutRes int layoutResid, @NonNull List<Student> data) {
        this.data = data;
        this.layoutResid = layoutResid;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView;
        ViewHolder viewHolder;
        if (convertView == null) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(layoutResid, parent, false);
            viewHolder = new ViewHolder(itemView);
            itemView.setTag(viewHolder);
        } else {
            itemView = convertView;
            viewHolder = (ViewHolder) itemView.getTag();
        }
        viewHolder.bind(data.get(position));
        return itemView;
    }

    private class ViewHolder {
        private final TextView lblName;
        private final TextView lblAge;

        ViewHolder(View itemView) {
            lblName = ViewCompat.requireViewById(itemView, R.id.lblName);
            lblAge = ViewCompat.requireViewById(itemView, R.id.lblAge);
        }

        void bind(Student item) {
            if (item.getName().startsWith("B")) {
                lblName.setTextColor(ContextCompat.getColor(lblName.getContext(), R.color.red));
            } else {
                lblName.setTextColor(ContextCompat.getColor(lblName.getContext(), R.color.black));
            }
            lblName.setText(item.getName());
            lblAge.setText(String.valueOf(item.getAge()));
        }
    }

}
