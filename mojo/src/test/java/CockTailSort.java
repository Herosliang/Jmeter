/**
 * Created by liangwei on 2018/10/8.
 */
public class CockTailSort {
    public static void swap(int[] arrys, int i, int j) {
        int temp = arrys[i];
        arrys[i] = arrys[j];
        arrys[j] = temp;
    }

    public static void cocksort(int[] arrys, int n) {
        int left = 0;
        int right = n - 1;
        while (left < right) {
            for (int i = left; i < right; i++) {
                if (arrys[i] > arrys[i + 1]) {
                    swap(arrys, i, i + 1);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (arrys[i - 1] > arrys[i]) {
                    swap(arrys, i - 1, i);
                }
            }
            left++;
        }
    }

    public static void main(String[] args){
        int[] arrys={1,4,6,11,1234,2,555,23};
        cocksort(arrys,arrys.length);
        for (int i = 0;i<arrys.length;i++){
            System.out.print(arrys[i]+",");
        }
    }
}
