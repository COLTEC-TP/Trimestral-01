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
        TextView lblNomeImovel = new TextView(this.context);
        lblNomeImovel.setText(imovel.getNome() + imovel.getEndereco()+imovel.getCidade()+imovel.getTelefone()+ imovel.getValor());

        // recupera a view do adapter que será customizada
        View newView = LayoutInflater.from(this.context).inflate(R.layout.adapter_imoveis, viewGroup, false);

        // recupera cada um dos campos do item
        TextView lblNome = newView.findViewById(R.id.lbl_imovel_nome);
        TextView lblCidade = newView.findViewById(R.id.lbl_imovel_cidade);
        TextView lblEndereco = newView.findViewById(R.id.lbl_imovel_endereco);
        TextView lblValor = newView.findViewById(R.id.lbl_imovel_valor);
        TextView lblTelefone = newView.findViewById(R.id.lbl_imovel_telefone);

        // define o valor de cada um dos campos
        lblNome.setText(imovel.getNome());
        lblCidade.setText(imovel.getCidade());
        lblEndereco.setText(imovel.getEndereco());
        lblValor.setText(imovel.getValor().toString());
        lblTelefone.setText(imovel.getTelefone());
        return newView;
    }
}
