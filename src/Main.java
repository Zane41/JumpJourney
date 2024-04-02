import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        System.out.println("Введи начальные данные");
        Scanner vvod = new Scanner(System.in);
        int pointsQuantity = vvod.nextInt();
        Point startFrog = new Point(vvod.nextInt(), vvod.nextInt());
        int l = vvod.nextInt();
        Frog frog = new Frog(startFrog, l);
        Point[] route = new Point[pointsQuantity]; //создан массив указателей на точки (вес указателя 4 байта)
        for (int i = 0; i < pointsQuantity; i++) {
            route[i] = new Point(vvod.nextInt(), vvod.nextInt());
        }
        int a = 0;
        for (int i = 0; i < pointsQuantity; i++) {
            if (Point.calcDist(startFrog, route[i]) > frog.tongueLenght) {
                a++; if (a==pointsQuantity) System.out.println("Yes");
            }
            else {
                a++;
                System.out.println("Лягушка съела Тему в точке " + a);
                break;
            }
        }
    }
}
class Point {
    int x; int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public static double calcDist(Point p1, Point p2){
     return Math.sqrt(Math.pow((p2.x-p1.x),2)+Math.pow((p2.y-p1.y),2));
    }
}

class Frog {
    Point place; int tongueLenght;

    public Frog(Point place, int tongueLenght) {
        this.place = place;
        this.tongueLenght = tongueLenght;
    }

}
class testFunctions{
    public static Frog createFrog() {
        System.out.println("Введи координаты начальной точки лягухи и длину её языка");
        Scanner vvod = new Scanner(System.in);
        return  new Frog(new Point(vvod.nextInt(), vvod.nextInt()), vvod.nextInt());
    }
    public  static Point[] askRoute (){
        System.out.println("Введи количество точек в маршруте");
        Scanner vvod= new Scanner(System.in);
        int routeLenght = vvod.nextInt();
        System.out.println("Введи координаты этих точек");
        Point [] route = new Point[routeLenght];
        for (int i = 0; i < routeLenght; i++) {

            route[i]= new Point(vvod.nextInt(), vvod.nextInt());
        }
        return route;
    }
    public static void fullTest (){
         Point[] route = askRoute();int pointsQuantity= route.length; Frog frog=createFrog(); Point startFrog=frog.place;
        int a = 0;
        for (int i = 0; i < pointsQuantity; i++) {
            if (Point.calcDist(startFrog, route[i]) > frog.tongueLenght) {
                a++; if (a==pointsQuantity) System.out.println("Yes");
            }
            else {
                a++;
                System.out.println("Лягушка съела Тему в точке " + a);
                break;
            }
        }
    }
}