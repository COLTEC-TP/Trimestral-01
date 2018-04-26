package br.ufmg.coltec.tp.moreaqui;

import java.util.ArrayList;

/**
 * Classe responsável por fazer o controle da persistência dos imóveis
 */
public class ImovelDAO {

    private ArrayList<Imovel> imoveis;

    // singleton para lidar com única instância do DAO
    private static ImovelDAO instance;

    /**
     * Construtor privado (NÃO UTILIZAR)
     */
    private ImovelDAO() {
        imoveis = new ArrayList<>();
        carregarImoveis();
    }

    /**
     * Retorna instância do DAO com os imóveis cadastrados até o momento.
     *
     * Utilize esse método para recuperar a instância do singleton
     *
     * @return Objeto do tipo ImovelDAO
     */
    public static ImovelDAO getInstance() {

        if(instance == null)
            instance = new ImovelDAO();

        return instance;
    }

    /**
     * Carrega a lista inicial de imóveis
     */
    private void carregarImoveis() {
        imoveis.add(new Imovel("Flat Savassi",
                "Av. Getúlio Vargas, 3500, Savassi",
                "Belo Horizonte",
                3000.00,
                "2314-1514"));

        imoveis.add(new Imovel("Moradia UFMG",
                "Flemming",
                "Belo Horizonte",
                850.00,
                "3409-2525"));

        imoveis.add(new Imovel("Edifício JK",
                "Av. Olegário Maciel, 500, Centro",
                "Belo Horizonte",
                1200.00,
                "99456-4430"));

        imoveis.add(new Imovel("Casa 3 quartos",
                "Rua Santa Mônica, 450, Ouro Preto",
                "Belo Horizonte",
                1800.00,
                "3411-3030"));

        imoveis.add(new Imovel("Eldorado",
                "Praça da CEMIG, 500",
                "Contagem",
                800.00,
                "3350-0670"));

        imoveis.add(new Imovel("Mansão Mangabeiras",
                "Av. Afonso Pena, 13000",
                "Belo Horizonte",
                14000.00,
                "99999-9999"));
    }

    /**
     * Faz a filtragem dos imóveis por nome
     *
     * @param nome nome a ser utilizado na filtragem
     */
    public ArrayList<Imovel> filtrarImoveis(String nome) {
        ArrayList<Imovel> imoveisFiltrados = new ArrayList<>();


        // TODO implementar ação de filtragem
        // Dica: Para implementar a filtragem, você deverá verificar se o parâmetro "nome"
        // está incluso dentro do nome de cada imóvel (Utilize o String.contains)


        return imoveisFiltrados;
    }

    /**
     * Adiciona um novo imóvel na lista
     *
     * @param novoImovel imóvel que será adicionado na lista
     */
    public void adicionarImovel(Imovel novoImovel) {
        instance.imoveis.add(novoImovel);
    }


    /**
     * Recupera lista completa dos imóveis
     * @return ArrayList com todos os imóveis cadastrados no DAO
     */
    public ArrayList<Imovel> getImoveis() {
        return instance.imoveis;
    }
}
