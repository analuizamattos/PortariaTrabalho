package com.ninjasmockers.portaria_trabalho.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.ninjasmockers.portaria_trabalho.utils.Util;

import java.io.IOException;

public class DownloadTask extends AsyncTask<String, Void, Bitmap> {
    private ProgressDialog load;
    private ImageView imagem;
    private Context contexto;

    public DownloadTask(Context contexto, ImageView imagem) {
        this.imagem = imagem;
        this.contexto = contexto;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        try{
            return Util.baixarImagem(strings[0]);
        }catch (IOException e){
            Log.i("AsyncTask", e.getMessage());
        }
        return null;
    }

    @Override
    protected void onPreExecute(){
        load = ProgressDialog.show(contexto, "Por favor Aguarde ...",
                "Baixando Imagem ...");
    }

    @Override
    protected void onPostExecute(Bitmap bitmap){
        if(bitmap!=null) {
            imagem.setImageBitmap(bitmap);
        }
        load.dismiss();
    }
}
