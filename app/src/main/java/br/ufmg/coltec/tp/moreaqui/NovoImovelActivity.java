package br.ufmg.coltec.tp.moreaqui;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NovoImovelActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_imovel);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Button enviar = findViewById(R.id.btnOk);
        final EditText nome = findViewById(R.id.nome);
        final EditText cidade = findViewById(R.id.cidade);
        final EditText endereco = findViewById(R.id.endereco);
        final EditText valor = findViewById(R.id.valor);
        final double v = Double.parseDouble(valor.toString());
        final EditText tel = findViewById(R.id.telefone);

        enviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ImovelDAO dao = ImovelDAO.getInstance();

                dao.adicionarImovel(new Imovel(nome.toString(),
                        cidade.toString(),
                        endereco.toString(),
                        v,
                        tel.toString())
                );
            }
        });
    }
}
