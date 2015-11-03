package br.hue.hue.inf008.kinkinmonitor.controller;

import br.hue.hue.inf008.kinkinmonitor.model.AreaMonitorada;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeEuclidiana;
import br.hue.hue.inf008.kinkinmonitor.model.UnidadeManhattan;
import java.util.List;

public class UnidadeMonitoraController<T> implements IController<T> {

	private final Class<T> typeParameterClass;
	private UnidadeManhattanController unidadeManhattanController = null;
	private UnidadeEuclidianaController unidadeEuclidianaController = null;

	public UnidadeMonitoraController(Class<T> typeParameterClass) {
		this.typeParameterClass = typeParameterClass;
		unidadeManhattanController = new UnidadeManhattanController();
		unidadeEuclidianaController = new UnidadeEuclidianaController();

	}

	@Override
	public List<T> listAll() throws Exception {
		if (typeParameterClass.equals(UnidadeEuclidiana.class)) {
			return (List<T>) unidadeEuclidianaController.listAll();
		} else if (typeParameterClass.equals(UnidadeManhattan.class)) {
			return (List<T>) unidadeManhattanController.listAll();
		}
		return null;
	}

	public List<T> listAllByAreaMonitorada(AreaMonitorada areaSelecionada) throws Exception {
		if (typeParameterClass.equals(UnidadeEuclidiana.class)) {
			return (List<T>) unidadeEuclidianaController.listAllByAreaMonitorada(areaSelecionada);
		} else if (typeParameterClass.equals(UnidadeManhattan.class)) {
			return (List<T>) unidadeManhattanController.listAllByAreaMonitorada(areaSelecionada);
		}
		return null;
	}

	@Override
	public T findById(String nome) throws Exception {
		if (typeParameterClass.equals(UnidadeEuclidiana.class)) {
			return (T) unidadeEuclidianaController.findById(nome);
		} else if (typeParameterClass.equals(UnidadeManhattan.class)) {
			return (T) unidadeManhattanController.findById(nome);
		}
		return null;
	}

	@Override
	public int insert(T domain) throws Exception {
		if (typeParameterClass.equals(UnidadeEuclidiana.class)) {
			return unidadeEuclidianaController.insert((UnidadeEuclidiana) domain);
		} else if (typeParameterClass.equals(UnidadeManhattan.class)) {
			return unidadeManhattanController.insert((UnidadeManhattan) domain);
		}
		return 0;
	}

	@Override
	public int update(T domain) throws Exception {
		if (typeParameterClass.equals(UnidadeEuclidiana.class)) {
			return unidadeEuclidianaController.update((UnidadeEuclidiana) domain);
		} else if (typeParameterClass.equals(UnidadeManhattan.class)) {
			return unidadeManhattanController.update((UnidadeManhattan) domain);
		}
		return 0;
	}

	@Override
	public int delete(T domain) throws Exception {
		if (typeParameterClass.equals(UnidadeEuclidiana.class)) {
			return unidadeEuclidianaController.delete((UnidadeEuclidiana) domain);
		} else if (typeParameterClass.equals(UnidadeManhattan.class)) {
			return unidadeManhattanController.delete((UnidadeManhattan) domain);
		}
		return 0;
	}

}
