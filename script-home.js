const API = "http://localhost:8080/artigos"

async function createArtigo() {
    const formArtigo = document.getElementById("form-artigo");

    formArtigo.addEventListener("submit", async (event) => {
        event.preventDefault(); // Impede o envio padrão do formulário
        const titulo = document.getElementById("titulo").value.trim();
        const conteudo = document.getElementById("conteudo").value.trim();

        if (!titulo || !conteudo) {
            alert("Por favor, preencha todos os campos.");
            return;
        }

        const artigo = {
            titulo: titulo,
            texto: conteudo,
            dataPublicacao: new Date().toISOString() // Adiciona a data de publicação atual
        };

        try {

            const query = API + "/criar";
            const resp = await fetch(query, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(artigo)
            });

            if (!resp.ok) {
                throw new Error(`Erro HTTP: ${resp.status}`);
            }

            alert("Artigo criado com sucesso!");
            createArtigo.reset(); // Limpa o formulário após o envio
        } catch (error) {
            console.error("Error creating artigo:", error);
            throw error;
        }
    });
}

document.addEventListener("DOMContentLoaded", () => {
    createArtigo();
});