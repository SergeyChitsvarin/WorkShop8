package Adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

import Model.Booking;
import Model.Classes;

public class ClassesAdapter extends ArrayAdapter<Classes> implements DataAdapter<Classes> {
    private Context context;
    private List<Classes> dataList;

    public ClassesAdapter(Context context, List<Classes> dataList) {
        super(context, 0, dataList);
        this.context = context;
        this.dataList = dataList;
    }
    @Override
    public void setData(List<Classes> data) {
        clear();
        if (data != null) {
            addAll(data);
        }
        notifyDataSetChanged();
    }
}