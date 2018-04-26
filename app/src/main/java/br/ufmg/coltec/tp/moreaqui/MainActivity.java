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

        //Atualizar a lista sempre
        ImovelDAO dao = ImovelDAO.getInstance();
        this.atualizarLista(dao.getImoveis());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);

        MenuItem item = menu.findItem(R.id.menu_filtro);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                ArrayList<Imovel> listaFiltrada = ImovelDAO.getInstance().filtrarImoveis(s);
                atualizarLista(listaFiltrada);
                if(listaFiltrada.isEmpty()) Toast.makeText(MainActivity.this,getString(R.string.notFound),Toast.LENGTH_SHORT).show();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                atualizarLista(ImovelDAO.getInstance().getImoveis());
                return false;
            }
        });

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_cadastrar:
                startActivity(new Intent(MainActivity.this,NovoImovelActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
}
