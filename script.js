const API = "http://127.0.0.1:8080/artigos"

async function getArtigos() {
    try {
        const query = API + "/listar";
        const resp = await fetch(query);
        const artigos = await resp.json();
        
        document.getElementById("artigos").innerHTML = artigos.map(artigo => `
            <article>
                <div class="titleArtigo">
                    <h2>${artigo.titulo}</h2>
                    <time datetime="${artigo.dataPublicacao}">${artigo.dataPublicacao}</time>
                </div>
                <p>${artigo.texto}</p>
                <button onclick="deleteArtigo(${artigo.id})" class="btn-danger">Deletar</button>
            </article>
        `).join("");
    } catch (error) {
        console.error("Erro ao buscar artigos:", error);       }

}

async function deleteArtigo(id) {
    await fetch(`${API}/deletar/${id}`, { method: 'DELETE' });
    getArtigos(); // Atualiza a lista de artigos após a exclusão
}

getArtigos(); // Chama a função para carregar os artigos ao carregar a página