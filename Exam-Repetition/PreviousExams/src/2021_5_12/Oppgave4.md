## Oppgave 4 - Grafer (25%)
Data:
A:0 B:1 C:2 D:3 E:4

### a)

5
0 a  2  1 3  2 1
1 b  4  0 3  2 7  3 5  4 1
2 c  3  0 1  1 7  3 2
3 d  3  1 5  2 2  4 7
4 e  2  1 1  3 7

### b)

  A B C D E
A 0 3 1 * *
B 3 0 7 5 1
C 1 7 0 2 *
D * 5 2 0 7
E * 1 * 7 0

### c)
DFS fra E, alltid skje i i alfabetisk stigende rekkefølge.

E B A C D

### d)
BFS fra E, alltid skje i i alfabetisk stigende rekkefølge.

E B D A C

### e)

  A B C D E
A 0 3 1 3 4
B 3 0 4 5 1
C 1 4 0 2 5
D 3 5 2 0 6
E 4 1 5 6 0

### f)

| Steg | A | B | C | D | E | Funnet |
|------|---|---|---|---|---|--------|
| 0    | * | * | * | * | 0 |        |
| 1    | * | 1 | * | 7 | 0 | E      |
| 2    | 4 | 1 | 8 | 6 | 0 | EB     |
| 3    | 4 | 1 | 5 | 6 | 0 | EBA    |
| 4    | 4 | 1 | 5 | 6 | 0 | EBAC   |
| 5    | 4 | 1 | 5 | 6 | 0 | EBACD  |
