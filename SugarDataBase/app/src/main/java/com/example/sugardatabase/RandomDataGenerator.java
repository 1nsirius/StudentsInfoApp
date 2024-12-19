package com.example.sugardatabase;

import java.util.Random;

public class RandomDataGenerator {

    private static final String[] surnames = {
            "Иванов", "Петров", "Сидоров", "Кузнецов", "Семёнов", "Винокуров", "Ильин", "Евсеев", "Маркин", "Баранов", "Котов", "Егоров", "Павлов", "Дмитриев", "Александров", "Кузьмин", "Юдин", "Филиппов"
    };

    private static final String[] names = {
            "Иван", "Пётр", "Сидор", "Алексей", "Дмитрий", "Константин", "Никита", "Тимофей", "Марк", "Михаил", "Вячеслав", "Захар", "Герман", "Артём", "Егор", "Арсений"
    };

    private static final String[] patronymics = {
            "Иванович", "Петрович", "Сидорович", "Алексеевич", "Дмитриевич", "Русланович", "Сергеевич", "Денисович", "Владиславович", "Всеволодович", "Матвеевич"
    };

    private static final String[] faculties = {
            "ФЭИС", "СФ", "ФИСЭ", "ЭФ"
    };

    private static final Random random = new Random();

    public static String getRandomSurname() {
        return surnames[random.nextInt(surnames.length)];
    }

    public static String getRandomName() {
        return names[random.nextInt(names.length)];
    }

    public static String getRandomPatronymic() {
        return patronymics[random.nextInt(patronymics.length)];
    }

    public static String getRandomBirthDate() {
        // Генерация случайной даты (например, от 1990 до 2005)
        int year = random.nextInt(16) + 1990; // 1990-2005
        int month = random.nextInt(12) + 1; // 1-12
        int day = random.nextInt(28) + 1; // 1-28 для простоты
        return String.format("%02d.%02d.%d", day, month, year);
    }

    public static String getRandomPhoneNumber() {
        // Генерация случайного номера телефона в формате +375 (XX) XXX-XX-XX
        String[] codes = {"33", "29"};
        String selectedCode = codes[random.nextInt(codes.length)]; // Выбор случайного кода

        int part1 = random.nextInt(900) + 100; // Первая часть номера (100-999)
        int part2 = random.nextInt(90) + 10;   // Вторая часть номера (10-99)
        int part3 = random.nextInt(90) + 10;   // Вторая часть номера (10-99)

        return String.format("+375 (%s) %d-%d-%d",
                selectedCode, part1, part2, part3);
    }

    public static String getRandomFaculty() {
        return faculties[random.nextInt(faculties.length)];
    }

    public static int getRandomCourse() {
        return random.nextInt(5) + 1; // Курсы от 1 до 5
    }

    public static float getRandomAverageScore() {
        return (float) (random.nextInt(41) + 60) / 10; // Средний балл от 6.0 до 10.0
    }
}