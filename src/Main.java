import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        MrBet mrbet = new MrBet();
        Scanner sc = new Scanner(System.in);

        while(true) {
            printMenu();
            String userInput = sc.nextLine().toLowerCase();

        }
    }

    private static void printMenu() {
        System.out.println(
            "(M)Minha inclusão de times\n"+
            "(R)Recuperar time\n"+
            "(.)Adicionar campeonato\n"+
            "(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n"+
            "(E)Exibir campeonatos que o time participa\n"+
            "(T)Tentar a sorte e status\n"+
            "(!)Já pode fechar o programa!\n"+
            "\n"+
            "Opção> \n"
        );
    }

    private static void handleInput(String userInput, MrBet sistema) {
        switch (userInput) {
            case "m": System.out.println("Funcionalidade não implementada");break;
            case "r": System.out.println("Funcionalidade não implementada");break;
            case ".": System.out.println("Funcionalidade não implementada");break;
            case "b": System.out.println("Funcionalidade não implementada");break;
            case "e": System.out.println("Funcionalidade não implementada");break;
            case "t": System.out.println("Funcionalidade não implementada");break;
            case "!": System.out.println("Funcionalidade não implementada");break;
        }
    }
} 