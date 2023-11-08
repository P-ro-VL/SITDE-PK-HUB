import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playerSize = scanner.nextInt();
        List<Integer> players = new ArrayList<>();
        for(int i = 0; i < playerSize; i++) {
            players.add(scanner.nextInt());
        }

        int newPlayer = scanner.nextInt();
        Queue<Integer> newPlayers = new LinkedList<>();
        for(int i = 0; i < newPlayer; i++) {
            newPlayers.add(scanner.nextInt());
        }

        int rank = scanner.nextInt();
        Collections.sort(players);

        int sum = players.get(rank - 1);
        while(!newPlayers.isEmpty()) {
            players.add(newPlayers.poll());
            Collections.sort(players);
            sum += players.get(rank - 1);
        }

        System.out.println(sum);
    }

}
