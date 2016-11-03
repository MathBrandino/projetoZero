package br.com.caelum.appdozero.events;

import java.util.List;

import br.com.caelum.appdozero.model.Livro;

/**
 * Created by matheus on 03/11/16.
 */
public class LivrosEvent {
    public List<Livro> livros;

    public LivrosEvent(List<Livro> livros) {

        this.livros = livros;
    }
}
