/**
 * Created by liangwei on 2018/10/8.
 */
public class SelectSort {
    public static void swap(int[] arrys,int i,int min){
        int temp = arrys[i];
        arrys[i]=arrys[min];
        arrys[min]=temp;
    }
    public static void selectSorts(int[] arrys,int n){
        for (int i = 0;i<n;i++){
            int min=i;
            for (int j=i+1;j<n;j++){
                if (arrys[j]>arrys[min]){
                    min=j;
                }
            }
            if (i!=min){
                swap(arrys,i,min);
            }
        }
    }
    public static void main(String[] args){
        int[] arrys={10,12,13,43,2,55,22};
        selectSorts(arrys,arrys.length);
        for (int i = 0;i<arrys.length;i++){
            System.out.print(arrys[i]+">");
        }
    }
}
