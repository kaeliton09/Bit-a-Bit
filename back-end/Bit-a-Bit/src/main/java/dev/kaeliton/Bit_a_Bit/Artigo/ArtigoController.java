package dev.kaeliton.Bit_a_Bit.Artigo;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://127.0.0.1:3000", "http://localhost:3000"})
@RestController 
@RequestMapping("/artigos")
public class ArtigoController {

    public ArtigoService artigoService;
    public ArtigoController(ArtigoService artigoService) {
        this.artigoService = artigoService;
    }

    @GetMapping("/listar")
    public List<ArtigoModel> obterTodosArtigos() {
        return artigoService.obterTodosArtigos();
    }

    @GetMapping ("/ultimos/{quantidade}")
    public List<ArtigoModel> ultimosArtigos(@PathVariable int quantidade) {
        return artigoService.ultimosArtigos(quantidade);
    }

    @GetMapping ("/buscar/{titulo}")
    public List<ArtigoModel> buscarArtigosPorTitulo(@PathVariable String titulo) {
        return artigoService.buscarArtigosPorTitulo(titulo);
    }

    @PostMapping("/criar")
    public ArtigoModel criarArtigo(@RequestBody ArtigoModel artigo) {
        return artigoService.criarArtigo(artigo);
    }

    @PostMapping ("/atualizar/{id}")
    public ArtigoModel atualizarArtigo(@PathVariable Long id, ArtigoModel artigoAtualizado) {
        return artigoService.atualizarArtigo(id, artigoAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarArtigo(@PathVariable Long id) {
        artigoService.deletarArtigo(id);
    }



}
