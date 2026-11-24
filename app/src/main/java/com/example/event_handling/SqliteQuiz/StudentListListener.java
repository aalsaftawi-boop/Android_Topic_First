package com.example.event_handling.SqliteQuiz;

public interface StudentListListener {
     void onDelete(int id);
     void onEdit(int id);
     void onItemClick(int id);
}
