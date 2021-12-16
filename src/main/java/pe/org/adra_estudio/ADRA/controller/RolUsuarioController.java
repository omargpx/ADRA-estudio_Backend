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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.org.adra_estudio.ADRA.entity.RolUsuario;
import pe.org.adra_estudio.ADRA.service.RolUsuarioService;

/**
 *
 * @author lober
 */
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("api/rolUsuario")
@Api(value = "Microservicio de gestion de la tabla de Roles_usuario", description = "Gestion de la tabla Roles_usuario")
public class RolUsuarioController {
    
    @Autowired
    private RolUsuarioService service;
    
    @ApiOperation(value = "Lista de Roles por usuario")
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

    @ApiOperation(value = "AsignarRoles")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody RolUsuario capacitacion, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        RolUsuario data = service.save(capacitacion);

        result.put("success", true);
        result.put("message", "el rol se ha asignado correctamente.");
        result.put("result", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
}
