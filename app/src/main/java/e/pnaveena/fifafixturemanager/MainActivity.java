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


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static ListView list;
    public static ArrayList<ListData> listItems = new ArrayList<ListData>();

    public static int i;
    public static List<Integer>img=new ArrayList<>();
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);
        getDataInList();
        list.setAdapter(new MyBaseAdapter(c, listItems));

Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show();
        list.setOnItemClickListener(this);
    }

    private void getDataInList() {
      if(text.size()>=1){
          Intent intent=getIntent();



          //  Toast.makeText(c,""+text.size(),Toast.LENGTH_SHORT).show();

          listItems.add(i,new ListData(i));
         // Log.d("hey", "onCreate: "+listItems.get(i).getImgResId());
        i++;  }
    }






    public void add(View v){

    Intent intent=new Intent(this,Add.class);
        startActivity(intent);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       // Toast.makeText(c,"Position"+position,Toast.LENGTH_SHORT).show();

Intent intent=new Intent(this,UpdateDelete.class);
intent.putExtra("position",position);
startActivity(intent);



        //update code
        //text.set(position,"hello");
        //listItems.set(position,new ListData(position));


        //list.setAdapter(new MyBaseAdapter(c, listItems));

    }
}










//Toast.makeText(this,""+text.size(),Toast.LENGTH_SHORT).show();

      /*  c=this;
        SharedPreferences a=getSharedPreferences("Data",MODE_PRIVATE);
        list=findViewById(R.id.list);
        adapter= new ArrayAdapter<String>(this,R.layout.row,R.id.txt,listItems);
        list.setAdapter(adapter);
*/
