package com.ninjasmockers.portaria_trabalho.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.ninjasmockers.portaria_trabalho.service.WebService;

import java.io.IOException;

public class JokeTask extends AsyncTask<String, Void, String> {
    private ProgressDialog load;
    private Context contexto;
    private TextView jokeText;

    public JokeTask(Context contexto, TextView jokeText) {
        this.contexto = contexto;
        this.jokeText = jokeText;
    }

    @Override
    protected String doInBackground(String... strings) {
        try{
            return WebService.buscarPiada();
        }catch (IOException e){
            Log.i("AsyncTask", e.getMessage());
        }
        return null;
    }

    @Override
    protected void onPreExecute(){
        load = ProgressDialog.show(contexto, "Por favor Aguarde ...",
                "Baixando dados da Chuck Norrias API ...");
    }

    @Override
    protected void onPostExecute(String piada){
        if(jokeText!=null) {
            jokeText.setText(piada);
        }
        load.dismiss();
    }
}
