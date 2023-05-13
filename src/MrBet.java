import java.util.Scanner;

import repositories.*;
import models.*;

public class MrBet {
    Scanner sc = new Scanner(System.in);
    private final RepositorioApostas apostas = new RepositorioApostas();
    private final RepositorioCampeonatos campeonatos = new RepositorioCampeonatos();
    private final RepositorioTimes times = new RepositorioTimes();

    public void cadastrarTime() {
        System.out.println("Código: ");
        String timeId = sc.nextLine();
        System.out.println("Nome: ");
        String nomeTime  = sc.nextLine();
        System.out.println("Mascote: ");
        String mascote  = sc.nextLine();

        times.cadastrarTime(timeId, nomeTime, mascote);
        System.out.println("INCLUSÃO REALIZADA!");
    }

    public void getTimeById() {
        System.out.println("Código: ");
        String timeId = sc.nextLine();
        Time timeEncontrado = times.getTime(timeId);

        if(timeEncontrado == null) System.out.println("TIME NÃO EXISTE!");
        else System.out.println(timeEncontrado);
    }

    public void criarCampeonato() {
        System.out.println("Campeonato: ");
        String nomeCampeonato = sc.nextLine();
        System.out.println("Participantes: ");
        int quantParticipantes = Integer.parseInt(sc.nextLine());

        campeonatos.adicionarCampeonato(nomeCampeonato, quantParticipantes);
        System.out.println("CAMPEONATO ADICIONADO!");
    }

    public void incluirTimeEmCampeonato() {
        System.out.println("(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato?");
        String subOpcao = sc.nextLine().toLowerCase();

        System.out.println("Código: ");
        String timeId = sc.nextLine();
        System.out.println("Campeonato: ");
        String nomeCampeonato = sc.nextLine();

        Campeonato campeonatoEncontrado = campeonatos.getCampeonato(nomeCampeonato);
        if(campeonatoEncontrado == null) throw new IllegalArgumentException("CAMPEONATO NÃO EXISTE!");

        Time timeEncontrado = times.getTime(timeId);
        if(timeEncontrado == null) throw new IllegalArgumentException("TIME NÃO EXISTE!");

        if(subOpcao.equals("i")) campeonatoEncontrado.inscreverTime(timeEncontrado);
        else if(subOpcao.equals("v")) {
            if(campeonatoEncontrado.timeJaInscrito(timeEncontrado)) System.out.println("O TIME ESTÁ NO CAMPEONATO!");
            else System.out.println("O TIME NÃO ESTÁ NO CAMPEONATO!");
        }
        else throw new IllegalArgumentException("OPÇÃO INVÁLIDA!");
    }

    public void exibirCampeonatosDeUmTime() {
        System.out.println("Time: ");
        String timeId = sc.nextLine();

        Time timeEcontrado = times.getTime(timeId);
        if(timeEcontrado == null) throw new IllegalArgumentException("TIME NÃO EXISTE!");

        Campeonato[] campeonatosDeQueParticipa = campeonatos.procurarRegistrosDeTimeEmCampeonatos(timeId);
        System.out.println("Campeonatos do " + timeEcontrado.getNome()+":");

        for(Campeonato campeonato : campeonatosDeQueParticipa) {
            System.out.println("* "+campeonato+" - "+campeonato.getQuantidadeParticipantes()+"/"+campeonato.getTotalDeVagasNoCampeonato());
        }
    }

    public void apostaHandler() {
        System.out.println("(A)Apostar ou (S)Status das Apostas?");
        String subOpcao = sc.nextLine().toLowerCase();

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

        if(subOpcao.equals("a")) {
            Time timeEncontrado = times.getTime(timeId);
            Campeonato campeonatoEncontrado = campeonatos.getCampeonato(nomeCampeonato);

            if(timeEncontrado == null) throw new IllegalArgumentException("TIME NÂO EXISTE!");
            if(campeonatoEncontrado == null) throw new IllegalArgumentException("CAMPEONATO NÃO EXISTE!");

            apostas.registrarAposta(timeEncontrado, campeonatoEncontrado, palpiteColocacao, valorAposta);
            System.out.println("APOSTA REGISTRADA!");
        }
        else if(subOpcao.equals("s")) System.out.println(apostas);
    }

}
