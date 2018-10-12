/**
 * Created by liangwei on 2018/10/8.
 */
public class Bubble {
    public static void swap(int []arry,int i,int j){
           int temp = arry[i];
            arry[i]=arry[j];
            arry[j]=temp;
    }

    public static void bubbleSort(int [] arry,int n){
        for( int i = 0;i<n;i++){
            for (int j = i+1;j<n;j++){
                if (arry[i]<arry[j]){
                    swap(arry,i,j);
                }
            }
        }
    }

    public static void main(String[] args){
        int [] arrys={1,3,5,2,4,8,6};
        bubbleSort(arrys,arrys.length);
        for (int i = 0;i<arrys.length;i++)
        System.out.print(arrys[i]);
    }

}
