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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.org.adra_estudio.ADRA.entity.Usuario;
import pe.org.adra_estudio.ADRA.service.UsuarioService;

/**
 *
 * @author lober
 */
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("api/usuario")
@Api(value = "Micro servicio para la gestion de usuarios", description = "Gestion de la tabla Usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    //obteniendo datos del usuario por email
    @ApiOperation(value = "Obtiene Datos del usuario por el email")
    @GetMapping(value = "/{email}")
    public ResponseEntity<?> findById(@PathVariable(value = "email") int email, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Usuario data = service.findByEmail(email);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe usuario con nombre: " + email);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        result.put("success", true);
        result.put("message", "Se ha encontrado el registro.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
