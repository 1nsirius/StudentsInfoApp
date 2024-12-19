package com.example.sugardatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = userList.get(position);

        holder.userSurname.setText(user.getSurname());
        holder.userName.setText(user.getName());
        holder.userPatronymic.setText(user.getPatronymic());
        holder.userBirthDate.setText(user.getBirthDate());
        holder.userPhoneNumber.setText(user.getPhoneNumber());
        holder.userAdmissionDate.setText(user.getAdmissionDate());
        holder.userGraduationDate.setText(user.getGraduationDate());
        holder.userFaculty.setText(user.getFaculty());
        holder.userGroup.setText(user.getUserGroup());
        holder.userCourse.setText(String.valueOf(user.getCourse()));
        holder.userAverageScore.setText(String.valueOf(user.getAverageScore()));
    }

    @Override
    public int getItemCount() {
        return userList.size(); // Возвращаем количество пользователей в списке
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView userSurname;
        public TextView userName;
        public TextView userPatronymic;
        public TextView userBirthDate;
        public TextView userPhoneNumber;
        public TextView userAdmissionDate;
        public TextView userGraduationDate;
        public TextView userFaculty;
        public TextView userGroup;
        public TextView userCourse;
        public TextView userAverageScore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userSurname = itemView.findViewById(R.id.userSurname);
            userName = itemView.findViewById(R.id.userName);
            userPatronymic = itemView.findViewById(R.id.userPatronymic);
            userBirthDate = itemView.findViewById(R.id.userBirthDate);
            userPhoneNumber = itemView.findViewById(R.id.userPhoneNumber);
            userAdmissionDate = itemView.findViewById(R.id.userAdmissionDate);
            userGraduationDate = itemView.findViewById(R.id.userGraduationDate);
            userFaculty = itemView.findViewById(R.id.userFaculty);
            userGroup = itemView.findViewById(R.id.userGroup);
            userCourse = itemView.findViewById(R.id.userCourse);
            userAverageScore = itemView.findViewById(R.id.userAverageScore);
        }
    }
}