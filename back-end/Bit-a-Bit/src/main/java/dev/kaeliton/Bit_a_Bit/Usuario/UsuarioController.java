package dev.kaeliton.Bit_a_Bit.Usuario;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/usuarios")
@CrossOrigin(origins = {"http://127.0.0.1:3000", "http://localhost:3000"})
public class UsuarioController {

    public UsuarioService usuarioService;
    public UsuarioController(@RequestBody UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/criar")
    public UsuarioModel criarUsuario(@RequestBody UsuarioModel usuario) {
        return usuarioService.criarUsuario(usuario);
    }

    @GetMapping("/listar")
    public List<UsuarioModel> obterTodosUsuarios() {
        return usuarioService.obterTodosUsuarios();
    }

    @GetMapping("/buscar/{nome}")
    public List<UsuarioModel> buscarUsuariosPorNome(@PathVariable String nome) {
        return usuarioService.buscarUsuariosPorNome(nome);
    }

    @GetMapping("/buscar/{id}")
    public UsuarioModel obterUsuarioPorId(@PathVariable Long id) {
        return usuarioService.obterUsuarioPorId(id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
    }

    @PatchMapping("/atualizar/{id}")
    public UsuarioModel atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuarioAtualizado) {
        return usuarioService.atualizarUsuario(id, usuarioAtualizado);
    }

    @PostMapping("/login")
    public UsuarioModel login(@RequestBody UsuarioModel usuario) {
        return usuarioService.login(usuario);
    }

}
