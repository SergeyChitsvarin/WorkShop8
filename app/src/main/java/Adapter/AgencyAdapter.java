package Adapter;

import static android.text.method.TextKeyListener.clear;

import static java.util.Collections.addAll;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

import Model.Agency;

public class AgencyAdapter extends ArrayAdapter<Agency> implements DataAdapter<Agency> {
    private Context context;
    private List<Agency> dataList;

    public AgencyAdapter(Context context, List<Agency> dataList) {
        super(context, 0, dataList);
        this.context = context;
        this.dataList = dataList;
    }
    @Override
    public void setData(List<Agency> data) {
        clear();
        if (data != null) {
            addAll(data);
        }
        notifyDataSetChanged();
    }
}
