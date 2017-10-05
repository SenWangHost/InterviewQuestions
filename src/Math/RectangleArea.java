/**
 *
 */
package Math;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 *
 * Assume that the total area is never beyond the maximum possible value of int.
 * @author SenWang
 *
 */
public class RectangleArea {
    /**
     * this is my own solution to this question.
     */
    public static int solution(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaA = (C - A) * (D - B);
        int areaB = (G - E) * (H - F);

        // check whether there is overlape area
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);

        int overlap = 0;
        if (left < right && bottom < top) {
            overlap = (right - left) * (top - bottom);
        }
        return areaA + areaB - overlap;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
