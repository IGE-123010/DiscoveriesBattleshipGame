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

## Respostas da ficha 1

### Parte 1, Secção E, Exercício 3
##  Product Backlog – o que é?

O **Product Backlog** é a lista ordenada e priorizada de todos os requisitos e funcionalidades a implementar no projeto. No contexto deste trabalho, o backlog é constituído por um conjunto estruturado de **user stories**, organizadas por secções ou módulos funcionais.

A divisão por módulos permite que diferentes membros da equipa possam trabalhar de forma independente e simultânea, reduzindo dependências técnicas e minimizando tempos de espera. Esta abordagem está alinhada com os princípios da metodologia **Scrum**, promovendo desenvolvimento incremental e colaborativo.

O backlog é dinâmico, podendo ser atualizado e reordenado ao longo do projeto de acordo com a evolução das prioridades e necessidades identificadas.

---

##  User Stories

Cada **user story** representa uma funcionalidade do ponto de vista do utilizador final, descrevendo o que este pretende realizar e com que objetivo.

A formulação das user stories segue uma estrutura centrada no valor entregue ao utilizador:

> **Como** [tipo de utilizador]  
> **Quero** [funcionalidade]  
> **Para** [benefício ou objetivo]

A prioridade de cada user story deve refletir a sua importância para o funcionamento do sistema. De modo geral, são consideradas mais prioritárias as funcionalidades que constituem a **base mínima funcional do software**, ou seja, aquelas sem as quais o sistema não pode operar corretamente.

Na secção de **Issues** do GitHub encontra-se o conjunto de user stories definidas colaborativamente pela equipa, procurando cobrir as principais funcionalidades do jogo e garantindo uma implementação incremental, organizada e alinhada com o enunciado do projeto.
### Parte 1, Secção E, Exercício 6
- Para escolher uma user story para mim próprio, devo selecionar a user story pretendida e usar a opção de assign, selecionando o meu utilizador.
- Para indicar que esta user story já foi implementada, devemos selecionar a user story em questão e definir (opção "Mark as") o estado como completed.
- Finalmente, quando o product owner desiste de uma user story, devemos etiquetar a user story com a label "WONTFIX", indicada para items cuja decisão foi de explicitamente não serem alvo de implementação e trabalho.

### Parte 1, Secção D, Exercício 7

### Parte 2, Secção C, Exercício 1


## Comparação: Web vs IDE

Trabalhar via GitHub Web é mais adequado para:
- Pequenas edições rápidas
- Gestão de Issues e Pull Requests
- Revisão de código
- Operações simples

Trabalhar via IDE (IntelliJ) é mais adequado para:
- Desenvolvimento de código complexo
- Refatoração
- Debugging
- Geração de documentação
- Integração com ferramentas de build

A abordagem ideal combina ambas: desenvolvimento no IDE e gestão colaborativa na plataforma web.
