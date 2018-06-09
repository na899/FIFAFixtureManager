package e.pnaveena.fifafixturemanager;

import android.net.Uri;
import android.util.Log;
import android.util.MutableShort;

public class ListData {

    String Description;

    Uri img1;
    Uri img2;
    ListData(int pos){
        this.Description=MainActivity.text.get(pos);
       // Log.d("hey", "ListData:?? ");
        if(MainActivity.status1.get(pos)==1)
            this.img1= MainActivity.image1.get(pos);
        if(MainActivity.status2.get(pos)==1)
            this.img2= MainActivity.image2.get(pos);
        //this.imgResId=R.drawable.ic_launcher_foreground;
      //  Log.d("hey","UHOH");
    }
   /* ListData(String a,int b){
        this.Description=a;
        this.imgResId=b;
    }*/

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }




    public Uri getImg1() {
        return img1;
    }

    public void setImg1(Uri img) {
        this.img1 = img;
    }
    public Uri getImg2() {
        return img2;
    }

    public void setImg2(Uri img) {
        this.img2 = img;
    }

}
