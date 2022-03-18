package co.com.linadev.springbootwebflux.controller;

import co.com.linadev.springbootwebflux.model.Player;
import co.com.linadev.springbootwebflux.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/player")
public class PlayerController {


    private final PlayerService playerService;

    @PostMapping("/fillData")
    public Flux<Player> fillData(){
        return playerService.fillData();
    }

    @DeleteMapping("/clearData")
    public Mono<Void> deleteAll(){
        return playerService.deleteClearData();
    }

    @GetMapping("/club/{club}")
    public Flux<Player> findAllByPlayerClub(@PathVariable String club){
        return playerService.findAllByPlayerClub(club);
    }

    @GetMapping("/name/{name}")
    public Flux<Player> findAllByPlayerNameStartingWith(@PathVariable String name){
        return playerService.findAllByPlayerNameContains(name);
    }

    @GetMapping("/ageGreater/{age}")
    public Flux<Player> findAllByPlayerAgeGreaterThan(@PathVariable Integer age){
        return playerService.findAllByPlayerAgeGreaterThan(age);
    }

    @GetMapping("/ageLess/{age}")
    public Flux<Player> findAllByPlayerAgeLessThan(@PathVariable Integer age){
        return playerService.findAllByPlayerAgeLessThan(age);
    }

    @GetMapping("/age/{age}")
    public Flux<Player> findAllByPlayerAge(@PathVariable Integer age){
        return playerService.findAllByPlayerAge(age);
    }

    @GetMapping("/country/{country}")
    public Flux<Player> findAllByPlayerCountryContainingIgnoreCase(@PathVariable String country){
        return playerService.findAllByPlayerCountryContainingIgnoreCase(country);
    }

    @GetMapping("/countryStatOne/{country}")
    public Flux<Player> findAllByPlayerCountryContainingIgnoreCaseOrderByPlayerStatOne(@PathVariable String country){
        return playerService.findAllByPlayerCountryContainingIgnoreCaseOrderByPlayerStatOne(country);
    }


}
