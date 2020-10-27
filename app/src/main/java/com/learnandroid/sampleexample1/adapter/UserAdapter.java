package com.learnandroid.sampleexample1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.learnandroid.sampleexample1.R;
import com.learnandroid.sampleexample1.model.userdata.UsersList;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private List<UsersList> usersLists;

    public UserAdapter(List<UsersList> usersLists){
        this.usersLists = usersLists;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.users_list_cell, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
           holder.tvUserName.setText(usersLists.get(position).getName());
        holder.tvUserMobile.setText(usersLists.get(position).getPhone());
        holder.tvUserEmail.setText(usersLists.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return usersLists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvUserName,tvUserMobile,tvUserEmail;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserName = itemView.findViewById(R.id.tvUserName);
            tvUserMobile = itemView.findViewById(R.id.tvUserMobile);
            tvUserEmail = itemView.findViewById(R.id.tvUserEmail);
        }
    }
}
