package dao.interf;

import model.Study;

public interface StudyDAO {
    void guardar(Study study);
    Study recuperarJuegoPorNombre(String name);
    void actualizar(Study Study);
    Study recuperar(Long id);
}
