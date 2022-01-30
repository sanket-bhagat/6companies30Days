package _6_walmart;

public class _3_RemoveColoredPiecesIfBothNeighborsAreTheSameColor {

	static boolean winnerOfGame(String colors) {
        int countA = 0, countB = 0;
        int movesA = 0, movesB = 0;
        for (int i = 0; i < colors.length(); i++) {
            if (colors.charAt(i) == 'A') {
                countB = 0;
                if (++countA > 2)
                    movesA++;
            }
            else {
                countA = 0;
                if (++countB > 2)
                    movesB++;
            }
        }
        return movesA > movesB;
    }

    public static void main(String[] args) {
        String colors = "ABBBBBBBAAA";
        System.out.println(winnerOfGame(colors));
    }

}
