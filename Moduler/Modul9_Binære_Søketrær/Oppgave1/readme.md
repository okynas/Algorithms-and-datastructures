# 9.3: Øvingsoppgaver
## Oppgave 1
Denne oppgaven baserer seg på følgende binære søketre (ikke AVL) der verdien i hver node er en enkel bokstav:

           k
          / \
         /   \
        c     n
       / \     \
      a   e     s
         / \   / 
        d   h p

1. Sett inn hver av disse verdiene i dette treet:

       m  f  b  t  c  s

Finn ut hvilke sammenligninger av verdier som blir gjort i hver enkelt av tilfellene. Gjør hver innsetting uavhenging av de andre, slik at innsettingen foregår i det opprinnelige treet som er "tegnet" ovenfor:

2. Finn hvilke sammenligninger som blir gjort når vi leter etter følgende verdier i søketreet ovenfor:

       c  s  k  a  d  f  t

3. Bruk den vanlige algoritmen for fjerning av node fra et søketre til å fjerne følgende verdier fra treet ovenfor:

       a  p  n  s  e  k

Gjør hver fjerning uavhengig av de andre, slik at fjerningen hele tiden skjer i det opprinnelige treet. Kontroller at fjerningen gjøres riktig, dvs. at treet fortsatt er et søketre etter at en verdi er fjernet.

### SVAR:

#### Oppgave 1a

Opprinnelig: ![img.png](img.png)

m:
![img_1.png](img_1.png)
![img_2.png](img_2.png)
![img_3.png](img_3.png)
![img_4.png](img_4.png)

f:
![img_5.png](img_5.png)
![img_6.png](img_6.png)
![img_7.png](img_7.png)
![img_8.png](img_8.png)
![img_9.png](img_9.png)

b:
![img_10.png](img_10.png)
![img_11.png](img_11.png)
![img_12.png](img_12.png)
![img_13.png](img_13.png)

t:
![img_14.png](img_14.png)
![img_15.png](img_15.png)
![img_16.png](img_16.png)
![img_17.png](img_17.png)

c:
![img_18.png](img_18.png)
![img_19.png](img_19.png)
![img_20.png](img_20.png)
![img_21.png](img_21.png)
![img_22.png](img_22.png)

s:
![img_23.png](img_23.png)
![img_24.png](img_24.png)
![img_25.png](img_25.png)
![img_26.png](img_26.png)

### Oppgave 1b

           k
          / \
         /   \
        c     n
       / \     \
      a   e     s
         / \   / 
        d   h p

c  s  k  a  d  f  t

c: 
- c < k -> venstre 
- c = c -> funnet, høyde = 1

s: 
- s > k -> høyre 
- s > n -> høyre 
- s = s -> funnet, høyde = 2

k: 
- k = k -> funnet, høyde = 0

a:
- a < k -> venstre 
- a < c -> venstre 
- a = a -> funnet, høyde = 2

d:
- d < k -> venstre 
- d > c -> høyre 
- d < e -> venstre 
- d = d -> funnet, høyde = 3

f:
- f < k -> venstre 
- f > c -> høyre 
- f > e -> høyre 
- f < h -> venstre 
- f < null -> ikke funnet, høyde (elementet med null) = 4

t: 
- t > l -> høyre 
- t > n -> høyre
- t > s -> høyre 
- t < null -> ikke funnet, høyde (element med null) = 3

### Oppgave 1c
    a  p  n  s  e  k

Deleting:

a: 
![img_27.png](img_27.png)
![img_28.png](img_28.png)
![img_29.png](img_29.png)
![img_30.png](img_30.png)

p:
![img_31.png](img_31.png)
![img_32.png](img_32.png)
![img_33.png](img_33.png)
![img_34.png](img_34.png)
![img_35.png](img_35.png)


           k
          / \
         /   \
        c     n
       / \     \
      a   e     s
         / \   / 
        d   h p

n:
- n > k -> høyre, forelder = null
- n = n -> forelder = k, 
  - setter barn til n lik k -> k.right = s

s:
- s > k -> høyre, forelder = null
- s > n -> høyre, forelder = k
- s = s -> forelder = n, 
  - setter n.right = p
  
e:
![img_36.png](img_36.png)
![img_37.png](img_37.png)
![img_38.png](img_38.png)
![img_39.png](img_39.png)
![img_40.png](img_40.png)
![img_41.png](img_41.png)

1. e>k -> høyre
2. e<c -> venstre
3. e=e -> 2 barn -> gå til venstre og finn største node i venstre subtre

k:
![img_42.png](img_42.png)
![img_43.png](img_43.png)
![img_44.png](img_44.png)
![img_45.png](img_45.png)
![img_46.png](img_46.png)
![img_47.png](img_47.png)
![img_48.png](img_48.png)