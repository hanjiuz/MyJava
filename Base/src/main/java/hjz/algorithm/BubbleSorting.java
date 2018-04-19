package hjz.algorithm;

public class BubbleSorting {


	public static void main(String[] args) {
		int [] arr = {38, 70, 30, 22, 14, 21, 5, 66, 62, 65};
		
		System.out.println("array before sorting:");
		print(arr);
		
		bubbleSort(arr);
		
		System.out.println("array after bubble sorting:");
		print(arr);

	}	
    
	/**
     * 冒泡排序 - 每一轮冒出一个最大（或最小），放到最后（或最前），直到全部冒完。
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { //loop first n-1 elements
            boolean flag = true;//设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已然完成。
            for (int j = 0; j < arr.length - 1 - i; j++) { //loop first n-1-i elements
                if (arr[j] > arr[j + 1]) {
                    swap(arr,j,j+1);
                    flag = false;
                }
            }
            if (flag) {
                break;
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
     * 交换数组元素 - 这个交换不能处理a==b的情况，会导致值为0
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
