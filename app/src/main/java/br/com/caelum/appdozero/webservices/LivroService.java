package br.com.caelum.appdozero.webservices;

import java.util.List;

import br.com.caelum.appdozero.model.Livro;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by matheus on 03/11/16.
 */

public interface LivroService {

    @GET("listarLivros")
    public Call<List<Livro>> buscaLivros(@Query("indicePrimeiroLivro") int indice,
                                         @Query("qtdLivros") int qtd);
}
