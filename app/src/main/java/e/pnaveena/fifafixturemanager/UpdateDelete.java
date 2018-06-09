package e.pnaveena.fifafixturemanager;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class UpdateDelete extends AppCompatActivity {
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
        setContentView(R.layout.activity_update_delete);
        Intent a=new Intent();
        pos=a.getIntExtra("position",0);
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

       MainActivity.team1.set(MainActivity.i,nameA.getText().toString());
       MainActivity.team2.set(MainActivity.i,nameB.getText().toString());
       MainActivity.date.set(MainActivity.i,Date.getText().toString());
       MainActivity.time.set(MainActivity.i,Time.getText().toString());
       MainActivity.venue.set(MainActivity.i,venue.getText().toString());



       String str=nameA.getText().toString()+" Vs. "+nameB.getText().toString()+" on "+Date.getText().toString()+", "+Time.getText().toString()+" at "+venue.getText().toString()+". ";
       MainActivity.text.add(str);
       //Intent intent=new Intent(this,MainActivity.class);
       //startActivity(intent);

   }
   public void delete(View v){

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
                   // take.setEnabled(false);
                    //choose.setEnabled(false);
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
                   // take.setEnabled(false);
                    //choose.setEnabled(false);
                }
                break;
        }
    }
}

