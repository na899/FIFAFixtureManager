package e.pnaveena.fifafixturemanager;

public class ListData {

    String Description;

    int imgResId;
    ListData(){
        this.Description=MainActivity.text.get(MainActivity.i);
        this.imgResId=R.drawable.ic_launcher_background;
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




    public int getImgResId() {
        return imgResId;
    }

    public void setImgResId(int imgResId) {
        this.imgResId = imgResId;
    }

}
