package br.ufmg.coltec.tp.moreaqui;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class NovoImovelActivity extends Activity {

    private EditText nome;
    private EditText endereco;
    private EditText cidade;
    private EditText telefone;
    private EditText valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_imovel);

        nome = findViewById(R.id.nome);
        endereco = findViewById(R.id.endereco);
        cidade = findViewById(R.id.cidade);
        telefone = findViewById(R.id.telefone);
        valor = findViewById(R.id.valor);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_novo_imovel, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id) {
            case R.id.save:
                String nome = this.nome.getText().toString();
                String endereco = this.endereco.getText().toString();
                String cidade = this.cidade.getText().toString();
                String telefone = this.telefone.getText().toString();
                Double valor = Double.parseDouble( this.valor.getText().toString() );

                ImovelDAO crud = ImovelDAO.getInstance();
                crud.adicionarImovel( new Imovel(nome, endereco, cidade, valor, telefone) );
                finish();
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }
}
