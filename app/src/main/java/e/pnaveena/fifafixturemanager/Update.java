package e.pnaveena.fifafixturemanager;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Update extends AppCompatActivity {
    Uri img1;
    Uri img2;
    Button take;
    Button choose;
    EditText nameA;
    EditText nameB;
    EditText Date;
    EditText Time;
    EditText venue;
int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Intent a=getIntent();
        pos=a.getIntExtra("pos",11);
        nameA=findViewById(R.id.TeamA);
        nameB=findViewById(R.id.TeamB);
        Date=findViewById(R.id.Date);
        Time=findViewById(R.id.Time);
        venue=findViewById(R.id.Venue);
        nameA.setText(MainActivity.team1.get(pos));
        nameB.setText(MainActivity.team2.get(pos));
        Date.setText(MainActivity.date.get(pos));
        Time.setText(MainActivity.time.get(pos));
        venue.setText(MainActivity.venue.get(pos));



    }


   public void update(View v){
       Log.d("hey", "update: okay");
       MainActivity.team1.set(pos,nameA.getText().toString());
       MainActivity.team2.set(pos,nameB.getText().toString());
       MainActivity.date.set(pos,Date.getText().toString());
       MainActivity.time.set(pos,Time.getText().toString());
       MainActivity.venue.set(pos,venue.getText().toString());
       if(MainActivity.status1.get(pos)==2){
           MainActivity.image1.set(pos,img1);
           MainActivity.status1.set(pos,1);
       }
       if(MainActivity.status2.get(pos)==2){
           MainActivity.image2.set(pos,img2);
           MainActivity.status2.set(pos,1);
       }




       String str=nameA.getText().toString()+" Vs. "+nameB.getText().toString()+" on "+Date.getText().toString()+", "+Time.getText().toString()+" at "+venue.getText().toString()+". ";
       MainActivity.text.set(pos,str);
       MainActivity.listItems.set(pos,new ListData(pos));
       //Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show();
      // MainActivity.list.setAdapter(new MyBaseAdapter(MainActivity.getMain(), MainActivity.listItems));
       Intent intent=new Intent(this,MainActivity.class);
      startActivity(intent);

   }
  



    public void takeA(View v){
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePicture, 0);//zero can be replaced with any action code
    }
    public void chooseA(View v){
        Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto , 0);//one can be replaced with any action code
    }
    public void takeB(View v){
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePicture, 1);//zero can be replaced with any action code
    }
    public void chooseB(View v){
        Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto , 1);//one can be replaced with any action code
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        ImageView image1=findViewById(R.id.img1);
        ImageView image2=findViewById(R.id.img2);
        switch(requestCode) {
            case 0:


                if(resultCode == RESULT_OK){


                    img1 = imageReturnedIntent.getData();
                    MainActivity.status1.set(pos,2);
                    take=findViewById(R.id.takePicA);
                    choose=findViewById(R.id.choosePicA);
                   // take.setEnabled(false);
                    //choose.setEnabled(false);

                }

                break;
            case 1:
                if(resultCode == RESULT_OK){
                    img2 = imageReturnedIntent.getData();
                    MainActivity.status2.set(pos,2);
                    take=findViewById(R.id.takePicB);
                    choose=findViewById(R.id.choosePicB);
                   // take.setEnabled(false);
                    //choose.setEnabled(false);
                }
                break;
        }
    }
}

