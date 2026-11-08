const API = "http://localhost:8080/usuarios";

async function createUsuario() {
    const formUsuario = document.getElementById("cadastro-form");
    formUsuario.addEventListener("submit", async (event) => {
        event.preventDefault();

        const nome = document.getElementById("nome").value.trim();
        const email = document.getElementById("email").value.trim();
        const senha = document.getElementById("senha").value.trim();
        const confirmarSenha = document.getElementById("confirmar-senha").value.trim();

        if (!nome || !email || !senha || !confirmarSenha) {
            alert("Por favor, preencha todos os campos.");
            return;
        }

        if (senha !== confirmarSenha) {
            alert("As senhas não coincidem.");
            return;
        }

        const usuario = {
            nome: nome,
            email: email,
            senha: senha
        };

        try {
            const query = API + "/criar";
            const response = await fetch(query, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(usuario)
            });

            if (response.ok) {
                alert("Usuário cadastrado com sucesso!");
                window.location.href = "login.html";
            } else {
                alert("Erro ao cadastrar usuário.");
            }
        } catch (error) {
            console.error("Erro ao cadastrar usuário:", error);
            alert("Erro ao cadastrar usuário.");
        }
    });
}

addEventListener("DOMContentLoaded", () => {
    createUsuario();
});