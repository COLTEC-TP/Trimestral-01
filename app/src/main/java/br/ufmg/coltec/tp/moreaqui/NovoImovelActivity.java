package br.ufmg.coltec.tp.moreaqui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NovoImovelActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_imovel);

        Button adicionar = findViewById(R.id.button);
        final EditText name = findViewById(R.id.nomeDoImovel);
        final EditText address = findViewById(R.id.enderecoDoImovel);
        final EditText city = findViewById(R.id.cidadeDoImovel);
        final EditText value = findViewById(R.id.valorDoImovel);
        final EditText phone = findViewById(R.id.telefoneDoImovel);


        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImovelDAO dao = ImovelDAO.getInstance();
                double value2 = Double.parseDouble(value.getText().toString());
                Imovel  novoImovel = new Imovel(name.getText().toString(), address.getText().toString(), city.getText().toString(), value2, phone.getText().toString());
                dao.adicionarImovel(novoImovel);
                Intent intent = new Intent(NovoImovelActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }


    }
