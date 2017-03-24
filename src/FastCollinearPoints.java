
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FastCollinearPoints {
    
    private ArrayList<Point> points;
    private ArrayList<LineSegment> segments = new ArrayList<>();
    int numberOfSegments = 0;
    
    
   // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        if (points == null) {
            throw new NullPointerException();
        }
        Set<String> s = new HashSet<>();
        for (Point point : points) {
            if (point == null) {
                throw new NullPointerException();
            }
            if (s.contains(point.toString())) {
                throw new IllegalArgumentException();
            }
            s.add(point.toString());
            this.points.add(point);
        }
        s.clear();

        int numOfPoints = this.points.size();
        for (int i = 0; i < numOfPoints; i++) {
            Collections.sort(this.points, this.points.get(i).slopeOrder());
            for (int j = 0; j < numOfPoints; j++) {
                for (int k = j + 1; k < numOfPoints; k++) {
                    int segmentLength = 0;
                    
                    if (points[i].slopeTo(points[j]) == points[i].slopeTo(points[k])) {
                        segmentLength++;
                    } else if (segmentLength < 4) {
                        
                    }
                }
            }
        }
    }
   
    // the number of line segments
    public int numberOfSegments() {
        return numberOfSegments;
    }
    
    // the line segments
    public LineSegment[] segments() {
        if (segments.isEmpty()) 
            return null;
        return segments.toArray(new LineSegment[segments.size()]);
    }
}