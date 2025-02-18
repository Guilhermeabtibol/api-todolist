package br.com.guilhermeabtibol.desafio_todolist; // aqui estamos definindo o pacote onde a classe de teste vai ficar.

import br.com.guilhermeabtibol.desafio_todolist.entity.Todo; // importando a classetodo que vamos testar.
import org.junit.jupiter.api.Test; // importando a anotacao para definir que isso e um teste.
import org.springframework.beans.factory.annotation.Autowired; // importando a anotacao para injetar dependencias.
import org.springframework.boot.test.context.SpringBootTest; // importando a anotacao para configurar o contexto do spring para testes.
import org.springframework.test.web.reactive.server.WebTestClient; // importando a classe para fazer chamadas HTTP em testes.

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // configurando o spring para rodar em uma porta aleatoria durante os testes.
class DesafioTodolistApplicationTests { // comecando a definicao da classe de teste.

	@Autowired // injetando o WebTestClient para fazer chamadas HTTP.
	private WebTestClient webTestClient; // criando uma instancia do WebTestClient.

	@Test // anotacao que indica que esse metodo e um teste.
	void TestCreateTodoSuccess() { // metodo para testar a criacao de umtodo com sucesso.
		var todo = new Todo("todo 1", "desc todo 1", false, 1); // criando um novo objetotodo com dados de exemplo.

		webTestClient. // usando o WebTestClient para fazer uma requisicao.
				post() // especificando que vamos fazer uma requisicao POST.
				.uri("/todos") // definindo a URI do endpoint que vamos chamar.
				.bodyValue(todo) // passando o objetotodo como corpo da requisicao.
				.exchange() // trocando a requisicao e esperando a resposta.
				.expectStatus().isOk() // esperando que a resposta tenha status 200 OK.
				.expectBody() // esperando o corpo da resposta.
				.jsonPath("$").isArray() // verificando se o corpo da resposta e um array.
				.jsonPath("$.length()").isEqualTo(1) // verificando se o array tem um elemento.
				.jsonPath("$[0].nome").isEqualTo(todo.getNome()) // verificando se o nome do primeirotodo e igual ao que foi enviado.
				.jsonPath("$[0].descricao").isEqualTo(todo.getDescricao()) // verificando se a descricao e igual.
				.jsonPath("$[0].realizado").isEqualTo(todo.isRealizado()) // verificando se o status de realizado e igual.
				.jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade()); // verificando se a prioridade e igual.

	}

	@Test // anotacao que indica que esse metodo e um teste.
	void TestCreateTodoFailure() { // metodo para testar a falha na criacao de um todo.
		webTestClient // usando o WebTestClient para fazer uma requisicao.
				.post() // especificando que vamos fazer uma requisicao POST.
				.uri("/todos") // definindo a URI do endpoint que vamos chamar.
				.bodyValue( // passando um objeto todo invalido como corpo da requisicao.
						new Todo("", "", false, 0) // criando um todo com campos vazios e prioridade 0.
				).exchange() // trocando a requisicao e esperando a resposta.
				.expectStatus().isBadRequest(); // esperando que a resposta tenha status 400 Bad Request.
	}
}