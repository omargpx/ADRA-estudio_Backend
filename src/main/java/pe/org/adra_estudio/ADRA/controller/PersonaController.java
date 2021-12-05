package pe.org.adra_estudio.ADRA.controller;

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

import pe.org.adra_estudio.ADRA.service.PersonaService;
import pe.org.adra_estudio.ADRA.entity.Persona;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("api/persona")
@Api(value = "Microservicio de gestion de la tabla Persona", description = "Gestion de la tabla TBL_PERSONA")
public class PersonaController {

    @Autowired
    private PersonaService PersonaService;

    @ApiOperation(value = "Lista de la tabla Personas")
    @GetMapping
    public ResponseEntity<?> findAll(
            @RequestParam(value = "query", required = false, defaultValue = "") String query,
            @RequestParam(value = "page", required = false, defaultValue = "-1") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "-1") int limit,
            @RequestParam(value = "sortBy", required = false, defaultValue = "") String sortBy,
            HttpServletRequest request) {
        if (query.equals("") && limit == -1 && "".equals(sortBy)) {
            return new ResponseEntity<>(PersonaService.findAll(), HttpStatus.OK);
        } else if (!query.equals("") && page == -1 && limit == -1 && "".equals(sortBy)) {
            return new ResponseEntity<>(PersonaService.findAll(query, ""), HttpStatus.OK);
        } else if (!query.equals("") && page == -1 && limit == -1 && !"".equals(sortBy)) {
            return new ResponseEntity<>(PersonaService.findAll(query, sortBy), HttpStatus.OK);
        } else if (limit != -1 && page == -1) {
            return new ResponseEntity<>(new Exception("Parámetro page es requerido"), HttpStatus.CONFLICT);
        } else if (page != -1 && limit == -1) {
            return new ResponseEntity<>(new Exception("Parámetro limit es requerido"), HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(PersonaService.findAll(query, page, limit, sortBy), HttpStatus.OK);
        }
    }

    @ApiOperation(value = "Crea una nueva Persona")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Persona clasificacion, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Persona data = PersonaService.save(clasificacion);

        result.put("success", true);
        result.put("message", "la persona se ha registrado correctamente.");
        result.put("result", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Actualiza datos de una persona")
    @PutMapping("/{ID_PERSONA}")
    public ResponseEntity<?> update(@RequestBody Persona clasificacion, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Persona data = PersonaService.findById(clasificacion.getIdPersona());
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe Persona con Id: " + clasificacion.getIdPersona());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            PersonaService.save(clasificacion);
            result.put("success", true);
            result.put("message", "Se ha actualizado los datos de clasificacion.");
            result.put("result", clasificacion);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Obtiene Datos la persona")
    @GetMapping(value = "/{ID_PERSONA}")
    public ResponseEntity<?> findById(@PathVariable(value = "ID_PERSONA") int idPersona, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Persona data = PersonaService.findById(idPersona);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe persona con Id: " + idPersona);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        result.put("success", true);
        result.put("message", "Se ha encontrado el registro.");
        result.put("result", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina una Persona")
    @DeleteMapping(value = "/{ID_PERSONA}")
    public ResponseEntity<?> delete(@PathVariable(value = "ID_PERSONA") int idPersona, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Persona data = PersonaService.findById(idPersona);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe persona con id: " + idPersona);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            PersonaService.save(data);
            result.put("success", true);
            result.put("message", "Se han eliminado los datos del registro.");
            result.put("result", data);
            return new ResponseEntity<>(result, HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
