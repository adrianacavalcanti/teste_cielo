package br.com.cielo.dao;


import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import br.com.cielo.ControleLancamento;
import br.com.cielo.DadosControleLancamento;
import br.com.cielo.DadosDomicilioBancario;
import br.com.cielo.ExtratoLancamento;
import br.com.cielo.LancamentoContaCorrente;

public class ExtratoLancamentoDaoImpl implements ExtratoLancamentoDao {

	@Override
	public ExtratoLancamento buscarExtratoLancamentoRepository() {

		JSONObject jsonObject;
		

		ExtratoLancamento item = new ExtratoLancamento();
		LancamentoContaCorrente listContaCorrente = new LancamentoContaCorrente();
		DadosDomicilioBancario listDadosDomicilioBancario = new DadosDomicilioBancario();
		DadosControleLancamento listControleLancamento = new DadosControleLancamento();
		List<DadosControleLancamento> listaDadosControleLancamento = new ArrayList<DadosControleLancamento>();
		List<LancamentoContaCorrente> listaLancamentoContaCorrente = new ArrayList<LancamentoContaCorrente>();
		ControleLancamento controleLancamento = new ControleLancamento();
		
		

		Reader in = new InputStreamReader(getClass().getResourceAsStream("/br/com/cielo/lancamentoContaLegado.json"));
		jsonObject = (JSONObject) JSONValue.parse(in);

		JSONObject a = (JSONObject) jsonObject.get("totalControleLancamento");
		item.getTotalControleLancamento().setValorLancamentos((Double) a.get("valorLancamentos"));
		item.getTotalControleLancamento().setQuantidadeRemessas((Long) a.get("quantidadeRemessas"));
		item.getTotalControleLancamento().setQuantidadeLancamentos((Long) a.get("quantidadeLancamentos"));

		item.setIndice((Long) jsonObject.get("indice"));
		item.setTamanhoPagina((Long) jsonObject.get("tamanhoPagina"));
		item.setTotalElements((Long) jsonObject.get("totalElements"));

		JSONArray b = (JSONArray) jsonObject.get("listaControleLancamento");
		Iterator lista = b.iterator();
		while (lista.hasNext()) {
			JSONObject controle = (JSONObject) lista.next();

			listControleLancamento.setCodigoIdentificadorUnico((String) controle.get("codigoIdentificadorUnico"));
			listControleLancamento.setDataEfetivaLancamento((String) controle.get("dataEfetivaLancamento"));
			listControleLancamento
					.setDateLancamentoContaCorrenteCliente((Long) controle.get("dateLancamentoContaCorrenteCliente"));
			listControleLancamento.setDateEfetivaLancamento((Long) controle.get("dateEfetivaLancamento"));
			listControleLancamento.setDescricaoGrupoPagamento((String) controle.get("descricaoGrupoPagamento"));
			listControleLancamento.setNomeBanco((String) controle.get("nomeBanco"));
			listControleLancamento.setNumeroEvento((Long) controle.get("numeroEvento"));
			listControleLancamento.setNumeroRaizCNPJ((String) controle.get("numeroRaizCNPJ"));
			listControleLancamento.setNumeroSufixoCNPJ((String) controle.get("numeroSufixoCNPJ"));
			listControleLancamento
					.setQuantidadeLancamentoRemessa((Long) controle.get("quantidadeLancamentoRemessa"));
			listControleLancamento.setValorLancamentoRemessa((Double) controle.get("valorLancamentoRemessa"));
			
			listaDadosControleLancamento.add(listControleLancamento);
			controleLancamento.setListaDadosControleLancamento(listaDadosControleLancamento);
			
			

			JSONObject lancamento = (JSONObject) controle.get("lancamentoContaCorrenteCliente");

			listContaCorrente.setNumeroRemessaBanco((Long) lancamento.get("numeroRemessaBanco"));
			listContaCorrente.setNomeSituacaoRemessa((String) lancamento.get("nomeSituacaoRemessa"));
			listContaCorrente.setNomeTipoOperacao((String) lancamento.get("nomeTipoOperacao"));

			JSONObject domicilio = (JSONObject) lancamento.get("dadosDomicilioBancario");

			listDadosDomicilioBancario.setCodigoBanco((Long) domicilio.get("codigoBanco"));
			listDadosDomicilioBancario.setNumeroAgencia((Long) domicilio.get("numeroAgencia"));
			listDadosDomicilioBancario.setNumeroContaCorrente((String) domicilio.get("numeroContaCorrente"));

			listContaCorrente.getDadosDomicilioBancario().add(listDadosDomicilioBancario);
			
			listaLancamentoContaCorrente.add(listContaCorrente);
			
			controleLancamento.setListaLancamentoContaCorrente(listaLancamentoContaCorrente);
			
			item.getListaControleLancamento().add(controleLancamento);
			
		}
		

		return item;
	}

}
