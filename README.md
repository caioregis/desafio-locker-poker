# desafio-locker-poker
Desafio para a empresa Locker - Jogo Poker em Java (Contém testes unitários)

# Poker

No jogo de Poker, uma mão consiste em cinco cartas que podem ser comparadas, da mais baixa para a mais alta, da seguinte maneira: 

* Carta Alta (High Card): A carta de maior valor.
* Um Par (Pair): Duas cartas do mesmo valor.
* Dois Pares (Two Pairs): Dois pares diferentes. 
* Trinca (Three of a Kind): Três cartas do mesmo valor e duas de valores diferentes. 
* Straight (seqüência): Todas as carta com valores consecutivos. 
* Flush: Todas as cartas do mesmo naipe. 
* Full House: Um trinca e um par. 
* Quadra (Four of a kind): Quatro cartas do mesmo valor. 
* Straight Flush: Todas as cartas são consecutivas e do mesmo naipe. 
* Royal Flush: A seqüência 10, Valete, Dama, Rei, Ás, do mesmo naipe. 

As cartas são, em ordem crescente de valor: 2, 3, 4, 5, 6, 7, 8, 9, 10, Valete (T), Dama (Q), Rei (K), Ás (A). <br />
Os naipes são: Ouro (D), Copa (H), Espadas (S), Paus (C).

Se dois jogadores possuem a mesma mão, vence que tiver a mão formada pelas cartas de maior valor. 

Alguns exemplos de mão e seus respectivos vencedores: 

Jogador 1 | Jogador 2 | Vencedor 
------------- | ------------  | ------------
5H 5C 6S 7S KD <br />*Par de cinco* | 2C 3S 8S 8D TD <br />*Par de oito* | Jogador 2 
5D 8C 9S JS AC <br />*Carta mais alta: Ás* | 2C 5C 7D 8S QH <br />*Carta mais alta: Dama* | Jogador 1 
2D 9C AS AH AC <br />*Trinca de Ás* | 3D 6D 7D TD QD <br />*Flush com Ouro* | Jogador 2 
4D 6S 9H QH QC <br />*Par de Damas<br />Carta mais alta: 9* | 3D 6D 7H QD QS <br />*Par de Damas<br />Carta mais alta: 7* | Jogador 1 
2H 2D 4C 4D 4S <br />*Full House Com três 4* | 3C 3D 3S 9S 9D <br />*Full HouseCom três 3* | Jogador 1 

Desenvolva um programa que, de acordo com as mãos de dois jogadores, informe qual deles é o vencedor.
