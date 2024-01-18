package elpu.virtual.api.controller;


import elpu.virtual.api.domain.Suministro.DatosSuministros;
import elpu.virtual.api.domain.Suministro.Suministro;
import elpu.virtual.api.domain.Suministro.SuministroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/guardarSuministros")
public class GuardarSuministros {

    @Autowired
    SuministroRepository suministroRepository;

    @PostMapping
    public ResponseEntity guardarSum(@RequestBody DatosSuministros datosSuministros) {

        Suministro suministro = new Suministro(datosSuministros.ruta(), datosSuministros.codigo_suministro(), datosSuministros.usuario_fk()) ;
        suministroRepository.save(suministro);
        return ResponseEntity.ok().body("Registro Exitoso");
    }
}
