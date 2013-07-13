package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import net.compor.frameworks.jcf.api.Component;
import net.compor.frameworks.jcf.api.Service;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Dependente;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;

public class CriarDependente extends Component{

	public CriarDependente() {
		super("Criação de Dependente");
	}

	@Service(name="criarDependente",requiredServices="setDependente")
	public void criarFontePagadora(Titular titular, Dependente dependente) {
		requestService("setDependente", titular, dependente);
	}
}
