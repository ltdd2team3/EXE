package tdc.edu.vn.test;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Song_Adapter extends ArrayAdapter<Song> {
    Context context;
    int layoutResoureId;
    ArrayList<Song> data = null;

    public Song_Adapter(Context context, int layoutResoureId, ArrayList<Song> data) {
        super(context, layoutResoureId, data);
        this.context = context;
        this.layoutResoureId = layoutResoureId;
        this.data = data;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        SocialNetworkHolder holder = null;
        if(row == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResoureId, parent, false);
            holder = new SocialNetworkHolder();
            holder.tenBaiHat = (TextView) row.findViewById(R.id.tenbaihat);
            holder.tenCasi = (TextView) row.findViewById(R.id.tencasi);
            row.setTag(holder);
        }
        else
        {
            holder = (SocialNetworkHolder)row.getTag();
        }
        Song item = data.get(position);
        holder.tenBaiHat.setText(item.getTenBaiHat());
        holder.tenCasi.setText(item.getTenCaSi());
        return row;
    }
    static class SocialNetworkHolder{
        TextView tenBaiHat;
        TextView tenCasi;
    }
}
