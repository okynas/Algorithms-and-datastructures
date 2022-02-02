## Oppgave 8

Skriv en rekursiv metode som reverserer (snur om rekkefølgen på) elementene i en array x av lengde n. Funksjonen skal flytte delvektoren

    x[1, 2, 3, ..., n-1]

et "hakk" nedover, til delvektoren

    x[0, 1, 2,..., n-2]

x[0] blir da satt lik x[1], x[1] blir satt lik x[2] osv. Deretter skal den "gamle" verdien av x[0] lagres i x[n-1]. Rekkefølgen av elementene i delvektoren:

    x[0, 1, 2,..., n-2]

skal så snus om med et rekursivt kall.