package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.compor.frameworks.jcf.api.Component;
import net.compor.frameworks.jcf.api.Service;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Dependente;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;

public class GerentedeDependentes extends Component{
	Map<Titular,List<Dependente>> gerencia;
	public GerentedeDependentes() {
		super("Gerente de Dependentes");
		gerencia =  new HashMap<Titular, List<Dependente>>();
	}
	
	@Service (name="setDependente")
	public void setDependente(Titular titular, Dependente dep){
		if(gerencia.get(titular)==null)
			gerencia.put(titular, new ArrayList<Dependente>());
		gerencia.get(titular).add(dep);
	}
	
	@Service (name="getDependentes")
	public List<Dependente> getDependente(Titular titular){
		return gerencia.get(titular);
	}
	

}
