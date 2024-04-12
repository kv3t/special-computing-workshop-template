package ru.spbu.apcyb.svp.tasks.task2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Linkedlist implements List<Object> {

    private static class Node{
        Object value;
        Node next;
        Node prev;

        Node (Object value){
            this.value = value;
        }
    }

    private Node head;
    private int size;
    final String ErrorIndex = "Некорректно введен индекс";

    @Override
    public boolean add(Object value) { // добавления в конец
        Node new_node = new Node(value);
        if (this.head != null) {
            Node current_node = this.head;
            while (current_node.next != null) {
                current_node = current_node.next;
            }
            current_node.next = new_node;
            new_node.prev = current_node;
        }
        else {
            this.head = new_node;
        }
        this.size++;

        return true;
    }

    @Override
    public Object remove(int index) { // удаление по индексу
        Node current_node = this.head;
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(ErrorIndex);
        }
        if (index == 0) {
            this.head = this.head.next;
            this.head.prev = null;
        }
        else {
            for (int i = 0; i < index; i++) {
                current_node = current_node.next;
            }
            if (index != (this.size - 1)) {
                current_node.next.prev = current_node.prev;
            }
            current_node.prev.next = current_node.next;
        }
        this.size--;

        return current_node.value;
    }


    @Override
    public boolean contains(Object value) { // проверка наличия по значению
        for (Node current_node = head; current_node != null; current_node = current_node.next) {
            if (current_node.value == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() { // проверка списка на пустоту
        return this.size == 0;
    }

    @Override
    public Object get(int index) { // получение по индексу
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException(ErrorIndex);
        }

        Node current_node = this.head;
        for (int i = 0;  i < index && current_node.next != null ; i++) {
            current_node = current_node.next;
        }

        return current_node.value;
    }

    @Override
    public void add(int index, Object value) { // добавление по индексу
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException(ErrorIndex);
        }
        Node new_node = new Node(value);
        if (this.size == 0 || this.size == index) {
            add(value);
        }
        else {
            Node current_node = this.head;
            for (int i = 0; i < index; i++) {
                current_node = current_node.next;
            }
            new_node.prev = current_node.prev;
            new_node.next = current_node;
            current_node.prev = new_node;
            if (index != 0) {
                new_node.prev.next = new_node;
            }
            else {
                this.head = new_node;
            }
            this.size++;
        }
    }

    @Override
    public int size() { // размер списка
        return this.size;
    }

    @Override
    public Iterator<Object> iterator() {
        throw new UnsupportedOperationException("Для связного списка не переопределен метод iterator");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Для связного списка не переопределен метод toArray");
    }

    @Override
    public <T> T[] toArray(T[] arr) {
        throw new UnsupportedOperationException("Для связного списка не переопределен метод toArray(array)");
    }

    @Override
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Для связного списка не переопределен метод remove");
    }

    @Override
    public boolean containsAll(Collection<?> col) {
        throw new UnsupportedOperationException("Для связного списка не переопределен метод containsAll");
    }

    @Override
    public boolean addAll(Collection<?> col) {
        throw new UnsupportedOperationException("Для связного списка не переопределен метод addAll(collection)");
    }

    @Override
    public boolean addAll(int index, Collection<?> col) {
        throw new UnsupportedOperationException("Для связного списка не переопределен метод addAll(int, collection)");
    }

    @Override
    public boolean removeAll(Collection<?> col) {
        throw new UnsupportedOperationException("Для связного списка не переопределен метод removeAll");
    }

    @Override
    public boolean retainAll(Collection<?> col) {
        throw new UnsupportedOperationException("Для связного списка не переопределен метод retainAll");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Для связного списка не переопределен метод clear");

    }

    @Override
    public Object set(int index, Object element) {
        throw new UnsupportedOperationException("Для связного списка не переопределен метод set");
    }

    @Override
    public int indexOf(Object obj) {
        throw new UnsupportedOperationException("Для связного списка не переопределен метод indexOf");
    }

    @Override
    public int lastIndexOf(Object obj) {
        throw new UnsupportedOperationException("Для связного списка не переопределен метод lastIndexOf");
    }

    @Override
    public ListIterator<Object> listIterator() {
        throw new UnsupportedOperationException("Для связного списка не переопределен метод listIterator");
    }

    @Override
    public ListIterator<Object> listIterator(int index) {
        throw new UnsupportedOperationException("Для связного списка не переопределен метод listIterator(int)");
    }

    @Override
    public List<Object> subList(int fromindex, int toindex) {
        throw new UnsupportedOperationException("Для связного списка не переопределен метод subList");
    }

}