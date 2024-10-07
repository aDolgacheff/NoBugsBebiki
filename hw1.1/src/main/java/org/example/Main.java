package org.example;

import org.example.book.Book;
import org.example.point.Point;
import org.example.student.Student;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setName("Капитанская дочка");
        book1.setAuthor("А.С.Пушкин");
        book1.setYear(1836);
        book1.display();

        Student student1 = new Student();
        student1.setName("Andrew");
        student1.setId(123456789);
        student1.setScore(3.5);
        student1.print();

        Point point1 = new Point();
        point1.setX(0);
        point1.setY(0);
        System.out.print(point1.x);
        System.out.println(point1.y);
        point1.moveUp();
        point1.moveDown();
        point1.moveLeft();
        point1.moveRight();
        System.out.print(point1.x);
        System.out.println(point1.y);

    }
}
