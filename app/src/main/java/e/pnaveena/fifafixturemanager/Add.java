package e.pnaveena.fifafixturemanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.transition.Transition;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;


public class Add extends AppCompatActivity {
    EditText nameA;
    EditText nameB;
    EditText Date;
    EditText Time;
    EditText venue;
    Uri img1;
    Uri img2;
    Button take;
    Button choose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
         nameA=findViewById(R.id.teamA);
         nameB=findViewById(R.id.teamB);
         Date=findViewById(R.id.date);
         Time=findViewById(R.id.time);
         venue=findViewById(R.id.venue);

        MainActivity.status1.add(MainActivity.i,0);
        MainActivity.status2.add(MainActivity.i,0);



    }
    public void addFixture(View v){



      /*  SharedPreferences a=getSharedPreferences("Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=a.edit();
        editor.putString("teamA",nameA.getText().toString());
        editor.putString("teamB",nameB.getText().toString());

        editor.apply();*/
        MainActivity.team1.add(MainActivity.i,nameA.getText().toString());
        MainActivity.team2.add(MainActivity.i,nameB.getText().toString());
        MainActivity.date.add(MainActivity.i,Date.getText().toString());
        MainActivity.time.add(MainActivity.i,Time.getText().toString());
        MainActivity.venue.add(MainActivity.i,venue.getText().toString());



       String str=nameA.getText().toString()+" Vs. "+nameB.getText().toString()+" on "+Date.getText().toString()+", "+Time.getText().toString()+" at "+venue.getText().toString()+". ";
       MainActivity.text.add(str);
       //MainActivity.img.add(MainActivity.i,R.drawable.ic_launcher_foreground);
       if(MainActivity.status1.get(MainActivity.i)==1&&MainActivity.status2.get(MainActivity.i)==1){
           MainActivity.image1.add(MainActivity.i,img1);
           MainActivity.image2.add(MainActivity.i,img2);

           Intent intent=new Intent(this,MainActivity.class);
           startActivity(intent);
       }
       else Toast.makeText(this,"please set icon",Toast.LENGTH_SHORT).show();
        //Toast.makeText(this,MainActivity.text.get(MainActivity.text.size()-1),Toast.LENGTH_SHORT).show();

//MainActivity.img[MainActivity.img.length]=R.drawable.ic_launcher_foreground;
      // MainActivity.adapter.notifyDataSetChanged();



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

                    Uri selectedImage = imageReturnedIntent.getData();
                     img1=selectedImage;
                     MainActivity.status1.add(MainActivity.i,1);
                     take=findViewById(R.id.takePicA);
                     choose=findViewById(R.id.choosePicA);
                     take.setEnabled(false);
                     choose.setEnabled(false);
                   // image1.setImageURI(selectedImage);
                }

                break;
            case 1:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    img2=selectedImage;
                    MainActivity.status2.add(MainActivity.i,1);
                    take=findViewById(R.id.takePicB);
                    choose=findViewById(R.id.choosePicB);
                    take.setEnabled(false);
                    choose.setEnabled(false);
                }
                break;
        }
    }
}

