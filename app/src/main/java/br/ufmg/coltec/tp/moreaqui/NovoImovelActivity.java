package br.ufmg.coltec.tp.moreaqui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NovoImovelActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_imovel);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true); //nao funciona

        final EditText lbl_add_nome = findViewById(R.id.lbl_add_nome);
        final EditText lbl_add_endereco = findViewById(R.id.lbl_add_endereco);
        final EditText lbl_add_cidade = findViewById(R.id.lbl_add_cidade);
        final EditText lbl_add_telefone = findViewById(R.id.lbl_add_telefone);
        final EditText lbl_add_valor = findViewById(R.id.lbl_add_valor);

        Button btn_adicionar = findViewById(R.id.btn_adicionar);

        btn_adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(lbl_add_nome.getText())){
                    lbl_add_nome.setError("Nome é obrigatório");
                }
                else if (TextUtils.isEmpty(lbl_add_cidade.getText())){
                    lbl_add_cidade.setError("Cidade é obrigatório");
                }
                else if (TextUtils.isEmpty(lbl_add_endereco.getText())){
                    lbl_add_endereco.setError("Endereço é obrigatório");
                }
                else if (TextUtils.isEmpty(lbl_add_valor.getText())){
                    lbl_add_valor.setError("Valor é obrigatório");
                }
                else if (TextUtils.isEmpty(lbl_add_telefone.getText())){
                    lbl_add_telefone.setError("Telefone é obrigatório");
                }
                else{

                    ImovelDAO.getInstance().adicionarImovel(new Imovel(lbl_add_nome.getText().toString(),lbl_add_endereco.getText().toString(),lbl_add_cidade.getText().toString(),Double.valueOf(lbl_add_valor.getText().toString()),lbl_add_telefone.getText().toString()));


                    Intent intent = new Intent(NovoImovelActivity.this, MainActivity.class);
                    finish();
                    startActivity(intent);
                }
            }

        });
    }
}
