package com.example.sugardatabase;

import com.orm.SugarRecord;

public class User extends SugarRecord {
    private String surname; // Фамилия
    private String name; // Имя
    private String patronymic; // Отчество
    private String birthDate; // Дата рождения
    private String phoneNumber; // Номер телефона
    private String admissionDate; // Дата поступления
    private String graduationDate; // Дата окончания учебы
    private String faculty; // Факультет
    private String userGroup; // Группа
    private int course; // Курс
    private float averageScore; // Средний балл

    public User() {
        // Пустой конструктор необходим для Sugar ORM
    }

    // Конструктор с параметрами
    public User(String surname, String name, String patronymic, String birthDate, String phoneNumber,
                String admissionDate, String graduationDate, String faculty, String userGroup,
                int course, float averageScore) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.admissionDate = admissionDate;
        this.graduationDate = graduationDate;
        this.faculty = faculty;
        this.userGroup = userGroup;
        this.course = course;
        this.averageScore = averageScore;
    }

    // Геттеры и сеттеры
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPatronymic() { return patronymic; }
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getAdmissionDate() { return admissionDate; }
    public void setAdmissionDate(String admissionDate) { this.admissionDate = admissionDate; }

    public String getGraduationDate() { return graduationDate; }
    public void setGraduationDate(String graduationDate) { this.graduationDate = graduationDate; }

    public String getFaculty() { return faculty; }
    public void setFaculty(String faculty) { this.faculty = faculty; }

    public String getUserGroup() { return userGroup; }
    public void setUserGroup(String userGroup) { this.userGroup = userGroup; }

    public int getCourse() { return course; }
    public void setCourse(int course) { this.course = course; }

    public float getAverageScore() { return averageScore; }
    public void setAverageScore(float averageScore) { this.averageScore = averageScore; }
}