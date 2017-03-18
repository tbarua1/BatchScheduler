package licttrainer.ttinnovations.batchscheduler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Abhishek.Sehgal on 14-03-2017.
 */

public class CustomeAdapter extends BaseAdapter {
    Context context;
   // int flags[];
    String[] countryNames;
    LayoutInflater inflter;

  /*  public CustomeAdapter(Context context, int[] flags, String[] countryNames) {
        this.context = context;
        this.flags = flags;
        this.countryNames = countryNames;
        this.inflter = (LayoutInflater.from(context));
    }

*/


    public CustomeAdapter(Context context, String[] temp) {
        this.context = context;
        //this.flags = flags;
        this.countryNames = temp;
        this.inflter = (LayoutInflater.from(context));
    }
    public int getCount() {
        return countryNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
convertView=inflter.inflate(R.layout.custom_spinner_layout,null);
        TextView names = (TextView)  convertView.findViewById(R.id.data);
        names.setText(countryNames[position]);

        return convertView;
    }

   /* @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflter.inflate(R.layout.custom_spinner_layout, null);
      //  ImageView icon = (ImageView)  convertView.findViewById(R.id.imageView);
        TextView names = (TextView)  convertView.findViewById(R.id.data);
       // icon.setImageResource(flags[i]);
        names.setText(countryNames[i]);
        return view;
    }*/
}
