package br.com.cielo;

import java.util.ArrayList;
import java.util.List;

public class ControleLancamento {

	private List<LancamentoContaCorrente> listaLancamentoContaCorrente = new ArrayList<LancamentoContaCorrente>();
	private List<DadosControleLancamento> listaDadosControleLancamento = new ArrayList<DadosControleLancamento>();

	public List<LancamentoContaCorrente> getListaLancamentoContaCorrente() {
		return listaLancamentoContaCorrente;
	}

	public void setListaLancamentoContaCorrente(List<LancamentoContaCorrente> listaLancamentoContaCorrente) {
		this.listaLancamentoContaCorrente = listaLancamentoContaCorrente;
	}

	public List<DadosControleLancamento> getListaDadosControleLancamento() {
		return listaDadosControleLancamento;
	}

	public void setListaDadosControleLancamento(List<DadosControleLancamento> listaDadosControleLancamento) {
		this.listaDadosControleLancamento = listaDadosControleLancamento;
	}

}
