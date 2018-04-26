package br.ufmg.coltec.tp.moreaqui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class adicionarImovel extends Activity {

    EditText Nome, Endereco, Cidade, Valor, Telefone;
    Button botaoAdicionarImovel;
    Imovel CadastrarDadosDoImovel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_imovel);

        Nome = (EditText) findViewById(R.id.Nome);
        Endereco = (EditText) findViewById(R.id.Endereco);
        Cidade = (EditText) findViewById(R.id.Cidade);
        Valor = (EditText) findViewById(R.id.Valor);
        Telefone = (EditText) findViewById(R.id.Telefone);
        botaoAdicionarImovel = (Button) findViewById(R.id.botaoAdicionarImovel);


        botaoAdicionarImovel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fNome = Nome.getText().toString();
                String fEndereco = Endereco.getText().toString();
                String fCidade = Cidade.getText().toString();
                Double fValor = Double.parseDouble(Valor.getText().toString());
                String fTelefone = Valor.getText().toString();

                CadastrarDadosDoImovel = new Imovel(fNome, fEndereco, fCidade, fValor,fTelefone);

                ImovelDAO dao = ImovelDAO.getInstance();
                dao.adicionarImovel(CadastrarDadosDoImovel);

                //Voltar para a tela inicial
                Intent intent = new Intent(adicionarImovel.this, MainActivity.class);
                startActivity(intent);


            }
        });

    }


}
