package e.pnaveena.fifafixturemanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.MediaStore;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        nameA=findViewById(R.id.teamA);
         nameB=findViewById(R.id.teamB);
         Date=findViewById(R.id.date);
        Time=findViewById(R.id.time);
         venue=findViewById(R.id.venue);





    }
    public void addFixture(View v){



      /*  SharedPreferences a=getSharedPreferences("Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=a.edit();
        editor.putString("teamA",nameA.getText().toString());
        editor.putString("teamB",nameB.getText().toString());

        editor.apply();*/



       String str=nameA.getText().toString()+" Vs. "+nameB.getText().toString()+" on "+Date.getText().toString()+", "+Time.getText().toString()+" at "+venue.getText().toString()+". ";
       MainActivity.text.add(str);

//MainActivity.img[MainActivity.img.length]=R.drawable.ic_launcher_foreground;
      // MainActivity.adapter.notifyDataSetChanged();


 Intent intent=new Intent(this,MainActivity.class);

     startActivity(intent);

    }

    public void take(View v){
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePicture, 0);//zero can be replaced with any action code
    }
    public void choose(View v){
        Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto , 1);//one can be replaced with any action code
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        ImageView imageview =null;
        switch(requestCode) {
            case 0:


                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    imageview.setImageURI(selectedImage);
                }

                break;
            case 1:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    imageview.setImageURI(selectedImage);
                }
                break;
        }
    }
}

