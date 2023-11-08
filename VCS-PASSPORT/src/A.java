import java.util.*;

class Maina {

    static Map<String, List<Pair<String, String>>> inputs = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cacheEntriesSize = scanner.nextInt();
        scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < cacheEntriesSize; i++) {
            String[] data = scanner.nextLine().split(" ");
            Pair<String, String> pair = new Pair<>(data[1], data[2]);
            List<Pair<String, String>> lists = inputs.containsKey(data[0]) ?
                    inputs.get(data[0]) : new ArrayList<>();
            lists.add(pair);
            inputs.put(data[0],lists);
        }

        int queriesSize = scanner.nextInt();
        scanner.nextInt();

        scanner.nextLine();
        for(int i = 0; i < queriesSize; i++) {
            String[] query = scanner.nextLine().split(" ");

            for(Pair<String, String> pair : inputs.get(query[1]))
                if(pair.left.equals(query[0]))
                    System.out.println(pair.right);
        }
    }

    static class Pair<L, R> {
        Pair(L left, R right) {
            this.left = left;
            this.right = right;
        }
        public L left;
        public R right;
    }
}
