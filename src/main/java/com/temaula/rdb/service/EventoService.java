package com.temaula.rdb.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.temaula.rdb.model.Evento;
import com.temaula.rdb.model.Pessoa;
import java.sql.Timestamp;
import java.time.Instant;

@Stateless
public class EventoService {
	List<Evento> lista = new ArrayList<Evento>();

	// Inicializando dados
	public EventoService() {
		Evento e1 = new Evento();
		e1.setId(1);
		e1.setDataInicio(LocalDate.now());
		e1.setDataFim(LocalDate.now());
		e1.setDataCriacao(Timestamp.from(Instant.now()));
		e1.setDescricao("Sopao do Bras");
		e1.setItensDoacao(null);

		Pessoa pessoa = new Pessoa();
		pessoa.setId(1L);
		pessoa.setNome("Evandro");
		pessoa.setEmail("email@email.com");
		pessoa.setSenha("1234");
		pessoa.setTelefone("(11) 91234-5678");
		pessoa.setEndereco("Rua da Paroquia, n1");
		e1.setAutor(pessoa);
		e1.setUrlImagem("/imagem/sopao1.png");

		lista.add(e1);

		Evento e2 = new Evento();
		e2.setId(2);
		e2.setDataInicio(LocalDate.of(2020, 02, 15));
		e2.setDataFim(LocalDate.of(2020, 02, 18));
		e2.setDataCriacao(Timestamp.from(Instant.now()));
		e2.setDescricao("Sopao do Se");
		e2.setItensDoacao(null);

		Pessoa pessoa2 = new Pessoa();
		pessoa2.setId(1L);
		pessoa2.setNome("Fredegundo");
		pessoa2.setEmail("email@email.com");
		pessoa2.setSenha("1234");
		pessoa2.setTelefone("(11) 91234-5678");
		pessoa2.setEndereco("Rua da Paroquia, n7");
		e2.setAutor(pessoa2);
		e2.setUrlImagem("/imagem/sopao2.png");

		lista.add(e2);
	}

	public List<Evento> listarTodos() {

		return lista;
	}

	public Evento pesquisarId(int id) {

		for (Evento evento : lista) {
			if (evento.getId() == id) {
				return evento;
			}
		}

		return null;
	}
	
	public boolean atualizar( Evento evento ) {
		for(int i = 0; i < lista.size(); i++) {
			if( lista.get( i ).getId() == evento.getId() ) {
				lista.set(i, evento);
				return true;
			}
		}
		return false;
	}

	public void inserir(Evento evento) {
		lista.add(evento);
	}
	
	public void deletar(int id) {
		Evento e = pesquisarId(id); 
		if( e != null) {
			lista.remove(e);
		}
	}
}
