package br.ufmg.coltec.tp.moreaqui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ImoveisAdapter mAdapter;
    private ListView mImoveisList;
    private ArrayList<Imovel> mImoveis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // recupera os imóveis cadastrados no DAO até o momento e os carrega na lista
         mImoveisList = findViewById(R.id.imoveisList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ImovelDAO dao = ImovelDAO.getInstance();
        this.atualizarLista(dao.getImoveis());
    }


    /**
     * Método auxiliar para atualizar a ListView. Utilizar quando os dados da lista
     * são atualizados
     *
     * OBS: INEFICIENTE. NÃO FAÇAM ISSO EM CASA :)
     * Agora pode fazer kk :) Ficou legal!!!
     *
     * @param imoveis lista que será enviada ao adapter
     */
    private void atualizarLista(ArrayList<Imovel> imoveis) {
        if (mImoveis == null)
            mImoveis = new ArrayList<Imovel>();

            // Limpa a sua lista de livros e adiciona todos os registros da lista temporária
            mImoveis.clear();
            mImoveis.addAll(imoveis);

        // Se o adapter for null, cria o adapter, se não notifica que seu dataset teve alteração (No seu caso a lista de livros).
        if (mAdapter == null) {
            mAdapter = new ImoveisAdapter(this, mImoveis);
            mImoveisList.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search_property);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ImovelDAO dao = ImovelDAO.getInstance();
                atualizarLista(dao.filtrarImoveis(s));
                if (mAdapter.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.toast_adapter_null, Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_add_property:
                Intent intent = new Intent(MainActivity.this, NovoImovelActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onMenuItemSelected(featureId, item);
        }

    }
}
