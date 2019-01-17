public class minitest {

	public static void main(String[] args) {

		System.out.println(hash("agile"));

		

		
//		test de	l'unhash avec agile
		System.out.println(unhash(485617381)); 

//		réponse au test
		System.out.println(unhash(24682779393128L));
	}

	/***
	 * fonction de hash
	 * 
	 * @param s mot à coder
	 * @return mot codé
	 */
	public static int hash (String s) {

		int h = 7;
		String letters = "acdegilmnoprstuw";

		for(int i = 0; i < s.length(); i++) {
			h = (h * 37 + letters.indexOf(s.charAt(i)));
		}

		return h;

	}

	
	/***
fonction de décodage

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

si on extrait la nième lettre, et qu'on divise par 37 on a :
x = (7*37 + a1)*37 + ... )*37 +a(n-1)

donc on peut extraire toute les lettres en partant de la fin de cette facon jusqu'à atteindre 7*37


	 * @param l 
	 * @return	mot décodé si le hash est correct
	 */
	public static String unhash (long l) {

		String letters = "acdegilmnoprstuw";
		StringBuffer output = new StringBuffer();
		long lTemp = l;
		
		while (lTemp > 7)
        {
//			on trouve la dernière lettre
			long letterEmplacement = lTemp % 37;
			
//			test pour savoir si le mot existe bien
			if(letterEmplacement < letters.length()) {
				
//				on l'ajoute au mot final(par la fin)
				output.insert(0, letters.charAt((int)letterEmplacement));
				
//				on remplace le mot codé par le nouveau (sans la dernière lettre codée)
				lTemp = (lTemp - letterEmplacement)/37;				
			}else {
				
				//Si on est ici, le mot n'existe pas
				output.replace(0, output.length(), "Aucun mot n'existe avec ce hashage");
				break;
			}
			
        }

        return output.toString();
    }		
		


}
