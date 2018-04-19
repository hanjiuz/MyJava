package hjz.algorithm;

public class ShellSorting {


	public static void main(String[] args) {
		int [] arr1 = {38, 70, 30, 22, 14, 21, 5, 66, 62, 65};
		
		/**
		 * 希尔排序是根据一个增量序列进行，一般可以选择希尔序列
		 * 希尔序列不是最优序列，但可以突破O（n*n）
		 * 遍历增量序列里面的每个增量gap，按照gap把元素分组，每个组内部采用简单插入排序法排序。
		 * 原理是序列内排序不浪费
		 * 
		 */
		
		System.out.println("array before sorting:");
		print(arr1);
		
		shellSort1(arr1);
		
		System.out.println("array after shell sorting1(swap):");
		print(arr1);
		
		int [] arr2 = {38, 70, 30, 22, 14, 21, 5, 66, 62, 65};
		System.out.println("array before sorting:");
		print(arr2);
		
		shellSort1(arr2);
		
		System.out.println("array after shell sorting2(move):");
		print(arr2);

	}	
    
		/**
	      * 希尔排序 针对有序序列在插入时采用交换法
	      * @param arr
	      */
	     public static void shellSort1(int []arr){
	         //增量gap，并逐步缩小增量
	        for(int gap=arr.length/2;gap>0;gap/=2){  //loop 希尔增量序列
	            //从第gap个元素，逐个对其所在组进行直接插入排序操作
	            for(int i=gap;i<arr.length;i++){
	                int j = i;
	                while(j-gap>=0 && arr[j]<arr[j-gap]){
	                    //插入排序采用交换法
	                    swap(arr,j,j-gap);
	                    j-=gap;
	                }
	            }
	        }
	     }
	 
	     /**
	      * 希尔排序 针对有序序列在插入时采用移动法。
	      * @param arr
	      */
	     public static void shellSort2(int []arr){
	         //增量gap，并逐步缩小增量
	         for(int gap=arr.length/2;gap>0;gap/=2){
	             //从第gap个元素，逐个对其所在组进行直接插入排序操作
	             for(int i=gap;i<arr.length;i++){
	                 int j = i;
	                 
	                 int temp = arr[j];
	                
                     while(j-gap>=0 && temp<arr[j-gap]){
                         //移动法
                         arr[j] = arr[j-gap];
                         j-=gap;
                     }
                     //move temp to right place
                     arr[j] = temp;
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
