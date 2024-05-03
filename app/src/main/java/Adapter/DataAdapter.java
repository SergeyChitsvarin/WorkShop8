package Adapter;

import java.util.List;

public interface DataAdapter<T> {
    void setData(List<T> data);
}