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

1. Cada jogador, à vez, dispara **três tiros**
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
