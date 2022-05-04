/*
* Hjelpefunksjon
*/
String sortString(String inputString) {
char tempArray[] = inputString.toCharArray();
 Arrays.sort(tempArray);
 return new String(tempArray);
}

/**
* Et anagram er et ord som er blitt satt sammen ved å stokke rundt
* på bokstavene i et annet ord eller uttrykk.
*
* eks: jus-sju, rådhus-husråd, gitar-artig, sykebil-libyske, melk-klem, reparasjon-japanroser
*
* @return true hvis strengen S2 er et anagram laget av tegnene i strengen S1, dvs. at
* @param s1 string
* @param s2, string, er en permutasjon av tegnene i S1.
*/
public boolean erAnagram(String S1, String S2) {
  String S1Sortert = sortString(S1);
  String S2Sortert = sortString(S2);

  for (int i = 0; i < S1Sortert.length(); i++) {
    if (S1Sortert[i] != S2Sortert[i]) {
      return false;
    }
  }

  return true;

}

// kan også progges slik:
public boolean erAnagram(String S1, String S2) {
  return sortString(S1).compareTo(sortString(S2)) == 0;
}