package br.ufmg.coltec.tp.moreaqui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Adapter responsável por carregar os imóveis na lista
 */
public class ImoveisAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Imovel> imoveis;

    public ImoveisAdapter(Context context, ArrayList<Imovel> imoveis) {
        this.context = context;

        this.imoveis = imoveis;
    }

    @Override
    public int getCount() {
        return imoveis.size();
    }

    @Override
    public Object getItem(int i) {
        return imoveis.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Imovel imovel = (Imovel) this.getItem(i);

        // Mecanismo de estilização da lista //
        View newView = LayoutInflater.from(this.context).inflate(R.layout.list_imoveis, viewGroup, false);

        TextView nome = newView.findViewById(R.id.lbl_nome);
        TextView cidade = newView.findViewById(R.id.lbl_cidade);
        TextView endereco = newView.findViewById(R.id.lbl_endereco);
        TextView valor = newView.findViewById(R.id.lbl_valor);
        TextView telefone = newView.findViewById(R.id.lbl_telefone);

        nome.setText(imovel.getNome());
        cidade.setText(imovel.getCidade());
        endereco.setText(imovel.getEndereco());

        valor.setText(viewGroup.getResources().getString(R.string.moeda_valor) + String.valueOf(imovel.getValor())); // Converte o valor double para string //
        telefone.setText(viewGroup.getResources().getString(R.string.telefone) + imovel.getTelefone());
        notifyDataSetChanged();

        return newView;

        //TODO implementar mecanismo para estilizar elemento da lista (OK)
        //TextView lblNomeImovel = new TextView(this.context);
        //lblNomeImovel.setText(imovel.getNome() + " -- " + imovel.getValor());
        // return lblNomeImovel;
    }
}
