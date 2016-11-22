package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.TempoGuardadoDAO;
import br.com.gerencia.model.TempoGuardado;

@Service("tempoGuardadoService")
public class TempoGuardadoServiceImpl implements TempoGuardadoService{

	@Autowired
	private TempoGuardadoDAO tempoGuardadoDAO;

	public Boolean salvarTempoGuardado(TempoGuardado tempoGuardado) {
			return tempoGuardadoDAO.salvarTempoGuardado(tempoGuardado);
		}

		public Boolean editarTempoGuardado(TempoGuardado tempoGuardado) {
			return tempoGuardadoDAO.editarTempoGuardado(tempoGuardado);
		}

		public Boolean excluirTempoGuardado(TempoGuardado tempoGuardado) {
			return tempoGuardadoDAO.excluirTempoGuardado(tempoGuardado);
		}

		public Boolean exluirTempoGuardadoPorChave(Long chave) {
			return tempoGuardadoDAO.exluirTempoGuardadoPorChave(chave);
		}

		public List<TempoGuardado> listarTempoGuardados() {
			return  tempoGuardadoDAO.listarTempoGuardados();
		}

		public List<TempoGuardado> pesquisarTempoGuardadoPorNome(String nomeAtributo, String valor) {
			return  tempoGuardadoDAO.pesquisarTempoGuardadoPorNome(nomeAtributo, valor);
		}

		public TempoGuardado pesquisarTempoGuardadoPorChave(Long chave) {
			return tempoGuardadoDAO.pesquisarTempoGuardadoPorChave(chave);
		}
}
