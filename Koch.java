import edu.princeton.cs.introcs.StdDraw;

/** Draws the Koch curve and the Koch snowflake fractal. */
public class Koch {

    public static void main(String[] args) {

        //// Uncomment the first code block to test the curve function.
        //// Uncomment the second code block to test the snowflake function.
        //// Uncomment only one block in each test, and remember to compile
        //// the class whenever you change the test.

        /*
        // Tests the curve function:
        // Gets n, x1, y1, x2, y2,
        // and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
        curve(Integer.parseInt(args[0]),
              Double.parseDouble(args[1]), Double.parseDouble(args[2]),
              Double.parseDouble(args[3]), Double.parseDouble(args[4]));
        */

        /*
        // Tests the snowflake function:
        // Gets n, and draws a Koch snowflake of n edges in the standard canvass.
        snowFlake(Integer.parseInt(args[0]));
        */
    }

    /** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
    public static void curve(int n, double x1, double y1, double x2, double y2) {

        // Base case: just draw the segment
        if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        }

        // Divide the segment into 3 equal parts: A -> B -> D -> E
        double dx = x2 - x1;
        double dy = y2 - y1;

        double bx = x1 + dx / 3.0;
        double by = y1 + dy / 3.0;

        double dx2 = x1 + 2.0 * dx / 3.0;
        double dy2p = y1 + 2.0 * dy / 3.0;

        // Build equilateral triangle on the middle segment (B -> D).
        // Apex point C (one consistent "outside" side for a directed segment B->D):
        double cx = (bx + dx2) / 2.0 + (Math.sqrt(3) / 2.0) * (by - dy2p);
        double cy = (by + dy2p) / 2.0 + (Math.sqrt(3) / 2.0) * (dx2 - bx);

        // Recurse on the 4 segments: A->B, B->C, C->D, D->E
        curve(n - 1, x1, y1, bx, by);
        curve(n - 1, bx, by, cx, cy);
        curve(n - 1, cx, cy, dx2, dy2p);
        curve(n - 1, dx2, dy2p, x2, y2);
    }

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
    public static void snowFlake(int n) {
        // A little tweak that makes the drawing look better
        StdDraw.setYscale(0, 1.1);
        StdDraw.setXscale(0, 1.1);
        StdDraw.clear();

        // Equilateral triangle vertices (counterclockwise)
        double x1 = 0.15, y1 = 0.15;
        double x2 = 0.95, y2 = 0.15;

        double side = x2 - x1;                     // 0.80
        double height = Math.sqrt(3) / 2.0 * side; // triangle height
        double x3 = (x1 + x2) / 2.0;
        double y3 = y1 + height;

        // Draw the three Koch curves around the triangle
        curve(n, x1, y1, x2, y2);
        curve(n, x2, y2, x3, y3);
        curve(n, x3, y3, x1, y1);
    }
}
