package org.example;

import org.example.book.Book;
import org.example.car.Car;
import org.example.clock.Clock;
import org.example.point.Point;
import org.example.student.Student;

public class Main {
    public static void main(String[] args) {
        // проверка класса Book
        Book book1 = new Book();
        book1.setName("Капитанская дочка");
        book1.setAuthor("А.С.Пушкин");
        book1.setYear(1836);
        book1.display();
        System.out.println();

        // проверка класса Student
        Student student1 = new Student();
        student1.setName("Andrew");
        student1.setId(123456789);
        student1.setScore(3.5);
        student1.print();
        System.out.println();

        // проверка класса Point
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
        System.out.println();

        // проверка класса Clock
        Clock clock1 = new Clock();
        clock1.setHours(0);
        clock1.setMinutes(0);
        clock1.setHours(0);
        clock1.tick();
        clock1.readTime();
        System.out.println();

        // проверка класса Car
        Car car1 = new Car();
        car1.setBrand("Toyota");
        car1.setModel("Camry");
        car1.setYear(2022);
        car1.start();
        car1.stop();
        car1.distance(1703);
        System.out.println();

    }
}
