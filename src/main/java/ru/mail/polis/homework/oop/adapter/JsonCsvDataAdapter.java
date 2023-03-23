package ru.mail.polis.homework.oop.adapter;

/**
 * После имплементации раскоментировать тест в ru.mail.polis.homework.oop.adapter.ProductPriceParsServiceTest
 * для проверки правильной имплементации
 */
public class JsonCsvDataAdapter extends CsvData {

    public JsonCsvDataAdapter(String text) {
        super(text);
    }

    public String convertJsonToCsv(String text) {
        String placeHolder = text.replace(':', ',').replace("\"", "");
        StringBuilder sb = new StringBuilder(placeHolder);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.toString().length() - 1);
        return sb.toString();
    }

    @Override
    public String getText() {
        return convertJsonToCsv(super.getText());
    }
}
