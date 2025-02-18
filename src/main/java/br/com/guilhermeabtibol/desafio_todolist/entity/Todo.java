package br.com.guilhermeabtibol.desafio_todolist.entity; // aqui estamos definindo o pacote onde a classe todo vai ficar.

import jakarta.persistence.*; // importando as anotacoes do jpa para trabalhar com banco de dados.
import jakarta.validation.constraints.NotBlank; // importando a anotacao para validar que um campo nao pode estar em branco.


@Entity // dizendo que essa classe e uma entidade que vai ser mapeada para uma tabela no banco de dados.
@Table(name = "todos") // especificando que a tabela no banco se chama "todos".
public class Todo { // comecando a definicao da classe todo.

    @Id // aqui estamos dizendo que esse campo e a chave primaria da tabela.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // o id vai ser gerado automaticamente pelo banco.
    private Long id; // campo para armazenar o id do todo.

    @NotBlank // essa anotacao garante que o nome nao pode ser vazio ou so espacos.
    private String nome; // campo para armazenar o nome do todo.

    @NotBlank // mesma coisa para a descricao, nao pode ser vazia.
    private String descricao; // campo para armazenar a descricao do todo.

    private boolean realizado; // campo que indica se o todo foi realizado ou nao.

    private int prioridade; // campo para armazenar a prioridade do todo (pode ser um numero, tipo 1 para alta prioridade).

    // construtor da classe, que e chamado quando criamos um novo todo.
    public Todo(String nome, String descricao, boolean realizado, int prioridade) {
        this.nome = nome; // atribuindo o nome passado como parametro ao campo nome.
        this.descricao = descricao; // atribuindo a descricao.
        this.realizado = realizado; // atribuindo se foi realizado ou nao.
        this.prioridade = prioridade; // atribuindo a prioridade.
    }

    // metodos getters e setters para acessar e modificar os campos da classe.

    public Long getId() { // metodo para pegar o id.
        return id; // retorna o id.
    }

    public void setId(Long id) { // metodo para definir o id.
        this.id = id; // atribui o id passado como parametro.
    }

    public String getNome() { // metodo para pegar o nome.
        return nome; // retorna o nome.
    }

    public void setNome(String nome) { // metodo para definir o nome.
        this.nome = nome; // atribui o nome passado como parametro.
    }

    public String getDescricao() { // metodo para pegar a descricao.
        return descricao; // retorna a descricao.
    }

    public void setDescricao(String descricao) { // metodo para definir a descricao.
        this.descricao = descricao; // atribui a descricao passada como parametro.
    }

    public boolean isRealizado() { // metodo para verificar se o todo foi realizado.
        return realizado; // retorna true ou false.
    }

    public void setRealizado(boolean realizado) { // metodo para definir se foi realizado.
        this.realizado = realizado; // atribui o valor passado como parametro.
    }

    public int getPrioridade() { // metodo para pegar a prioridade.
        return prioridade; // retorna a prioridade.
    }

    public void setPrioridade(int prioridade) { // metodo para definir a prioridade.
        this.prioridade = prioridade; // atribui a prioridade passada como parametro.
    }
}