package br.ufmg.coltec.tp.moreaqui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {


    private ImoveisAdapter imoveisAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // recupera os imóveis cadastrados no DAO até o momento e os carrega na lista
        ImovelDAO dao = ImovelDAO.getInstance();
        this.atualizarLista(dao.getImoveis());

    }

    @Override
    protected void onResume() {
        super.onResume();
        // recupera os imóveis cadastrados no DAO até o momento e os carrega na lista
        ImovelDAO dao = ImovelDAO.getInstance();
        this.atualizarLista(dao.getImoveis());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // infla menu na tela
        getMenuInflater().inflate(R.menu.menu_main, menu);

        /* *** Não faz a busca, tentei de tudo *** */

        // busca pelo SearchView e customiza suas ações
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ImovelDAO dao = ImovelDAO.getInstance();
                ArrayList<Imovel> filtrados = dao.filtrarImoveis(s);
                atualizarLista(filtrados);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // recupera id do item selecionado
        int id = item.getItemId();

        // verifica qual é o botão selecionado com base no id
        switch (id) {
            case R.id.action_add:
                Intent intent = new Intent(MainActivity.this, NovoImovelActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Método auxiliar para atualizar a ListView. Utilizar quando os dados da lista
     * são atualizados
     *
     * @param imoveis lista que será enviada ao adapter
     */
    private void atualizarLista(ArrayList<Imovel> imoveis) {

        ListView imoveisList = findViewById(R.id.imoveisList);

        if (imoveisAdapter == null) {
            imoveisAdapter = new ImoveisAdapter(this, imoveis);
            imoveisList.setAdapter(imoveisAdapter);
        } else {
            imoveisAdapter.notifyDataSetChanged();
        }

    }
}
