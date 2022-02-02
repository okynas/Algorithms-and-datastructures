## Oppgave 5

Ackermanns funksjon, A, som er definert nedenfor, brukes ofte i testprogrammer for å finne ut hvor godt rekursjon er implementert i en kompilator:

    A(0, n) = n + 1, 	for n >= 0
    A(m, 0) = A(m-1, 1), 	for m > 0
    A(m, n) = A(m-1, A(m, n-1)), 	for m > 0 og n > 0

    Beregn A(2, 3) for hånd. Hvor mange ganger må Ackermann's funksjon beregnes for å regne ut denne verdien?

Lag en rekursiv metode som beregner A(m, n). Lag et lite testprogram som leser inn m og n og bruker metoden til å regne ut A(m, n). Hvor store verdier av m og n klarer metoden din før du har brukt opp all tilgjengelig hukommelse i maskinen (evt. før den crasher)?
