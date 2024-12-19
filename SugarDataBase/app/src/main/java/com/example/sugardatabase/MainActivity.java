package com.example.sugardatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText surnameInput, nameInput, patronymicInput, birthDateInput, phoneInput,
            admissionDateInput, graduationDateInput, facultyInput, groupInput,
            courseInput, averageScoreInput, idInput;
    Button addButton, editButton, deleteButton, viewUsersButton, manageDatabaseButton, generateRandomDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация элементов UI
        surnameInput = findViewById(R.id.surnameInput);
        nameInput = findViewById(R.id.nameInput);
        patronymicInput = findViewById(R.id.patronymicInput);
        birthDateInput = findViewById(R.id.birthDateInput);
        phoneInput = findViewById(R.id.phoneInput);
        admissionDateInput = findViewById(R.id.admissionDateInput);
        graduationDateInput = findViewById(R.id.graduationDateInput);
        facultyInput = findViewById(R.id.facultyInput);
        groupInput = findViewById(R.id.groupInput);
        courseInput = findViewById(R.id.courseInput);
        averageScoreInput = findViewById(R.id.averageScoreInput);
        idInput = findViewById(R.id.idInput);
        addButton = findViewById(R.id.addButton);
        editButton = findViewById(R.id.editButton);
        deleteButton = findViewById(R.id.deleteButton);
        viewUsersButton = findViewById(R.id.viewUsersButton);
        manageDatabaseButton = findViewById(R.id.manageDatabaseButton);
        generateRandomDataButton = findViewById(R.id.generateRandomDataButton);

        // Установка обработчиков нажатий кнопок
        addButton.setOnClickListener(v -> addUser());
        editButton.setOnClickListener(v -> editUser());
        deleteButton.setOnClickListener(v -> deleteUser());
        viewUsersButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, UserDetailActivity.class);
            startActivity(intent);
        });
        manageDatabaseButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DatabaseManagementActivity.class);
            startActivity(intent);
        });
        generateRandomDataButton.setOnClickListener(v -> fillRandomData());



    // Загрузка фрагмента списка пользователей, если это первый запуск активности
        if (savedInstanceState == null) {
            loadUserListFragment();
        }
    }

    private void fillRandomData() {
        surnameInput.setText(RandomDataGenerator.getRandomSurname());
        nameInput.setText(RandomDataGenerator.getRandomName());
        patronymicInput.setText(RandomDataGenerator.getRandomPatronymic());
        birthDateInput.setText(RandomDataGenerator.getRandomBirthDate());
        phoneInput.setText(RandomDataGenerator.getRandomPhoneNumber());
        admissionDateInput.setText(RandomDataGenerator.getRandomBirthDate()); // Можете изменить на нужное
        graduationDateInput.setText(RandomDataGenerator.getRandomBirthDate()); // Можете изменить на нужное
        facultyInput.setText(RandomDataGenerator.getRandomFaculty());
        groupInput.setText("Гр. " + RandomDataGenerator.getRandomCourse()); // Пример группы
        courseInput.setText(String.valueOf(RandomDataGenerator.getRandomCourse()));
        averageScoreInput.setText(String.valueOf(RandomDataGenerator.getRandomAverageScore()));
    }

    private void loadUserListFragment() {
        UserListFragment userListFragment = new UserListFragment();
        // Загрузка фрагмента списка пользователей здесь
        // Используйте FragmentManager для замены фрагмента, если это необходимо
    }

    private void addUser() {
        String surname = surnameInput.getText().toString().trim();
        String name = nameInput.getText().toString().trim();
        String patronymic = patronymicInput.getText().toString().trim();
        String birthDate = birthDateInput.getText().toString().trim();
        String phone = phoneInput.getText().toString().trim();
        String admissionDate = admissionDateInput.getText().toString().trim();
        String graduationDate = graduationDateInput.getText().toString().trim();
        String faculty = facultyInput.getText().toString().trim();
        String group = groupInput.getText().toString().trim();
        String courseString = courseInput.getText().toString().trim();
        String averageScoreString = averageScoreInput.getText().toString().trim();


        if (surname.isEmpty() || name.isEmpty() || patronymic.isEmpty() ||
                birthDate.isEmpty() || phone.isEmpty() || admissionDate.isEmpty() ||
                graduationDate.isEmpty() || faculty.isEmpty() || group.isEmpty() ||
                courseString.isEmpty() || averageScoreString.isEmpty()) {
            Toast.makeText(this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
            return;
        }

        int course = Integer.parseInt(courseString);
        float averageScore = Float.parseFloat(averageScoreString);
        User user = new User(surname, name, patronymic, birthDate, phone, admissionDate,
                graduationDate, faculty, group, course, averageScore);
        user.save();
        Toast.makeText(this, "Пользователь добавлен", Toast.LENGTH_SHORT).show();

        // Обновление списка пользователей
        refreshUserList();
    }

    private void editUser() {
        String idString = idInput.getText().toString();
        if (idString.isEmpty()) {
            Toast.makeText(this, "Пожалуйста, введите ID пользователя", Toast.LENGTH_SHORT).show();
            return;
        }

        int id = Integer.parseInt(idString);
        User user = User.findById(User.class, id);
        if (user != null) {
            user.setSurname(surnameInput.getText().toString().trim());
            user.setName(nameInput.getText().toString().trim());
            user.setPatronymic(patronymicInput.getText().toString().trim());
            user.setBirthDate(birthDateInput.getText().toString().trim());
            user.setPhoneNumber(phoneInput.getText().toString().trim());
            user.setAdmissionDate(admissionDateInput.getText().toString().trim());
            user.setGraduationDate(graduationDateInput.getText().toString().trim());
            user.setFaculty(facultyInput.getText().toString().trim());
            user.setUserGroup(groupInput.getText().toString().trim());
            user.setCourse(Integer.parseInt(courseInput.getText().toString().trim()));
            user.setAverageScore(Float.parseFloat(averageScoreInput.getText().toString().trim()));
            user.save();
            Toast.makeText(this, "Пользователь обновлен", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Пользователь не найден", Toast.LENGTH_SHORT).show();
        }

        // Обновление списка пользователей
        refreshUserList();
    }

    private void deleteUser() {
        String idString = idInput.getText().toString();
        if (idString.isEmpty()) {
            Toast.makeText(this, "Пожалуйста, введите ID пользователя", Toast.LENGTH_SHORT).show();
            return;
        }

        int id = Integer.parseInt(idString);
        User user = User.findById(User.class, id);
        if (user != null) {
            user.delete();
            Toast.makeText(this, "Пользователь удален", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Пользователь не найден", Toast.LENGTH_SHORT).show();
        }

        // Обновление списка пользователей
        refreshUserList();
    }

    private void refreshUserList() {
        // Перезагрузка фрагмента списка пользователей для обновления отображаемых пользователей
        loadUserListFragment();
    }

    private void backupDatabase() {
        try {
            File dbFile = getDatabasePath("Sugar.db");
            File backupFile = new File(getExternalFilesDir(null), "backup.db");
            FileInputStream fis = new FileInputStream(dbFile);
            FileOutputStream fos = new FileOutputStream(backupFile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            fos.flush();
            fos.close();
            fis.close();
            Toast.makeText(this, "Резервное копирование завершено", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Ошибка резервного копирования", Toast.LENGTH_SHORT).show();
        }
    }
}