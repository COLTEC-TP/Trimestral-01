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

    public ImoveisAdapter(Context baseContext) {
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
        Imovel currentImovel = this.imoveis.get(i);
        View newView = LayoutInflater.from(this.context).inflate(R.layout.adapter_imoveis, viewGroup, false);

        TextView lblNome = newView.findViewById(R.id.lbl_imovel_nome);
        TextView lblEndereco = newView.findViewById(R.id.lbl_imovel_endereco);
        TextView lblCidade = newView.findViewById(R.id.lbl_imovel_cidade);
        TextView lblTelefone = newView.findViewById(R.id.lbl_imovel_telefone);
        TextView lblPreco = newView.findViewById(R.id.lbl_imovel_preco);





        //TODO implementar mecanismo para estilizar elemento da lista
        lblNome.setText(currentImovel.getNome());
        lblEndereco.setText(currentImovel.getEndereco());
        lblCidade.setText(currentImovel.getCidade());
        lblTelefone.setText(currentImovel.getTelefone());
        lblPreco.setText(currentImovel.getValor().toString());


        return newView;
    }
}
