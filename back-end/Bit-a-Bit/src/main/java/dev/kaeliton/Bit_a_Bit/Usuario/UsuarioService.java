package dev.kaeliton.Bit_a_Bit.Usuario;

import java.util.List;

import org.springframework.stereotype.Service;

@Service 
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioModel criarUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public UsuarioModel atualizarUsuario(Long id, UsuarioModel usuarioAtualizado) {
        UsuarioModel usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));

        usuarioExistente.setNome(usuarioAtualizado.getNome());
        usuarioExistente.setEmail(usuarioAtualizado.getEmail());
        usuarioExistente.setSenha(usuarioAtualizado.getSenha());

        return usuarioRepository.save(usuarioExistente);
    }

    public void deletarUsuario(Long id) {
        UsuarioModel usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));

        usuarioRepository.delete(usuarioExistente);
    }

    public UsuarioModel obterUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));
    }

    public List<UsuarioModel> obterTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public List<UsuarioModel> buscarUsuariosPorNome(String nome) {
        List<UsuarioModel> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .filter(usuario -> usuario.getNome().toLowerCase().contains(nome.toLowerCase()))
                .toList();
    }

    

}
