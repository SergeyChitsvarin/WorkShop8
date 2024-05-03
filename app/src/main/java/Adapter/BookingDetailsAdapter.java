package Adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

import Adapter.DataAdapter;
import Model.Booking;
import Model.BookingDetails;

public class BookingDetailsAdapter extends ArrayAdapter<BookingDetails> implements DataAdapter<BookingDetails> {
    private Context context;
    private List<BookingDetails> dataList;

    public BookingDetailsAdapter(Context context, List<BookingDetails> dataList) {
        super(context, 0, dataList);
        this.context = context;
        this.dataList = dataList;
    }
    @Override
    public void setData(List<BookingDetails> data) {
        clear();
        if (data != null) {
            addAll(data);
        }
        notifyDataSetChanged();
    }
}
