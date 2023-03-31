package ru.mail.polis.homework.objects;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Вам придется реализовать Iterable класс CustomArrayWrapper вместе с методами которые
 * могут возващать итераторы только по четным/нечетным позициям в массиве. Пример с классического
 * итератора можете взять из лекции. Обратите внимание что подсчет четного или нечетного элемента
 * идет с человеческой точки зрения.
 * Пример:
 * дан массив [100, 0 ,100, 0, 100]
 * тогда все элементы со значением 100 имеют нечетную позицию, а элементы = 0 - четную.
 */
public class CustomArrayWrapper implements Iterable<Integer> {

    private final int[] array;          // массив
    private int position;               // следующая позиция куда будет вставлен элемент

    public CustomArrayWrapper(int size) {
        this.array = new int[size];
    }

    public void add(int value) {
        checkIndex(position);
        array[position] = value;
        position++;
    }

    public void edit(int index, int value) {
        checkIndex(index);
        array[index] = value;
    }

    public int get(int index) {
        checkIndex(index);
        return array[index];
    }

    public int size() {
        return array.length;
    }

    /**
     * Реализовать метод:
     * Возврящает обычный итератор.
     *
     * @return default Iterator
     */
    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<>() {

            private int currentIndex;

            @Override
            public boolean hasNext() {
                return currentIndex < array.length;
            }

            @Override
            public Integer next() {
                return array[currentIndex++];
            }
        };
    }

    /**
     * Реализовать метод:
     * Возвращает итератор который проходит только четные элементы.
     *
     * @return Iterator for EVEN elements
     */
    public Iterator<Integer> evenIterator() {
        return new Iterator<>() {

            private int currentEvenIndex = 0;
            private final int finalPosition = position;

            @Override
            public boolean hasNext() {
                return currentEvenIndex + 2 <= array.length;
            }

            @Override
            public Integer next() {
                if (currentEvenIndex % 2 == 0) {
                    currentEvenIndex++;
                }
                if (position != finalPosition) {
                    throw new ConcurrentModificationException();
                }
                return array[currentEvenIndex++];
            }
        };
    }

    /**
     * Реализовать метод:
     * Возвращает итератор который проходит нечетные элементы
     *
     * @return Iterator for ODD elements
     */
    public Iterator<Integer> oddIterator() {
        return new Iterator<>() {

            private int currentIndex = 0;
            private final int finalPosition = position;

            @Override
            public boolean hasNext() {
                if (currentIndex == 0) {
                    return currentIndex < array.length;
                }
                return currentIndex + 2 <= array.length;
            }

            @Override
            public Integer next() {
                if (position != finalPosition) {
                    throw new ConcurrentModificationException();
                }
                if (currentIndex % 2 != 0) {
                    currentIndex++;
                }
                return array[currentIndex++];
            }
        };
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException();
        }
    }

}
