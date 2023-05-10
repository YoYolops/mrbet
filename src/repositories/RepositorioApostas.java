package repositories;

import java.util.ArrayList;

import models.*;

public class RepositorioApostas {
    private ArrayList<Aposta> apostas = new ArrayList<Aposta>();

    public void registrarAposta(Time time, Campeonato campeonato, int colocacao, double valor) {
        if(!campeonato.timeJaInscrito(time)) throw new IllegalArgumentException("O TIME NÃO ESTÁ NESSE CAMPEONATO");
        Aposta novaAposta = new Aposta(time, campeonato, colocacao, valor);
        apostas.add(novaAposta);
    }
    
}
