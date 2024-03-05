public class BingoPatternPlus extends BingoPattern{

    public BingoPatternPlus(BingoCard toCheckAgainst) {
        super(toCheckAgainst);
        bingoCheckers.add(new BingoRowChecker(2, toCheckAgainst));
        bingoCheckers.add(new BingoColumnChecker(2, toCheckAgainst));
    }
}
