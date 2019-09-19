package lkl.sort_foundation;
/*
插入排序：在排序的过程中，维护了一个已经排好序的部分（part1），数组中剩余的部分（part2）为乱序
          对于part2中的每一个元素，查找其在已经排好序的部分的位置，然后进行插入
小技巧：part2中的元素 x 在part1中查找要插入位置的时候，并不是要比较一个交换一个，这样会造成交换次数比较多
        而是要找到插入位置y，把从位置y到part1的最后一个元素依次向后复制，给x腾出要插入的位置
 */
public class sort_solution1 {
    public static void insert_sort(int[] arr){
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int j = i-1;
            //先把待插入的值保留一份
            int insert_value = arr[i];
            //从要插入位置  到  有序部分的结尾 的这些元素依次向后复制  arr[j] = arr[j-1]
            for (; j>=0 && insert_value < arr[j]; j--) {
                arr[j+1] = arr[j];
            }
            //把元素插入到指定位置
            arr[j+1] = insert_value;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,7,2};
        sort_solution1.insert_sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%3d",arr[i]);
        }
    }
}
