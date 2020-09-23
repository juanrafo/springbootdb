package com.springbootdb.springbootdb;

import io.reactivex.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@ApiModel("Controller")
public class SpringbootdbController {

    String result ="";

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "Hello, world";
    }

    @Autowired
    BlogRespository blogRespository;
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    RestTemplate restTemplate;

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

    @GetMapping(path = "/login",consumes = "application/json", produces = "application/json")
    public List<Usuario> login(@RequestBody Map<String, String> body) {
        String nombreUsuario = body.get("nombreUsuario");
        String password = body.get("password");

        return usuarioRepository.loguear(nombreUsuario,password);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/login2",consumes = "application/json", produces = "application/json")
    @ApiModelProperty(value = "login2", required = true)
    public List<Usuario> login2(@RequestParam("nombreUsuario") String nombreUsuario,@RequestParam("password") String password) {
        return usuarioRepository.loguear(nombreUsuario,password);
    }

    @RequestMapping(value = "/distritos")
    public List<Object> getDistritos() {
        String Url = "http://192.168.99.100:8080/api/v1/mantenimiento/distritos";
        Object[] objects = restTemplate.getForObject(Url,Object[].class);
        return Arrays.asList(objects);
    }



    @RequestMapping(value = "/reactivos")
    public void getReactivos() {
        /*String Url = "http://192.168.99.100:8080/api/v1/mantenimiento/distritos";
        Object[] objects = restTemplate.getForObject(Url,Object[].class);
        return Arrays.asList(objects);*/
        String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
        //Observable<String> o = Observable.from(Arrays.asList("hola", "que", "tal"));
        Observable<String> o = Observable.fromArray(letters);

        //o.subscribe(s->{System.out.println(s);});
        o.subscribe(i -> result += i, Throwable::printStackTrace, () -> result += "_Completed");

        //o.subscribe(action1);

        /*o.subscribe(new Action1<String>() {
            public void call(String arg0) {
                System.out.println(arg0);

            }
        });*/
    }
        @RequestMapping(value = "/test")
        public void testReactivo()
        {
            //producer
            Observable<String> o = Observable.just("como", "estas", "hoy", "estudiando", "java");
            //observable.subscribe(s->{System.out.println(s);});
            result ="";
            o.subscribe(s->{System.out.print(s);});

            o.subscribe(System.out::println);

         String Url = "http://192.168.99.100:8080/api/v1/mantenimiento/distritos";
        Object[] objects = restTemplate.getForObject(Url,Object[].class);
        List<Object> lista =Arrays.asList(objects);
        Observable.just(lista).subscribe(System.out::println);
        //return Arrays.asList(objects);

         Observable.fromIterable(lista).subscribe(System.out::println);
         Observable.just(1,2,3,4,5,6).filter(x -> x % 3 ==0).subscribe(System.out::println);

/*            int[] letters1 = {1,2,3,4,5,6,7};
            Observable.fromArray(letters1).flatMap(v->Observable.fromArray());*/

        }
}