package 이분탐색.기초알고리즘;

public class Main {

    public static int[] a = {1, 3, 5, 7, 9, 11, 14, 15, 18, 19, 25, 28};
    public static int data = 7;

    public static void main(String[] args) {

        int result = search(0, a[a.length/2], data);
        if(result != -1)
            System.out.println(result+1 + "번째에서 찾았습니다.");
    }

    public static int search(int start, int end, int target) {
        if(start > end) return -1;
        int mid = (start + end) / 2;
        if(a[mid] == target) return mid;
        else if(a[mid] > target) return search(start, mid-1, target);
        else return search(mid +1, end, target);
    }
}