package e.pnaveena.fifafixturemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button Add;
    private Button update;
    ArrayList<String> listItems=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    private ListView list;
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.text);
        list =findViewById(R.id.list);
        update=findViewById(R.id.update);


        adapter=new ArrayAdapter<String >(this,android.R.layout.simple_spinner_item, listItems);
        list.setAdapter(adapter);

    }
 public void test(View v){
     listItems.add(text.getText().toString());
     // next thing you have to do is check if your adapter has changed
     adapter.notifyDataSetChanged();
 }

    public void addFixture(View v){
        Intent intent=new Intent(this,Add.class);
        startActivity(intent);

    }
}
