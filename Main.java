import java.util.*;
class Main {
  
  public static int [] arrayValues;//accessible by entire class
  public static int [] arrayCollatz;//accessible by entire class

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);//take input for startNum, endNum and nth place
    int startNum = 10000;//sc.nextInt();
    int endNum = 10020;//sc.nextInt();
    int n = 3; //sc.nextInt(); RETURN FOR HACKERRANK

    int count = 0; //starts count at zero for every method call
    int index = 0;//holds index value that will assign items into arrays 
    arrayValues = new int [endNum-startNum +1];//holds nums in range
    arrayCollatz = new int [endNum-startNum +1];//holds collatz nums in range
    
    //creates 2 arrays to hold the values and collatz nums
    for (int i = startNum; i <= endNum; i++ ){
      int col = collatz(i, count);
      arrayValues[index] = i;
      arrayCollatz[index] = col;
      index++;
    }
    //testing purposes to see array before any changes
    for (int i = 0; i<arrayValues.length; i++){
      System.out.println(arrayValues[i]+" "+arrayCollatz[i]);
    }
    //median3(0, arrayCollatz.length-1);
    insertionSort();
    System.out.println();
    //check array after change
    for (int i = 0; i<arrayValues.length; i++){
      System.out.println(arrayValues[i]+" "+arrayCollatz[i]);
    }
  }

  //determine collatz num recursively
  public static int collatz(int num, int count){
    if (num == 1) return count;//base case returns count(0 if no other computation)
    count++;
    if (num%2 == 0) {return collatz(num/2, count);}//if even
    else {return collatz(num*3+1, count);}//if odd
  }

public static void insertionSort() {
  for (int outer = 1; outer < arrayCollatz.length; outer++) {
  // outer is the next element to be sorted
    int temp = arrayCollatz[outer]; //back it up
    int inner = outer; // inner used to track shifts
    while (inner > 0 && arrayCollatz[inner - 1] >= temp) {
      arrayCollatz[inner] = arrayCollatz[inner - 1];// swap
      inner--;
  } //shift them all right until one is smaller
  arrayCollatz[inner] = temp;
  }
}

}