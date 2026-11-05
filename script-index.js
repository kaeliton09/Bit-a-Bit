const API = "http://localhost:8080/artigos"
const limitLastArtigos = 3; 

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

async function getLastArtigos(limitLastArtigos) {
    try {
        const query = API + "/ultimos/" + limitLastArtigos;
        const resp = await fetch(query);
        const artigos = await resp.json(); 

        document.getElementById("ultimos-artigos").innerHTML = artigos.map(artigo => 
        `<article>
            <div class="postit">
                    <h4>${artigo.titulo}</h4>
                    <a href="artigo${artigo.id}.html">Leia mais</a>
                </div>
        </article>`).join("");
    } catch (error) {
        console.error("Erro ao buscar últimos artigos:", error);
    }
}

async function deleteArtigo(id) {
    await fetch(`${API}/deletar/${id}`, { method: 'DELETE' });
    getArtigos(); // Atualiza a lista de artigos após a exclusão
}

getArtigos(); // Chama a função para carregar os artigos ao carregar a página
getLastArtigos(limitLastArtigos); // Chama a função para carregar os últimos artigos ao carregar a página