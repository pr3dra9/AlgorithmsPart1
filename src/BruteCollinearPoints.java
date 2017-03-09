
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class BruteCollinearPoints {

    private Point[] points;
    private ArrayList<LineSegment> segments = new ArrayList<>();
    
    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new NullPointerException();
        }
        Set<Point> s = new HashSet<>();
        for (Point point : points) {
            if (point == null) {
                throw new NullPointerException();
            }
            if (s.contains(point)) {
                throw new IllegalArgumentException();
            }
            s.add(point);
        }
        this.points = points;
    }

    // the number of line segments
    public int numberOfSegments() {
        int numberOfSegments = 0;
        int numOfPoints = points.length;
        for (int i = 0; i < numOfPoints; i++) {
            for (int j = i + 1; j < numOfPoints; j++) {
                for (int k = j + 1; k < numOfPoints; k++) {
                    for (int l = k + 1; l < numOfPoints; l++) {
                        if (isCollinear(points[i], points[j], points[k], points[l])) {
                            //System.out.println(points[i] + " " + points[j] + " " + points[k] + " " + points[l]);
                            ArrayList<Point> qw = new ArrayList<>();
                            qw.add(points[i]);
                            qw.add(points[j]);
                            qw.add(points[k]);
                            qw.add(points[l]);
                            Collections.sort(qw);
                            LineSegment ls = new LineSegment(qw.get(0), qw.get(qw.size() - 1));
                            segments.add(ls);
                            numberOfSegments++;
                        }
                    }
                }
            }
        }
        return numberOfSegments;
    }

    private boolean isCollinear(Point p, Point q, Point r, Point s) {
        //System.out.println("Slope p, q: " + p.slopeTo(q));
        //System.out.println("Slope p, r: " + p.slopeTo(r));
        //System.out.println("Slope p, s: " + p.slopeTo(s));
        //System.out.println("-----------------------------------");
        return p.slopeTo(q) == p.slopeTo(r) && p.slopeTo(q) == p.slopeTo(s);
        
    }

    // the line segments
    public LineSegment[] segments() {
        return segments.toArray(new LineSegment[segments.size()]);
    }

    public static void main(String[] args) {
        Point p1 = new Point(10000, 0);
        Point p2 = new Point(0, 10000);
        Point p3 = new Point(3000, 7000);
        Point p4 = new Point(7000, 3000);
        Point p5 = new Point(20000, 21000);
        Point p6 = new Point(3000, 4000);
        Point p7 = new Point(14000, 15000);
        Point p8 = new Point(6000, 7000);
        Point[] ps = new Point[8];
        ps[0] = p1;
        ps[1] = p2;
        ps[2] = p3;
        ps[3] = p4;
        ps[4] = p5;
        ps[5] = p6;
        ps[6] = p7;
        ps[7] = p8;
        BruteCollinearPoints bc = new BruteCollinearPoints(ps);
        //System.out.println(p1.slopeTo(p2));
        //System.out.println(p1.slopeTo(p3));
        //System.out.println(p1.slopeTo(p8));
        
        System.out.println(bc.numberOfSegments());
        
        LineSegment[] ls = bc.segments();
        for (LineSegment l : ls) {
            System.out.println(l);
        }
                
    }
        
}
