package e.pnaveena.fifafixturemanager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class CustomAdapter extends ArrayAdapter<String> {


    public CustomAdapter( Context context, String a[]) {
        super(context,R.layout.row ,a);

    }



}
