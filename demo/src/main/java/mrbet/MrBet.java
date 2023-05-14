package mrbet;

import java.util.Scanner;

import mrbet.repositories.*;
import mrbet.models.*;

public class MrBet {
    Scanner sc = new Scanner(System.in);
    private final RepositorioApostas apostas = new RepositorioApostas();
    private final RepositorioCampeonatos campeonatos = new RepositorioCampeonatos();
    private final RepositorioTimes times = new RepositorioTimes();

    public void cadastrarTime(String timeId, String nomeTime, String mascote) {
        times.cadastrarTime(timeId, nomeTime, mascote);
        System.out.println("INCLUSÃO REALIZADA!");
    }

    public void getTimeById(String timeId) {
        Time timeEncontrado = times.getTime(timeId);

        if(timeEncontrado == null) throw new IllegalArgumentException("TIME NÃO EXISTE!");
        else System.out.println(timeEncontrado);
    }

    public void criarCampeonato(String nomeCampeonato, int quantParticipantes) {
        campeonatos.adicionarCampeonato(nomeCampeonato, quantParticipantes);
        System.out.println("CAMPEONATO ADICIONADO!");
    }

    public Campeonato getCampeonato(String nomeCapeonato) {
        return campeonatos.getCampeonato(nomeCapeonato);
    }

    public void incluirTimeEmCampeonato(String subOpcao, String timeId, String nomeCampeonato) {
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

    public void exibirCampeonatosDeUmTime(String timeId) {
        Time timeEcontrado = times.getTime(timeId);
        if(timeEcontrado == null) throw new IllegalArgumentException("TIME NÃO EXISTE!");

        Campeonato[] campeonatosDeQueParticipa = campeonatos.procurarRegistrosDeTimeEmCampeonatos(timeId);
        System.out.println("Campeonatos do " + timeEcontrado.getNome()+":");

        for(Campeonato campeonato : campeonatosDeQueParticipa) {
            System.out.println("* "+campeonato+" - "+campeonato.getQuantidadeParticipantes()+"/"+campeonato.getTotalDeVagasNoCampeonato());
        }
    }

    public void apostar(String timeId, String nomeCampeonato, int palpiteColocacao, double valorAposta) {
        Time timeEncontrado = times.getTime(timeId);
        Campeonato campeonatoEncontrado = campeonatos.getCampeonato(nomeCampeonato);

        if(timeEncontrado == null) throw new IllegalArgumentException("TIME NÂO EXISTE!");
        if(campeonatoEncontrado == null) throw new IllegalArgumentException("CAMPEONATO NÃO EXISTE!");

        apostas.registrarAposta(timeEncontrado, campeonatoEncontrado, palpiteColocacao, valorAposta);
        System.out.println("APOSTA REGISTRADA!");
    }

    public void relatorioDeApostas() {
        System.out.println(apostas);
    }

}
