import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        MrBet mrbet = new MrBet();
        Scanner sc = new Scanner(System.in);
        String userInput = "";

        while(!userInput.equals("!") ) {
            try {
                printMenu();
                userInput = sc.nextLine().toLowerCase();
                handleInput(userInput, mrbet, sc);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Por hoje é só pessoal!");
    }

    private static void printMenu() {
        System.out.println(
            "\n"+
            "(M)Minha inclusão de times\n"+
            "(R)Recuperar time\n"+
            "(.)Adicionar campeonato\n"+
            "(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n"+
            "(E)Exibir campeonatos que o time participa\n"+
            "(T)Tentar a sorte e status\n"+
            "(!)Já pode fechar o programa!\n"+
            "\n"+
            "Opção>"
        );
    }

    private static void handleInput(String userInput, MrBet sistema, Scanner sc) {
        switch (userInput) {
            case "m": sistema.cadastrarTime();break;
            case "r": sistema.getTimeById();break;
            case ".": sistema.criarCampeonato();break;
            case "b": sistema.incluirTimeEmCampeonato();break;
            case "e": sistema.exibirCampeonatosDeUmTime();break;
            case "t": sistema.apostaHandler();break;
            case "!": break;
            default: sc.close();throw new IllegalArgumentException("OPÇÂO INVÁLIDA");
        }
    }
} 