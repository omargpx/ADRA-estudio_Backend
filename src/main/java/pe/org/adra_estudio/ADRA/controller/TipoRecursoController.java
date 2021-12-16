/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import pe.org.adra_estudio.ADRA.entity.TipoRecurso;
import pe.org.adra_estudio.ADRA.service.TipoRecursoService;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("api/tiporecurso")
@Api(value = "Microservicio de gestion de la tabla de Recurso", description = "Gestion de la tabla recurso")
public class TipoRecursoController {
    
    @Autowired
    private TipoRecursoService service;
    
    @ApiOperation(value = "Lista de tipo de recursos")
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

    @ApiOperation(value = "Crea un nuevo tipo de recurso")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody TipoRecurso tipo, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        TipoRecurso data = service.save(tipo);

        result.put("success", true);
        result.put("message", "el recurso se ha registrado correctamente.");
        result.put("result", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Actualiza datos de un tipo de recurso")
    @PutMapping("/{ID_TI_RECURSO}")
    public ResponseEntity<?> update(@RequestBody TipoRecurso tipo, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        TipoRecurso data = service.findById(tipo.getId_tipo_recurso());
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe sesion con Id: " + tipo.getId_tipo_recurso());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            service.save(tipo);
            result.put("success", true);
            result.put("message", "Se ha actualizado los datos.");
            result.put("result", tipo);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Obtiene Datos el  tipo de recurso")
    @GetMapping(value = "/{ID_TI_RECURSO}")
    public ResponseEntity<?> findById(@PathVariable(value = "ID_TI_RECURSO") int id_tipo_recurso, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        TipoRecurso data = service.findById(id_tipo_recurso);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe capacitacion con Id: " + id_tipo_recurso);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        } else {
            result.put("success", true);
            result.put("message", "Se ha encontrado el registro.");
            result.put("result", data);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @ApiOperation(value = "Elimina un tipo recurso")
    @DeleteMapping(value = "/{ID_TI_RECURSO}")
    public ResponseEntity<?> delete(@PathVariable(value = "ID_TI_RECURSO") int id_tipo_recurso, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        TipoRecurso data = service.findById(id_tipo_recurso);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe sesion con id: " + id_tipo_recurso);
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
