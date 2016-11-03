package br.com.caelum.appdozero.webservices;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import br.com.caelum.appdozero.converter.LivroServiceConverterFactory;
import br.com.caelum.appdozero.events.LivrosEvent;
import br.com.caelum.appdozero.model.Livro;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by matheus on 03/11/16.
 */

public class WebClient {

    public void buscaLivros(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://cdcmob.herokuapp.com/")
                .addConverterFactory(new LivroServiceConverterFactory())
                .build();

        LivroService livroService = retrofit.create(LivroService.class);

        Call<List<Livro>> call = livroService.buscaLivros(0, 10 );

        call.enqueue(new Callback<List<Livro>>() {
            @Override
            public void onResponse(Call<List<Livro>> call, Response<List<Livro>> response) {

                List<Livro> livros = response.body();
                EventBus.getDefault().post(new LivrosEvent(livros));
            }

            @Override
            public void onFailure(Call<List<Livro>> call, Throwable t) {

            }
        });


    }
}
