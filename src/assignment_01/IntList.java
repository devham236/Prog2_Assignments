package assignment_01;

public class IntList {
    public static void main(String[] args){
        int[] test = intToList(999);
        int testNum = listToInt(addOne(test));
        System.out.println(testNum);
    }

    public static int countNumbers(int num){
        String str = String.valueOf(num);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
        }
        return count;
    }

    public static int getDigit(String str, int index){
        char chr = str.charAt(index);
        int singleInt = Integer.parseInt(String.valueOf(chr));
        return singleInt;
    }

    public static int[] intToList(int value){
        int[] list = new int[countNumbers(value)];
        String str = String.valueOf(value);
        for (int i = 0; i < str.length(); i++) {
            int digit = getDigit(str, i);
            list[i] = digit;
        }
        return list;
    }

    public static int listToInt(int[] numbers){
        String str = "";
        for (int i = 0; i < numbers.length; i++) {
            str += Integer.toString(numbers[i]);
        }
        return Integer.parseInt(str);
    }

    public static int[] addOne(int[] numbers){
        int num = listToInt(numbers);
        int[] numArray = intToList(num+1);
        return numArray;
    }
}
