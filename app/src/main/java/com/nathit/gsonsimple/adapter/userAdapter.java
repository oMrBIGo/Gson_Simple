package com.nathit.gsonsimple.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nathit.gsonsimple.R;
import com.nathit.gsonsimple.model.userModel;

import java.util.ArrayList;
import java.util.List;

public class userAdapter extends RecyclerView.Adapter<userAdapter.MyHolder> {

    private ArrayList<userModel> userModelArrayList;

    public userAdapter(ArrayList<userModel> userModelArrayList) {
        this.userModelArrayList = userModelArrayList;
    }

    @NonNull
    @Override
    public userAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull userAdapter.MyHolder holder, int position) {
        userModel userModel = userModelArrayList.get(position);

        holder.tvLine1.setText(userModel.getLine1());
        holder.tvLine2.setText(userModel.getLine2());
    }

    @Override
    public int getItemCount() {
        return userModelArrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        public TextView tvLine1;
        public TextView tvLine2;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            tvLine1 = itemView.findViewById(R.id.textview_line1);
            tvLine2 = itemView.findViewById(R.id.textview_line_2);
        }
    }
}
