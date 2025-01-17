package mrbet.repositories;

import java.util.Set;
import java.util.HashSet;

import mrbet.models.Campeonato;

public class RepositorioCampeonatos {
    private Set<Campeonato> campeonatos = new HashSet<Campeonato>();

    public void adicionarCampeonato(String nome, int quantParticipantes) {
        if(campeonatoJaExiste(nome)) throw new IllegalArgumentException("CAMPEONATO JÁ EXISTE!");

        Campeonato novoCampeonato = new Campeonato(nome, quantParticipantes);
        campeonatos.add(novoCampeonato);
    }

    public boolean campeonatoJaExiste(String nome) {
        for(Campeonato campeonato : campeonatos) {
            if(campeonato.getNome().equals(nome)) return true;
        }
        return false;
    }

    public Campeonato getCampeonato(String nomeCampeonato) {
        for(Campeonato campeonato : campeonatos) {
            if(campeonato.getNome().equals(nomeCampeonato)) return campeonato;
        }
        return null;
    }

    public Campeonato[] procurarRegistrosDeTimeEmCampeonatos(String idTime) {
        Campeonato[] campeonatosDeQueParticipa = new Campeonato[campeonatos.size()];
        int contador = 0;

        for(Campeonato campeonato : campeonatos) {
            if(campeonato.getTime(idTime) != null) campeonatosDeQueParticipa[contador] = campeonato;
            contador++;
        }

        if(campeonatosDeQueParticipa[0] == null) return null;
        return campeonatosDeQueParticipa;
    }
}
