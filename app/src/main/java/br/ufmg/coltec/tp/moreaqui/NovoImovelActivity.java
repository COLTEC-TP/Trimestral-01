package br.ufmg.coltec.tp.moreaqui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by bryans on 26/04/18.
 */

public class NovoImovelActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adicionar_imovel);

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // infla menu na tela
        getMenuInflater().inflate(R.menu.menu_adicionar, menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // recupera id do item selecionado
        int id = item.getItemId();

        // recupera dados digitados
        TextView nome = findViewById(R.id.name);
        TextView valor = findViewById(R.id.price);
        TextView endereco = findViewById(R.id.address);
        TextView cidade = findViewById(R.id.city);
        TextView telefone = findViewById(R.id.phone);
        
        Double preco = Double.parseDouble(valor.getText().toString());
        
        ImovelDAO imovelDAO = ImovelDAO.getInstance();

        // verifica qual é o botão selecionado com base no id
        switch (id) {
            case R.id.action_done:
                Imovel novoImovel = new Imovel(nome.getText().toString(),endereco.getText().toString(),cidade.getText().toString(),preco,telefone.getText().toString());
                imovelDAO.adicionarImovel(novoImovel);
                finish();
                Toast.makeText(this,"Imóvel Adicionado",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_back:
                finish();   // Ta fechando o aplicativo :c
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
