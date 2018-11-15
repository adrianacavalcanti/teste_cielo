package br.com.cielo;

import java.util.ArrayList;
import java.util.List;

public class LancamentoContaCorrente {

	private Long numeroRemessaBanco;
	private String nomeSituacaoRemessa;
	private String nomeTipoOperacao;
	private List<DadosDomicilioBancario> dadosDomicilioBancario = new ArrayList<DadosDomicilioBancario>();

	public Long getNumeroRemessaBanco() {
		return numeroRemessaBanco;
	}

	public void setNumeroRemessaBanco(Long numeroRemessaBanco) {
		this.numeroRemessaBanco = numeroRemessaBanco;
	}

	public String getNomeSituacaoRemessa() {
		return nomeSituacaoRemessa;
	}

	public void setNomeSituacaoRemessa(String nomeSituacaoRemessa) {
		this.nomeSituacaoRemessa = nomeSituacaoRemessa;
	}

	public String getNomeTipoOperacao() {
		return nomeTipoOperacao;
	}

	public void setNomeTipoOperacao(String nomeTipoOperacao) {
		this.nomeTipoOperacao = nomeTipoOperacao;
	}

	public List<DadosDomicilioBancario> getDadosDomicilioBancario() {
		return dadosDomicilioBancario;
	}

	public void setDadosDomicilioBancario(List<DadosDomicilioBancario> dadosDomicilioBancario) {
		this.dadosDomicilioBancario = dadosDomicilioBancario;
	}

	
}
