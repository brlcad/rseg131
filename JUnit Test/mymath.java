public class mymath {
    public int sum(int[] numbers) {
        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        return sum;
    }


    public int avg(int[] numbers) {
        int sum = 0;
        int count = 0;
        for (int i : numbers) {
            sum += i;
            count += 1;
        }


        return sum / count;
    }
}

