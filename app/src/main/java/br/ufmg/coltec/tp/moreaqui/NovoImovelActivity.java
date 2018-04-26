package br.ufmg.coltec.tp.moreaqui;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class NovoImovelActivity extends AppCompatActivity {



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_novo_imovel);

            android.support.v7.app.ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_layout, menu);

////////////////////////////////////
            final   MenuItem item = menu.findItem(R.id.action_search);
            SearchView searchView = (SearchView) item.getActionView();
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

                // /////////////////////////////////////////       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override

                public boolean onQueryTextSubmit(String s) {
                    Toast.makeText(NovoImovelActivity.this, "Buscar : " + s, Toast.LENGTH_SHORT).show();
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    return false;
                }
            });

            MenuItem share = menu.findItem(R.id.action_share);
//
//            ShareActionProvider mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(share);
//
//            Intent intent = new Intent(Intent.ACTION_SEND);
//            mShareActionProvider.setShareIntent(intent);

            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();

            switch (id) {
                case R.id.config:
                    Toast.makeText(
                            this, "Configurações", Toast.LENGTH_SHORT).show();
                    return true;
                ////////////////////////////

                case R.id.action_refresh:
                    Toast.makeText(this, "Atualizar", Toast.LENGTH_SHORT).show();
                    return true;

                ////////////////////////////

                case R.id.action_share:
                    Toast.makeText(this, "Compartilhar", Toast.LENGTH_SHORT).show();
                    return true;

                ////////////////////////////

                case R.id.about:
                    Toast.makeText(this, " Sobre", Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(NovoImovelActivity.this);
                    alertBuilder.setTitle("Informções do aplicativo");
                    alertBuilder.setMessage("Desenvolvido Por: Dellareti\nCopyright © Disney");

                    AlertDialog dialog = alertBuilder.create();
                    dialog.show();
                    return true;

                ////////////////////////////
                case R.id.sair:
                    finishAffinity();
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }



        ////////////   Dados do formulário

        Button btn = findViewById(R.id.add);
        final EditText Nome = findViewById(R.id.Nome);
        final EditText Endereco = findViewById(R.id.Endereco);
//        final EditText Valor = findViewById(R.id.Valor);
        final EditText Telefone = findViewById(R.id.Telefone);
        final EditText Cidade = findViewById(R.id.Cidade);
        
    }
