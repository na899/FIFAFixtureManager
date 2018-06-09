package e.pnaveena.fifafixturemanager;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyBaseAdapter extends BaseAdapter {

    ArrayList<ListData> myList ;
    LayoutInflater inflater;
    Context context;


    public MyBaseAdapter(Context context, ArrayList<ListData> myList) {
        this.myList = myList;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public ListData getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder mViewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row, parent, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        ListData currentListData = getItem(position);


        mViewHolder.text.setText(currentListData.getDescription());
        mViewHolder.Icon1.setImageURI(currentListData.getImg1());
        mViewHolder.Icon2.setImageURI(currentListData.getImg2());

        return convertView;
    }

    private class MyViewHolder {
        TextView text;
        ImageView Icon1,Icon2;

        public MyViewHolder(View item) {
           text = (TextView) item.findViewById(R.id.txt);
            Icon1 = (ImageView) item.findViewById(R.id.img1);
            Icon2 = (ImageView) item.findViewById(R.id.img2);
        }
    }
}