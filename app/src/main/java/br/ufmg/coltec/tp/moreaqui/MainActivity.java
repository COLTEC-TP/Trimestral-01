package br.ufmg.coltec.tp.moreaqui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity {

    static final int CODE = 1;

    private void newId(){
        Intent intent = new Intent(MainActivity.this,ImovelDAO.class);
        startActivityForResult(intent, CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);// Check which request we're responding to
        if (requestCode == CODE) {
            if (resultCode == RESULT_OK) {
                Imovel imovel = new Imovel(null,null,null,null,null);
                imovel.setNome(data.getStringExtra("nome"));
                imovel.setEndereco(data.getStringExtra("endereco"));
                imovel.setValor(data.getStringExtra("000,00 BRL"));
                imovel.setCidade(data.getStringExtra("cidade"));
                imovel.setTelefone(data.getStringExtra("tel"));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_lista,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        switch (id){
            case R.id.menu_add:
                newId();
                return true;
            case R.id.action_exit:
                finishAffinity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // recupera os imóveis cadastrados no DAO até o momento e os carrega na lista
        ImovelDAO dao = ImovelDAO.getInstance();
        this.atualizarLista(dao.getImoveis());
    }

    /**
     * Método auxiliar para atualizar a ListView. Utilizar quando os dados da lista
     * são atualizados
     *
     * OBS: INEFICIENTE. NÃO FAÇAM ISSO EM CASA :)
     *
     * @param imoveis lista que será enviada ao adapter


    private void atualizarLista(ArrayList<Imovel> imoveis) {
        ListView imoveisList = findViewById(R.id.imoveisList);
        imoveisList.setAdapter(new ImoveisAdapter(this, imoveis));
    }
}

    */
    }

