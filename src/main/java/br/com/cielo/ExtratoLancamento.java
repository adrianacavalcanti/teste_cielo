package br.com.cielo;

import java.util.ArrayList;
import java.util.List;

public class ExtratoLancamento {

	private Long indice;
	private Long tamanhoPagina;
	private Long totalElements;
	private TotalControleLancamento totalControleLancamento = new TotalControleLancamento();
	private ControleLancamento controleLancamento = new ControleLancamento();
	private List<ControleLancamento> listaControleLancamento = new ArrayList<ControleLancamento>();

	public Long getIndice() {
		return indice;
	}

	public void setIndice(Long indice) {
		this.indice = indice;
	}

	public Long getTamanhoPagina() {
		return tamanhoPagina;
	}

	public void setTamanhoPagina(Long tamanhoPagina) {
		this.tamanhoPagina = tamanhoPagina;
	}

	public Long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}

	public TotalControleLancamento getTotalControleLancamento() {
		return totalControleLancamento;
	}

	public void setTotalControleLancamento(TotalControleLancamento totalControleLancamento) {
		this.totalControleLancamento = totalControleLancamento;
	}

	public ControleLancamento getControleLancamento() {
		return controleLancamento;
	}

	public void setControleLancamento(ControleLancamento controleLancamento) {
		this.controleLancamento = controleLancamento;
	}

	public List<ControleLancamento> getListaControleLancamento() {
		return listaControleLancamento;
	}

	public void setListaControleLancamento(List<ControleLancamento> listaControleLancamento) {
		this.listaControleLancamento = listaControleLancamento;
	}
	
	

}
