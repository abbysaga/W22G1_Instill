package com.instill.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.instill.R;
import com.instill.interfaces.RecyclerViewItemClick;
import com.instill.models.Suggestion;

import java.util.List;

public class SuggestionsAdapter extends RecyclerView.Adapter<SuggestionsAdapter.FilesViewHolder> {

    private final List<Suggestion> suggestionList;
    RecyclerViewItemClick recyclerViewItemClick;

    public SuggestionsAdapter(List<Suggestion> suggestionList, RecyclerViewItemClick recyclerViewItemClick) {
        this.suggestionList = suggestionList;
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
        Suggestion suggestion = suggestionList.get(position);
        holder.txtFileName.setText(suggestion.title + "\n" + suggestion.link);
        holder.txtFileName.setOnClickListener(view -> recyclerViewItemClick.onItemClick(position, view));
    }

    @Override
    public int getItemCount() {
        return suggestionList.size();
    }

    public static class FilesViewHolder extends RecyclerView.ViewHolder {

        TextView txtFileName;

        public FilesViewHolder(View itemView) {
            super(itemView);
            txtFileName = itemView.findViewById(R.id.txtFileName);
        }
    }

}
