package Adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

import Model.Booking;
import Model.ProductsSupplier;

public class ProductSupplierAdapter extends ArrayAdapter<ProductsSupplier> implements DataAdapter<ProductsSupplier> {
    private Context context;
    private List<ProductsSupplier> dataList;

    public ProductSupplierAdapter(Context context, List<ProductsSupplier> dataList) {
        super(context, 0, dataList);
        this.context = context;
        this.dataList = dataList;
    }
    @Override
    public void setData(List<ProductsSupplier> data) {
        clear();
        if (data != null) {
            addAll(data);
        }
        notifyDataSetChanged();
    }
}
