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

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.imovel_layout, viewGroup, false);
        }

        //TODO implementar mecanismo para estilizar elemento da lista
        TextView lblNomeImovel = view.findViewById(R.id.show_nome);
        lblNomeImovel.setText(imovel.getNome());

        TextView lblEnderecoImovel = view.findViewById(R.id.show_endereco);
        lblEnderecoImovel.setText(imovel.getEndereco());

        TextView lblCidadeImovel = view.findViewById(R.id.show_cidade);
        lblCidadeImovel.setText(imovel.getCidade());

        TextView lblValorImovel = view.findViewById(R.id.show_valor);
        lblValorImovel.setText(String.valueOf(imovel.getValor()));

        TextView lbltelefoneImovel = view.findViewById(R.id.show_telefone);
        lbltelefoneImovel.setText(imovel.getTelefone());

        return view;
    }
}
