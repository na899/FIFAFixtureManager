package e.pnaveena.fifafixturemanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
     public static ArrayList<ListData>listItems=new ArrayList<ListData>();
     //public static ArrayAdapter<String> adapter;
     public static int i ;
     public static int pos=0;
     public static ArrayList<String>text=new ArrayList<String>();
    //public static int [] img={};
   // public static int[] img1={R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};
    //public static int[] img2={R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground};
    public  Context c=this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       list=findViewById(R.id.list);
       getDataInList();
       list.setAdapter(new MyBaseAdapter(c,listItems));
        Toast.makeText(this,listItems.size()+"",Toast.LENGTH_SHORT).show();




        }

    private void getDataInList() {
        for (int i = 0; i < text.size(); i++) {


                        ListData ld = new ListData();
            ld.setDescription(text.get(i));
            ld.setImgResId(R.drawable.ic_launcher_foreground);
                        listItems.add(ld);

        }
    }




    public void add(View v){

    Intent intent=new Intent(this,Add.class);
        startActivity(intent);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       // Toast.makeText(MainActivity.c,"Position"+position,Toast.LENGTH_SHORT).show();



    }
}










//Toast.makeText(this,""+text.size(),Toast.LENGTH_SHORT).show();

      /*  c=this;
        SharedPreferences a=getSharedPreferences("Data",MODE_PRIVATE);
        list=findViewById(R.id.list);
        adapter= new ArrayAdapter<String>(this,R.layout.row,R.id.txt,listItems);
        list.setAdapter(adapter);
*/
//list.setOnItemClickListener(this);