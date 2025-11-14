import { useState, useEffect } from 'react';
import './App.css'; // O Vite já inclui este arquivo para estilo

function App() {
  // 1. Criamos um "estado" para guardar nossa lista de usuários
  //    Começa como um array vazio [].
  const [usuarios, setUsuarios] = useState([]);

  // 2. Este "efeito" roda UMA VEZ quando a página carrega
  useEffect(() => {
    // 3. Este é o "fetch", a chamada de API!
    //    É o React fazendo o que o Postman fez.
    fetch('http://localhost:8080/api/usuarios')
      .then(response => response.json()) // Converte a resposta para JSON
      .then(data => setUsuarios(data)) // Salva os dados no nosso "estado"
      .catch(error => console.error("Erro ao buscar usuários:", error));
  }, []); // O [] vazio significa "rode apenas uma vez"

  // 4. Este é o HTML que será desenhado na tela
  return (
    <div>
      <h1>Stay Agenda - Usuários</h1>
      
      <ul>
        {/* 5. Fazemos um "map" (loop) na nossa lista de usuários */}
        {usuarios.map(usuario => (
          <li key={usuario.id}>
            <strong>Nome:</strong> {usuario.nome}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;