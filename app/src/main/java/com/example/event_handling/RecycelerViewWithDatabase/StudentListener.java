package com.example.event_handling.RecycelerViewWithDatabase;

public interface StudentListener {


    void onDelete(int id, int index);
    void onEdit(int id, int index);
    void onItemClick(int index);


}
