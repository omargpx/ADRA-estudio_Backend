/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.org.adra_estudio.ADRA.service;

import java.util.HashMap;
import java.util.List;
import pe.org.adra_estudio.ADRA.entity.TipoRecurso;

public interface TipoRecursoService {
         public List<TipoRecurso> findAll();

    public TipoRecurso findById(int id);

    public TipoRecurso save(TipoRecurso tipo);

    public void delete(TipoRecurso tipo);                                   

    public List<TipoRecurso> findAll(String query, String sortBy);

    public HashMap<String, Object> findAll(String query, int page, int limit, String sortBy);
}
