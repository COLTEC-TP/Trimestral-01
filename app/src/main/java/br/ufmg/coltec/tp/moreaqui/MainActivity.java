package br.ufmg.coltec.tp.moreaqui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private  static ImoveisAdapter imoveisAdapter;
    private List<Imovel> imovelList;
    ImovelDAO dao = ImovelDAO.getInstance();

    private void getImovel() {

        List<Imovel> tempList = dao.getImoveis();


        if (imovelList == null)
            imovelList = new ArrayList<Imovel>();


        imovelList.clear();
        imovelList.addAll(tempList);


        if (imoveisAdapter == null) {
            imoveisAdapter = new ImoveisAdapter(this, (ArrayList<Imovel>) imovelList);
            imPrincipal.setAdapter(imoveisAdapter);
        } else {
            imoveisAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.getImovel();
    }

    ListView imPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // recupera os imóveis cadastrados no DAO até o momento e os carrega na lista
        ImovelDAO dao = ImovelDAO.getInstance();
        this.atualizarLista(dao.getImoveis());
        imPrincipal = findViewById(R.id.imoveisList);
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

    private List<Imovel> imovelList2;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // infla menu na tela
        getMenuInflater().inflate(R.menu.menu_main, menu);

//        // busca pelo SearchView e customiza suas ações
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                ImovelDAO dao = ImovelDAO.getInstance();
                imovelList2 = dao.filtrarImoveis(s);
                ImoveisAdapter imoveisAdapter2 = new ImoveisAdapter(MainActivity.this, (ArrayList<Imovel>) imovelList2);
                imPrincipal.setAdapter(imoveisAdapter2);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                // executado enquanto texto é alterado pelo usuário
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // recupera id do item selecionado
        int id = item.getItemId();

        // verifica qual é o botão selecionado com base no id
        switch (id) {
            case R.id.action_add:
                Intent intent = new Intent(MainActivity.this, TelaAdicionar.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
