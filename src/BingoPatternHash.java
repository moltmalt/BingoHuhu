public class BingoPatternHash extends BingoPattern{
    public BingoPatternHash(BingoCard toCheckAgainst) {
        super(toCheckAgainst);
        bingoCheckers.add(new BingoRowChecker(1, toCheckAgainst));
        bingoCheckers.add(new BingoRowChecker(3, toCheckAgainst));
        bingoCheckers.add(new BingoColumnChecker(1, toCheckAgainst));
        bingoCheckers.add(new BingoColumnChecker(3, toCheckAgainst));
    }
}
