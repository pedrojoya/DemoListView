package es.iessaladillo.pedrojoya.demolistviewadapter.base;

import android.view.View;

@SuppressWarnings("WeakerAccess")
public class GenericViewHolder {

    public final View itemView;
    private int adapterPosition;

    public GenericViewHolder(View itemView) {
        this.itemView = itemView;
    }

    public int getAdapterPosition() {
        return adapterPosition;
    }

    public void setAdapterPosition(int adapterPosition) {
        this.adapterPosition = adapterPosition;
    }

}
