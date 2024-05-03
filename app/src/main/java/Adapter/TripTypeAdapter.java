package Adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

import Model.Booking;
import Model.TripType;

public class TripTypeAdapter extends ArrayAdapter<TripType> implements DataAdapter<TripType> {
    private Context context;
    private List<TripType> dataList;

    public TripTypeAdapter(Context context, List<TripType> dataList) {
        super(context, 0, dataList);
        this.context = context;
        this.dataList = dataList;
    }
    @Override
    public void setData(List<TripType> data) {
        clear();
        if (data != null) {
            addAll(data);
        }
        notifyDataSetChanged();
    }
}
