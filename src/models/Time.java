package models;

import java.util.Objects;;

public class Time {
    private String id;
    private String nome;
    private String mascote;

    public Time(String id, String nome, String mascote) {
        this.id = id;
        this.nome = nome;
        this.mascote = mascote;
    }

    public String getId() { return this.id; }

    public String getNome() { return this.nome; }

    public String getMascote() { return this.mascote; }

    public boolean equals(Object generic) {
        if(this == generic) return true;
        if(generic == null) return false;
        if(generic.getClass() != this.getClass()) return false;

        Time timeDesconhecido = (Time) generic;
        return this.id.equals(timeDesconhecido.getId());
    }

    public int  hashCode() {
        return Objects.hash(this.id);
    }
}