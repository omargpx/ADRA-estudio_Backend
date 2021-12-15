/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.org.adra_estudio.ADRA.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.org.adra_estudio.ADRA.entity.Sesion;
import pe.org.adra_estudio.ADRA.service.SesionService;

/**
 *
 * @author lober
 */
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("api/sesion")
@Api(value = "Microservicio de gestion de la tabla de sesion", description = "Gestion de la tabla sesion")
public class SesionController {
    
    @Autowired
    private SesionService service;
    
    @ApiOperation(value = "Lista de sesiones")
    @GetMapping
    public ResponseEntity<?> findAll(
            @RequestParam(value = "query", required = false, defaultValue = "") String query,
            @RequestParam(value = "page", required = false, defaultValue = "-1") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "-1") int limit,
            @RequestParam(value = "sortBy", required = false, defaultValue = "") String sortBy,
            HttpServletRequest request) {
        if (query.equals("") && limit == -1 && "".equals(sortBy)) {
            return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
        } else if (!query.equals("") && page == -1 && limit == -1 && "".equals(sortBy)) {
            return new ResponseEntity<>(service.findAll(query, ""), HttpStatus.OK);
        } else if (!query.equals("") && page == -1 && limit == -1 && !"".equals(sortBy)) {
            return new ResponseEntity<>(service.findAll(query, sortBy), HttpStatus.OK);
        } else if (limit != -1 && page == -1) {
            return new ResponseEntity<>(new Exception("Parámetro page es requerido"), HttpStatus.CONFLICT);
        } else if (page != -1 && limit == -1) {
            return new ResponseEntity<>(new Exception("Parámetro limit es requerido"), HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(service.findAll(query, page, limit, sortBy), HttpStatus.OK);
        }
    }

    @ApiOperation(value = "Crea una nueva sesion")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Sesion capacitacion, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Sesion data = service.save(capacitacion);

        result.put("success", true);
        result.put("message", "la persona se ha registrado correctamente.");
        result.put("result", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Actualiza datos de una sesion")
    @PutMapping("/{id_sesion}")
    public ResponseEntity<?> update(@RequestBody Sesion sesion, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Sesion data = service.findById(sesion.getId_sesion());
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe sesion con Id: " + sesion.getId_sesion());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            service.save(sesion);
            result.put("success", true);
            result.put("message", "Se ha actualizado los datos.");
            result.put("result", sesion);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Obtiene Datos la sesion")
    @GetMapping(value = "/{id_sesion}")
    public ResponseEntity<?> findById(@PathVariable(value = "id_sesion") int idCapacitacion, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Sesion data = service.findById(idCapacitacion);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe capacitacion con Id: " + idCapacitacion);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        } else {
            result.put("success", true);
            result.put("message", "Se ha encontrado el registro.");
            result.put("result", data);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @ApiOperation(value = "Elimina una sesion")
    @DeleteMapping(value = "/{id_sesion}")
    public ResponseEntity<?> delete(@PathVariable(value = "id_sesion") int id_capacitacion, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Sesion data = service.findById(id_capacitacion);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe sesion con id: " + id_capacitacion);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            service.delete(data);
            result.put("success", true);
            result.put("message", "Se han eliminado los datos del registro.");
            result.put("result", data);
            return new ResponseEntity<>(result, HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
