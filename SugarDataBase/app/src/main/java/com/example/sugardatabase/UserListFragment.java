package com.example.sugardatabase;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.sugardatabase.User;
import com.example.sugardatabase.UserAdapter;

import java.util.List;

public class UserListFragment extends Fragment {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_list, container, false);
        recyclerView = view.findViewById(R.id.user_list_recycler_view);

        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            loadUserList();
        } else {
            Log.e("UserListFragment", "RecyclerView is null");
        }

        return view;
    }

    private void loadUserList() {
        List<User> userList = User.listAll(User.class);
        userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);
    }
}