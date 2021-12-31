import java.util.Random;

import edu.princeton.cs.algs4.*;


public class SortExample{

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exchange(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static int IndexOfMax(Comparable[] a){
        int index = 0;
        int N = a.length;
        for(int i = 0; i < N; ++i){
            if(less(a[index], a[i]))
                index = i;
        }
        return index;
    }

    private static void drawInit(){
        StdDraw.clear();
        StdDraw.setCanvasSize(1000, 500);
        StdDraw.enableDoubleBuffering();
    }

    private static void showDouble(Double[] a, int redIndex, int greenIndex){
        StdDraw.clear();
        int N = a.length;
        int maxIndex = IndexOfMax(a);
        Double maxHeight = a[maxIndex];
        Double width = 1.0 / (2 * N);
        for(int i = 0; i < N; ++i){
            Double height = a[i];
            if(i == redIndex) StdDraw.setPenColor(StdDraw.RED);
            else if(i == greenIndex) StdDraw.setPenColor(StdDraw.GREEN);
            else StdDraw.setPenColor(StdDraw.BLUE);
            Double center_x = (2 * i + 1) * width;
            Double center_y = (0.1 + height / (maxHeight * 1.2)) / 2;
            Double half_width = width / 2;
            Double half_height = height / (2 * maxHeight * 1.2);
            StdDraw.filledRectangle(center_x, center_y, half_width, half_height);
        }
        StdDraw.show();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isSorted(Comparable[] a){
        for(int i = 0; i < a.length - 1; ++i){
            if(less(a[i + 1], a[i]))
                return false;
        }
        return true;
    }

    public static void insertSort(Double[] a){
        for(int i = 0; i < a.length - 1; ++i){
            for(int j = i + 1; j > 0; --j){
                if(less(a[j], a[j - 1])){
                    showDouble(a, j, i + 2);
                    exchange(a, j, j - 1);
                }
            }
        }
    }

    public static void selectSort(Double[] a){
        for(int i = 0; i < a.length; ++i){
            int minIndex = i;
            for(int j = i + 1; j < a.length; ++j){
                if(less(a[j], a[minIndex])){
                    minIndex = j;
                }
            }
            showDouble(a, minIndex, i);
            exchange(a, i, minIndex);
            
        }
    }

    public static void main(String[] args){
        drawInit();
        int num = 30;
        Double[] a = new Double[num];
        Random randomGenter = new Random();
        for(int i = 0; i < num; ++i)
            a[i] = randomGenter.nextDouble(500.0);
        insertSort(a);
        //selectSort(a);
        assert isSorted(a);
        //showDouble(a);
    }
}