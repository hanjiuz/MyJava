package hjz.algorithm;

public class QuickSorting {
	

	public static void main(String[] args) {
		int [] arr = {38, 70, 30, 22, 14, 21, 5, 66, 62, 65};
		
		System.out.println("array before sorting:");
		print(arr);
		
		quickSort(arr);
		
		System.out.println("array after quick sorting:");
		print(arr);

	}
	
    /**
     * 快速排序 - 选取枢纽元，分而治之。
     * @param arr
     * 
     */
    public static void quickSort(int[] arr) {
    	
    	/**
    	 * 快速排序时间复杂度O（n * log n）
    	 */
    	
    	sort(arr, 0, arr.length-1);
    }

    /**
     * @param arr
     * @param left  左指针
     * @param right 右指针
     */
    private static void sort(int[] arr, int left, int right) {
        if (left < right) {
            //获取枢纽值，并将其放在当前待处理序列末尾
            dealPivot(arr, left, right);
            
            //枢纽值被放在序列末尾（倒数第二个值）
            int pivot = right - 1;
            
            //左指针
            int i = left;
            //右指针
            int j = right - 1;
            while (true) {
                while (arr[++i] < arr[pivot]) {
                }
                while (j > left && arr[--j] > arr[pivot]) {
                }
                if (i < j) {
                    swap(arr, i, j);
                } else {
                    break;
                }
            }
            if (i < right) {
                swap(arr, i, right - 1);
            }
            sort(arr, left, i - 1);
            sort(arr, i + 1, right);
        }

    }

    /**
     * 处理枢纽值 - 枢纽值（三者中值）放到倒数第二右边。
     *
     * @param arr
     * @param left
     * @param right
     */
    private static void dealPivot(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (arr[left] > arr[mid]) {
            swap(arr, left, mid);
        }
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        if (arr[right] < arr[mid]) {
            swap(arr, right, mid);
        }
        swap(arr, right - 1, mid);
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
     * 交换元素通用处理 - 这个交换可以处理 a==b 的情形。
     *
     * @param arr
     * @param a
     * @param b
     */
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
