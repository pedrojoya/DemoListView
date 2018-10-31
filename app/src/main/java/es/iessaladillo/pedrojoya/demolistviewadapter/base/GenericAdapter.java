package es.iessaladillo.pedrojoya.demolistviewadapter.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

// M for Model, VH for ViewHolder
@SuppressWarnings("unused")
public abstract class GenericAdapter<M, VH extends GenericViewHolder> extends BaseAdapter {

    @NonNull
    private List<M> data = new ArrayList<>();
    @LayoutRes
    private final int layoutResid;

    @SuppressWarnings("SameParameterValue")
    protected GenericAdapter(@LayoutRes int layoutResid) {
        this.layoutResid = layoutResid;
    }

    public void submitList(@NonNull List<M> newData) {
        data = newData;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public M getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView;
        VH viewHolder;
        if (convertView == null) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(layoutResid, parent, false);
            viewHolder = onCreateViewHolder(itemView);
            itemView.setTag(viewHolder);
        } else {
            itemView = convertView;
            //noinspection unchecked
            viewHolder = (VH) itemView.getTag();
        }
        viewHolder.setAdapterPosition(position);
        onBindViewHolder(viewHolder, position);
        return itemView;
    }

    protected abstract void onBindViewHolder(VH viewHolder, int position);

    protected abstract VH onCreateViewHolder(View itemView);

}
