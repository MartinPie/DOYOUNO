Find a 8*-letter string containing only letters from: " acdegilmnoprstuw", such that the hash(this_string) is 24682779393128*With hash defined by the following pseudo-code:

hash (string s) {
h = 7
letters = "acdegilmnoprstuw"
for(i = 0; i < s.length; i++) {
h = (h * 37 + letters.indexOf(s[i]))
}
return h
}
For example, if we try to find the 5-letter string where hash( this_string ) is 485617381 , the answer will be " agile ".












J'ai raisonné de la facon suivante : 

Si le mot x n'avait qu'une lettre a1, alors l'opération pour trouver a1 serait :
	x = 7*37 + a1

Avec 2 lettres a1 et a2:
	x = (7*37 + a1)*37 + a2

donc avec n lettres : 
 x = (7*37 + a1)*37 + ... )*37 + an

Donc à chaque fois, nous avons une opération de la forme :
 x = 37k + an

(avec k un nombre entier et an la dernière lettre à extraire)

Si on extrait la nième lettre, et qu'on divise par 37 on a :
 x = (7*37 + a1)*37 + ... )*37 +a(n-1)

Donc on peut extraire toute les lettres en partant de la fin de cette facon jusqu'à atteindre 7*37
