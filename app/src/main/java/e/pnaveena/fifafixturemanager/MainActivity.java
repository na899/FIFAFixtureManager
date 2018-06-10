package e.pnaveena.fifafixturemanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener  {

    public static ListView list;
    public static ArrayList<ListData> listItems = new ArrayList<ListData>();

    public static int i;
    public static ArrayList<String> text = new ArrayList<String>();
    public static ArrayList<String> team1=new ArrayList<String>();
    public static ArrayList<String> team2=new ArrayList<String>();
    public static ArrayList<String> date = new ArrayList<String>();
    public static ArrayList<String> time=new ArrayList<String>();
    public static ArrayList<String> venue=new ArrayList<String>();


    public Context c = this;
    public static ArrayList<Integer>status1=new ArrayList<>();
    public static ArrayList<Integer>status2=new ArrayList<>();

    public static ArrayList<Uri> image1=new ArrayList<>();
    public static ArrayList<Uri> image2=new ArrayList<>();
   public static ListAdapter adapter;
     public static int press;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);
        if(press==1)
        getDataInList();

          // else if(press==2)
          //
        adapter=new MyBaseAdapter(c, listItems);
        list.setAdapter(adapter);

        Log.d("hey", "onCreate: "+press);


        /*if(press==1||press==2)
            adapter.notify();*/


        list.setOnItemClickListener(this);
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int pos, long id) {




                MainActivity.listItems.remove(pos);
                MainActivity.team1.remove(pos);
                MainActivity.team2.remove(pos);
                MainActivity.date.remove(pos);
                MainActivity.time.remove(pos);
                MainActivity.venue.remove(pos);
                MainActivity.image1.remove(pos);
                MainActivity.status1.remove(pos);
                MainActivity.image2.remove(pos);
                MainActivity.status2.remove(pos);






                MainActivity.text.remove(pos);
                ((BaseAdapter)adapter).notifyDataSetChanged();
                i--;

                return true;
            }
        });
    }

    private void getDataInList() {
      if(text.size()>=1){
         // Intent intent=getIntent();





          listItems.add(i,new ListData(i));

        i++;  }
    }






    public void add(View v){
        press=1;

    Intent intent=new Intent(this,Add.class);
        startActivity(intent);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
        press=2;
        // Toast.makeText(c,"Position"+position,Toast.LENGTH_SHORT).show();

Intent intent=new Intent(this,Update.class);
intent.putExtra("pos",pos);
startActivity(intent);


        //error with delete
    }



}










//Toast.makeText(this,""+text.size(),Toast.LENGTH_SHORT).show();

      /*  c=this;
        SharedPreferences a=getSharedPreferences("Data",MODE_PRIVATE);
        list=findViewById(R.id.list);
        adapter= new ArrayAdapter<String>(this,R.layout.row,R.id.txt,listItems);
        list.setAdapter(adapter);
*/
