package br.com.cielo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.cielo.impl.ExtratoLancamentoServiceImpl;

@RestController
public class ExtratoLancamentoContaController {

	private ExtratoLancamentoServiceImpl service = new ExtratoLancamentoServiceImpl();

	/*
	 * Webservice Rest responsavel pela busca do arquivo json legado.
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "extrato", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSONObject> extratoLancamento(@RequestParam(value = "id", defaultValue = "id") String id)
			throws Exception {

		ExtratoLancamento retorno = service.buscarExtratoLancamento();

		JSONObject vRetornoConsulta = new JSONObject();

		JSONObject vRetornoControle = new JSONObject();

		JSONObject vRetornoTotalControleLancamento = new JSONObject();

		JSONObject vRetorno = new JSONObject();

		vRetornoTotalControleLancamento.put("quantidadeLancamentos",
				retorno.getTotalControleLancamento().getQuantidadeLancamentos());
		vRetornoTotalControleLancamento.put("quantidadeRemessas",
				retorno.getTotalControleLancamento().getQuantidadeRemessas());
		vRetornoTotalControleLancamento.put("valorLancamentos",
				retorno.getTotalControleLancamento().getValorLancamentos());

		vRetornoControle.put("totalControleLancamento", vRetornoTotalControleLancamento);

		JSONArray vRetornoListaControleLancamento = new JSONArray();
		JSONObject vRetornoControleLancamento = new JSONObject();
		JSONObject vRetornoLancamentoContaCorrenteCliente = new JSONObject();

		int i = 0;

		for (ControleLancamento item : retorno.getListaControleLancamento()) {

			JSONObject vRetornoLista = new JSONObject();
			JSONObject vRetornoListaDados = new JSONObject();

			vRetornoLista.put("numeroRemessaBanco",
					item.getListaLancamentoContaCorrente().get(i).getNumeroRemessaBanco());
			vRetornoLista.put("nomeSituacaoRemessa",
					item.getListaLancamentoContaCorrente().get(i).getNomeSituacaoRemessa());
			vRetornoLista.put("nomeTipoOperacao", item.getListaLancamentoContaCorrente().get(i).getNomeTipoOperacao());

			vRetornoListaDados.put("codigoBanco",
					item.getListaLancamentoContaCorrente().get(i).getDadosDomicilioBancario().get(i).getCodigoBanco());
			vRetornoListaDados.put("numeroAgencia", item.getListaLancamentoContaCorrente().get(i)
					.getDadosDomicilioBancario().get(i).getNumeroAgencia());
			vRetornoListaDados.put("numeroContaCorrente", item.getListaLancamentoContaCorrente().get(i)
					.getDadosDomicilioBancario().get(i).getNumeroContaCorrente());

			vRetornoLista.put("dadosDomicilioBancario", vRetornoListaDados);

			vRetornoLancamentoContaCorrenteCliente.put("lancamentoContaCorrenteCliente", vRetornoLista);

			vRetornoLancamentoContaCorrenteCliente.put("dataEfetivaLancamento",
					item.getListaDadosControleLancamento().get(i).getDataEfetivaLancamento());
			vRetornoLancamentoContaCorrenteCliente.put("numeroEvento",
					item.getListaDadosControleLancamento().get(i).getNumeroEvento());
			vRetornoLancamentoContaCorrenteCliente.put("descricaoGrupoPagamento",
					item.getListaDadosControleLancamento().get(i).getDescricaoGrupoPagamento());
			vRetornoLancamentoContaCorrenteCliente.put("codigoIdentificadorUnico",
					item.getListaDadosControleLancamento().get(i).getCodigoIdentificadorUnico());
			vRetornoLancamentoContaCorrenteCliente.put("nomeBanco",
					item.getListaDadosControleLancamento().get(i).getNomeBanco());
			vRetornoLancamentoContaCorrenteCliente.put("quantidadeLancamentoRemessa",
					item.getListaDadosControleLancamento().get(i).getQuantidadeLancamentoRemessa());
			vRetornoLancamentoContaCorrenteCliente.put("numeroRaizCNPJ",
					item.getListaDadosControleLancamento().get(i).getNumeroRaizCNPJ());
			vRetornoLancamentoContaCorrenteCliente.put("numeroSufixoCNPJ",
					item.getListaDadosControleLancamento().get(i).getNumeroSufixoCNPJ());
			vRetornoLancamentoContaCorrenteCliente.put("valorLancamentoRemessa",
					item.getListaDadosControleLancamento().get(i).getValorLancamentoRemessa());
			vRetornoLancamentoContaCorrenteCliente.put("dateLancamentoContaCorrenteCliente",
					item.getListaDadosControleLancamento().get(i).getDateLancamentoContaCorrenteCliente());
			vRetornoLancamentoContaCorrenteCliente.put("dateEfetivaLancamento",
					item.getListaDadosControleLancamento().get(i).getDataEfetivaLancamento());

			vRetornoListaControleLancamento.add(vRetornoLancamentoContaCorrenteCliente);
			
			i++;
		}

		vRetornoControleLancamento.put("listaControleLancamento", vRetornoListaControleLancamento);

		vRetorno.put("indice", retorno.getIndice());
		vRetorno.put("tamanhoPagina", retorno.getTamanhoPagina());
		vRetorno.put("totalElements", retorno.getTotalElements());

		vRetornoConsulta.putAll(vRetornoControle);
		vRetornoConsulta.putAll(vRetornoControleLancamento);
		vRetornoConsulta.putAll(vRetorno);

		return new ResponseEntity<>(vRetornoConsulta, HttpStatus.OK);
	}
}
