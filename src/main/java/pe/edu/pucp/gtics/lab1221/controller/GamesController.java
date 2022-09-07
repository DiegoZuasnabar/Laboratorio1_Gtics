package pe.edu.pucp.gtics.lab1221.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.pucp.gtics.lab1221.entity.Distributors;
import pe.edu.pucp.gtics.lab1221.entity.Games;
import pe.edu.pucp.gtics.lab1221.entity.Platforms;
import pe.edu.pucp.gtics.lab1221.repository.DistributorsRepository;
import pe.edu.pucp.gtics.lab1221.repository.GamesRepository;
import pe.edu.pucp.gtics.lab1221.repository.PlatformsRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/juegos")
public class GamesController {
    @Autowired
    GamesRepository gamesRepository;
    @Autowired
    PlatformsRepository platformsRepository;

    @GetMapping(value = {"/lista"})
    public String listaJuegos (Model model){

        List<Games> lista = gamesRepository.findAll();
        model.addAttribute("gamesList", lista);

        return "juegos/lista";
    };

    @GetMapping(value = {"/editar"})
    public String editarJuegos(Model model,@RequestParam("id") int id,@RequestParam("idplat") int idplat  ){

        Optional<Games> optDis = gamesRepository.findById(id);
        Optional<Platforms> optDis2 = platformsRepository.findById(idplat);

        if (optDis.isPresent() && optDis2.isPresent()  ) {
            Games games = optDis.get();
            model.addAttribute("juegos", games);
            Platforms platforms = optDis2.get();
            model.addAttribute("plataforma", platforms);
            return "juegos/editar";
        } else {
            return "redirect:/juegos/lista";
        }
    }

    @PostMapping("/guardar")
    public String guardarJuegos(Games juegos){
        gamesRepository.save(juegos);
        return "redirect:/juegos/lista";
    }

}