package br.ufmg.coltec.tp.moreaqui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaAdicionar extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_adicionar);

        Button add = findViewById(R.id.botaoAdd);
        final EditText nome = findViewById(R.id.addNome);
        final EditText endereco = findViewById(R.id.addEndereco);
        final EditText cidade = findViewById(R.id.addCidade);
        final EditText valor = findViewById(R.id.addValor);
        final EditText telefone = findViewById(R.id.addTelefone);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImovelDAO dao = ImovelDAO.getInstance();
                double newvalor = Double.parseDouble(valor.getText().toString());
                Imovel  novoImovel = new Imovel(nome.getText().toString(), endereco.getText().toString(), cidade.getText().toString(), newvalor, telefone.getText().toString());
                dao.adicionarImovel(novoImovel);
                Intent intent = new Intent(TelaAdicionar.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
