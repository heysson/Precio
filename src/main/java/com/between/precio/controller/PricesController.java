package com.between.precio.controller;

import org.springframework.web.bind.annotation.*;
import com.between.precio.repository.PricesRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;@CrossOrigin()

@RestController
@RequestMapping({"/api/prices" })
public class PricesController {

    @Autowired
    private PricesRepository repositoryPrincipal;

    @GetMapping
    public ResponseEntity<Object> findAll() {
      return new ResponseEntity<>(repositoryPrincipal.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{fecha}/{idProduct}/{idCadena}")
    public ResponseEntity<Object> findById(@PathVariable("fecha") String fecha, @PathVariable("idProduct") int idProduct, @PathVariable("idCadena") int idCadena) throws ParseException {
      SimpleDateFormat fechaApl = new SimpleDateFormat("yyyy-MM-dd_hhmm");
      return new ResponseEntity<>(repositoryPrincipal.findByIdFecha(idProduct,fechaApl.parse(fecha),idCadena), HttpStatus.OK);
  }
}
