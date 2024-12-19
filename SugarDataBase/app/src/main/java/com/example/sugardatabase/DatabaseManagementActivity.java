package com.example.sugardatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DatabaseManagementActivity extends AppCompatActivity {

    private Button backupButton;
    private Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_management);

        backupButton = findViewById(R.id.backupButton);
        deleteButton = findViewById(R.id.deleteButton);

        backupButton.setOnClickListener(v -> backupDatabase());
        deleteButton.setOnClickListener(v -> showDeleteConfirmationDialog());
    }

    private void backupDatabase() {
        String dbName = "Sugar.db"; // Убедитесь, что это имя совпадает с вашим
        File dbFile = getDatabasePath(dbName);
        Log.d("Database Path", dbFile.getAbsolutePath());

        if (!dbFile.exists()) {
            Toast.makeText(this, "База данных не существует", Toast.LENGTH_SHORT).show();
            return;
        }

        String backupFileName = "backup_" + System.currentTimeMillis() + ".db";
        File backupFile = new File(getExternalFilesDir(null), backupFileName);

        try (FileInputStream fis = new FileInputStream(dbFile);
             FileOutputStream fos = new FileOutputStream(backupFile)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            fos.flush();
            Toast.makeText(this, "Резервное копирование завершено: " + backupFileName, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Ошибка резервного копирования: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void showDeleteConfirmationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Подтверждение удаления")
                .setMessage("Вы уверены, что хотите удалить базу данных?")
                .setPositiveButton("Да", (dialog, which) -> deleteDatabase())
                .setNegativeButton("Нет", null)
                .show();
    }

    private void deleteDatabase() {
        String dbName = "Sugar.db"; // Убедитесь, что это имя совпадает с вашим
        File dbFile = getDatabasePath(dbName);

        if (!dbFile.exists()) {
            Toast.makeText(this, "База данных не существует", Toast.LENGTH_SHORT).show();
            return;
        }

        if (dbFile.delete()) {
            Toast.makeText(this, "База данных удалена", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Не удалось удалить базу данных", Toast.LENGTH_SHORT).show();
        }
    }
}