package com.ninjasmockers.portaria_trabalho.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Util {

    public static Bitmap baixarImagem(String url) throws IOException {
        URL endereco;
        InputStream inputStream;
        Bitmap imagem;

        endereco = new URL(url);
        inputStream = endereco.openStream();
        imagem = BitmapFactory.decodeStream(inputStream);

        inputStream.close();

        return imagem;
    }

    public static String buscarPiada() throws IOException {
        String endereco = "https://api.chucknorris.io/jokes/random";

        URL url = new URL(endereco);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        StringBuffer buffer = new StringBuffer();
        String line = "";

        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        
        JSONObject mainObject = new JSONObject(buffer.toString());
        return mainObject.getJsonString("value");
    }
}
