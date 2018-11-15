package br.com.cielo.impl;

import br.com.cielo.ExtratoLancamento;
import br.com.cielo.dao.ExtratoLancamentoDaoImpl;

public class ExtratoLancamentoServiceImpl implements ExtratoLancamentoService{
	
	private ExtratoLancamentoDaoImpl dao = new ExtratoLancamentoDaoImpl();

	@Override
	public ExtratoLancamento buscarExtratoLancamento() {
		
		return dao.buscarExtratoLancamentoRepository();
	}

}
