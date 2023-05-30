package com.example.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private RespositorioOficio repo;
    private LayoutInflater layoutInflater;


    public MyAdapter(Context context){
        repo = RespositorioOficio.getInstance();
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);



    }


    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.simple_element_rcvw,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {

      //  Oficio oficio = RespositorioOficio.getInstance().getAll().get(position);
        Oficio oficio = repo.getOficio(position);

        holder.text1.setText(oficio.getName());
        holder.text2.setText(oficio.getAge()+"");

    }

    @Override
    public int getItemCount() {
        return repo.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text1;
        private TextView text2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            text1 = itemView.findViewById(R.id.textViewNombre);
            text2 = itemView.findViewById(R.id.textViewedad);

        }
    }
}
