package org.example.clock;

public class Clock implements Readable {
    private int hours;
    private int minutes;
    private int seconds;

    //setter
    public void setHours(int hour) {this.hours = hour;}
    public void setMinutes(int minute) {this.minutes = minute;}
    public void setSeconds(int second) {this.seconds = second;}

    //getter
    public int getHours() {return hours;}
    public int getMinutes() {return minutes;}
    public int getSeconds() {return seconds;}

    public void tick() {this.seconds += 1;}

    @Override
    public void readTime() {
        System.out.println(this.hours + ":" + this.minutes + ":" + this.seconds);
    }
}
