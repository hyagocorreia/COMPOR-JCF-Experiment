package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FontePagadora;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;
import net.compor.frameworks.jcf.api.Component;
import net.compor.frameworks.jcf.api.Service;

public class CriarFontePagadora extends Component {
	
	public CriarFontePagadora() {
		super("Criação de Fonte Pagadora");
	}
	
	@Service(name="criarFontePagadora",requiredServices="setFonte")
	public void criarFontePagadora(Titular titular, FontePagadora fonte) {
		requestService("setFonte", titular, fonte);
	}
	
	
}
