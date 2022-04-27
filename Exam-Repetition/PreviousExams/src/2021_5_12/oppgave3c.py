'''
int distance(int i) {

  if (hashTabell[i] == null || i < 0 || i > hashlengde) {
    return 0;
  }
  int h = hash(hashVerdi);

  // while (hashTabell[i] != hashTabell[distance]) {
  //   distance++;
  // }

  if (i>=h) {
    return i-h; // ikke wrap around
  }
  else {
    return (hashLengde - h) + 1;
  }
  // return distance;
  
}

int hash(String S) {
  int h = Math.abs(S.hashCode());
  return h % hashLengde;
}
'''


lengde = 13
hashTabel = [2] * lengde

print(hashTabel)

def insert(s):
  pass

def hash(s):
  return abs(hash(s)) % lengde

def distance(i):
  if (True):
    return 0