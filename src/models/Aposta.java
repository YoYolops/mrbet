package models;

public class Aposta {
    private Time time;
    private Campeonato campeonato;
    private int palpiteColocacao;
    private double valor;

    public Aposta(Time time, Campeonato campeonato, int colocacao, double valor) {
        this.time = time;
        this.campeonato = campeonato;
        this.palpiteColocacao = colocacao;
        this.valor = valor;
    }

    public String toString() {
        return 
            time.toString()+"\n"+
            campeonato.toString()+"\n"+
            this.palpiteColocacao+"/"+campeonato.getTotalDeVagasNoCampeonato()+"\n"+
            "R$ "+valor+"\n";
    }
}
