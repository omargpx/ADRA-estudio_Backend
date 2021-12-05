package pe.org.adra_estudio.ADRA.controller;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.org.adra_estudio.ADRA.service.BancoComunalService;
import pe.org.adra_estudio.ADRA.entity.BancoComunal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("api/banco_comunal")
@Api(value = "Gestion de Banquitos Comunales", description = "Microservicio de Banquito Comunal")
public class BanquitoController {

    @Autowired
    private BancoComunalService bancoComunalService;

    @ApiOperation(value = "lista de banquitos")
    @GetMapping
    public ResponseEntity<?> findAll(
            @RequestParam(value = "query", required = false, defaultValue = "") String query,
            @RequestParam(value = "page", required = false, defaultValue = "-1") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "-1") int limit,
            @RequestParam(value = "sortBy", required = false, defaultValue = "") String sortBy,
            HttpServletRequest request) {
        if (query.equals("") && limit == -1 && "".equals(sortBy)) {
            return new ResponseEntity<>(bancoComunalService.findAll(), HttpStatus.OK);
        } else if (!query.equals("") && page == -1 && limit == -1 && "".equals(sortBy)) {
            return new ResponseEntity<>(bancoComunalService.findAll(query, ""), HttpStatus.OK);
        } else if (!query.equals("") && page == -1 && limit == -1 && !"".equals(sortBy)) {
            return new ResponseEntity<>(bancoComunalService.findAll(query, sortBy), HttpStatus.OK);
        } else if (limit != -1 && page == -1) {
            return new ResponseEntity<>(new Exception("Parámetro page es requerido"), HttpStatus.CONFLICT);
        } else if (page != -1 && limit == -1) {
            return new ResponseEntity<>(new Exception("Parámetro limit es requerido"), HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(bancoComunalService.findAll(query, page, limit, sortBy), HttpStatus.OK);
        }
    }

    @ApiOperation(value = "Registra un nuevo Banco Comunal")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody BancoComunal banquito, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        BancoComunal data = bancoComunalService.save(banquito);

        result.put("success", true);
        result.put("message", "se ha registrado correctamente.");
        result.put("result", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Actualiza datos de un Banco Comunal")
    @PutMapping("/{id_banco_comunal}")
    public ResponseEntity<?> update(@RequestBody BancoComunal banquito, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        BancoComunal data = bancoComunalService.findById(banquito.getId_banquito());
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe banquito con Id: " + banquito.getId_banquito());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            bancoComunalService.save(banquito);
            result.put("success", true);
            result.put("message", "Se ha actualizado los datos de banquito.");
            result.put("result", banquito);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Obten datos de un Banco Comunal")
    @GetMapping(value = "/{id_banco_comunal}")
    public ResponseEntity<?> findById(@PathVariable(value = "id_banco_comunal") int idBanquito, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        BancoComunal data = bancoComunalService.findById(idBanquito);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe banquito con Id: " + idBanquito);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        } else {
            result.put("success", true);
            result.put("message", "Se ha encontrado el registro.");
            result.put("result", data);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }

    }

    @ApiOperation(value = "Elimina el registro de un BancoComunal")
    @DeleteMapping(value = "/{id_banco_comunal}")
    public ResponseEntity<?> delete(@PathVariable(value = "id_banco_comunal") int idBanco, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        BancoComunal data = bancoComunalService.findById(idBanco);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe banquito con id: " + idBanco);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            bancoComunalService.save(data);
            result.put("success", true);
            result.put("message", "Se ha eliminado los datos del registro.");
            result.put("result", data);
            return new ResponseEntity<>(result, HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
