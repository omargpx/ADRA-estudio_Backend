/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.org.adra_estudio.ADRA.service;

import java.util.HashMap;
import java.util.List;
import pe.org.adra_estudio.ADRA.entity.Recurso;


public interface RecursoService {   
      public List<Recurso> findAll();

    public Recurso findById(int id);

    public Recurso save(Recurso recurso);

    public void delete(Recurso recurso);

    public List<Recurso> findAll(String query, String sortBy);

    public HashMap<String, Object> findAll(String query, int page, int limit, String sortBy);
}
