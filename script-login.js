const API = "http://localhost:8080/usuarios"


async function login() {
    const formLogin = document.getElementById("login-form");

    formLogin.addEventListener("submit", async (event) => {
        event.preventDefault();

        const email = document.getElementById("email").value.trim();
        const senha =  document.getElementById("senha").value.trim();

        if(!email || !senha){
            alert("preencha todos os campos!");
            return;
        }

        const usuario = {
            email: email,
            senha: senha,
        };

        try{
            const query = API + "/login";
            const resp = await fetch(query, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(usuario)
            }); 

            if(resp.ok){
                window.location.href = "index.html";
            }else{
                alert("Senha ou email invalidos!");
            }
        }catch (error){
            console.error("Erro ao logar usuário:", error);
            alert("Erro ao logar usuário.");
        }
    });
}

addEventListener("DOMContentLoaded", () => {
    login();
});