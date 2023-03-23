package ru.mail.polis.homework.collections.structure;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Objects;
import java.util.Stack;

/**
 * Задание оценивается в 2 балла.
 * Надо расширить стандартный класс Stack методом getMaxValue().
 * Этот метод должен возвращать какое максимальное значение сейчас
 * храниться в Stack. Отрабатывать метод должен за О(1).
 */
public class MaxStack extends Stack<Integer> {
    private ArrayList<Integer> maxValues = new ArrayList<>();
    private Integer currentMaxValue = 0;

    public MaxStack() {
        super();
    }

    public Integer getMaxValue() {
        if (super.isEmpty()) {
            throw new EmptyStackException();
        }
        return currentMaxValue;
    }

    @Override
    public Integer push(Integer item) {
        if (item >= currentMaxValue) {
            currentMaxValue = item;
            maxValues.add(currentMaxValue);
        }
        return super.push(item);
    }

    @Override
    public Integer pop() {
        int currentValue = super.pop();
        if (Objects.equals(currentValue, currentMaxValue)) {
            maxValues.remove(maxValues.size() - 1);
            if (!maxValues.isEmpty()) {
                currentMaxValue = maxValues.get(maxValues.size() - 1);
            }
        }
        return currentValue;
    }
}
