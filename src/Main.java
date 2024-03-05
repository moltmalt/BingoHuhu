public class Main {
    public static void main(String[] args) {

        Thread game =  new Thread(new BingoGame());
        game.start();
        BingoCard bc =  new BingoCard(1);
        bc.toString();
    }
}