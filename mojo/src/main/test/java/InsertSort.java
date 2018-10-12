/**
 * Created by liangwei on 2018/10/9.
 */
public class InsertSort {
    public static void insersort(int[] arrys,int n){
        for (int i=1;i<n;i++){
            int j = i-1;
            int get = arrys[i];
            while (j>=0 && arrys[j]>get){
                arrys[j+1]=arrys[j];
                j--;
            }
            arrys[j+1]=get;
        }
    }

    public static void main(String [] args){
        int[] arrys={10,31,32,22,53,2,4,1,24,5,8};
        insersort(arrys,arrys.length);
        for (int i = 0; i<arrys.length;i++){
            System.out.print(arrys[i]+"<");
        }
    }
}