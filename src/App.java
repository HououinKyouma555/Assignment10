import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        Scanner scnr = new Scanner(System.in);
        System.out.println("Input size of array:");
        int n = scnr.nextInt();
        scnr.close();
        int numbers[] = new int[n];

        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = rand.nextInt(n);
        }

        int[] copyNumbers = new int[numbers.length];

        for (int x : numbers)
        {
            copyNumbers[x] = numbers[x];
        }
        
        System.out.println("Beginning Merge Sort");
        System.out.println("Numbers before sorting:");
        printArray(numbers);
        long time1 = System.nanoTime();
        mergeSort(numbers);

        System.out.println("Numbers after sorting:");
        printArray(numbers);
        long time2 = System.nanoTime();
        long mergeTime = time2 - time1;
        System.out.println("Merge Sort time taken: " + mergeTime + " ns");

        System.out.println("Beginning Bubble Sort");
        System.out.println("Numbers before sorting:");
        printArray(copyNumbers);
        time1 = System.nanoTime();
        bubbleSort(numbers);

        System.out.println("Numbers after sorting:");
        printArray(copyNumbers);
        time2 = System.nanoTime();
        long bubTime = time2 - time1;
        System.out.println("Bubble Sort time taken: " + bubTime + " ns");

        System.out.println("\nMerge Sort time: " + mergeTime);
        System.out.println("Bubble Sort time: " + bubTime);

        if (mergeTime < bubTime)
        {
            System.out.println("Merge sort was faster by " + (bubTime - mergeTime) + " ns");
        }
        else
        {
            System.out.println("Bubble sort was faster by " + (mergeTime - bubTime) + " ns");
        }
    }

    public static void printArray(int[] num){
        for (int i = 0; i < num.length; i++)
        {
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int[] inputArray)
    {
        int length = inputArray.length;

        if (length < 2)
        {
            return;
        }

        int midIndex = length / 2;
        int left[] = new int[midIndex];
        int right[] = new int[length - midIndex];

        for (int i = 0; i < midIndex; i++)
        {
            left[i] = inputArray[i];
        }

        for (int i = midIndex; i < length; i++)
        {
            right[i - midIndex] = inputArray[i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(inputArray, left, right);
    }

    public static void merge(int inputArray[], int left[], int right[])
    {
        int leftSize = left.length;
        int rightSize = right.length;

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftSize && j < rightSize)
        {
            if (left[i] < right[j])
            {
                inputArray[k] = left[i];
                i++;
            }
            else
            {
                inputArray[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < leftSize)
        {
            inputArray[k] = left[i];
            i++;
            k++;
        }
        while (j < rightSize)
        {
            inputArray[k] = right[j];
            j++;
            k++;
        }
    }

    public static void bubbleSort(int[] inputArray){
        for (int i = 0; i < inputArray.length; i++)
        {
            for (int j = 1; j < (inputArray.length-1); j++)
            {
                if (inputArray[j-1] > inputArray[j])
                {
                    int temp = inputArray[j-1];
                    inputArray[j-1] = inputArray[j];
                    inputArray[j] = temp;
                }
            }
        }
    }
}
