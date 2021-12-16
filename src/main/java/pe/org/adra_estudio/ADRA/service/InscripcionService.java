/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.org.adra_estudio.ADRA.service;

import java.util.HashMap;
import java.util.List;
import pe.org.adra_estudio.ADRA.entity.Inscripcion;

public interface InscripcionService {
          public List<Inscripcion> findAll();

    public Inscripcion findById(int id);

    public Inscripcion save(Inscripcion inscripcion);

    public void delete(Inscripcion inscripcion);

    public List<Inscripcion> findAll(String query, String sortBy);

    public HashMap<String, Object> findAll(String query, int page, int limit, String sortBy);
}
