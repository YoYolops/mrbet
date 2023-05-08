package repositories;

import java.util.HashSet;
import java.util.Set;

import models.Time;

public class RepositorioTimes {
    private Set<Time> times = new HashSet<Time>();

    public void cadastrarTime(String id, String nome, String mascote) {
        Time novoTime = new Time(id, nome, mascote);
        if(times.contains(novoTime)) {
            throw new IllegalArgumentException("TIME JÁ EXISTE!");
        }
        times.add(novoTime);
    }

    
}
