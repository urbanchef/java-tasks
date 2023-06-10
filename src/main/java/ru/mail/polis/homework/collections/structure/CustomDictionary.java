package ru.mail.polis.homework.collections.structure;

import java.util.*;

/**
 * Задание оценивается в 4 тугрика.
 * Необходимо реализовать класс которы умеет хранить строки и возвращать
 * список строк состоящий из того же набора буков, что ему передали строку.
 * Напишите какая сложность операций у вас получилась для каждого метода.
 */
public class CustomDictionary {

    private final Map<String, List<String>> stringsStorage = new HashMap<>();
    private int size;

    public CustomDictionary() {
        this.size = 0;
    }

    private String prepareString(String value) {
        return value.toLowerCase().trim().replaceAll("\\s+", "");
    }

    private String keyString(String value) {
        String preparedString = prepareString(value);
        char[] charString = preparedString.toCharArray();
        Arrays.sort(charString);

        return String.valueOf(charString);

    }

    /**
     * Сохранить строку в структуру данных
     *
     * @param value - передаваемая строка
     * @return - успешно сохранили строку или нет.
     * <p>
     * Сложность - [O(value.length())]
     */
    public boolean add(String value) {
        if (value == null || value.isEmpty() || value.isBlank()) {
            throw new IllegalArgumentException();
        }

        String preparedKeyString = keyString(value);
        List<String> stringValue = stringsStorage.getOrDefault(preparedKeyString, new ArrayList<>());

        boolean result = false;
        if (stringValue.contains(value)) {
            return result;
        }
        result = stringValue.add(value);
        stringsStorage.putIfAbsent(preparedKeyString, stringValue);
        size++;
        return result;
    }

    /**
     * Проверяем, хранится ли такая строка уже у нас
     *
     * @param value - передаваемая строка
     * @return - есть такая строка или нет в нашей структуре
     * <p>
     * Сложность - [O(value.length())]
     */
    public boolean contains(String value) {
        List<String> existingSimilarWords = stringsStorage.getOrDefault(keyString(value), new ArrayList<>());

        for (String existingSimilarWord : existingSimilarWords) {
            if (existingSimilarWord.equals(value)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Удаляем сохраненную строку если она есть
     *
     * @param value - какую строку мы хотим удалить
     * @return - true если удалили, false - если такой строки нет
     * <p>
     * Сложность - []
     */
    public boolean remove(String value) {
        boolean result = false;
        List<String> existingSimilarWords = stringsStorage.getOrDefault(keyString(value), new ArrayList<>());

        Iterator<String> iterator = existingSimilarWords.iterator();
        while (iterator.hasNext()) {
            String currentValue = iterator.next();
            if (value.equals(currentValue)) {
                iterator.remove();
                size--;
                result = true;
            }
        }

        return result;
    }

    /**
     * Возвращает список из сохраненных ранее строк, которые состоят
     * из того же набора букв что нам передали строку.
     * Примеры:
     * сохраняем строки ["aaa", "aBa", "baa", "aaB"]
     * При поиске по строке "AAb" нам должен вернуться следующий
     * список: ["aBa","baa","aaB"]
     * <p>
     * сохраняем строки ["aaa", "aAa", "a"]
     * поиск "aaaa"
     * результат: []
     * Как можно заметить - регистр строки не должен влиять на поиск, при этом
     * возвращаемые строки хранятся в том виде что нам передали изначально.
     *
     * @return - список слов которые состоят из тех же букв, что и передаваемая
     * строка.
     * <p>
     * Сложность - []
     */
    public List<String> getSimilarWords(String value) {
        return stringsStorage.getOrDefault(keyString(value), Collections.emptyList());
    }

    /**
     * Колл-во хранимых строк.
     *
     * @return - Колл-во хранимых строк.
     * <p>
     * Сложность - []
     */
    public int size() {
        return size;
    }


}
