package br.com.aninha.primeiro_projeto_spring_boot.controller;

import java.util.Map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primeiraController")
@ComponentScan(basePackages="br.com.aninha")
public class PrimeiraController {

    @GetMapping("/primeiroMetodo")
    public String primeiroMetodo() {
        return "Primeiro método";
    }

    @GetMapping("/primeiroMetodo/{id}")
    public String primeiroMetodoId(@PathVariable String id) {
        //http://localhost:8080/primeiraController/primeiroMetodo/24
        return "Primeiro método com id " + id;
    }
    
    @GetMapping("/metodoComQueryParamns")
    public String metodoComQueryParamns(@RequestParam String id){
        //http://localhost:8080/primeiraController/metodoComQueryParamns?id=25
        return "Método com query params é " + id;
    }
    
    @GetMapping("/metodoComQueryParamns2")
    public String metodoComQueryParamns2(@RequestParam Map<String, String> allParams){
        //http://localhost:8080/primeiraController/metodoComQueryParamns2?id=25?nome=ana?cidade=DoisVizinhos
        return "Método com query params é " + allParams.entrySet();
    }

    @PostMapping("/metodoComBodyParamns")
    public String metodoComBodyParamns(@RequestBody Usuario usuario){
        return "Método com body params " + usuario.username;
    }
    record Usuario(String username){}

    @PostMapping("/metodoComHeaders")
    public String metodoComHeaders(@RequestHeader("name") String name ){
        return "Método com Headers params " + name;
    }

    @PostMapping("/metodoComListHeaders")
    public String metodoComListHeaders(@RequestHeader Map<String, String> headers ){
        return "Método com List Headers params " + headers.entrySet();
    }

    @GetMapping("/metodoResposeEntity")
    public ResponseEntity<Object> metodoResposeEntity(){
        return ResponseEntity.status(201).body("Método com ResponseEntity");
    }
}
