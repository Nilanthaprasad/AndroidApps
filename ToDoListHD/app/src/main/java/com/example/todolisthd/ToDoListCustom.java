package com.example.todolisthd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.todolisthd.databinding.ActivityToDoListBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ToDoListCustom extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {
    //ArrayList<String> mItems;
    RecyclerView recyclerView;
    ArrayList<String> animalNames;
    //RecyclerView.Adapter mAdapter;
    //LinearLayoutManager mRecentLayoutManager;
    //int ITEMS_COUNT = 5;
    private ActivityToDoListBinding binding;
    MyRecyclerViewAdapter adapter;
    int reqCodeAddToDoItem = 1;
    FloatingActionButton fabaddToDoItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityToDoListBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_to_do_list_custom);
        fabaddToDoItem = findViewById(R.id.floatingActionButton);

        //-------------
        animalNames = new ArrayList<>();
        animalNames.add("Task 1");
        animalNames.add("Task 2");
        animalNames.add("Task 3");
        animalNames.add("Task 4");
        animalNames.add("Task 5");

        // set up the RecyclerView
        recyclerView = findViewById(R.id.rvToDoList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, animalNames);
        adapter.setClickListener(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);
        //-------------

        fabaddToDoItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AddtoDoItemActivity.class);
                startActivityForResult(i,reqCodeAddToDoItem);
            }
        });
    }

    /*
    private void initData() {
        mItems = new ArrayList<String>();
        for (int i = 0; i < ITEMS_COUNT; i++) {
            mItems.add("Item " + (i + 1));
        }
    }

    private void initRecyclerView() {
        mRecentRecyclerView = (RecyclerView) findViewById(R.id.rvToDoList);
        mRecentRecyclerView.setHasFixedSize(true);
        mRecentLayoutManager = new LinearLayoutManager(this);
        mRecentRecyclerView.setLayoutManager(mRecentLayoutManager);


        mAdapter = new RecyclerView.Adapter<CustomViewHolder>() {
            @Override
            public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.notice_snippet
                        , viewGroup, false);
                return new CustomViewHolder(view);
            }

            @Override
            public void onBindViewHolder(CustomViewHolder viewHolder, int i) {
                viewHolder.noticeSubject.setText(mItems.get(i));
            }

            @Override
            public int getItemCount() {
                return mItems.size();
            }

        };

        mRecentRecyclerView.setAdapter(mAdapter);

    }

    private class CustomViewHolder extends RecyclerView.ViewHolder {

        private TextView noticeSubject;

        public CustomViewHolder(View itemView) {
            super(itemView);
            noticeSubject = (TextView) itemView.findViewById(R.id.notice_subject);
        }
    }
*/
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == reqCodeAddToDoItem) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this,data.getStringExtra("title").toString(), Toast.LENGTH_SHORT).show();
                String item = data.getStringExtra("title");
                animalNames.add(item);
                adapter.notifyItemInserted(animalNames.size()-1);
            }
        }
    }
    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}