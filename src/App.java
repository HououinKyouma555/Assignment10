import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        int numbers[] = new int[1000];

        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = rand.nextInt(1000);
        }

        System.out.println("Numbers before sorting:");
        printArray(numbers);

        mergeSort(numbers);

        System.out.println("Numbers after sorting:");
        printArray(numbers);
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

}
