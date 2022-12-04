package com.cristian.demo.controller;

import com.cristian.demo.exception.PersonaNotFoundException;
import com.cristian.demo.model.Persona;
import com.cristian.demo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    @PostMapping("/persona")
    Persona newPersona(@Validated @RequestBody Persona newPersona) {
        return personaRepository.save(newPersona);
    }

    @GetMapping("/personas")
    List<Persona> getAllPersonas() {
        return  personaRepository.findAll();
    }

    @DeleteMapping("/persona/{id}")
    Long deletePersona(@PathVariable Long id){
        if(!personaRepository.existsById(id))
            throw new PersonaNotFoundException(id);
        personaRepository.deleteById(id);
        return id;
    }
    @PutMapping("/persona/{id}")
    Persona updateUPersona(@RequestBody Persona persona, @PathVariable Long id) {
        return personaRepository.findById(id)
                .map(p -> {
                    p.setPerNombre(persona.getPerNombre());
                    p.setPerApellido(persona.getPerApellido());
                    p.setPerFechaNacimiento(persona.getPerFechaNacimiento());
                    p.setPerTipoDocumento(persona.getPerTipoDocumento());
                    p.setPerNumeroDocumento(persona.getPerNumeroDocumento());
                    return personaRepository.save(persona);
                }).orElseThrow(()->new PersonaNotFoundException(id));
    }
}
