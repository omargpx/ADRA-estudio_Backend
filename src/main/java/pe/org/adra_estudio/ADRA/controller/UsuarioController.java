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
import pe.org.adra_estudio.ADRA.entity.Usuario;
import pe.org.adra_estudio.ADRA.service.UsuarioService;

/**
 *
 * @author lober
 */
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("api/usuario")
@Api(value = "Micro servicio para la gestion de usuarios", description = "Gestion de la tabla Usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;
    
    @ApiOperation(value = "Lista de la tabla Usuarios")
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
    
    @ApiOperation(value = "Inserta un nuevo Uusario")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Usuario usuario, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Usuario data = service.save(usuario);

        result.put("success", true);
        result.put("message", "Usuario Registrado con exito");
        result.put("result", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @ApiOperation(value = "Actualiza datos de un USUARIO")
    @PutMapping("/{id_usuario}")
    public ResponseEntity<?> update(@RequestBody Usuario usuario, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Usuario data = service.findById(usuario.getId_usuario());
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe Persona con Id: " + usuario.getId_usuario());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            service.save(usuario);
            result.put("success", true);
            result.put("message", "Se ha actualizado los datos de usuario.");
            result.put("result", usuario);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ApiOperation(value = "Obtiene Datos del usuario")
    @GetMapping(value = "/{id_usuario}")
    public ResponseEntity<?> findById(@PathVariable(value = "id_usuario") int idusuario, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Usuario data = service.findById(idusuario);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe persona con Id: " + idusuario);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        result.put("success", true);
        result.put("message", "Se ha encontrado el registro.");
        result.put("result", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @ApiOperation(value = "Elimina un Usuario")
    @DeleteMapping(value = "/{id_usuario}")
    public ResponseEntity<?> delete(@PathVariable(value = "id_usuario") int idUsuario, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Usuario data = service.findById(idUsuario);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe persona con id: " + idUsuario);
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
