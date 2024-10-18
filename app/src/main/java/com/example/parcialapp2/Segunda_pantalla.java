package com.example.parcialapp2;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Segunda_pantalla extends AppCompatActivity implements UsuarioAdaptador.OnUsuarioClickListener {

    RecyclerView rcv_usuarios;
    UsuarioAdaptador adaptador;
    List<Usuario> listaUsuarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_pantalla);

        rcv_usuarios = findViewById(R.id.rcv_usuarios);
        rcv_usuarios.setLayoutManager(new LinearLayoutManager(this));

        listaUsuarios.add(new Usuario("https://ih1.redbubble.net/image.4108176410.3851/flat,750x,075,f-pad,750x1000,f8f8f8.jpg", "Travis Scott", "Artist", "Cactus Jack"));
        listaUsuarios.add(new Usuario("https://i.pinimg.com/originals/5c/54/b9/5c54b968384c83550d26cf9bdcaf9f8f.jpg", "Drake", "Artist", "Champagne Papi"));
        listaUsuarios.add(new Usuario("https://images.fineartamerica.com/images/artworkimages/mediumlarge/3/jackboys-poster-oliver-jager.jpg", "Cristiano Ronaldo", "Futbolista", "El bicho"));

        adaptador = new UsuarioAdaptador(this, listaUsuarios, this);
        rcv_usuarios.setAdapter(adaptador);
    }

    @Override
    public void onUsuarioClick(Usuario usuario) {
        mostrarPerfil(usuario);
    }

    private void mostrarPerfil(Usuario usuario) {
        Toast.makeText(this, "Nombre: " + usuario.getNombre(), Toast.LENGTH_SHORT).show();
    }
}
