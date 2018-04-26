package br.ufmg.coltec.tp.moreaqui;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class NovoImovelActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_imovel);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ff")));

        final EditText nome = findViewById(R.id.txt_nome);
        final EditText valor = findViewById(R.id.txt_valor);
        final EditText cidade = findViewById(R.id.txt_cidade);
        final EditText endereco = findViewById(R.id.txt_endereco);
        final EditText telefone = findViewById(R.id.txt_telefone);

        Button btn = findViewById(R.id.btn_add);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Verifica se os campos estão preenchidos //
                if (TextUtils.isEmpty(nome.getText())){
                    nome.setError("preencha o nome");
                }else if (TextUtils.isEmpty(valor.getText())){
                    //valor.setError(getString(R.string.toastGeneroObrigatorio));
                    valor.setError("preencha o valor");
                }else if (TextUtils.isEmpty(cidade.getText())){
                    //valor.setError(getString(R.string.toastGeneroObrigatorio));
                    cidade.setError("preencha o valor");
                }else if (TextUtils.isEmpty(endereco.getText())){
                    //valor.setError(getString(R.string.toastGeneroObrigatorio));
                    endereco.setError("preencha o valor");
                }else if (TextUtils.isEmpty(telefone.getText())) {
                    //valor.setError(getString(R.string.toastGeneroObrigatorio));
                    telefone.setError("preencha o valor");
                }else {
                    // Cria e adiciona o imóvel //
                    Imovel newImovel = new Imovel(nome.getText().toString(), endereco.getText().toString(), cidade.getText().toString(), Double.parseDouble(valor.getText().toString()), telefone.getText().toString());
                    ImovelDAO dao = ImovelDAO.getInstance();
                    dao.adicionarImovel(newImovel);

                    // Encerra a activity //
                    finish();
                }
            }
        });
    }
}
