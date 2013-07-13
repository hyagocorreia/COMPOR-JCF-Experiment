package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.List;

import net.compor.frameworks.jcf.api.Component;
import net.compor.frameworks.jcf.api.Service;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Dependente;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FontePagadora;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Resultado;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;
import br.ufcg.ppgcc.compor.jcf.experimento.util.CalculoImpostoRenda;

public class DeclaracaoCompleta extends Component {
	
	
	public DeclaracaoCompleta() {
		super("Declaração Completa");
	}
	
	@SuppressWarnings("unchecked")
	@Service (name="gerarDeclaracao", requiredServices="getFontes,getDependentes")
	public Resultado gerarDeclaracao(Titular titular){
		Resultado res = new Resultado();
		List<FontePagadora> fontes =
				(List<FontePagadora>) requestService("getFontes", titular);
		List<Dependente> deps =
				(List<Dependente>) requestService("getDependentes", titular);
		
		CalculoImpostoRenda cal = new CalculoImpostoRenda();
		
		Double resultado = cal.totalRecebido(fontes);
		
		if(deps==null)	
			res.setImpostoDevido(cal.impostoDevido(resultado));
		else
			res.setImpostoDevido(cal.impostoDevido(cal.descontoDependentes(resultado, deps)));
		return res;
	}
	
}
