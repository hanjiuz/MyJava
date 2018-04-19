package hjz.algorithm;

public class SelectSorting {

	public static void main(String[] args) {
		int [] arr = {38, 70, 30, 22, 14, 21, 5, 66, 62, 65};
		
		System.out.println("array before sorting:");
		print(arr);
		
		selectSort(arr);
		
		System.out.println("array after select sorting:");
		print(arr);

	}	
    
    /**
     * 简单选择排序 - 每一轮选择一个最小的放前面，直到选完所有的（选n-1轮就都选完了）。
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { //loop first n-1 elements
            int min = i;//每一趟循环比较时，min用于存放较小元素的数组下标，这样当前批次比较完毕最终存放的就是此趟内最小的元素的下标，避免每次遇到较小元素都要进行交换。
            for (int j = i + 1; j < arr.length; j++) { //loop last n-i elements
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            //进行交换，如果min发生变化，则进行交换
            if (min != i) {
                swap(arr,min,i);
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
