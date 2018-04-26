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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        final ImovelDAO dao = ImovelDAO.getInstance();

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                atualizarLista(dao.filtrarImoveis(s.toLowerCase()));
                if((dao.filtrarImoveis(s.toLowerCase()).size()) == 0){
                    Toast.makeText(MainActivity.this, getResources().getText(R.string.error), Toast.LENGTH_SHORT).show();
                    atualizarLista(dao.getImoveis());
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                // executado enquanto texto é alterado pelo usuário
                return false;
            }

        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {

            @Override
            public boolean onClose() {
                atualizarLista(dao.getImoveis());
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        final ImovelDAO dao = ImovelDAO.getInstance();
        int id = item.getItemId();
        switch (id) {
            case R.id.action_add:
                Intent intent = new Intent(MainActivity.this, NovoImovelActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void onResume(){
        super.onResume();
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

        if (imoveisAdapter == null) {
            imoveisAdapter = new ImoveisAdapter(this, imoveis);
            imoveisList.setAdapter(imoveisAdapter);
        } else {
            imoveisAdapter.notifyDataSetChanged();
        }
    }
}
