import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Введи начальные данные");
        Scanner vvod = new Scanner(System.in);
        int pointsQuantity = vvod.nextInt();
        Point startFrog = new Point(vvod.nextInt(), vvod.nextInt());
        int l = vvod.nextInt();
        Frog frog = new Frog(startFrog,l);
        Point [] route= new Point[pointsQuantity]; //создан массив указателей на точки (вес указателя 4 байта)
        for (int i = 0; i < pointsQuantity; i++) {
            route[i] = new Point(vvod.nextInt(), vvod.nextInt());
        }
        int a=0;
        for (int i= 0; i <pointsQuantity ; i++) {

            if (Point.calcDist(route[i],startFrog)<= frog.tongueLenght){
                System.out.println("Лягушка съела Тему в точке "+i); break;
            }
            else a++;
        }
        if(a==pointsQuantity) System.out.println("YES");
    }

}
class Point {
    int x; int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public static double calcDist(Point p1, Point p2){
     return Math.sqrt(Math.pow((p1.x-p2.x),2)+Math.pow((p1.y-p2.y),2));
    }
}

class Frog {
    Point place; int tongueLenght;

    public Frog(Point place, int tongueLenght) {
        this.place = place;
        this.tongueLenght = tongueLenght;
    }
}