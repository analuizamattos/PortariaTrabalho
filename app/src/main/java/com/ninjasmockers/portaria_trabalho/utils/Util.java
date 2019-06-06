package com.ninjasmockers.portaria_trabalho.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
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
        InputStream stream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        StringBuffer buffer = new StringBuffer();
        String line;

        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        try {
            JSONObject mainObject = new JSONObject(buffer.toString());
            return mainObject.getString("value");
        } catch (Exception e) {
            return null;
        }
    }
}
