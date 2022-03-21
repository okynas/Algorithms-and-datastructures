# Oppgave 3

Følgende nøkkelverdier skal legges inn i en tom hashtabell:

     10 100 32 45 58 126 3 29 200 400 0

Vi skal i deloppgavene nedenfor se på effekten av å bruke forskjellige hashfunksjoner og hashlengder.

1. La hashfunksjonen være:

hash(nøkkel) = nøkkel % hashlengde
Hashverdien er her bare er resten ved heltallsdivisjon av datanøkkelen med hashlengden. Finn hashverdien som beregnes for hver av de 11 nøklene ovenfor og beregn antall kollisjoner, når hashlengden er lik 13.

2. Finn hashverdiene og antall kollisjoner, når hashlengden er lik 13 og hashfunksjonen bruker folding etter følgende metode:

- Legg sammen de enkelte sifferne i hver nøkkelverdi til et tall. F.eks. vil nøkkelverdien 126 gi summen 1 + 2 + 6 = 9.

- Beregn deretter hashverdien ved å finne resten ved heltallsdivisjon av summen av sifferne med hashlengden.

3. Gjenta oppgave b., men med hashlengde lik 11.