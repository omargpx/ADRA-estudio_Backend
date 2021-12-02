package com.adrastudio.adrastudio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("api/persona")
@Api(value = "Microservicio de gestion de la tabla Persona", description = "Gestion de la tabla TBL_PERSONA")
public class PersonaController {

}
