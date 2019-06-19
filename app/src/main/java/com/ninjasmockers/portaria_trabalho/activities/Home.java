package com.ninjasmockers.portaria_trabalho.activities;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.ninjasmockers.portaria_trabalho.R;

public class Home extends AppCompatActivity implements View.OnDragListener, View.OnLongClickListener {
    private FirebaseAuth autenticacao;

   // private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    //private DatabaseReference usuarios = referencia.child("usuarios");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btn = findViewById(R.id.dragButton);
        btn.setTag("DRAGGABLE BUTTON");
        btn.setOnLongClickListener(this);
        findViewById(R.id.recyclerView).setOnDragListener(this);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        ((RecyclerView)findViewById(R.id.recyclerView)).setLayoutManager(manager);
        /*referencia.child("pontos").setValue("100");
        referencia.child("produtos").child("001").child("descricao").setValue("IfoneX");



*/
        //Usuario usuario = new Usuario("Douglas", "Angelo");

        //referencia.child("usuarios").push().setValue(usuario);

    }

    protected void inserir(View view) {
        startActivity(new Intent(this, CadastroVisitante.class));
    }

    protected void sair(View view) {
        startActivity(new Intent(this, MainActivity.class));
        //autenticacao.signOut();
    }

    @Override
    public boolean onLongClick(View v) {
        ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
        ClipData data = new ClipData(v.getTag().toString(), mimeTypes, item);
        View.DragShadowBuilder dragShadow = new View.DragShadowBuilder(v);
        v.startDrag(data, dragShadow, v, 0);
        return true;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        int action = event.getAction();
        switch (action) {

            case DragEvent.ACTION_DRAG_STARTED:
                return event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN);

            case DragEvent.ACTION_DRAG_ENTERED:
                v.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);
                v.invalidate();
                return true;

            case DragEvent.ACTION_DRAG_LOCATION:
                return true;

            case DragEvent.ACTION_DRAG_EXITED:
                v.getBackground().clearColorFilter();
                v.invalidate();
                return true;

            case DragEvent.ACTION_DROP:
                ClipData.Item item = event.getClipData().getItemAt(0);
                String dragData = item.getText().toString();
                Toast.makeText(this, "Objeto pego é " + dragData, Toast.LENGTH_SHORT).show();
                v.getBackground().clearColorFilter();
                v.invalidate();

                View vw = (View) event.getLocalState();
                ViewGroup container = (RecyclerView) v;

                if(vw.getParent() != null) {
                    ((ViewGroup)vw.getParent()).removeView(vw);
                }
                container.addView(vw);
                vw.setVisibility(View.VISIBLE);
                return true;

            case DragEvent.ACTION_DRAG_ENDED:
                v.getBackground().clearColorFilter();
                v.invalidate();
                if (event.getResult())
                    Toast.makeText(this, "Objeto reposicionado com sucesso.", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "Falha ao soltar.", Toast.LENGTH_SHORT).show();
                return true;
            default:
                Log.e("DragDrop", "Ação desconhecida.");
                break;
        }
        return false;
    }
}
