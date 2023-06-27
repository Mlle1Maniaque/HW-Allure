package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy",
                new Locale("ru")));
    }

    public static String generateCity() {
        String[] cities = new String[]{"Москва", "Казань", "Санкт-Петербург", "Саратов", "Петрозаводск", "Новосибирск", "Воронеж", "Тверь"};
        int itemIndex = (int) (Math.random() * cities.length);
        return cities[itemIndex];
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String randomName = (faker.name().lastName() + " " + faker.name().firstName() + " ");
        return randomName.replace('ё', 'е');
    }

    public static String generatePhone() {
        String[] phones = new String[]{"+79370266989", "+79370260000", "+79522659834", "+79256347896", "+79522478547", "+79085469874"};
        int itemIndex = (int) (Math.random() * phones.length);
        return phones[itemIndex];
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone());
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
