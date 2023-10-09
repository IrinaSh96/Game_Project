import service.GameService;

public class App {
    public static void main(String[] args) {
        GameService gameService = new GameService();
        gameService.start();
    }
}

