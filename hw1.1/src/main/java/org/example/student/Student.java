package org.example.student;

public class Student implements Printable {
    private String name;
    private long id;
    private double score;

    //сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setScore(double score) {
        this.score = score;
    }

    //геттеры
    public String getName() {
        return this.name;
    }

    public long getId() {
        return this.id;
    }

    public double getScore() {
        return this.score;
    }

    @Override
    public void print() {
        System.out.println("Имя: " + this.name);
        System.out.println("Id: " + this.id);
        System.out.println("Средний балл: " + this.score);
    }

}
