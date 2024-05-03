package Adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

import Model.Region;

public class RegionAdapter extends ArrayAdapter<Region> implements DataAdapter<Region> {
    private Context context;
    private List<Region> dataList;

    public RegionAdapter(Context context, List<Region> dataList) {
        super(context, 0, dataList);
        this.context = context;
        this.dataList = dataList;
    }
    @Override
    public void setData(List<Region> data) {
        clear();
        if (data != null) {
            addAll(data);
        }
        notifyDataSetChanged();
    }
}
