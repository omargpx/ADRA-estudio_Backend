/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.org.adra_estudio.ADRA.service;

import java.util.HashMap;
import java.util.List;
import pe.org.adra_estudio.ADRA.entity.Sesion;

/**
 *
 * @author lober
 */
public interface SesionService {
    public List<Sesion> findAll();

    public Sesion findById(int id);

    public Sesion save(Sesion sesion);

    public void delete(Sesion sesion);

    public List<Sesion> findAll(String query, String sortBy);

    public HashMap<String, Object> findAll(String query, int page, int limit, String sortBy);
}
