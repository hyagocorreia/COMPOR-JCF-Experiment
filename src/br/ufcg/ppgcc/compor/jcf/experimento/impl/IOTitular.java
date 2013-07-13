package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.ArrayList;
import java.util.List;

import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;
import net.compor.frameworks.jcf.api.Component;
import net.compor.frameworks.jcf.api.Service;

public class IOTitular extends Component {
	List<Titular> titulares;
	
	public IOTitular() {
		super("Criação de Titular");
		titulares =  new ArrayList<Titular>();
	}
	
	@Service(name="ICriarTitular")
	public void criarNovoTitualar(Titular t) {
		titulares.add(t);
	}
	
	@Service(name="IRecuperarTitulares")
	public List<Titular> recuperarTitulares() {
		return titulares;
	}
}
