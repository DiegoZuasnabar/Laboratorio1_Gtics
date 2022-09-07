package pe.edu.pucp.gtics.lab1221.controller;

/*
com
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.pucp.gtics.lab1221.entity.Distributors;
import pe.edu.pucp.gtics.lab1221.repository.DistributorsRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Controller
@RequestMapping("/distribuidoras")
public class DistributorsController {

    @Autowired
    DistributorsRepository distributorsRepository;

    @GetMapping(value = {"/lista"})
    public String listaDistribuidoras (Model model){

        List<Distributors> lista = distributorsRepository.findAll();
        model.addAttribute("distributorsList", lista);



        return "distribuidoras/lista";
    }

    @GetMapping(value = {"/editar"})
    public String editarDistribuidoras(Model model,@RequestParam("id") int id ){

        Optional<Distributors> optDis = distributorsRepository.findById(id);

        if (optDis.isPresent()) {
            Distributors distribuidoras = optDis.get();
            model.addAttribute("distri", distribuidoras);
            return "distribuidoras/editar";
        } else {
            return "redirect:/distribuidoras/lista";
        }
    }



    @PostMapping("/guardar")
    public String guardarDistribuidora(Distributors distribuidoras){
        distributorsRepository.save(distribuidoras);
        return "redirect:/distribuidoras/lista";
    };
    @GetMapping("/nuevo")
    public String nuevaDistribuidora() {
        return "distribuidoras/nuevo";
    }





    public String borrarDistribuidora(){
        return "";
    };
}
