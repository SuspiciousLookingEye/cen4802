import java.util.*;

public class DemoClass {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("How many numbers do you want in the new array?");
		int inputIndex = input.nextInt();
		if (inputIndex <= 1) {
			System.out.println("Please try again - invalid number of array elements");
		}

		int [] initialArray = createArray(inputIndex);

		int [] sortedArray = sortArray(initialArray);


		System.out.println("Array created.");

		boolean loop = true;

		while(loop) {
			System.out.println("Enter 1 to search for a value, 2 to do a frequency check, ");
			System.out.println("3 to determine statistics, 4 to generate a new array, or 5 to exit.");

			int choice = input.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter a number to search for...");
				int searchValue = input.nextInt();
				boolean comparison = searchArray(sortedArray, searchValue);
				if (comparison == true) {
					System.out.println("The value " + searchValue + " was found.");
				}
				else {
					System.out.println("The value " + searchValue + " was not found.");
				}
				break;
			case 2:
				int [][]containingArray = countArray(sortedArray);
				for (int x = 0; x < containingArray[0].length; x++) {
					if (containingArray[1][x] == -1) {
						continue;
					}
					else {
					System.out.println("Element " + containingArray[0][x] + " was found " + containingArray[1][x] + " times.");
					}
				}
				break;
			case 3:
				double [] resultsArray = statArray(sortedArray);
				
				System.out.println("The average of values in the array is " + String.format("%.2f", resultsArray[0]));
				System.out.println("The lowest value is " + resultsArray[1]);
				System.out.println("The highest value is " + resultsArray[2]);
				break;
			case 4:
				System.out.println("How many numbers do you want in the new array?");
				int newIndex = input.nextInt();
				if (newIndex <= 1) {
					System.out.println("Please try again - invalid number of array elements");
				}

				int [] replacementArray = createArray(newIndex);
				initialArray = replacementArray;
				sortedArray = sortArray(initialArray);
				break;
			case 5:
				System.out.println("Thank you. Exiting now.");
				input.close();
				loop = false;
				System.exit(0);
				break;
			default:
				System.err.print("Invalid choice, please choose between 1 through 5!");
				break;
			}
		}
	}

	public static int [] createArray(int index) {
		int [] userArray = new int [index];
		Random rand = new Random();
		int max = 100;
		int min = 1;
		for (int x = 0; x < userArray.length; x++) {
			userArray[x] = rand.nextInt((max - min) + 1) + min;
		}
		System.out.printf("Initial Array : %s", Arrays.toString(userArray));
		System.out.println();
		return userArray;
	}

	public static int [] sortArray (int [] array) {
		int [] sortArray = array;
		Arrays.sort(sortArray);
		System.out.printf("Sorted Array : %s", Arrays.toString(sortArray));
		System.out.println();
		return sortArray;
	}

	public static boolean searchArray (int [] array , int searchQuery) {
		int low = 0;
		int high = array.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (searchQuery > array[mid]) {
				low = mid + 1;
			}
			else if (searchQuery < array[mid]) {
				high = mid - 1;
			}
			else {
				return true;
			}

		}
		return false;
	}

	public static int[][] countArray (int [] array) {
		int [] countingArray = array;
		int [] frequencyArray = new int [countingArray.length];
		int selected = -1;
		int [][] containingArray = new int[][] {countingArray,frequencyArray};

		for (int x = 0; x < countingArray.length; x++) {
			int count = 1;
			for (int y = x + 1; y < countingArray.length; y++) {
				if (countingArray[x] == countingArray[y]) {
					count++;
					frequencyArray[y] = selected;
				}
			}
			if (frequencyArray[x] != selected) {
				frequencyArray[x] = count;
			}
		}
		return containingArray;
	}

	public static double[] statArray(int [] array) {
		double sum = 0;
		int index = array.length;
		for (int x = 0; x < index; x++) {
			sum += array[x];
		}
		double average = sum / index;
		double [] outputArray = {average, array[0], array[array.length - 1]};
		
		return outputArray;
	}


}
