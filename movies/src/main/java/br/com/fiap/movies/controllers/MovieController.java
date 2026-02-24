package br.com.fiap.movies.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController { //Beans - Controller é um componente

    @GetMapping("/") //REST
    //@ResponseBody //Para indicar que a resposta não é uma página web, mas sim um texto - como colocamos RestController, não precisamos de ResponseBody
    public String healthCheck() {
        return """
                {
                    "status": "ok",
                    "message": "yada yada yada!"
                }
                """;
    }
}
