import java.util.*;
public class MinMax{
    static int operationComparisons = 0;
    
    static class MandM { 
                int min; 
                int max; 
        } 

        static MandM getMinMax(int arr[], int start, int end) { 
                MandM minmax = new MandM(); 
                MandM lMinMax = new MandM(); 
                MandM rMinMax = new MandM(); 
                int mid; 

                if (start == end) { 
                        minmax.max = arr[start]; 
                        minmax.min = arr[start]; 
                        return minmax; 
                } 

                if (end == start + 1) { 
                    operationComparisons++;
                        if (arr[start] > arr[end]) { 
                                minmax.max = arr[start]; 
                                minmax.min = arr[end]; 
                        } else { 
                                minmax.max = arr[end]; 
                                minmax.min = arr[start]; 
                        } 
                        return minmax; 
                } 

                mid = (start + end) / 2; 
                lMinMax = getMinMax(arr,start, mid); 
                rMinMax = getMinMax(arr, mid + 1, end); 

                if (lMinMax.min < rMinMax.min) { 
                        minmax.min = lMinMax.min; 
                } else { 
                        minmax.min = rMinMax.min; 
                } 
                operationComparisons++;
        
                if (lMinMax.max > rMinMax.max) { 
                        minmax.max = lMinMax.max; 
                } else { 
                        minmax.max = rMinMax.max; 
                } 
                operationComparisons++;
        
                return minmax; 
        } 
        
    public static void main(String []args){
        Random rand = new Random(); 
        int arr1[] = new int[10000];
        int arr2[] = new int [20000];
        int arr3[] = new int [50000];
        
        for(int i = 0; i < arr1.length; i++){
                arr1[i] = rand.nextInt(1000000);
        }
        for (int i = 0; i < arr2.length; i++) {
        	arr2[i] = rand.nextInt(1000000);
        }
        
        for (int i = 0; i < arr3.length; i++) {
        	arr3[i] = rand.nextInt(1000000);
        }
        
        MandM minmax = getMinMax(arr1, 0, arr1.length - 1); 
        System.out.printf("\n1st Array Min is %d", minmax.min); 
        System.out.printf("\n1st Array Max is %d", minmax.max); 
        System.out.println("\nNumber of comparisons in 1st Array : "+ operationComparisons); 
        System.out.println("----------------------------------------");
        operationComparisons = 0;
        
        MandM minmax2 = getMinMax(arr2, 0, arr2.length - 1); 
        System.out.printf("\n2nd Array Min is %d", minmax2.min); 
        System.out.printf("\n2nd Array Max is %d", minmax2.max); 
        System.out.println("\nNumber of comparisons in the 2nd Array : "+ operationComparisons); 
        System.out.println("----------------------------------------");
        operationComparisons = 0;
        
        MandM minmax3 = getMinMax(arr3, 0, arr3.length - 1); 
        System.out.printf("\n3rd Array Min is %d", minmax3.min); 
        System.out.printf("\n3rd Array Max is %d", minmax3.max); 
        System.out.printf("\nNumber of comparisonsvin the 3rd Array: "+ operationComparisons); 
    }
}