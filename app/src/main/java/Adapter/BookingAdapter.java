package Adapter;

import static android.text.method.TextKeyListener.clear;

import static java.util.Collections.addAll;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

import Model.Agency;
import Model.Booking;

public class BookingAdapter extends ArrayAdapter<Booking> implements DataAdapter<Booking> {
    private Context context;
    private List<Booking> dataList;

    public BookingAdapter(Context context, List<Booking> dataList) {
        super(context, 0, dataList);
        this.context = context;
        this.dataList = dataList;
    }
    @Override
    public void setData(List<Booking> data) {
        clear();
        if (data != null) {
            addAll(data);
        }
        notifyDataSetChanged();
    }
}