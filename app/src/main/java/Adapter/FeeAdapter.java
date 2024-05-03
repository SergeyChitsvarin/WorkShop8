package Adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

import Model.Fee;


public class FeeAdapter extends ArrayAdapter<Fee> implements DataAdapter<Fee> {
    private Context context;
    private List<Fee> dataList;

    public FeeAdapter(Context context, List<Fee> dataList) {
        super(context, 0, dataList);
        this.context = context;
        this.dataList = dataList;
    }
    @Override
    public void setData(List<Fee> data) {
        clear();
        if (data != null) {
            addAll(data);
        }
        notifyDataSetChanged();
    }
}
