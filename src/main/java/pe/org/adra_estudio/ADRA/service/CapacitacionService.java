/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.org.adra_estudio.ADRA.service;

import java.util.HashMap;
import java.util.List;
import pe.org.adra_estudio.ADRA.entity.Capacitacion;

/**
 *
 * @author lober
 */
public interface CapacitacionService {

    public List<Capacitacion> findAll();

    public Capacitacion findById(int id);

    public Capacitacion save(Capacitacion capacitacion);

    public void delete(Capacitacion capacitacion);

    public List<Capacitacion> findAll(String query, String sortBy);

    public HashMap<String, Object> findAll(String query, int page, int limit, String sortBy);
}
