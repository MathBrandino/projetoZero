package br.com.caelum.appdozero.converter;


import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.appdozero.model.Livro;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by matheus on 29/06/16.
 */
public class LivroServiceConverter implements Converter<ResponseBody, List<Livro>> {

    @Override
    public List<Livro> convert(ResponseBody value) throws IOException {
        try {
            String json = value.string();
            LivroConverter livroConverter = new LivroConverter();

            List<Livro> livros = livroConverter.fromJson(json);
            return livros;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}