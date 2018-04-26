package br.ufmg.coltec.tp.moreaqui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.ShareActionProvider;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends Activity {

    public static ListView imoveisList;
    private ImoveisAdapter adapter;
    ArrayList<Imovel> imoveisArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imoveisList = findViewById(R.id.imoveisList);

        ImovelDAO dao = ImovelDAO.getInstance();
        this.atualizarLista(dao.getImoveis());
    }

    public void atualizarLista(ArrayList<Imovel> imoveis) {

        if(imoveisArray == null){
            imoveisArray = new ArrayList<>();
        }

        imoveisArray.clear();
        imoveisArray.addAll(imoveis);

        if (adapter == null) {
            adapter = new ImoveisAdapter(this, imoveisArray);
            imoveisList.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
        imoveisList.refreshDrawableState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem addItem = menu.findItem(R.id.add);
        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        addItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
                return true;
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(s.isEmpty()){
                    atualizarLista(ImovelDAO.getInstance().getImoveis());
                    return false;
                }
                else {
                    atualizarLista(ImovelDAO.getInstance().filtrarImoveis(s));
                    return false;
                }
            }
        });

        return true;
    }

}
