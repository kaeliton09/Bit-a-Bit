package dev.kaeliton.Bit_a_Bit.Artigo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service 
public class ArtigoService {


    private ArtigoRespository artigoRespository;

    public ArtigoService(ArtigoRespository artigoRespository) {
        this.artigoRespository = artigoRespository;
    }

    public ArtigoModel criarArtigo(ArtigoModel artigo) {
        return artigoRespository.save(artigo);
    }

    public ArtigoModel atualizarArtigo(Long id, ArtigoModel artigoAtualizado) {
        ArtigoModel artigoExistente = artigoRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artigo não encontrado com o ID: " + id));

        artigoExistente.setTitulo(artigoAtualizado.getTitulo());
        artigoExistente.setDataPublicacao(artigoAtualizado.getDataPublicacao());
        artigoExistente.setTexto(artigoAtualizado.getTexto());

        return artigoRespository.save(artigoExistente);
    }

    public void deletarArtigo(Long id) {
        ArtigoModel artigoExistente = artigoRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artigo não encontrado com o ID: " + id));

        artigoRespository.delete(artigoExistente);
    }

    public ArtigoModel obterArtigoPorId(Long id) {
        return artigoRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artigo não encontrado com o ID: " + id));
    }

    public List<ArtigoModel> obterTodosArtigos() {
        return artigoRespository.findAll();
    }

    public List<ArtigoModel> buscarArtigosPorTitulo(String titulo) {
        List<ArtigoModel> artigos = artigoRespository.findAll();
        return artigos.stream()
                .filter(artigo -> artigo.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .toList();
    }

    public List<ArtigoModel> ultimosArtigos(int quantidade) {
        List<ArtigoModel> artigos = artigoRespository.findAll();
        return artigos.stream()
                .sorted((a1, a2) -> a2.getId().compareTo(a1.getId()))
                .limit(quantidade)
                .toList();
    }

}
