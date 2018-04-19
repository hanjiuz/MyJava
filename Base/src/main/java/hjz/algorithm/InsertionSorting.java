package hjz.algorithm;

public class InsertionSorting {


	public static void main(String[] args) {
		int [] arr = {38, 70, 30, 22, 14, 21, 5, 66, 62, 65};
		
		System.out.println("array before sorting:");
		print(arr);
		
		insertionSort(arr);
		
		System.out.println("array after insertion sorting:");
		print(arr);

	}	
    
	/**
     * 插入排序 - 前面子队列是有序的，后面的插入到适当位置得到一个更大的子队列，直至全部有序。
     *
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) { //loop from 2nd element
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) { //move current looping element to right place 
                swap(arr,j,j-1);
                j--;
            }
        }
    }
	
	
	/**
	 * print array
	 */
	public static void print(int []arr) {
		for (int i=0; i<arr.length; i++) {
			if(i!=arr.length-1) {
				System.out.print(arr[i]+", ");
			}else{
				System.out.print(arr[i]+". \n");
			}	
		}
	}
	
	/**
     * 交换数组元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a,int b){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }


}
