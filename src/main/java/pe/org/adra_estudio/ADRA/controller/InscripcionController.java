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
import pe.org.adra_estudio.ADRA.entity.Inscripcion;
import pe.org.adra_estudio.ADRA.service.InscripcionService;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("api/inscripcion")
@Api(value = "Microservicio de gestion de la tabla de Recurso", description = "Gestion de la tabla recurso")
public class InscripcionController {
    @Autowired
    private InscripcionService service;
    
    @ApiOperation(value = "Lista de Recusos")
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

    @ApiOperation(value = "Crea un nuevo recurso")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Inscripcion inscripcion, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Inscripcion data = service.save(inscripcion);

        result.put("success", true);
        result.put("message", "el recurso se ha registrado correctamente.");
        result.put("result", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Actualiza datos de una sesion")
    @PutMapping("/{ID_INSCRIPCION}")
    public ResponseEntity<?> update(@RequestBody Inscripcion inscripcion, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Inscripcion data = service.findById(inscripcion.getId_inscripcion());
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe sesion con Id: " + inscripcion.getId_inscripcion());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            service.save(inscripcion);
            result.put("success", true);
            result.put("message", "Se ha actualizado los datos.");
            result.put("result", inscripcion);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Obtiene Datos el recurso")
    @GetMapping(value = "/{ID_INSCRIPCION}")
    public ResponseEntity<?> findById(@PathVariable(value = "ID_INSCRIPCION") int id_inscripcion, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Inscripcion data = service.findById(id_inscripcion);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe capacitacion con Id: " + id_inscripcion);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        } else {
            result.put("success", true);
            result.put("message", "Se ha encontrado el registro.");
            result.put("result", data);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @ApiOperation(value = "Elimina un recurso")
    @DeleteMapping(value = "/{ID_INSCRIPCION}")
    public ResponseEntity<?> delete(@PathVariable(value = "ID_INSCRIPCION") int id_inscripcion, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Inscripcion data = service.findById(id_inscripcion);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe sesion con id: " + id_inscripcion);
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
