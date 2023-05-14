package mrbet;

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
            case "m": cadastrarTime(sc, sistema);break;
            case "r": getTimeById(sc, sistema);break;
            case ".": criarCampeonato(sc, sistema);break;
            case "b": incluirTimeEmCampeonato(sc, sistema);break;
            case "e": exibirCampeonatosDeUmTime(sc, sistema);break;
            case "t": apostaHandler(sc, sistema);break;
            case "!": break;
            default: sc.close();throw new IllegalArgumentException("OPÇÂO INVÁLIDA");
        }
    }

    private static void cadastrarTime(Scanner sc, MrBet sistema) {
        System.out.println("Código: ");
        String timeId = sc.nextLine();
        System.out.println("Nome: ");
        String nomeTime  = sc.nextLine();
        System.out.println("Mascote: ");
        String mascote  = sc.nextLine();
        sistema.cadastrarTime(timeId, nomeTime, mascote);
    }

    private static void getTimeById(Scanner sc, MrBet sistema) {
        System.out.println("Código: ");
        String timeId = sc.nextLine();

        sistema.getTimeById(timeId);
    }

    private static void criarCampeonato(Scanner sc, MrBet sistema) {
        System.out.println("Campeonato: ");
        String nomeCampeonato = sc.nextLine();
        System.out.println("Participantes: ");
        int quantParticipantes = Integer.parseInt(sc.nextLine());

        sistema.criarCampeonato(nomeCampeonato, quantParticipantes);
    }

    private static void incluirTimeEmCampeonato(Scanner sc, MrBet sistema) {
        System.out.println("(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato?");
        String subOpcao = sc.nextLine().toLowerCase();

        System.out.println("Código: ");
        String timeId = sc.nextLine();
        System.out.println("Campeonato: ");
        String nomeCampeonato = sc.nextLine();

        sistema.incluirTimeEmCampeonato(subOpcao, timeId, nomeCampeonato);
    }

    private static void exibirCampeonatosDeUmTime(Scanner sc, MrBet sistema) {
        System.out.println("Time: ");
        String timeId = sc.nextLine();

        sistema.exibirCampeonatosDeUmTime(timeId);
    }

    private static void apostaHandler(Scanner sc, MrBet sistema) {
        System.out.println("(A)Apostar ou (S)Status das Apostas?");
        String subOpcao = sc.nextLine().toLowerCase();

        if(subOpcao.equals("a")) {
            System.out.println("Código: ");
            String timeId = sc.nextLine();
            System.out.println("Campeonato: ");
            String nomeCampeonato = sc.nextLine();
            System.out.println("Colocação: ");
            int palpiteColocacao = Integer.parseInt(sc.nextLine());
            System.out.println("Valor da Aposta: ");
            double valorAposta = Double.parseDouble(
                sc.nextLine()
                .replace("R$", "")
                .replace(",", ".")
            );

            sistema.apostar(timeId, nomeCampeonato, palpiteColocacao, valorAposta);
        }
        else if(subOpcao.equals("s")) sistema.relatorioDeApostas();
        else System.out.println("Opção inválida");
    }
}

