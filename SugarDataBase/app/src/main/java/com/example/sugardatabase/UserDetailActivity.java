package com.example.sugardatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UserDetailActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        recyclerView = findViewById(R.id.user_detail_recycler_view);
        Button backButton = findViewById(R.id.back_button);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadUserList();

        backButton.setOnClickListener(v -> finish());
    }

    private void loadUserList() {
        List<User> userList = User.listAll(User.class);
        userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);
    }
}