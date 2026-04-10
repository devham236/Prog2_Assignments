public class IntList {
    public static void main(String[] args){
        System.out.println(countNumbers(123));
    }

    public static int countNumbers(int num){
        String str = String.valueOf(num);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
        }
        return count;
    }

    public static int[] intToList(int value){
        int[] list = new int[countNumbers(value)];

        return list;
    }
}
