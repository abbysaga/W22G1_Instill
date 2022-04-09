package com.instill.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.instill.R;
import com.instill.interfaces.RecyclerViewItemClick;
import com.instill.utils.Utils;

import java.io.File;
import java.util.List;

public class FilesAdapter extends RecyclerView.Adapter<FilesAdapter.FilesViewHolder> {

    private final List<File> fileList;
    RecyclerViewItemClick recyclerViewItemClick;

    public FilesAdapter(List<File> fileList, RecyclerViewItemClick recyclerViewItemClick) {
        this.fileList = fileList;
        this.recyclerViewItemClick = recyclerViewItemClick;
    }

    @NonNull
    @Override
    public FilesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_files, parent, false);
        return new FilesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilesViewHolder holder, int position) {
        File file = fileList.get(position);
        holder.txtFileName.setText(file.getName().substring(0, file.getName().lastIndexOf('.')) + "\n" + Utils.showLastModified(file.lastModified()));
        holder.txtFileName.setOnClickListener(view -> recyclerViewItemClick.onItemClick(position, view));
    }

    @Override
    public int getItemCount() {
        return fileList.size();
    }

    public static class FilesViewHolder extends RecyclerView.ViewHolder {

        TextView txtFileName;

        public FilesViewHolder(View itemView) {
            super(itemView);
            txtFileName = itemView.findViewById(R.id.txtFileName);
        }
    }

}
