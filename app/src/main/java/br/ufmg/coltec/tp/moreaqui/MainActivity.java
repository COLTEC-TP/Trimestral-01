package br.ufmg.coltec.tp.moreaqui;

import android.app.ActionBar;
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
    private ImoveisAdapter adapter;
    private ImovelDAO dao;
    private ListView imoveisList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // recupera os imóveis cadastrados no DAO até o momento e os carrega na lista
        dao = ImovelDAO.getInstance();

        imoveisList = findViewById(R.id.imoveisList);
        adapter = new ImoveisAdapter(this, dao.getImoveis());
        imoveisList.setAdapter(adapter);
        this.atualizarLista();

        ActionBar actionBar = getActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // infla menu na tela
        getMenuInflater().inflate(R.menu.actionbar_main, menu);

        MenuItem item = menu.findItem(R.id.search_bar);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                // executado enquanto texto é alterado pelo usuário
                ArrayList<Imovel> filtro = MainActivity.this.dao.filtrarImoveis(s);
                adapter = new ImoveisAdapter(MainActivity.this,filtro);
                imoveisList.setAdapter(adapter);
                MainActivity.this.atualizarLista();
                return false;
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
            case R.id.add:
                Intent intent = new Intent(MainActivity.this,NovoImovelActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void atualizarLista() {

        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.atualizarLista();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        this.atualizarLista();
    }
}
