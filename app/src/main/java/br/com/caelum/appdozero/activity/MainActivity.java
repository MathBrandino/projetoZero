package br.com.caelum.appdozero.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.appdozero.R;
import br.com.caelum.appdozero.events.LivrosEvent;
import br.com.caelum.appdozero.model.Livro;
import br.com.caelum.appdozero.webservices.WebClient;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private List<Livro> livros = new ArrayList<>();
    private ArrayAdapter<Livro> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // poderia usar o butterknife para find da view


        lista = (ListView) findViewById(R.id.lista_livros);
        adapter = new ArrayAdapter<Livro>(this, android.R.layout.simple_list_item_1, livros);
        lista.setAdapter(adapter);

        new WebClient().buscaLivros();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void recebeListagem(LivrosEvent event) {
        List<Livro> listagemLivrosServidor = event.livros;
        livros.addAll(listagemLivrosServidor);
        adapter.notifyDataSetChanged();
    }
}
