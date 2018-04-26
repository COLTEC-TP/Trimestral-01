package br.ufmg.coltec.tp.moreaqui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NovoImovelActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_imovel);

        final EditText nome = findViewById(R.id.novo_nome);
        final EditText endereco = findViewById(R.id.novo_endereco);
        final EditText cidade = findViewById(R.id.novo_cidade);
        final EditText valor = findViewById(R.id.novo_valor);
        final EditText telefone = findViewById(R.id.novo_telefone);

        Button botaoOk = findViewById(R.id.novo_botao);

        botaoOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Pegar as entradas de texto
                String n = nome.getText().toString();
                String e = endereco.getText().toString();
                String c = cidade.getText().toString();
                String v = valor.getText().toString();
                String t = telefone.getText().toString();

                //Verificar se tudo foi preenchido antes de cadastrar
                if(n.length()>0&&e.length()>0&&c.length()>0&&v.length()>0&&t.length()>0) {
                    ImovelDAO dao = ImovelDAO.getInstance();
                    dao.adicionarImovel(new Imovel(n,e,c,(double) Integer.parseInt(v),t));

                    finish(); //Finalizar essa atividade e assim voltar para a anterior
                }
                else {
                    Toast.makeText(NovoImovelActivity.this,"Por favor, preencha todos os campos",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
