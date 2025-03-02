package com.example;

/**
 * Класс Container - простой контейнер для хранения объектов.
 * Он поддерживает добавление, извлечение и удаление элементов.
 *
 * @param <T> тип элементов, хранящихся в контейнере
 */
public class Container<T> {
    private Object[] elements; // Массив для хранения элементов
    private int size; // Текущее количество элементов

    /**
     * Создание контейнера с начальной емкостью.
     *
     * @param initialCapacity Начальная емкость контейнера
     * @throws IllegalArgumentException если начальная емкость меньше или равна 0
     */
    public Container(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        this.elements = new Object[initialCapacity];
        this.size = 0;
    }

    /**
     * Создает контейнер с емкостью по умолчанию (10).
     */
    public Container() {
        this(10);
    }

    /**
     * Добавляет элемент в контейнер.
     *
     * @param element элемент для добавления
     */
    public void add(T element) {
        if (size == elements.length) {
            expandCapacity(); // Расширяем массив, если он заполнен
        }
        elements[size++] = element;
    }

    /**
     * Извлекает элемент из контейнера по индексу.
     *
     * @param index Индекс элемента
     * @return Элемент
     * @throws IndexOutOfBoundsException если индекс выходит за пределы
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    /**
     * Удаляет элемент из контейнера по индексу.
     *
     * @param index Индекс элемента
     * @return Удаленный элемент
     * @throws IndexOutOfBoundsException если индекс выходит за пределы
     */
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        checkIndex(index);
        T removedElement = (T) elements[index];
        // Сдвигаем элементы влево
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null; // Очищаем последний элемент
        return removedElement;
    }

    /**
     * Возвращает текущее количество элементов.
     *
     * @return Количество элементов
     */
    public int size() {
        return size;
    }

    /**
     * Проверяет, пуст ли контейнер.
     *
     * @return true, если контейнер пуст
     */
    public boolean isEmpty() {
        return size == 0;
    }

    // Проверка индекса
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // Расширение емкости массива
    private void expandCapacity() {
        int newCapacity = elements.length * 2; // Увеличиваем емкость в 2 раза
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    /**
     * Возвращает строковое представление контейнера.
     *
     * @return строковое представление
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}