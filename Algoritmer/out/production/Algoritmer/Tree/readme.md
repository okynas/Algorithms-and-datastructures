# Algoritme - Tree

## Hva er et tre?

Tre representerer nodene forbundet med kanter.

Binary Tree (Binært Tre) er en spesiell datastruktur som brukes til datalagringsformål. Et binært tre har en spesiell betingelse om at hver node kan ha maksimalt to barn. Et binært tre har fordelene med både en ordnet matrise og en koblet liste, siden søk er like raskt som i en sortert matrise og innsettings- eller slettingsoperasjoner er like raske som i koblet liste.

### Ulike begreper:
**Bane** - Bane refererer til sekvensen av noder langs kantene av et tre.

**Rot** - Noden på toppen av treet kalles rot. Det er bare én rot per tre og én vei fra rotnoden til en hvilken som helst node.

**Forelder** − Enhver node unntatt rotnoden har en kant oppover til en node kalt overordnet.

**Barn** - Noden under en gitt node koblet sammen med kanten nedover kalles dens barnnode.

**Blad** − Noden som ikke har noen barnenode kalles bladnoden.

**Undertre** − Undertre representerer etterkommerne til en node.

**Besøk** – Besøk refererer til å sjekke verdien til en node når kontrollen er på noden.

**Traversering** - Traversering betyr å passere gjennom noder i en bestemt rekkefølge.

**Nivåer** − Nivået til en node representerer genereringen av en node. Hvis rotnoden er på nivå 0, er den neste undernoden på nivå 1, barnebarnet er på nivå 2, og så videre.

**Keys** − Nøkkel representerer en verdi av en node basert på hvilken en søkeoperasjon skal utføres for en node.


## Metoder:
### Obligatoriske:
- insert
- search
- isEmpty

### Lurt å ha med:
- InOrder
- PostOrder
- PreOrder
- antallmedEttBarn
- antallMedToBarn
- antallBlader
- copyTree
- toString

## Bilder:

![image](https://user-images.githubusercontent.com/36879451/151720101-5973824d-b2e5-4ca8-81d5-d0bd5c70cb68.png)
