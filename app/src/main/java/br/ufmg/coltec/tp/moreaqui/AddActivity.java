package br.ufmg.coltec.tp.moreaqui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AddActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        final TextView nome = findViewById(R.id.nome);
        final TextView endereco = findViewById(R.id.endereco);
        final TextView cidade = findViewById(R.id.cidade);
        final TextView valor = findViewById(R.id.valor);
        final TextView telefone = findViewById(R.id.telefone);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeS = nome.getText().toString();
                String enderecoS = endereco.getText().toString();
                String cidadeS = cidade.getText().toString();
                String valorS = valor.getText().toString();
                String telefoneS = telefone.getText().toString();

                if (nomeS.isEmpty() || enderecoS.isEmpty() || cidadeS.isEmpty() || valorS.isEmpty() || telefoneS.isEmpty()){
                    Toast.makeText(AddActivity.this, "Campos Vazios", Toast.LENGTH_SHORT).show();
                }
                else {
                    Imovel imovel = new Imovel(nomeS, enderecoS, cidadeS, Double.parseDouble(valorS), telefoneS);
                    ImovelDAO dao = ImovelDAO.getInstance();
                    dao.adicionarImovel(imovel);
                    Intent intent = new Intent(AddActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
