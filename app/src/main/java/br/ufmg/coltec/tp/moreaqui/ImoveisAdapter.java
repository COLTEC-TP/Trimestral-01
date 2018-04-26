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

        //TODO implementar mecanismo para estilizar elemento da lista
        View newView = LayoutInflater.from(this.context).inflate(R.layout.adapter_imoveis, viewGroup, false);

        TextView nome = newView.findViewById(R.id.item_nome);
        TextView valor = newView.findViewById(R.id.item_valor);
        TextView endereco = newView.findViewById(R.id.item_endereco);
        TextView telefone = newView.findViewById(R.id.item_telefone);
        TextView cidade = newView.findViewById(R.id.item_cidade);

        nome.setText(imovel.getNome());
        valor.setText(context.getString(R.string.moneyUnit) + " " + imovel.getValor().toString());
        endereco.setText(imovel.getEndereco());
        telefone.setText(imovel.getTelefone());
        cidade.setText(imovel.getCidade());

        return newView;
    }
}
