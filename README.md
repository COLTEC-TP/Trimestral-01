# Prova Trimestral 01

Tecnologias de Programação

Professor: João Eduardo Montandon

Ano: 2018

Valor: 10 + 1 pontos

## MoreAqui App

Uma das tarefas mais corriqueiras no desenvolvimento de software consiste na manutenção de um sistema já existente. Nesta avaliação, você será responsável por fazer a manutenção de um aplicativo Android desenvolvido anteriormente por outro desenvolvedor.

O aplicativo, chamado MoreAqui, foi concebido para atender a usuários que estão interessados em alugar algum imóvel. Basicamente, o app lista uma série de imóveis cadastrados previamente pelo usuário. Para cada imóvel cadastrado, são informados os seguintes dados:

* Identificação: Texto para identificação do imóvel
* Endereço: Rua e bairro do imóvel
* Cidade: Cidade onde o imóvel está localizado
* Valor do Aluguel: Valor cobrado para se alugar o imóvel
* Telefone: Telefone para contactar a imobiliária

Dessa forma, o usuário poderá manter controle dos imóveis que os interessa e até compartilhar os mais interessantes com seus amigos!! Contudo, o aplicativo ainda não poderá ser lançado pois está incompleto. Você deverá implementar as funcionalidades restantes, descritas abaixo:


### Estilizar Elemento da Lista (1,5 pontos)

Ao executar o aplicativo, você vai observar que aparência da lista dos imóveis está horrível!! Nesta tarefa você deverá construir um layout personalizado para os itens da lista. O layout customizado deverá mostrar todos os campos, com destaque para a identificação e valor do aluguel.

Para isso, você deverá cirar um arquivo de layout chamado `adapter_imoveis.xml` e alterar o método `getView()` presente no arquivo `ImoveisAdapter.java` para utilizar o novo adapter.

### Cadastrar Novo Imóvel (4 pontos)

Você deverá implementar a funcionalidade de cadastro de novo imóvel. A função de cadastro deverá estar disponível por meio de um botão na `ActionBar` presente na tela de listagem (Você deveria criar o botão). 

O cadastro deverá ser feito por meio de uma nova Activity, chamada `NovoImovelActivity`. A tela deverá conter um formulário para preenchimento de todos os campos do novo imóvel a ser cadastrado. Lembre-se de definir corretamente o tipo do dado para cada um dos campos, para que o teclado possa ser exibido de acordo com o dado que será inserido.

Ainda, a `ActionBar` presente no `NovoImovelActivity` deverá implementar a ação de retorno para a tela principal.

*OBS: Utilize o método `adicionarImovel()` da classe `ImovelDAO` para cadastrar o novo imóvel. Não se esqueça de atualizar o adapter com o novo imóvel cadastrado.*

### Filtrar Imóveis (3 pontos)

O aplicativo deverá ter uma forma de fazer a filtragem dos imóveis existentes. Você deverá acrescentar a `ActionBar` da tela de listagem uma opção de filtragem de imóveis. Para isso, utilize o componente `android.widget.SearchView`, que deverá estar sempre disponível na `ActionBar`.

A filtragem será feita com base na identificação do imóvel, e deverá ser realizada toda vez que o usuário concluir a busca. Isto é, você deverá executar a ação de filtragem toda vez que o evento `onQueryTextSubmit()` for disparado.

É importante saber que já existe uma ação de filtragem **parcialmente** implementada no método `filterByName(String text)`, presente na classe `ImovelDAO`.

### Internacionalização (1,5 pontos)

O conteúdo do aplicativo foi escrito em português, porém ele será lançado também para o público estadunidense. Você deverá fornecer **todo** o conteúdo do aplicativo nas duas línguas: PT-BR e inglês.

*OBS: É importante ressaltar que você deverá traduzir, inclusive, o conteúdo que foi criado pela implementação das novas funcionalidades.*

### Extra: Atualização do Adapter (1 ponto)

Como você deve ter observado, a atualização do adapter está sendo feita de forma ineficiente. Corrija
a atualização do adapter para que ela aconteça de forma correta. Consulte este [link](https://pt.stackoverflow.com/questions/115564/atualizar-listview-usando-notifydatasetchanged) para mais informações.


