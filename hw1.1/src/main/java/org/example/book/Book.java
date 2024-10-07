package org.example.book;

public class Book implements Displayable {
    private String name;
    private String author;
    private int year;

    //сеттеры
    public void setName (String name) {
        this.name = name;
    }

    public void setAuthor (String author) {
        this.author = author;
    }

    public void setYear (int year) {
        this.year = year;
    }

    //геттеры
    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public int year() {
        return this.year;
    }

    @Override
    public void display() {
        System.out.println("Название: " + this.name);
        System.out.println("Автор: " + this.author);
        System.out.println("Год: " + this.year);
    }
}
