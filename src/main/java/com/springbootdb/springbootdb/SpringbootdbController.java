package com.springbootdb.springbootdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
public class SpringbootdbController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "Hello, world";
    }

    @Autowired
    BlogRespository blogRespository;
    @Autowired
    UsuarioRepository usuarioRepository;

     @GetMapping("/blog")
    public List<Blog> index(){
        return blogRespository.findAll();
    }

    @GetMapping("/blog/{id}")
    public Optional<Blog> show(@PathVariable String id){

        return blogRespository.findById(Integer.valueOf(id.toString()));
    }

    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return blogRespository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
    }

    @PostMapping(path = "/blog",consumes = "application/json", produces = "application/json")
    public Blog create(@RequestBody Map<String, String> body){
        String title = body.get("title");
        String content = body.get("content");
        return blogRespository.save(new Blog(title, content));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/login",consumes = "application/json", produces = "application/json")
    public List<Usuario> login(@RequestBody Map<String, String> body) {
        String nombreUsuario = body.get("nombreUsuario");
        String password = body.get("password");

        return usuarioRepository.loguear(nombreUsuario,password);
    }

}
