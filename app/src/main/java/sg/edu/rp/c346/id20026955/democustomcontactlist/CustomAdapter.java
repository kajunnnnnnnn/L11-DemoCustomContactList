package sg.edu.rp.c346.id20026955.democustomcontactlist;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Contact> contactList;



    public CustomAdapter(Context context, int resource, ArrayList<Contact> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        contactList = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) parent_context.
        getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvName = rowView.findViewById(R.id.tvName);
        TextView tvCode = rowView.findViewById(R.id.tvCountryCode);
        TextView tvNum = rowView.findViewById(R.id.tvPhoneNum);
        ImageView iv = rowView.findViewById(R.id.imageView);

        Contact currentItem = contactList.get(position);
        tvName.setText(currentItem.getName());
        tvCode.setText("+" + currentItem.getCountryCode());
        tvNum.setText(currentItem.getPhoneNum() + "");
//        if (currentItem.getGender() == ('F')) {
//            iv.setImageResource(R.drawable.female);
//        }else{
//            iv.setImageResource(R.drawable.male);
//        }
        String imageUrl = "https://i.imgur.com/tGbaZCY.jpg";
        Picasso.with(parent_context).load(imageUrl).into(iv);

        return rowView;
    }

}
