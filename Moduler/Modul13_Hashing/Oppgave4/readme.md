# Oppgave 4:

Hvis vi bruker hashing med åpen adressering, kan f.eks en hashtabell med lengde 10 som
inneholder 7 heltall fremstilles slik:

    0: 19
    1: 31
    2:
    3: 133
    4: 63
    5: 93
    6:
    7:
    8: 8
    9: 59

Hvis vi bruker kjeding (med lenkede lister) til håndtere kollisjoner, kan hashtabellen se slik ut:

    0:
    1: 31
    2:
    3: 93 63 133
    4:
    5:
    6:
    7:
    8:  8
    9:  19 59

En hashtabell med lengde 10 som lagrer heltall er i utgangspunktet tom. Følgende 7 verdier skal
settes inn i tabellen i denne rekkefølgen:
    
    21 23 63 49 34 99 89

Hashfunksjonen som brukes er denne:

``` java
int hash (int verdi) {
    return verdi % 10;
}
``` 

Hashindeksen som beregnes for en verdi er altså lik resten ved heltallsdivisjon med hashlengden.
Vis hvordan hashtabellen ser ut etter innsetting av de 7 verdiene ovenfor, for hver av de følgende 5
metodene for håndtering av kollisjoner:


## Oppgave a - Lineær probing:

    0:  99
    1:  21
    2:  89
    3:  23
    4:  63
    5:  34
    6
    7
    8
    9:  49

## Oppgave b - Kvadratisk probing:

    0:  99
    1:  21
    2
    3:  23
    4:  63
    5:  34
    6
    7
    8:  89
    9:  49

## Oppgave c - hashing med kjeding

    0:  
    1:  21
    2: 
    3:  63, 23
    4:  34
    5
    6
    7
    8
    9:  89, 99, 49

## Oppgave d - last come, first serve

    0:  99
    1:  49
    2:  21
    3:  63
    4:  34
    5:  23
    6
    7
    8
    9:  89

## Oppgave e - Robin hood

21 23 63 49 34 99 89

    0:  99
    1:  89
    2:  21
    3:  23
    4:  63
    5:  34
    6
    7
    8
    9:  49