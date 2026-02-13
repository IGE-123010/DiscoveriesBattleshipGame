  # 🚢 Battleship

Versão académica básica do jogo **Battleship**, desenvolvida como base para futuros desenvolvimentos.

---

## 👥 Grupo: *ADM*

### Membros

| Número  | Nome                  | Curso |
|---------|-----------------------|-------|
| 123028  | Lourenço Santos       | IGE   |
| 123023  | Rodrigo Sampaio       | IGE   |
| 123016  | Tiago Pires           | IGE   |
| 123010  | Manuel Albuquerque   | IGE   |


---

## 📜 Regras do Jogo

O jogo **Discoveries Battleship Game** é jogado por dois jogadores.

---

### 🗺️ Tabuleiros

Cada jogador possui:
- Uma grelha 10x10 representando **o seu mar**
- Uma grelha 10x10 representando **o mar do adversário**

Os navios:
- Devem ser colocados horizontal ou verticalmente
- Não se podem tocar entre si
- Podem estar encostados às bordas da grelha
- Devem respeitar o número e dimensão indicados na tabela acima

---

### 🎯 Fase de Ataque

Depois de posicionados os navios:

1. Cada jogador, à vez, dispara **um tiro**
2. Cada tiro é identificado por coordenadas (linha, coluna)
3. O adversário deve indicar:
   - Se acertou ou falhou
   - Em que tipo de navio acertou (caso aplicável)
   - Se algum navio foi afundado

---

### 📊 Registo das Jogadas

- Cada jogador deve marcar na sua grelha do adversário:
  - Tiros na água
  - Acertos
  - Navios afundados
- As jogadas podem ser guardadas, por exemplo, num ficheiro JSON

---

### 🏆 Condição de Vitória

Ganha o jogo o primeiro jogador que:
- Afundar **todos os navios da frota adversária**

---

## Tipos de navios:
| Batalha Naval | Descobrimentos | English | Dimensão | #Navios | 
|---------------|----------------|---------|----------|---------|
| Porta-aviões | Galeão | Galleon | 5 | 1 |
| Navio de 4 canhões | Fragata | Frigate | 4 | 1 |
| Navio de 3 canhões | Nau | Carrack | 3 | 2 |
| Navio de 2 canhões | Caravela | Caravel | 2 | 3 |
| Submarino | Barca | Barge | 1 | 4 |  

---

### ℹ️ Navios históricos

Durante a época dos Descobrimentos Portugueses, diferentes tipos de embarcações foram utilizados, cada um com características próprias adaptadas às necessidades de exploração, comércio e guerra.

- **Caravelas**  
  Embarcações leves e ágeis, com velas latinas triangulares. Ideais para exploração costeira e navegação em mares desconhecidos.
  <img height="350" alt="image" src="https://github.com/user-attachments/assets/1fdb8842-f54e-4f64-8ea8-37710c786e97" />

- **Carracas**
  Grande navio oceânico dos séculos XV e XVI, antecessor do galeão. Possuía casco alto, vários conveses e grande capacidade de carga, sendo amplamente utilizado nas rotas     comerciais de longa distância, incluindo a Carreira da Índia.
  <img height="350" alt="image" src="https://github.com/user-attachments/assets/410c1add-9011-426f-ba4c-d0c2748d2fbe" />

- **Naus**  
  Navios de grande porte, usados principalmente para longas viagens oceânicas e transporte de mercadorias e tripulação.
  <img height="350" alt="image" src="https://github.com/user-attachments/assets/2b4fdea2-9472-4f54-aa00-724cc4e1a907" />

- **Barca**  
  Embarcação de porte médio, utilizada tanto para transporte como para apoio a expedições marítimas.
  <img height="350" alt="image" src="https://github.com/user-attachments/assets/667bc725-eb2b-4ed6-bb43-b6ef0f2199d6" />

- **Barinel**  
  Antecessor da caravela, bastante usado no início dos Descobrimentos para transporte e reconhecimento marítimo.
  <img height="350" alt="image" src="https://github.com/user-attachments/assets/c7880761-1508-4c03-967f-3d21ebd768e8" />

- **Caravelão**  
  Variante maior da caravela, combinando maior capacidade de carga com boa manobrabilidade.

- **Galeão**  
  Navio robusto e fortemente armado, utilizado tanto para guerra como para transporte de riquezas nas rotas oceânicas.  
  <img height="350" alt="image" src="https://github.com/user-attachments/assets/48125ee4-5d86-4a0d-9fcb-1e2f84f2d9be" />

- **Xaveco**  
  Embarcação rápida e manobrável, muito usada no Mediterrâneo e posteriormente adaptada a contextos atlânticos.  
  <img height="350" alt="image" src="https://github.com/user-attachments/assets/b5e12033-7479-4cc7-ad43-43b0ec785860" />

- **Mais informação:**  
  https://pt.wikipedia.org/wiki/Categoria:Embarca%C3%A7%C3%B5es_dos_Descobrimentos

---
