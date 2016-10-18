package allinoneviewer.codekon.de.viewerallinone.Contoller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import allinoneviewer.codekon.de.viewerallinone.R;

public class CustomListViewAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private List<String> mList;

    public CustomListViewAdapter(Context context, List<String> objects) {

        super(context, R.layout.custom_listview_adapter, objects);

        this.mContext = context;
        this.mList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.custom_listview_adapter, parent, false);
        TextView row = (TextView) rowView.findViewById(R.id.listViewElement);

        row.setText(mList.get(position).toString());

        return rowView;
    }

    @Override
    public String getItem(int position) {
        return mList.get(position);
    }

}
