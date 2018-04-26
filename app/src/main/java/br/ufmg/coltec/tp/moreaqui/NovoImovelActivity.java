package br.ufmg.coltec.tp.moreaqui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NovoImovelActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_imovel);


        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Button btn = findViewById(R.id.save);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nome = findViewById(R.id.nome);
                EditText end = findViewById(R.id.end);
                EditText cidade = findViewById(R.id.cidade);
                EditText valor = findViewById(R.id.valor);
                EditText tel = findViewById(R.id.tel);

                String nomeTxt = nome.getText().toString();
                String endTxt = end.getText().toString();
                String cidadeTxt = cidade.getText().toString();

                Double valorTxt = 0.0;

                if(!valor.getText().toString().equals(""))
                    valorTxt =  Double.valueOf(valor.getText().toString());

                String telTxt = tel.getText().toString();


                //Adiciona ao banco de dados

                ImovelDAO dao = ImovelDAO.getInstance();
                dao.adicionarImovel(new Imovel(nomeTxt, endTxt, cidadeTxt, valorTxt, telTxt));
                finish();
            }
        });
    }

    
}
