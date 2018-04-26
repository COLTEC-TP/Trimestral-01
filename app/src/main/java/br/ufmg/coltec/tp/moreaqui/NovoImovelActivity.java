package br.ufmg.coltec.tp.moreaqui;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NovoImovelActivity extends Activity {

    private ImovelDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_imovel);

        dao = ImovelDAO.getInstance();

        Button btn = findViewById(R.id.add_submit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView id = findViewById(R.id.add_identificção);
                TextView endereço = findViewById(R.id.add_Endereço);
                TextView cidade = findViewById(R.id.add_cidade);
                TextView aluguel = findViewById(R.id.add_aluguel);
                TextView phone = findViewById(R.id.add_telefone);

                Imovel newImovel = new Imovel(id.getText().toString(), endereço.getText().toString(), cidade.getText().toString(), Double.parseDouble(aluguel.getText().toString()), phone.getText().toString());

                dao.adicionarImovel(newImovel);

                NovoImovelActivity.this.finish();
            }
        });
    }
}
