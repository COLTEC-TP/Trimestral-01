package br.ufmg.coltec.tp.moreaqui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NovoImovelActivity extends AppCompatActivity {


    EditText qNome, qEndereco, qCidade, qValor, qTelefone;
    Button btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_imovel);
        qNome = (EditText) findViewById(R.id.Nomeq);
        qEndereco = (EditText) findViewById(R.id.Enderecoq);
        qCidade = (EditText) findViewById(R.id.Cidadeq);
        qValor = (EditText) findViewById(R.id.Valorq);
        qTelefone = (EditText) findViewById(R.id.Telefoneq);
        btnAdd = (Button) findViewById(R.id.btnAdd);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fNome = qNome.getText().toString();
                String fEndereco = qEndereco.getText().toString();
                String fCidade = qCidade.getText().toString();
                String fValor = qValor.getText().toString();
                String fTelefone = qTelefone.getText().toString();
                if (fTelefone.length() != 0 || fNome.length() != 0 || fEndereco.length() != 0 || fCidade.length() != 0 || fValor.length() != 0) {
                    qTelefone.setText("");
                    qValor.setText("");
                    qCidade.setText("");
                    qEndereco.setText("");
                    qNome.setText("");

                    //Chama a activity de listar filmes
                    Intent intent = new Intent(NovoImovelActivity.this, ImovelDAO.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(NovoImovelActivity.this, "You must put something in the text field!", Toast.LENGTH_LONG).show();
                    Imovel c = new Imovel(fNome, fEndereco, fCidade, fValor, fTelefone);
                    ImovelDAO daw = ImovelDAO.getInstance();
                    daw.adicionarImovel(c);
                }
            }
        });

    }
}

