package com.resumeskillenhancer.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.resumeskillenhancer.R;
import com.resumeskillenhancer.interfaces.RecyclerViewItemClick;

import java.util.List;

public class DialogRecyclerViewAdapter extends RecyclerView.Adapter<DialogRecyclerViewAdapter.DialogViewHolder> {

    private final List<String> listOfStrings;
    RecyclerViewItemClick recyclerViewItemClick;

    public DialogRecyclerViewAdapter(List<String> listOfStrings, RecyclerViewItemClick recyclerViewItemClick) {
        this.listOfStrings = listOfStrings;
        this.recyclerViewItemClick = recyclerViewItemClick;
    }

    @NonNull
    @Override
    public DialogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dialog_list, parent, false);
        return new DialogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DialogViewHolder holder, int position) {
        holder.txtName.setText(listOfStrings.get(position));
        holder.imgRemove.setOnClickListener(view -> recyclerViewItemClick.onItemClick(position, view));
        holder.imgEdit.setOnClickListener(view -> recyclerViewItemClick.onItemClick(position, view));
    }

    @Override
    public int getItemCount() {
        return listOfStrings.size();
    }

    public static class DialogViewHolder extends RecyclerView.ViewHolder {
        ImageView imgRemove, imgEdit;
        TextView txtName;

        public DialogViewHolder(View itemView) {
            super(itemView);
            imgEdit = itemView.findViewById(R.id.imgEdit);
            imgRemove = itemView.findViewById(R.id.imgRemove);
            txtName = itemView.findViewById(R.id.txtName);
        }
    }

}

