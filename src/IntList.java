public class IntList {
    public static void main(String[] args){
        int[] test = intToList(12345667);

        for (int i = 0; i < test.length; i++) {
            System.out.printf("%d ", test[i]);
        }
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
}
