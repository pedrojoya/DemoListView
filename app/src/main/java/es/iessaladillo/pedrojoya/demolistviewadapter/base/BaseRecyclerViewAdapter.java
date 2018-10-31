package es.iessaladillo.pedrojoya.demolistviewadapter.base;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

// M for Model, VH for ViewHolder
@SuppressWarnings("unused")
public abstract class BaseRecyclerViewAdapter<M, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private List<M> data = new ArrayList<>();

    @Override
    public int getItemCount() {
        return data.size();
    }

    @SuppressWarnings("WeakerAccess")
    public M getItem(int position) {
        return data.get(position);
    }

    public void submitList(List<M> newStudents) {
        data = newStudents;
        notifyDataSetChanged();
    }

}
