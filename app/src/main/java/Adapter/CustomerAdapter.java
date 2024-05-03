package Adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;
import Model.Customer;

public class CustomerAdapter extends ArrayAdapter<Customer> implements DataAdapter<Customer> {
    private Context context;
    private List<Customer> dataList;

    public CustomerAdapter(Context context, List<Customer> dataList) {
        super(context, 0, dataList);
        this.context = context;
        this.dataList = dataList;
    }
    @Override
    public void setData(List<Customer> data) {
        clear();
        if (data != null) {
            addAll(data);
        }
        notifyDataSetChanged();
    }
}