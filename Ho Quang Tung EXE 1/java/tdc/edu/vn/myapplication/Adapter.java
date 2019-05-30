package tdc.edu.vn.myapplication;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{
    Context context;
    ArrayList<ThongTin> data;
    int layoutRS;

    public Adapter(Context context, ArrayList<ThongTin> data, int layoutRS) {
        this.context = context;
        this.data = data;
        this.layoutRS = layoutRS;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View row = inflater.inflate(layoutRS,viewGroup,false);

        return new MyViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder,final int i) {

        myViewHolder.txtSo1.setText(data.get(i).getTxtSo1());
        myViewHolder.txtSo2.setText(data.get(i).getTxtSo2());
        myViewHolder.txtPT.setText(data.get(i).getTxtPhepTinh());
        myViewHolder.txtKQ.setText(data.get(i).getTxtKQ());
        myViewHolder.img.setImageResource(data.get(i).getAnh());
        myViewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RemoveItem(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView txtSo1,txtSo2,txtPT,txtKQ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSo1 = itemView.findViewById(R.id.txtND1);
            txtSo2 = itemView.findViewById(R.id.txtND2);
            txtKQ = itemView.findViewById(R.id.txtKQ);
            txtPT = itemView.findViewById(R.id.txtTT);
            img = itemView.findViewById(R.id.img);

        }
    }
    public void RemoveItem(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }
}
