package br.ufmg.coltec.tp.moreaqui;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NovoImovelActivity extends Activity {

    EditText nome;
    EditText endereco;
    EditText cidade;
    EditText telefone;
    EditText valor;
    Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_imovel);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        nome = findViewById(R.id.name);
        endereco = findViewById(R.id.address);
        cidade = findViewById(R.id.city);
        telefone = findViewById(R.id.phone);
        valor = findViewById(R.id.value);
        botao = findViewById(R.id.confirm);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome1 = nome.getText().toString();
                String endereço1 = endereco.getText().toString();
                String cidade1 = cidade.getText().toString();
                String telefone1 = telefone.getText().toString();
                Double valor1;
                if(valor.getText().toString().equals("")){
                    valor1 = 0.0;
                }
                else{
                    valor1 = Double.parseDouble(valor.getText().toString());
                }

                //Adiciona ao banco de dados
                ImovelDAO dao = ImovelDAO.getInstance();
                dao.adicionarImovel(new Imovel(nome1, endereço1, cidade1, valor1, telefone1));
                finish();
            }
        });
    }
}
