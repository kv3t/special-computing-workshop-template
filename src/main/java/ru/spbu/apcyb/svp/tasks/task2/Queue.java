package ru.spbu.apcyb.svp.tasks.task2;

import java.util.Collection;
import java.util.Iterator;

public class Queue implements java.util.Queue<Object> {

    private final Linkedlist lqueue;

    public Queue() {
        this.lqueue = new Linkedlist();
    }

    @Override
    public int size() { // размер очереди
        return this.lqueue.size();
    }

    @Override
    public boolean add(Object obj) { // постановка в очередь
        return this.lqueue.add(obj);
    }

    @Override
    public Object peek() { // получение первого в очереди
        Object result = null;
        if (!this.isEmpty()) {
            result = this.lqueue.get(0);
        }
        return result;
    }

    @Override
    public boolean isEmpty() { // проверка на пустоту
        return this.lqueue.isEmpty();
    }

    @Override
    public boolean contains(Object obj) {
        throw new UnsupportedOperationException("Для очереди не переопределен метод contains");
    }

    @Override
    public Iterator<Object> iterator() {
        throw new UnsupportedOperationException("Для очереди не переопределен метод iterator");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Для очереди не переопределен метод toArray");
    }

    @Override
    public <T> T[] toArray(T[] arr) {
        throw new UnsupportedOperationException("Для очереди не переопределен метод toArray(array)");
    }

    @Override
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Для очереди не переопределен метод remove");
    }

    @Override
    public boolean containsAll(Collection<?> col) {
        throw new UnsupportedOperationException("Для очереди не переопределен метод containsAll");
    }

    @Override
    public boolean addAll(Collection<?> col) {
        throw new UnsupportedOperationException("Для очереди не переопределен метод addAll");
    }

    @Override
    public boolean removeAll(Collection<?> col) {
        throw new UnsupportedOperationException("Для очереди не переопределен метод removeAll");
    }

    @Override
    public boolean retainAll(Collection<?> col) {
        throw new UnsupportedOperationException("Для очереди не переопределен метод retainAll");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Для очереди не переопределен метод clear");
    }

    @Override
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Для очереди не переопределен метод offer");
    }

    @Override
    public Object remove() {
        throw new UnsupportedOperationException("Для очереди не переопределен метод remove");
    }

    @Override
    public Object poll() {
        throw new UnsupportedOperationException("Для очереди не переопределен метод poll");
    }

    @Override
    public Object element() {
        throw new UnsupportedOperationException("Для очереди не переопределен метод element");
    }

}