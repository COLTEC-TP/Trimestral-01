package br.ufmg.coltec.tp.moreaqui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

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
     */
    private void atualizarLista(ArrayList<Imovel> imoveis) {
        ListView imoveisList = findViewById(R.id.imoveisList);
        imoveisList.setAdapter(new ImoveisAdapter(this, imoveis));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                // executado enquanto texto é alterado pelo usuário

                ImovelDAO crud = ImovelDAO.getInstance();
                atualizarLista(crud.filtrarImoveis(s));

                return false;
            }
        });

        return true;
//        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.add:
                Intent adicionar = new Intent(MainActivity.this, NovoImovelActivity.class);
                startActivity(adicionar);
                ImovelDAO crud = ImovelDAO.getInstance();
                atualizarLista(crud.getImoveis());
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }
}
