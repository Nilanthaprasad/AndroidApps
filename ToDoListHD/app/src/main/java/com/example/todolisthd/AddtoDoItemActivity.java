package com.example.todolisthd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddtoDoItemActivity extends AppCompatActivity {

    EditText etTitle, etDescription;
    Button btnSaveItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addto_do_item);
        etTitle = findViewById(R.id.etToDoTitle);
        etDescription = findViewById(R.id.etToDoDescription);
        btnSaveItem = findViewById(R.id.btnAddToDoItem);

        btnSaveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("title", etTitle.getText().toString());
                data.putExtra("description", etDescription.getText().toString());
                setResult(RESULT_OK, data);
                finish();
            }
        });
    }
}