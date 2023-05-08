package models;

import java.util.Objects;

public class Campeonato {
    private String nome;
    private Time[] timesParticipantes;

    public Campeonato(String nome, int quantParticipantes) {
        this.nome = nome;
        this.timesParticipantes = new Time[quantParticipantes];
    }

    public void inscreverTime(Time time) {
        if(timeJaInscrito(time)) throw new IllegalArgumentException("TIME JÁ ESTÁ NO CAMPEONATO");
        if(timesParticipantes[timesParticipantes.length-1] != null) {
            throw new Error("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!");
        }

        for(int i = 0; i < timesParticipantes.length; i++) {
            if(timesParticipantes[i] == null) {
                timesParticipantes[i] = time;
                return;
            }
        }
    }

    private boolean timeJaInscrito(Time time) {
        for(Time timeParticipante : timesParticipantes) {
            if(timeParticipante == null) return false;
            if(timeParticipante.equals(time)) return true;
        }
        return false;
    }

    public Time getTime(String id) {
        for(Time timeInscrito : timesParticipantes) {
            if(timeInscrito.getId().equals(id)) return timeInscrito;
        }
        return null;
    }

    public String getNome() { return this.nome; }

    public int hashCode() { return Objects.hash(nome); }
    
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(o.getClass() != this.getClass()) return false;

        Campeonato campeonatoDesconhecido = (Campeonato) o;
        return this.nome.equals(campeonatoDesconhecido.getNome());
    }
}
