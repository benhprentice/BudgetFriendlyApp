package com.example.budgetfriendlyapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    String list[];

    public RecyclerAdapter(String[] list){
        this.list=list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.expense_cards,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        holder.textView.setText(list[position]);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            textView=itemView.findViewById(R.id.expenseCardNote);
        }
    }

//    private Context mContext;
//    private List<Data> myDataList;
//
//    public RecyclerAdapter(Context mContext, List<Data> myDataList) {
//        this.mContext = mContext;
//        this.myDataList = myDataList;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(mContext).inflate(R.layout.expense_cards, parent, false);
//        return new RecyclerAdapter.ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        final Data data = myDataList.get(position);
//        holder.note.setText(data.getNote());
//        holder.amount.setText("$" + data.getAmount());
//    }
//
//    @Override
//    public int getItemCount() {
//        return myDataList.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        public TextView amount, note;
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            note = itemView.findViewById(R.id.expenseCardNote);
//            amount = itemView.findViewById((R.id.expenseCardAmount));
//        }
//    }
}
