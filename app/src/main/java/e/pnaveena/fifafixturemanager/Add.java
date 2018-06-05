package e.pnaveena.fifafixturemanager;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

public class Add extends AppCompatActivity {


public void take(View v){
    Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    startActivityForResult(takePicture, 0);//zero can be replaced with any action code
}
public void choose(View v){
    Intent pickPhoto = new Intent(Intent.ACTION_PICK,
            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    startActivityForResult(pickPhoto , 1);//one can be replaced with any action code
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        ImageView imageview = null;
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
