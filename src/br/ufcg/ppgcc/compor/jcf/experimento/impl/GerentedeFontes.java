package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.compor.frameworks.jcf.api.Component;
import net.compor.frameworks.jcf.api.Service;

import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FontePagadora;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;

public class GerentedeFontes extends Component{
	Map<Titular,List<FontePagadora>> gerencia;
	
	public GerentedeFontes() {
		super("Gerente de Fontes Pagadores");
		gerencia =  new HashMap<Titular, List<FontePagadora>>();
	}

	@Service (name="setFonte")
	public void setFonte(Titular titular, FontePagadora fonte){
		if(gerencia.get(titular)==null)
			gerencia.put(titular, new ArrayList<FontePagadora>());
		gerencia.get(titular).add(fonte);
	}
	
	@Service (name="getFontes")
	public List<FontePagadora> getFonte(Titular titular){
		return gerencia.get(titular);
	}
	
}
