package algoexpert.graphs;

import java.util.*;

public class RectangleMania {

    public static void main(String[] args) {

        Point p1 = new Point(0,0);
        Point p2 = new Point(0,1);
        Point p3 = new Point(1,1);
        Point p4 = new Point(1,0);
        Point p5 = new Point(2,1);
        Point p6 = new Point(2,0);
        Point p7 = new Point(3,1);
        Point p8 = new Point(3,0);

        Point[] coords = new Point[]{p1,p2,p3,p4,p5,p6,p7,p8};

        System.out.println(rectangleMania(coords));

    }

    public static int rectangleMania(Point[] coords) {

        Integer rectangleCount = 0;
        Map<String,Point> map = getCoordinateMap(coords);

        for (int i=0 ; i< coords.length ;i++){
            List<Point> upRights = getUpperRightCoordinates(coords[i], coords);
            for(Point p : upRights){
                if(isRectangle(coords[i],p,map)){
                    rectangleCount++;
                }
            }

        }


        return rectangleCount;
    }

    private static boolean isRectangle(Point bottomLeft, Point topRight,Map<String,Point> map) {
        if(   Objects.isNull(map.get(bottomLeft.x + "-" + topRight.y)) || Objects.isNull(map.get(topRight.x + "-" + bottomLeft.y))   ){
            return false;
        }
        return true;
    }

    private static List<Point> getUpperRightCoordinates(Point point,Point[] coords) {

        List<Point> upperRights = new ArrayList<>();
        for(Point p : coords){
            if(p.greaterThan(point)){
                upperRights.add(p);
            }
        }
        return upperRights;
    }

    private static Map<String, Point> getCoordinateMap(Point[] coords) {
        Map<String, Point> map = new HashMap<>();
        for(Point p : coords){
            map.put(p.x + "-" + p.y, p);
        }
        return map;
    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean greaterThan(Point other){
            return (this.x > other.x) && (this.y > other.y);
        }
    }
}
