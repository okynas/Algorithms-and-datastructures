# Algoritme - Binary Tree

## Hva er en Binært tre?

I informatikk er et binært tre et type tre hvor hvert element / node i treet har maksimalt 2 barn.

## Typer;
- Balansert Binært Tre = venstre og høyre node for hvert element har maks 1 i høydeforskjell
- Komplett Binært Tre = hvert nivå, utenom siste er fylt opp, og alle nodene i siste nivå er fylt helt mot venstre som mulit
- Full Binært Tre = hver node har enten 0 eller 2 barn
- Perfekt Binært tre = hver element har 2 barn, og alle blader har samme dybde eller høyde. Et perfekt binært tre er også full og kompeltt.

## Implementert:
- Array:
  - venstre barn er lagra på 2*n indeks
  - høyre barn er lagret på 2*n+1 indeks
  - forelder er lagret på n/2 indeks
- Peker / referanse til en node

## Metoder:
- _Traversering_:
  - PreOrder()
  - InOrder()
  - PostOrder()
- _Insert_
  - BladNoder()
  - InternNoder()
- _Delete_
  - DeleteWithZeroOrOneChild()
  - DeleteWithTwoChild()
- 



## Bilder:


![img.png](img.png)
