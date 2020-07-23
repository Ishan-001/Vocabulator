package com.project.vocabulator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {

    private Context context;
    private int size;

    public WordAdapter(Context context, int size){
        this.context=context;
        this.size=size;
    }

    @NonNull
    @Override
    public WordAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.word_item, parent, false);
        return new WordAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TinyDB tinyDB = new TinyDB(context);
        ArrayList<String> words=reverse(tinyDB.getListString("Words"));
        ArrayList<String> descriptions=reverse(tinyDB.getListString("Descriptions"));
        ArrayList<String> types=reverse(tinyDB.getListString("Types"));

        holder.word.setText(words.get(position));
        holder.description.setText(descriptions.get(position));
        holder.type.setText(types.get(position));
    }

    @Override
    public int getItemCount() {
        return size;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView word, description, type;

        ViewHolder(View itemView){
            super(itemView);
            word=itemView.findViewById(R.id.word);
            description=itemView.findViewById(R.id.description);
            type=itemView.findViewById(R.id.type);
        }
    }

    ArrayList<String> reverse(ArrayList<String> list){
        ArrayList<String> list2=new ArrayList<>();
        for(int i=list.size()-1;i>=0;i--)
            list2.add(list.get(i));
        return list2;
    }
}
